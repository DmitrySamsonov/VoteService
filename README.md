VoteService
===========
ЗАДАНИЕ:


"Приложение-голосовалка"

Написать серверное standalone приложение со следующим функционалом : 
1) Создает темы для голосования,
2) Старт голосования с генерацией ссылки для голосования 
3) Закрытие голосования 
4) Отображение статистики (в виде Выбранный пункт - количество)
5) Получение данных о голосовании (по сгенерированной ссылке)
6) Регистрация голоса

С сервером общение посредством REST API, данные в формате Json.

Обязательные технологии: Java8, Spring boot

Система контроля версий: Git


_____________________________________________________________________
*********************************************************************


К серверу можно обратиться локально http://localhost:8090/

Для локальной работы с данными будем использовать H2 database.

Чтобы войти в консоль управления БД нужно перейти по адресу: http://localhost:8090/h2-console/

Для входа в H2 database console  JDBC URL:  jdbc:h2:mem:testdb

Описание работы приложения:
--------------------------
Для наглядности работы сервера (взаимодействия с сервером) я написал frontend client'а.
Он находится в папке frontendClient.  

После запуска приложения, откройте файл frontendClient/html/HomePage.html через браузер.

![1](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/1.png)


Первая часть:
Динамическая генерация JSON для отправления HTTP-POST запроса на сервер для создания голосования.
Сервер возвращает ID созданного объекта голосования (строки в таблице).

![2](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/2.png)


Далее Старт и Закрытие голосования (включение/отключение возможности голосовать)

![3](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/3.png)


Далее Получение ссылки для голосования

![4](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/4.png)


При переходе по ссылке мы отправляем GET-запрос на сервер. Сервер в ответ присылает view - show.ftl

![5](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/5.png)


В show.ftl мы можем выбрать нужные нам варианты и отправить запрос на сервер. 
Сервер сохранит изменения (если голосование открыто) в Базе Данных и вернет в ответ view - show.ftl


Также на frontendClient'e мы можем получить доступные нам опции REST API OPTIONS.

![6](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/6.png)


Также есть возможность войти в консоль управления БД.

![7](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/7.png)

![8](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/8.png)

![9](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/9.png)
