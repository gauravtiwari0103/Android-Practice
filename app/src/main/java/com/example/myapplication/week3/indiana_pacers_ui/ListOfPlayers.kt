package com.example.myapplication.week3.indiana_pacers_ui

import com.example.myapplication.R
import com.example.myapplication.week3.indiana_pacers_ui.data.Player

object ListOfPlayers {
    val listOfPlayer:ArrayList<Player> = ArrayList()

    init {
        listOfPlayer.add(Player("John Wendy","4","Gaurd", R.drawable.player1))
        listOfPlayer.add(Player("Wick Morty","13","Forward-Center", R.drawable.player2))
        listOfPlayer.add(Player("Steve Carry","23","Gaurd-Center", R.drawable.player3))
        listOfPlayer.add(Player("Miles Morales","3","Forward-Center", R.drawable.player4))
        listOfPlayer.add(Player("Wreak Ralph","435","Gaurd", R.drawable.player9))
        listOfPlayer.add(Player("Buzz Bitsyear","53","Forward-Center", R.drawable.player6))
        listOfPlayer.add(Player("Will Mith","60","Forward-Center", R.drawable.player7))
        listOfPlayer.add(Player("Stuart Giant","7","Forward-Center", R.drawable.player8))
        listOfPlayer.add(Player("Balleno Guss","77","Gaurd-Center", R.drawable.player9))
        listOfPlayer.add(Player("Guss Ring","18","Forward-Center", R.drawable.player10))
        listOfPlayer.add(Player("Jesse Whiteman","1","Forward-Center", R.drawable.player11))
        listOfPlayer.add(Player("Snow Black","53","Gaurd-Center", R.drawable.player12))
        listOfPlayer.add(Player("Green Amber","26","Gaurd-Forward", R.drawable.player13))
        listOfPlayer.add(Player("Huggie Morales","73","Gaurd", R.drawable.player14))
        listOfPlayer.add(Player("Ninne Hardy","65","Gaurd-Center", R.drawable.player15))
    }
}