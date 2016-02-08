package com.plugin


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class DomainTestsSpec extends Specification {

   void setupData() {
        new Dog(name:'chuckie', colour:'black').save(flush:true)
    }

    void "Test finding with Dog class"() {
        given:
            setupData()
        expect:
            Dog.findWhere(name:"chuckie") != null
    }

    void "Test finding with Animal class (polymorphic)"() {
        given:
            setupData()
        expect:
            Animal.findWhere(name:"chuckie") != null
    }
}
