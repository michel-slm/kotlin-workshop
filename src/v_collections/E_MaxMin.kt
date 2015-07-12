package v_collections

import v_collections.data.customers

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length() }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    // Return a customer who ordered maximum number of orders
    var curMaxSize = 0
    var curCustomer: Customer? = null
    for (customer in customers) {
        if (customer.orders.size() > curMaxSize) {
            curMaxSize = customer.orders.size()
            curCustomer = customer
        }
    }
    return curCustomer
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    // Return the most expensive ordered product
    var curMaxPrice = 0.0
    var curProduct: Product? = null
    for (order in orders) {
        for (product in order.products) {
            if (product.price > curMaxPrice) {
                curMaxPrice = product.price
                curProduct = product
            }
        }
    }
    return curProduct
}
