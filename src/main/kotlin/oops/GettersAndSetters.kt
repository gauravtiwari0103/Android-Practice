package oops

class GettersAndSetters {
    var pi: Float = 3.14f
        get() = field
        set(newval) {
            field = newval
        }
}
/*
please note that using pi directly in the getter and setter will result in an infinite recursion
because accessing pi within the getter or setter will trigger the getter or setter again,
leading to an endless loop. To avoid this, you need to use a backing field (e.g., field) to
store the actual value of the property.
 */