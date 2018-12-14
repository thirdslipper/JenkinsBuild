var a = "ten"; // The function that this var is in, is global
h = "fifteen"; // global
console.log(h);
console.log(a);

for (i = 0; i < 5; i++) {
    const block = "hello";
    console.log(i);
    console.log(block);
}
console.log("outside of the block")
console.log(i);
//console.log(block);
let g = 3;
function fun() {
    console.log(b);
    global = "hello";
    var b = 6;
    console.log("inside the function");
    console.log("global" + global);
    console.log("a=" + a);
    console.log("i=" + i);
    console.log("g=" + g);
    console.log("b=" + b);
    return;
}

console.log("calling fun");
fun();
console.log("outside the function");
console.log("global" + global);
console.log("a=" + a);
console.log("i=" + i);
console.log("g=" + g);
//console.log("b=" + b);

var h = 3;

function bar() {
    console.log("bar h ="+h);
    var h = 5;
    console.log("bar h ="+h);
}
bar();
console.log(h);
console.log("----------------------------");

/* Closure
    An inner function has access to the scope of an
    outer function even after the scope of the outer
    function has ended.
    */
// in JS, Closure is how we accomplish encapsulation
function foo() {
    var hidden=6;
    return {
        h: 5,
        getHidden: function() {
            return hidden;
        },
        setHidden: function(num) {
            hidden = num;
        }
    };
}
console.log("h");
var h = foo();
console.log(h);

console.log(h.getHidden());
h.hidden = 7;
console.log(h.getHidden());
console.log(h);


// Prototyping
/* In JavaScript, an object has a reference to another object
    to which it can delegate tasks. This object is called the
    prototype. Whenever an object is asked for a field, the object's
    keys are searched and then it will move up the prototype chain looking
    for keys if no keys that match were found.
    */
var bean = function() {
    this.name = "Bean";
    this.type="Green";
    this.grow = function() {
        return "I grew 4 inches";
    };
};

console.log(bean);
var greenBean = new bean();
console.log(greenBean);

var gmoBean = function() {
    this.name="GMOBean";
};

gmoBean.prototype=new bean();
gmoBean.prototype.constructor = gmoBean;

var b = new gmoBean();
console.log(b);

console.log(b.name);
console.log(b.grow());

console.log(b instanceof bean);
console.log(b instanceof gmoBean);
console.log(b instanceof {}.constructor);

bean.prototype = new gmoBean();
bean.prototype.constructor=bean;

var b2 = new bean();
console.log(b2);

console.log(b.__proto__.name);
b.type = 875;
console.log(b);

