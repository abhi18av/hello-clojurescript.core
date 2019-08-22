
/////
//  UTILS
/////

let clog = console.log;

/////
// 
/////

// let teacher : string = 'Kyle';
// let twitterHandle : string = 'getify';
// let age : number = 39;

// function whoAmI(myName: string, myNickname: string, myAge: number) {
//     clog(`
//     Hi, my name is ${myName}.
//     My nickname, which is also my twitter handle, is ${myNickname}.
//     And finally, my age is ${myAge}
//     `);
// };


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

// if (String && Number && BigInt && Array && Object) {
//     clog(true)
// } else {
// // undefined/NaN/null -> false
//     clog(false)
// }


/////
// 
/////

// let studentNames : string[] = ['Jack', 'Jill'];

// for (let i = 0 ; i < studentNames.length ; i++) {
//     clog(studentNames[i]);
// }

// for (let student in studentNames ) {
//     clog(student);
// }

// for (let student of studentNames ) {
//     clog(student);
// }

// while (studentNames.length > 0) {
//     let student = studentNames.pop();
//     clog(student)    
// }

/////
// 
/////




function timeOut(n: number) {
    return new Promise(res => setTimeout(res,n));
}

//timeOut(1);

export async function addNumbers(a: number, b: number) {
    await timeOut(500);
    return a + b;
}

(async () => {
    clog(await addNumbers(1,9))
})();
