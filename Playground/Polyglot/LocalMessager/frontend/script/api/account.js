fetch("http://localhost:8080/api/account")
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error("Ошибка запроса:", error);
    });