function Stack () {
    this.storage = "";
}

Stack.prototype.push = function (val) {
    this.storage = this.storage + "," + val;
    return this.storage
}

Stack.prototype.pop = function () {
    return this.storage.split(",").pop()
}

Stack.prototype.size = function () {
    return this.storage.split(",").length - 1;
}

var myWeeklyMenu = new Stack();

myWeeklyMenu.push('RedBeans');

