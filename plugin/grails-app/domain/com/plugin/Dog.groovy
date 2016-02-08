package com.plugin

class Dog extends Animal {

    String colour

    static constraints = {
        colour nullable:true
    }
}