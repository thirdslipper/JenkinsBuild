// Global Variables;
// a-e are the divs we wish to observe.
// cap is a variable that, when true, enables capturing
// button is a button that will swap cap
var cap = false;
var a = document.getElementById("A");
var b = document.getElementById("B");
var c = document.getElementById("C");
var d = document.getElementById("D");
var e = document.getElementById("E");
var button = document.getElementById("button");


window.onload=function(){
    button.innerHTML="Capture?";
    addEventListenersToDivs();
    button.addEventListener("click", switchCapture);
}

function switchCapture(){
    removeEventListenersFromDivs();
    if(!cap){
        cap=true;
        console.log("set to capture");
        button.innerHTML="Bubble?"
    } else{
        cap = false;
        console.log("set to bubble");
        button.innerHTML="Capture?"
    }
    addEventListenersToDivs();
}

function select(element) {
    //event.stopPropagation();
    element.style.backgroundColor="purple";
    console.log(element.id);
}
function unSelect(element) {
    element.style.backgroundColor="orange";
}

function selectWrapper() {
    select(this);
}
function unSelectWrapper() {
    unSelect(this);
}

function removeEventListenersFromDivs(){
    a.removeEventListener("mouseover",selectWrapper,cap);
    b.removeEventListener("mouseover",selectWrapper,cap);
    c.removeEventListener("mouseover",selectWrapper,cap);
    d.removeEventListener("mouseover",selectWrapper,cap);
    e.removeEventListener("mouseover",selectWrapper,cap);
}
function addEventListenersToDivs(){
    a.addEventListener("mouseover",selectWrapper,cap);
    b.addEventListener("mouseover",selectWrapper,cap);
    c.addEventListener("mouseover",selectWrapper,cap);
    d.addEventListener("mouseover",selectWrapper,cap);
    e.addEventListener("mouseover",selectWrapper,cap);

    a.addEventListener("mouseout",unSelectWrapper,cap);
    b.addEventListener("mouseout",unSelectWrapper,cap);
    c.addEventListener("mouseout",unSelectWrapper,cap);
    d.addEventListener("mouseout",unSelectWrapper,cap);
    e.addEventListener("mouseout",unSelectWrapper,cap);
}