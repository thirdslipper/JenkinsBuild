import { Feline, Lion } from './cat';

function main(): string {
    console.log("Hello");
    return "Hello";
}

main();
var cat = new Feline("mew", "brown");
var lion = new Lion("rrrr", "white", "roar");
console.log(lion);

console.log(cat);
cat.speak();
lion.speak();