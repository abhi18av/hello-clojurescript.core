/*
 * This is a JavaScript Scratchpad.
 *
 * Enter some JavaScript, then Right Click or choose from the Execute Menu:
 * 1. Run to evaluate the selected text (Cmd-R),
 * 2. Inspect to bring up an Object Inspector on the result (Cmd-I), or,
 * 3. Display to insert the result in a comment after the selection. (Cmd-L)
 */


var obj = {'a' : "A", 'b' : "B"}

obj['c'] = "C"

delete(obj.c)

Object.keys(obj)

Object.values(obj)

////////////////////


var nativeMap = new Map([[ 1, 'one' ],[ 2, 'two' ]])

repl

///////

var myMap = new Map();

var    keyString = 'a string';
var    keyObj = {};
var    keyFunc = function() {};
var    add9 = function (x) { 
                console.log(x + 9);
                return x + 9;}
var    add2 = (x) => {console.log(x + 2); return x+2;}

// setting the values
myMap.set(keyString, "value associated with 'a string'");
myMap.set(keyObj, 'value associated with keyObj');
myMap.set(keyFunc, 'value associated with keyFunc');
myMap.set(add9, 'value associated with add9');
myMap.set(add2, 'value associated with add2');

myMap.get(add9(9))
myMap.get(add2(2))


myMap.size; // 3

// getting the values
myMap.get(keyString);    // "value associated with 'a string'"
myMap.get(keyObj);       // "value associated with keyObj"
myMap.get(keyFunc);      // "value associated with keyFunc"

myMap.get('a string');   // "value associated with 'a string'"
                         // because keyString === 'a string'
myMap.get({});           // undefined, because keyObj !== {}
myMap.get(function() {}); // undefined, because keyFunc !== function () {}
