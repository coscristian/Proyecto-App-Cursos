function login() {

    const username = document.getElementById("floatingInput").value;
    const password = document.getElementById("floatingpassword").value;

    if(username == "") {
        showError("Ingresa un nombre de usuario");
        return;
    }

    if(password == "") {
        showError("Ingresa una contraseña");
        return;
    }

    const body = {
        "nombreUsuario": username,
        "contraseña": password
    }

    postToLogin(body);
}

const postToLogin = async (bodyObject) => {
    const url = "/api/inicioSesion";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type":"application/json"
        }
    });

    if(response.ok){
        const user = await response.json();
        localStorage.setItem("loggedUser", JSON.stringify(user));
        
        alert("Bienvenido " + user.nombre + "!", "success");
        
        await new Promise(r => setTimeout(r, 2000));

        window.location.href = "/";

    }else{
        const message = await response.text();
        showError(message);
    }
};

const showError = (message) =>{
    alert(message, "danger");
}

const alert = (message, type) => {
    document.getElementById("errorBox").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('');
}

