/*===== FOCUS =====*/
const inputs = document.querySelectorAll(".form__input")

/*=== Add focus ===*/
function addfocus(){
    let parent = this.parentNode.parentNode
    parent.classList.add("focus")
}

/*=== Remove focus ===*/
function remfocus(){
    let parent = this.parentNode.parentNode
    if(this.value == ""){
        parent.classList.remove("focus")
    }
}

/*=== To call function===*/
inputs.forEach(input=>{
    input.addEventListener("focus",addfocus)
    input.addEventListener("blur",remfocus)
})

function validate(){
    var formEmail = document.getElementById("form__email");
    var formPassword = document.getElementById("form__password");
    var email = document.getElementById("email").value;
    var text = document.getElementById("text");
    var text2 = document.getElementById("text2");
    var password = document.getElementById("password").value;
    const pattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;

    if(email.match(pattern)){
     formEmail.classList.add("valid");
     formEmail.classList.remove("invalid");
     text.innerHTML = "Правильный E-mail.";
     text.style.color = "#00ff00";
    }
    else{
     formEmail.classList.remove("valid");
     formEmail.classList.add("invalid");
     text.innerHTML = "Неправильный E-mail.";
     text.style.color = "#ff0000";
    }
    if(email == ""){
     formEmail.classList.remove("valid");
     formEmail.classList.remove("invalid");
     text.innerHTML = "";
     text.style.color = "#00ff00";
    }

    if(password.length < 8){
        formPassword.classList.remove("valid");
        formPassword.classList.add("invalid");
        text2.innerHTML = "Длинна пароля меньше 8 символов.";
        text2.style.color = "#ff0000";
       }
       else
       if(password.length > 15){
        formPassword.classList.remove("valid");
        formPassword.classList.add("invalid");
        text2.innerHTML = "Длинна пароля больше 15 символов.";
        text2.style.color = "#ff0000";
       }
       else{
        formPassword.classList.add("valid");
        formPassword.classList.remove("invalid");
        text2.innerHTML = "Правильный пароль.";
        text2.style.color = "#00ff00";
       }
       if(password.length == 0){
        formPassword.classList.remove("valid");
        formPassword.classList.remove("invalid");
        text2.innerHTML = "";
        text2.style.color = "#00ff00";
       }


   }
   
