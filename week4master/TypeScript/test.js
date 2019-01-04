"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var cat_1 = require("./cat");
function main() {
    console.log("Hello");
    return "Hello";
}
main();
var cat = new cat_1.Feline("mew", "brown");
var lion = new cat_1.Lion("rrrr", "white", "roar");
console.log(lion);
console.log(cat);
cat.speak();
lion.speak();
