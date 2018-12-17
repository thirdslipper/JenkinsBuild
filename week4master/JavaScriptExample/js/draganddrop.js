var counter = 0;

window.onload=function(){
    var cap = false;
    document.getElementById("outer").addEventListener("click",click,cap);
    document.getElementById("inner").addEventListener("click",click,cap);
    document.getElementById("innerMost").addEventListener("click",click,cap);

    document.getElementById("outer").addEventListener("dragover", allowDrag,cap);
    document.getElementById("inner").addEventListener("dragover", allowDrag,cap);
    document.getElementById("innerMost").addEventListener("dragover", allowDrag,cap);

    document.getElementById("outer").addEventListener("dragstart", drag,cap);
    document.getElementById("inner").addEventListener("dragstart", drag,cap);
    document.getElementById("innerMost").addEventListener("dragstart", drag,cap);

    document.getElementById("outer").addEventListener("drop", drop,cap);
    document.getElementById("inner").addEventListener("drop", drop,cap);
    document.getElementById("innerMost").addEventListener("drop", drop,cap);
};

function click(){
    event.stopPropagation();
    console.log(event.currentTarget.id+" "+counter++);
}
function allowDrag(){
    console.log("dragover: "+event.target.id);
    event.preventDefault();
}
function drag(){
    event.stopPropagation();
    console.log("starting to drag: "+event.target.id);
    event.dataTransfer.setData("text",event.target.id);
}
function drop(){
    console.log("drop!")
    event.preventDefault();
    var data = event.dataTransfer.getData("text");
    event.target.insertBefore(
        document.getElementById(data),
        event.target.firstChild);
}