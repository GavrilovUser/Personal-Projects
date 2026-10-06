<img src="image/preview.png" width="300">

## Бэкенд кликер
Написан на Spring Boot / Rest API

### Использование
Для запуска сервера нужно зайти в корень проекта, и ввести:
~~~Bash
./gradlew bootRun
~~~
Либо
~~~Bash
sh gradlew bootRun
~~~

**После запуска сервера, можно вводить запросы:**
~~~Prompt
http://localhost:8080/api/
~~~
Либо
~~~Prompt
http://127.0.0.1:8080/api/
~~~
### Запросы
- `[GET] balance` – Возвращает класс Account
- `[POST] click` – Добавляет единицу к счёту