var arr = [
    {
        name: 'Richard Orr',
        color:'Purple',
        cheese:'Bleu'
    },
    {
        name: 'David Donnelly',
        color:'Blue',
        cheese:'Munster'
    },
    {
        name: 'Keith Clark',
        color:'Black',
        cheese:'Gouda'
    },
    {
        name: 'Adam Diarbakerli',
        color:'Red',
        cheese:'Cheddar'
    },
    {
        name: 'Steven Dodds',
        color:'Purple',
        cheese:'Parmesan'
    },
    {
        name: 'Blake Eiten',
        color:'Burgundy',
        cheese:'Swiss'
    }
];

window.onload=populateTable(arr);

function populateTable(arr) {
    var table = document.getElementById("table");
    arr.forEach((item)=>{
        let bob = document.createElement("tr");
        table.appendChild(bob);

        let td = document.createElement("td");
        bob.appendChild(td);
        td.innerHTML=item.name;

        td = document.createElement("td");
        bob.appendChild(td);
        td.innerHTML=item.color;
        td.style.backgroundColor=item.color;

        td = document.createElement("td");
        bob.appendChild(td);
        td.innerHTML=item.cheese;
    });
}