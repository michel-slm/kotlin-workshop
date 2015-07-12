package v_collections

import java.util.*

fun example7() {
    val result = listOf("a", "b", "ba", "ccc", "ad").groupBy { it.length() }

    result == mapOf(1 to listOf("a", "b"), 2 to listOf("ba", "ad"), 3 to listOf("ccc"))
}

fun Shop.groupCustomersByCity(): Map<City, List<Customer>> {
    // Return the map of the customers living in each city
    val customerMap = HashMap<City, LinkedList<Customer>>()
    for (customer in customers) {
        if (customerMap.containsKey(customer.city)) {
                    customerMap.get(customer.city).add(customer)
        }
        else {
            val customerList = LinkedList<Customer>()
            customerList.add(customer)
            customerMap.set(customer.city, customerList)
        }
    }
    return customerMap
}
