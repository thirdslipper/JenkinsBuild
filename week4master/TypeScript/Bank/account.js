"use strict";
exports.__esModule = true;
var Account = /** @class */ (function () {
    function Account(balance, type) {
        this.balance = balance;
        this.type = type;
    }
    Account.prototype.withdraw = function (amount) {
        this.balance = this.balance - amount;
    };
    Account.prototype.deposit = function (amount) {
        //console.log(this.balance);
        this.balance = this.balance + amount;
        //console.log(this.balance);
    };
    return Account;
}());
exports.Account = Account;
