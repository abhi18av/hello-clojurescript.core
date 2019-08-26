
/////
// INTERVIEWCAKE
// 00 => Algorithmic Thinking
/////




// function printFirstItem(items) {
//     // always need to only access the first element only
//     console.log(items[0]);
// }

// printFirstItem([1,2,3,4,5])

// function printAllItems(items) {
//     items.forEach((anItem) => {
//         console.log(anItem)
//     })
// }

// printAllItems([1,2,3,3,4]);




// function printAllPossibleOrderedPairs(items) {
//   items.forEach(firstItem => {
//     items.forEach(secondItem => {
//       console.log(firstItem, secondItem);
//     });
//   });
// }


// printAllPossibleOrderedPairs(['a',"A",'b',"B"])

////////////



// // n is the upper limit of the range
// // singular number
// function sayHiNTimes(n) {
//   for (let i = 0; i < n; i++) {
//     console.log('hi');
//   }
// }

// // items itself is the entire range
// // collection
// function printAllItems(items) {
//   items.forEach(item => {
//     console.log(item);
//   });
// }

///////


// function printAllItemsTwice(items) {
//   items.forEach(item => {
//     console.log(item);
//   });

//   // Once more, with feeling
//   items.forEach(item => {
//     console.log(item);
//   });
// }



///////


// function printFirstItemThenFirstHalfThenSayHi100Times(items) {
//   console.log(items[0]); // constant time

//   const middleIndex = Math.floor(items.length / 2); // constant time calculation
//   let index = 0;
// // loop n/2
//   while (index < middleIndex) {
//     console.log(items[index]);
//     index++;
//   }

// // constant time
//   for (let i = 0; i < 100; i++) {
//     console.log('hi');
//   }
// }



///////

// // O(n + n*n) => O(n^2)

// function printAllNumbersThenAllPairSums(numbers) {


//     // O(n)
//     console.log('these are the numbers:');
//     numbers.forEach(number => {
//       console.log(number);
//     });
 
//     // O(n * n)
//     console.log('and these are their sums:');
//     numbers.forEach(firstNumber => {
//       numbers.forEach(secondNumber => {
//         console.log(firstNumber + secondNumber);
//       });
//     });
//   }


// printAllNumbersThenAllPairSums([2, 3, 4, 5 ,3 ,2]);


///////


// function contains(haystack, needle) {

//     // Does the haystack contain the needle?
//     for (let i = 0; i < haystack.length; i++) {
//       if (haystack[i] === needle) {
//         return true;
//       }
//     }
  
//     return false;
//   }

// console.log(contains([1,2,3,4,5], 2))


///////

// // n is a number and NOT a collection
// // constant space O(1)
// function sayHiNTimes(n) {
//     for (let i = 0; i < n; i++) {
//       console.log('hi');
//     }
//   }


// // n is a number and NOT a collection
// // space complexity O(n)
// function arrayOfHiNTimes(n) {
//   const hiArray = []; // declares an array - takes memory - will eventually contain n "hi" elements
//   for (let i = 0; i < n; i++) {
//     hiArray[i] = 'hi';
//   }
//   return hiArray;
// }

///////


// function getLargestItem(items) {
//   let largest = -Number.MAX_VALUE; // constant
//   items.forEach(item => {
//     if (item > largest) {
//       largest = item;
//     }
//   });
//   return largest;
// }

///////


// function getLargestItem(items) {
//   let largest = -Number.MAX_VALUE; // constant
//   items.forEach(item => {
//     if (item > largest) {
//       largest = item;
//     }
//   });
//   return largest;
// }


/////
// INTERVIEWCAKE
// 00 => Data Structures
/////


