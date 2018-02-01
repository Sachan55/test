var myImage = document.querySelector('img');

myImage.onclick = function() {
    var mySrc = myImage.getAttribute('src');
    if(mySrc === 'images/firefox-icon.png') {
      myImage.setAttribute ('src','images/chrome.png');
    } else {
      myImage.setAttribute ('src','images/firefox-icon.png');
    }
}
var mybutton = document.querySelector('button');
var myHeading = document.querySelector('h1');

function setUserName(){
         var myname = prompt('please enter your name : ');
         localStorage.setItem('name' , myname);
         myHeading.textContent = 'mozilla is cool, ' + myname;
}

if(!localStorage.getItem('name')){
	setUserName();
}
else{
	var storedName = localStorage.getItem('name');
	myHeading.textContent = 'Mozilla is cool, ' + storedName;
}