// import { User } from './user';
// import { Account } from './account';
var readline = require('readline');
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
// var users = [
//     new User('rorr', 'pass'),
//     new User('jamarius', 'pass'),
//     new User('seth', 'notpass'),
//     new User('steven', '1234'),
//     new User('collin', 'soul'),
//     new User('joseph', 'design pattern')
// ];
// users.forEach((user)=>{
//     user.accounts = [];
//     user.accounts.push(new Account(
//         Math.random()*1001, 'Checking'));
//     user.accounts.push(new Account(
//         Math.random()*100001, 'Savings'));
// });
var username;
var password;
var loggedUser;
var account;
main();
function main() {
    printUsers();
}
function printUsers() {
    // users.forEach((user) => {console.log(user);});
    // let maxMoney = 0;
    // let maxUser;
    // users.forEach((user) => {
    //     let money = 0;
    //     //console.log(user);
    //     user.accounts.forEach((acct) => {money+=acct.balance});
    //     if (maxMoney < money){
    //         maxMoney=money;
    //         maxUser = user.username;
    //     }
    // });
    // console.log(`The user with the most money is ${maxUser} with ${maxMoney}`);
    rl.question("Input a thing: ", function (input) {
        console.log("You inputted: " + input);
        next();
    });
    function next() {
        rl.question("Input another thing: ", function (input) {
            console.log("Also: " + input);
        });
    }
}
