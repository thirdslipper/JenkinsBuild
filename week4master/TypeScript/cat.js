"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
var Feline = /** @class */ (function () {
    function Feline(purr, fur) {
        this.meow = purr;
        this.fur = fur;
    }
    // Classes can have "methods" but they're still functions
    Feline.prototype.speak = function () {
        console.log(this.meow);
    };
    Feline.NUM_LEGS = 4;
    return Feline;
}());
exports.Feline = Feline;
var Lion = /** @class */ (function (_super) {
    __extends(Lion, _super);
    function Lion(purr, fur, roar) {
        var _this = _super.call(this, purr, fur) || this;
        _this.roar = roar;
        return _this;
    }
    Lion.prototype.speak = function () {
        console.log(this.roar);
    };
    Lion.origin = "Africa";
    return Lion;
}(Feline));
exports.Lion = Lion;
