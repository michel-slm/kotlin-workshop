package v_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter {
        it.orders.filter { it.products.contains(product) }.isNotEmpty() }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive among delivered products
    // (use Order.isDelivered flag)
    var curProduct: Product? = null
    var curPrice = 0.0
    for (order in orders.filter { it.isDelivered }) {
        for (product in order.products) {
            if (product.price > curPrice) {
                curProduct = product
                curPrice = product.price
            }
        }
    }
    return curProduct
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Returns number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    var orderCount = 0
    for (customer in customers) {
        for (order in customer.orders) {
            orderCount += order.products.filter { it == product }.size()
        }
    }
    return orderCount
}
