package kotlincollections

import kotlin.math.max

fun main(){
    // HASHMAP
    // Problem: find the word with highest frequency in the sentence taking input from user
    val map: HashMap<String, Int> = HashMap()
    val sentence: String = readln()
    for(word in sentence.split(" ")){
        map.put(word,map.getOrDefault(word,0)+1)
    }
    var maxFreq = 0
    var ans = ""
    for(key in map.keys){
        val curFreq = map[key]!!
        if(curFreq >maxFreq){
            maxFreq = curFreq
            ans = key
        }
    }
    println("Word with highest frequency is: $ans")



    // HASHSET
    // Problem find the number of unique words in the sentence
    val str = readln()
    val set: HashSet<String> = HashSet()
    for(word in str.split(" ")){
        set.add(word)
    }
    println("No of unique words in sentence is: ${set.size}")

}