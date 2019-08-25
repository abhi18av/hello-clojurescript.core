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


function printAllItemsTwice(items) {
  items.forEach(item => {
    console.log(item);
  });

  // Once more, with feeling
  items.forEach(item => {
    console.log(item);
  });
}