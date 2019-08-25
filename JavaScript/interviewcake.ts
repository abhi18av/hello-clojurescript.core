// function printFirstItem(items : number[]) {
//  //     always need to only access the first element only
//     console.log(items[0]);
// }

// printFirstItem([1,2,3]);
// printFirstItem([1,2,3,4,5,6]);
// printFirstItem([1]);

//////////

function printAllItems(items : number[]) {
    items.forEach((anItem : number) => {
        console.log(anItem)
    })
}


printAllItems([1,2,3,3,4]);

