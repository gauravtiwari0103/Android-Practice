package kotlincollections

import java.util.Stack

fun main(){

    // QUEUE
    var q :ArrayDeque<Int> = ArrayDeque()
    q.add(23)
    q.add(325)
    q.add(3245)
    q.removeFirst()
    println(q)

}


// STACK
// solving leetcode's valid parenthsis using stack -> Solution got accepted.
// Problem link: https://leetcode.com/problems/valid-parentheses/
fun isValid(s: String): Boolean {
    var stack : Stack<Char> = Stack()
    for(c in s){
        if(c=='(' || c=='[' || c=='{') stack.push(c)
        else{
            if(stack.isEmpty()) return false
            val popped: Char = stack.pop()
            if(c==')') if(popped!='(') return false
            if(c==']') if(popped!='[') return false
            if(c=='}') if(popped!='{') return false
        }
    }
    return stack.isEmpty()
}


//