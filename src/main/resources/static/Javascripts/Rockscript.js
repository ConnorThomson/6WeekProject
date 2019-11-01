
// function to add new entries to the database
    function savedata(){
        var Http=new XMLHttpRequest();
        Http.open("POST","http://"+location.hostname+":8081/rock/add");
        Http.setRequestHeader("Content-Type","application/json");
        let data={
            "artist": document.getElementById("rockartadd").value,
            "songtitle":document.getElementById("rocktitadd").value,
            "link":document.getElementById("rocklinadd").value
        };
        Http.send(JSON.stringify(data));
        alert("Thanks - record has now been added!!!!!"); 
    }
    //end of add function
    //show all data
    function showalldata(){
        var Http=new XMLHttpRequest();
        Http.open("GET","http://"+location.hostname+":8081/rock/showall");
        Http.setRequestHeader("Content-Type","application/json");
        Http.onload= function(){
            screen(JSON.parse(Http.response));
        };
        Http.send();
        };
    //end of show all data
    //displaying the data
    function screen(data){
        var A = 0;
        var table = document.getElementById("rocktable"); 
        while (table.hasChildNodes()) {
                table.removeChild(table.firstChild);
        }
        data.forEach(function(item){
             
            var row =table.insertRow(-1);
            var c1=row.insertCell(0);
            var c2=row.insertCell(1);
            var c3=row.insertCell(2);
            var c4=row.insertCell(3);
            var c5=row.insertCell(4);
            var c6=row.insertCell(5);

            var editButton = document.createElement("button");
            var delButton = document.createElement("button");

            editButton.innerText = "Edit";
            delButton.innerText = "Delete";

            editButton.addEventListener("click", function edit() {
                editrock(item, row);
            });

            delButton.addEventListener("click", function () {
            deleteRock(item.songnum);
            });

            c1.innerHTML=item.songnum;
            c2.innerHTML=item.artist;
            c3.innerHTML=item.songtitle;
            c4.innerHTML=item.link;
            c5.appendChild(editButton);
            c6.appendChild(delButton);
            
        });
        A += A;
    };
    //end of display
    //start of searching by artist
    function searchArtist(){
        let artist = document.getElementById("rockartsea").value;
        var Http=new XMLHttpRequest();
        Http.open("GET", "http://"+location.hostname+":8081/rock/findbyartist/"+artist);
        Http.setRequestHeader("Content-Type", "application/json");
        Http.onload=function(){
            screen(JSON.parse(Http.response))
        }
        Http.send();
    }
    //end of search by artist
    //start of searching by song
    function searchSong(){
        let song = document.getElementById("rocksonsea").value;
        var Http=new XMLHttpRequest();
        Http.open("GET", "http://"+location.hostname+":8081/rock/findbysong/"+song);
        Http.setRequestHeader("Content-Type", "application/json");
        Http.onload=function(){
            screen(JSON.parse(Http.response))
        }
        Http.send();
    }
    //end search by song
    //edit items
    function editrock(info, row) {
        while (row.hasChildNodes()) {
            row.removeChild(row.firstChild);
        }
        var td1=document.createElement("td");
        var td2=document.createElement("td");
        var td3=document.createElement("td");
        var td4=document.createElement("td");
        var td5=document.createElement("td");
        
        
        var songnum=document.createElement("input");
        var songartist=document.createElement("input");
        var songtitle=document.createElement("input");
        var songlink=document.createElement("input");
        var update=document.createElement("input");


        songnum.value=info.songnum;
        songartist.value=info.artist;
        songtitle.value=info.songtitle;
        songlink.value=info.link;
        update.type="button";
        update.value="Update";
        update.onclick=function(){
            var Http=new XMLHttpRequest();
             Http.open("PUT","http://"+location.hostname+":8081/rock/update");
            Http.setRequestHeader("Content-Type","application/json");
            let data={
                "songnum":songnum.value,
                "artist":songartist.value ,
                "songtitle":songtitle.value,
                "link": songlink.value,
             };
             Http.onload=function(){
                //screen(JSON.parse(Http.response)){
                    showalldata();
                }
             

            
            Http.send(JSON.stringify(data));
            alert("Thanks - record has now been added!!!!!"); 
            };
        
        td1.appendChild(songnum);
        td2.appendChild(songartist);
        td3.appendChild(songtitle);
        td4.appendChild(songlink);
        td5.appendChild(update);
        
        row.appendChild(td1);
        row.appendChild(td2);
        row.appendChild(td3);
        row.appendChild(td4);
        row.appendChild(td5);
        
    }
   // button.removeEventListener("click", func);
    // button.addEventListener("click", function () {
    //     info.artist = c2.innerText;
    //     info.songtitle = c3.innerText;
    //     info.link = c4.innerText;
        
    // });
    //finished editting items
    function deleteRock(id) {
    const http = new XMLHttpRequest();
    const url = 'http://'+location.hostname+':8081/rock/delete/' + id;
    http.open("DELETE", url);
    http.onload = function (e) {
        window.location.reload();
        alert("Record successfully deleted - thanks for helping out");
    }
    http.send();
}