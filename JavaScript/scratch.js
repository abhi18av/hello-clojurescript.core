/////
//  UTILS
/////

clog = console.log;

/////
// 
/////

let teacher = 'Kyle';
let twitterHandle = 'getify';
let age = 39;

function whoAmI(myName, myNickname, myAge) {
    clog(`
    Hi, my name is ${myName}.
    My nickname, which is also my twitter handle, is ${myNickname}.
    And finally, my age is ${myAge}
    `);
};


// whoAmI(teacher, twitterHandle, age);


//whoAmI('Abhinav', 'abhi18av', 27 );

/////
// 
/////

// clog(
// 42,
// 3.41,
// true,
// null,
// undefined,
// [1,2,3,4,5],
// {name : 'name'}
// )

/////
// 
/////

// clog(3===3.0)

// clog(typeof(NaN))

// clog(typeof(1n))

// clog(typeof(null))

// clog(typeof([1,2,3]))

// clog(typeof([1,2,3]) == Array)

// clog(Object.is(Array, [1,2,3]))

// clog(Array.isPrototypeOf([1,2]))

// clog(Array(1,2) == [1,2])

// clog(Array(1,2) === [1,2])

// clog([1,2].constructor)

/////
// 
/////

if (String && Number && BigInt && Array && Object) {
    clog(true)
} else {
// undefined/NaN/null -> false
    clog(false)
}
