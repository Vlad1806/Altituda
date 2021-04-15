/*===== SHOW NAVBAR  =====*/ 
const showNavbar = (toggleId, navId, bodyId, headerId) =>{
    const toggle = document.getElementById(toggleId),
    nav = document.getElementById(navId),
    bodypd = document.getElementById(bodyId),
    headerpd = document.getElementById(headerId)

    // Validate that all variables exist
    if(toggle && nav && bodypd && headerpd){
        toggle.addEventListener('click', ()=>{
            // show navbar
            nav.classList.toggle('show')
            // change icon
            toggle.classList.toggle('bx-x')
            // add padding to body
            bodypd.classList.toggle('body-pd')
            // add padding to header
            headerpd.classList.toggle('body-pd')
        })
    }
}

showNavbar('header-toggle','nav-bar','body-pd','header')

/*===== LINK ACTIVE  =====*/ 
const linkColor = document.querySelectorAll('.nav__link')

function colorLink(){
    if(linkColor){
        linkColor.forEach(l=> l.classList.remove('active'))
        this.classList.add('active')
    }
}
linkColor.forEach(l=> l.addEventListener('click', colorLink))


const labels = document.querySelectorAll(".nav__link");
const tabs = document.querySelectorAll(".nav__link");

function toggleShow() {
	const target = this;
	const item = target.classList.contains("nav__link")
		? target
		: target.parentElement;
	const group = item.dataset.actabGroup;
	const id = item.dataset.actabId;

	tabs.forEach(function(tab) {
		if (tab.dataset.actabGroup === group) {
			if (tab.dataset.actabId === id) {
				tab.classList.add("accordion-active");
			} else {
				tab.classList.remove("accordion-active");
			}
		}
	});

	labels.forEach(function(label) {
		const tabItem = label.parentElement;

		if (tabItem.dataset.actabGroup === group) {
			if (tabItem.dataset.actabId === id) {
				tabItem.classList.add("accordion-active");
			} else {
				tabItem.classList.remove("accordion-active");
			}
		}
	});
}

labels.forEach(function(label) {
	label.addEventListener("click", toggleShow);
});

tabs.forEach(function(tab) {
	tab.addEventListener("click", toggleShow);
});

var modal = document.getElementById("modal__add-user");

// Get the button that opens the modal
var btn = document.getElementById("add_user");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

var delete_modal = document.getElementById("modal__delete-user");

// Get the button that opens the modal
var btn_delete = document.getElementById("delete_user");

// Get the <span> element that closes the modal
var span_delete = document.getElementsByClassName("close__delete")[0];

// When the user clicks on the button, open the modal 
btn_delete.onclick = function() {
  delete_modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span_delete.onclick = function() {
  delete_modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == delete_modal) {
    delete_modal.style.display = "none";
  }
}

var edit_modal = document.getElementById("modal__edit-user");

// Get the button that opens the modal
var btn_edit = document.getElementById("edit_user");

// Get the <span> element that closes the modal
var span_edit = document.getElementsByClassName("close__edit")[0];

// When the user clicks on the button, open the modal 
btn_edit.onclick = function() {
  edit_modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span_edit.onclick = function() {
  edit_modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == edit_modal) {
    edit_modal.style.display = "none";
  }
}


