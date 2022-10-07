const loadUserConfig = () => {
    const loginLi = document.getElementById("login-link");
    const logoutLi = document.getElementById("logout-link");

    const user = localStorage.getItem("loggedUser");
    if(user == undefined) {
        loginLi.style.display = 'block';
        logoutLi.style.display = 'none';
    }else{
        loginLi.style.display = 'none';

        logoutLi.style.display = 'block';

        const userInfo = JSON.parse(user);

        const gestCursosA = document.getElementById("gest-cursos");
        const separadorDiv = document.getElementById("barra");
        if (userInfo.admin){
            gestCursosA.style.display = 'flex';
        }else{
            gestCursosA.style.display = 'none';
            separadorDiv.style.display = 'none';
        }
        document.getElementById("user-fullname").innerText = userInfo.nombre;
    }
};

loadUserConfig();