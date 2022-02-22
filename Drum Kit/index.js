// click 
for (var i = 0; i < document.querySelectorAll(".drum").length; i++) {
    document.querySelectorAll(".drum")[i].addEventListener("click", function () {
        var btnInnerHtml = this.innerHTML;
        makesound(btnInnerHtml);
        btnanimation(btnInnerHtml);
    });
}


// keyboard press
document.addEventListener("keypress", function (element) {
    makesound(element.key);
    btnanimation(element.key);
});

function makesound(key) {
    switch (key) {
        case "w":
            var audio = new Audio("sounds/tom-1.mp3");
            audio.play();
            break;
        case "a":
            var audio = new Audio("sounds/tom-2.mp3");
            audio.play();
            break;
        case "s":
            var audio = new Audio("sounds/tom-3.mp3");
            audio.play();
            break;
        case "d":
            var audio = new Audio("sounds/tom-4.mp3");
            audio.play();
            break;
        case "j":
            var audio = new Audio("sounds/crash.mp3");
            audio.play();
            break;
        case "k":
            var audio = new Audio("sounds/kick-bass.mp3");
            audio.play();
            break;
        case "l":
            var audio = new Audio("sounds/snare.mp3");
            audio.play();
            break;
        default:
            console.log(btnInnerHtml);
            break;
    }
}

function btnanimation(currKey){
    var activebtn= document.querySelector("."+currKey);
    activebtn.classList.add("pressed");
    setTimeout(() => {
       activebtn.classList.remove("pressed") ;
    }, 100);
}

