
// function factorial(x) {
//     if (x == 0 ) {
//         return 1;
//     } else {
//         return x * factorial(x - 1);
//     }
// }


// console.log(factorial(5))
// console.log(factorial(10))



// function Building(floors) {
//     this.what = "building";
//     this.floors  = floors;
//     this.countFloors = `Has ${this.floors} floors`
// };

// var myHouse = new Building(3);

// console.log(myHouse)

// console.log(typeof myHouse);

// myHouse.constructor;


function Tree(apples) {
   this.color = 'red';
}

Tree.prototype.quantity = function (quantity) {
    console.log(quantity);
}

var aTree = new Tree('apples');


// the constructor for Rectangle1 and Rectangle2 are the same.
class Rectangle1 {
    constructor(height, width) {
      this.height = height;
      this.width = width;
    }
  }

function Rectangle2 (height, width) {
    this.height = height;
    this.width = width;
}

// subclasssing and inheritance NOTE

