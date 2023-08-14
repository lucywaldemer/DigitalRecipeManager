window.addEventListener("load", function(){
// add link to API URL
    this.fetch('API NAME')
    .then(function(response){
        return response.json();
    }).then(function(response){
        //push out each recipe to the screen
    //get our element
    let myContainer = document.getElementById('container');
    //run a loop
    let allMyHTML="";
    for(let i=0; i<response.length; i++){
        let myHTML= `
        <div class="recipe">

        // How do we want to adapt the astronaut data to fit our recipes?
       <div class="bio">
          <h3>${response[i].firstName} ${response[i].lastName}</h3>
          <ul>
             <li>Hours in space: ${response[i].hoursInSpace}</li>
             <li>Active:${response[i].active}</li>
             <li>Skills: ${response[i].skills}</li>
          </ul>
       </div>
       <img class="avatar" src="${response[i].picture}">
    </div>
        `;

        allMyHTML += myHTML;
    }
    myContainer.innerHTML=allMyHTML
    })
    });