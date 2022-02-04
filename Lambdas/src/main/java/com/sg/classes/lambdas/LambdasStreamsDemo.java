/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.lambdas;

import com.sg.classes.stream.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author geetikabatra
 */
class LambdasStreamsDemo {

    private List<Person> people;

    public LambdasStreamsDemo() {
        people = new ArrayList<>();
        loadPeople();
    }

    public void demo(String[] args) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        List<Person> adults = new ArrayList<>();
        for (Person curr : people) {
            if (curr.getAge() >= 18) {
                adults.add(curr);
            }
        }
        simpleStream();
        System.out.println("");
        integratedForEach();

    }

    private void simpleStream() {

        //make it var so compiler can figure out what datatype it is
        var fullyProcessed
                = people.stream()
                        .filter(aPerson -> aPerson.getAge() >= 18) //lambda operator ->
                        .filter(filteredPerson -> filteredPerson.getName().startsWith("F")) //still returns stream
                        .map(doublefiltered -> doublefiltered.getName()). //getting a name from stream
                        collect(Collectors.toList());    //converting to list

        //people.stream().filter(  ()->aPerson.getAge()>=18  );
        // people.stream().filter(  (aPerson,kmkm)->aPerson.getAge()>=18  );
        for (var a : fullyProcessed) {
            System.out.println(a);
        }

    }
        
    
    int count=0;
    
    private void integratedForEach() {

        
       // var fullyProcessed =
                 people.stream()
                        .filter(aPerson -> aPerson.getAge() >= 18) //lambda operator ->
                        .filter(filteredPerson -> filteredPerson.getName().startsWith("F")) //still returns stream
                        .map(doublefiltered -> doublefiltered.getName())
                        .forEach(somestring-> {
                            var repeated=somestring.repeat(2);
                            System.out.println(repeated);
                            
                                    }
                        );
        
                 
                  people.stream()
                        .filter(aPerson -> aPerson.getAge() >= 18) //lambda operator ->
                        .filter(filteredPerson -> filteredPerson.getName().startsWith("F")) //still returns stream
                        .map(doublefiltered -> doublefiltered.getName())
                          .forEach(  str-> count+=str.length() );   //no of char we passed thru
          
        
        
        
    }
    

    private void loadPeople() {
        people.add(new Person("Fred", 25));
        people.add(new Person("Freddy", 11));
        people.add(new Person("eddy", 9));
        people.add(new Person("edd", 30));
        people.add(new Person("eddie", 10));
    }

}
