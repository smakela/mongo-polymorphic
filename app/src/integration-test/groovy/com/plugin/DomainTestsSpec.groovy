package com.plugin


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class DomainTestsSpec extends Specification {

   void setupData() {
        new Dog(name:'chuck').save(flush:true)
        new Bar(name:'chuck').save(flush:true)
    }

    void "Test finding with Dog class"() {
        given:
            setupData()
        expect:
            Dog.findWhere(name:"chuck") != null
    }

    void "Test finding with Animal class (polymorphic)"() {
        given:
            setupData()
        expect:
            Animal.findWhere(name:"chuck") != null
    }

    void "Test finding with Bar class"() {
        given:
            setupData()
        expect:
            Bar.findWhere(name:"chuck") != null
    }

    void "Test finding with Foo class (polymorphic)"() {
        given:
            setupData()
        expect:
            Foo.findWhere(name:"chuck") != null
    }    
}
