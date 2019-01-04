window.onload=()=>{
    console.log("Hello");

    // get an element by id
    var id = document.getElementById("t_id");
    var applePie = document.getElementById("t_name");
    var major = document.getElementById("t_major");

    console.log(id);
    console.log(applePie);
    console.log(major);

    // get an element by its tag name
    var header = document.getElementsByTagName("h1");
    console.log(header);

    // get elements by class name
    var labs = document.getElementsByClassName("lab");
    console.log(labs);

    // we can create elements
    var paragraph = document.createElement("p");
    paragraph.innerHTML="Hello, my name is JavaScript";
    document.getElementById("Mayuresh's Computer").appendChild(paragraph);

    b = document.getElementsByTagName("body");
    console.log(b[0].innerHTML);

    let button = document.getElementById("button");
    button.addEventListener("click", updateMajor);
};

function updateMajor(){
    console.log("callback functions!");
    var id = document.getElementById("t_id");
    var name = document.getElementById("t_name");
    var major = document.getElementById("t_major");

    var string = `${id.value}: ${name.value}, ${major.value}`;
    document.getElementById("me").innerHTML=string;
}