

document.getElementById("hidediv").style.backgroundColor = "white";

function submitLoginForm(event) {
    event.preventDefault();

    if (event.target['name'].value == "admin" && event.target['password'].value == "admin") {

        localStorage.setItem("isAdmin", "true");
    }

}
