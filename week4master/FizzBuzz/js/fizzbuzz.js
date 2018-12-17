// first number
// second number

// when the button is pressed, it will display fizz buzz
// from first to second

// fizz buzz is the sequence numbers printed where any
// number divisible by 3 is replaced with 'fizz', and
// any number divisible by 5 is replaced with 'buzz'.
// If a number (15) is divisible by both, it will print
// 'fizzbuzz' instead.

/* David Donnelly's solution: 
window.onload=function(){
    document.getElementById("button").addEventListener("click",clicked);
 }
 
 function clicked(){
    var theList = document.getElementById("list");
    while (theList.firstChild) {
        theList.removeChild(theList.firstChild);
    }
    var a = parseInt(document.getElementById("first").value);
    var b = parseInt(document.getElementById("second").value);
    fizzbuzz(a,b);
 }
 
 function fizzbuzz(a, b){
    for(var i=a; i<=b;i++){
        var output = "";
        if(i%3 == 0){
            output += "fizz";
        }
        if(i%5 == 0){
            output += "buzz"
        }
        let p = document.createElement("p");
        document.getElementById("list").appendChild(p);
        p.innerHTML= i + " "+ output;
    }
 } */

 /* Mateusz's Solution 
 window.onload = () => {
    // Create the button onClick event.
    document.getElementById("button").addEventListener("click", () => {
        // Get the start and end values.
        var startVal = parseInt(document.getElementById("first").value);
        var endVal = parseInt(document.getElementById("second").value);
 
        var displayDiv = document.getElementById("list");
        // Clear the display div.
        displayDiv.innerHTML = "";
 
        // Loop from startVal to endVal.
        for(; startVal <= endVal; startVal++) {
            var out = startVal;
 
            // Figure out what to display.
            if((startVal % 3 == 0) && (startVal % 5 == 0)) {
                out = "fizzbuzz";
            } else if(startVal % 3 == 0) {
                out = "fizz";
            } else if(startVal % 5 == 0) {
                out = "buzz";
            }
 
            // Append out to the display div.
            displayDiv.innerHTML += `<p>${out}</p>`;
        }
    });
 } */

/* Blake's solution 
window.onload = function (){
    document.getElementById("button").addEventListener("click",fizzbuzzer);
}


function fizzbuzzer(){
    let int1 = Number(document.getElementById("first").value);
    let int2 = Number(document.getElementById("second").value);

    console.log("int1 = " + int1 + " int2 = " + int2);

    for(let count = int1; count <= int2; count++){

        if(count % 3 == 0 || count % 5 == 0){
            
            if(count % 3 == 0){
                document.getElementById("list").innerHTML += "fizz";
                console.log("fizzing");
            }
            if(count % 5 == 0){
                document.getElementById("list").innerHTML += "buzz";
                console.log("buzzing");
            }
            document.getElementById("list").innerHTML += "<br>";
        }
       else {
            document.getElementById("list").innerHTML += count;
            document.getElementById("list").innerHTML += "<br>";

            console.log("numbering");
            }        
        }
}*/
/* Keith's solution: 
function click(){
    var num1 = document.getElementById("first").value;
    var num2 = document.getElementById("second").value;
    var div = document.createElement("div");
    console.log("start");
    for(var i = num1; i<=num2; i++){
        console.log("check:" + i);
       if(i%3 ===0 && i%5 ===0){
            console.log("print fizzbuss");
            div.innerHTML += "<p>fizzbuzz</p>";
        }else{
            if(i%3 ===0){
                div.innerHTML += "<p>fizz</p>";
        }else if(i%5 ===0){
                div.innerHTML += "<p>buzz</p>";
        }else{
            div.innerHTML += "<p> " + i +" </p>";
        }
    }
    console.log("done");
    }
 }
 
 document.getElementById("button").addEventListener("click", click);
 */
window.onload=()=>{
    document.getElementById("button").onclick=fizz;
}

function fizz() {
    let first = +document.getElementById("first").value;
    let second = +document.getElementById("second").value;

    if(first>second) {
        let a = first;
        first =second;
        second = a;
    }
    let fizzbuzz = [];
    for(let i = first; i<=second; i++) {
        let string = '';
        if(i%3===0)
            string+= 'fizz';
        if(i%5===0)
            string+='buzz';
        if(string==='')
            string+=i;
        fizzbuzz.push(string);
    }
    setFizzBuzz(fizzbuzz);
};
function setFizzBuzz(fizzbuzz) {
    let div = document.getElementById("list");
    div.innerHTML='';
    let ul = document.createElement('ul');
    div.appendChild(ul);
    fizzbuzz.forEach((item)=> {
        let li = document.createElement("li");
        li.innerHTML=item;
        ul.appendChild(li);
    });
}