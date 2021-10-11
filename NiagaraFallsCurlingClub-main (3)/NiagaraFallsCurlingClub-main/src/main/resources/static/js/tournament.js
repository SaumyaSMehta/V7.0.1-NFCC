
console.log("Hey beech")
window.onload = function(){ 
  // your code 

var count=1;


document.getElementById("numOfDiv").onclick=function(){

  count =  document.getElementById("numCount").value;
  for (var i=0;i<count-1;i++){


    var headerSecond=document.getElementById("head2");
    var new_div = document.createElement("div");
    new_div.className = "tournamentDiv";
    new_div.innerHTML ="<div class='placementDiv'><label>Tournament " +(i+2)+ "</label><input type='submit' value='Register' class='registerBtn'></div>"
    
    headerSecond.parentNode.insertBefore(new_div,headerSecond);

    console.log("This is repeat " + i);

  }
}

function theFunction(e)
{ 
  alert(e.target.id);
}


};