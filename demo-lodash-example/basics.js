// Mostly from: https://itnext.io/prototype-pollution-attack-on-nodejs-applications-94a8582373e7

// In Console, do following:

// Define function with function defined
function person(fullName, age) {
    this.age = age;
    this.fullName = fullName;
    this.details = function() {
        return this.fullName + " has age: " + this.age;
    }
}
var person1 = new person("Satoshi", 70);
var person2 = new person("Buterin", 26);

----------------------

// Define function with no function defined
function people(fullName, age) {
    this.age = age;
    this.fullName = fullName;
}

var people1 = new people("Susan", 20);
var people2 = new people("Tom", 30);

// Define prototype function for the function
people.prototype.details = function() {
    return this.fullName + " has age: " + this.age;
}

// Type these in console
people
person
people.prototype
person.prototype

// Try to define prototype of one of the objects, people1
// Note that it changes the adds the function even for people2!
people1.prototype.funny = function() {
    return this.fullName + " cannot be " + this.age;
}

// Can fun native code in the object as well
person1.constructor.constructor("return 1")
person1.constructor.constructor("return 1")()
person1.constructor.constructor("if (5>4) {return 'bigger'} else {return 'smaller'}")()

// Pollute prototype of objects
var arr = [
  [1, 2],
  [4, 5]
];

var bob = [
  ['a', 'b'],
  ['c', 'd']
];

arr
bob

arr['__proto__'][0] = 7;

arr
bob

// Using debugger, go over lodash-demo and lodash-demo-fix
