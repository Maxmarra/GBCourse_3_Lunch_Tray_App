package com.example.lunchtray.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.lunchtray.data.DataSource
import java.text.NumberFormat

class OrderViewModel : ViewModel() {

    // Map of menu items
    val menuItems = DataSource.menuItems

    // Default values for item prices
    private var previousEntreePrice = 0.0
    private var previousSidePrice = 0.0
    private var previousAccompanimentPrice = 0.0

    // Default tax rate
    private val taxRate = 0.18

    /*
    The MenuItem contained in the LiveData object is also nullable since
    it's possible for the user to not select an entree, side,
    and/or accompaniment.
    * **/
    // Entree for the order
    private val _entree = MutableLiveData<MenuItem?>()
    val entree: LiveData<MenuItem?> = _entree

    // Side for the order
    private val _side = MutableLiveData<MenuItem?>()
    val side: LiveData<MenuItem?> = _side

    // Accompaniment for the order.
    private val _accompaniment = MutableLiveData<MenuItem?>()
    val accompaniment: LiveData<MenuItem?> = _accompaniment

    // Subtotal for the order
    private val _subtotal = MutableLiveData(0.0)
    val subtotal: LiveData<String> = Transformations.map(_subtotal) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    // Total cost of the order
    private val _total = MutableLiveData(0.0)
    val total: LiveData<String> = Transformations.map(_total) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    // Tax for the order
    private val _tax = MutableLiveData(0.0)
    val tax: LiveData<String> = Transformations.map(_tax) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    /**
     * Set the entree for the order.
     */
    fun setEntree(entree: String) {

        // TODO: if _entree.value is not null,
        //  set the previous entree price to the current entree price.
        //  Так как мы постоянно обновляем ценник при выборе каждого блюда то:
        //  если вдруг клиент меняет уже выбранное первое блюдо
        //  то вытащи цену ранее выбранного первого блюда
        if(_entree.value != null){
            previousEntreePrice = _entree.value!!.price
        }

        // TODO: if _subtotal.value is not null subtract the previous entree price
        //  from the current subtotal value. This ensures that we only charge
        //  for the currently selected entree.
        //  Так как подытог _subtotal тоже уже имеет предыдущую цену то
        //  необходимо удалить у него это цену
        if(_subtotal.value != null){
            _subtotal.value = (_subtotal.value)?.minus(previousEntreePrice)
        }
        // TODO: set the current entree value to the menu item corresponding
        //  to the passed in string
        //  Теперь мы присваиваем _entree через переданное название
        //  соответствующий объект MenuItem из массива menuItems
        _entree.value = menuItems[entree]

        // TODO: update the subtotal to reflect the price of the selected entree.
        //  обновляем подытог цены занося туда новую цену этого MenuItem
        menuItems[entree]?.price?.let {
            updateSubtotal(it)
        }
    }

    /**
     * Set the side for the order.
     */
    fun setSide(side: String) {
        // TODO: if _side.value is not null, set the previous side price to the current side price.
        if (_side.value != null) {
            previousSidePrice = _side.value?.price!!
        }
        // TODO: if _subtotal.value is not null subtract the previous side price from the current
        //  subtotal value. This ensures that we only charge for the currently selected side.
        if (_subtotal.value != null) {
            _subtotal.value = ( _subtotal.value)?.minus(previousSidePrice)
        }
        // TODO: set the current side value to the menu item corresponding to the passed in string
        _side.value = menuItems[side]
        // TODO: update the subtotal to reflect the price of the selected side.
        menuItems[side]?.price?.let { updateSubtotal(it) }
    }

    /**
     * Set the accompaniment for the order.
     */
    fun setAccompaniment(accompaniment: String) {
        // TODO: if _accompaniment.value is not null, set the previous accompaniment price to the
        //  current accompaniment price.
        if (_accompaniment.value != null) {
            previousAccompanimentPrice = _accompaniment.value?.price!!
        }
        // TODO: if _accompaniment.value is not null subtract the previous accompaniment price from
        //  the current subtotal value. This ensures that we only charge for the currently selected
        //  accompaniment.
        if (_subtotal.value != null) {
            _subtotal.value = ( _subtotal.value)?.minus(previousAccompanimentPrice)
        }
        // TODO: set the current accompaniment value to the menu item corresponding to the passed in
        //  string
        _accompaniment.value = menuItems[accompaniment]

        // TODO: update the subtotal to reflect the price of the selected accompaniment.
        menuItems[accompaniment]?.price?.let { updateSubtotal(it) }
    }

    /**
     * Update subtotal value.
     */
    private fun updateSubtotal(itemPrice: Double) {
        // TODO: if _subtotal.value is not null, update it to reflect the price
        //  of the recently added item.
        //  Otherwise, set _subtotal.value to equal the price of the item.
        //  Если в _subtotal уже что-то есть, то добавь к нему передаваемую цену
        //  Если пусто, то просто присвой _subtotal эту цену
        if(_subtotal.value != null){
            _subtotal.value = (_subtotal.value)?.plus(itemPrice)
        }else{
            _subtotal.value = itemPrice
        }

        // TODO: calculate the tax and resulting total
        calculateTaxAndTotal()
    }

    /**
     * Calculate tax and update total.
     */
    fun calculateTaxAndTotal() {
        // TODO: set _tax.value based on the subtotal and the tax rate.
        //  умножь _subtotal на taxRate через функцию times
        _tax.value = (_subtotal.value)?.times(taxRate)

        // TODO: set the total based on the subtotal and _tax.value.
        //  сложи налог с подытогом чтобы получить итого
        _total.value = _tax.value?.let {
            (_subtotal.value)?.plus(it)
        }
    }

    /**
     * Reset all values pertaining to the order.
     */
    fun resetOrder() {
        // TODO: Reset all values associated with an order
        _subtotal.value = 0.0
        _total.value = 0.0
        _tax.value = 0.0

        previousEntreePrice = 0.0
        previousSidePrice = 0.0
        previousAccompanimentPrice = 0.0

        _entree.value = null
        _side.value = null
        _accompaniment.value = null
    }
}
