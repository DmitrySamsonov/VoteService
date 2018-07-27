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


Rest Api:

1 Создание голосвания
----------------------
Для этого необходимо отправить запрос http://localhost:8090/rest/voting/create HTTP-POST c JSON формата:

```json
{
  "votingTheme": "celebration",
  "question": "where we will celebrate the holiday ?",
  "answerList": [
    {
      "answerName": "home",
      "count": "0"
    },
    {
      "answerName": "restaurant",
      "count": "0"
    },
    {
      "answerName": "cottage",
      "count": "0"
    }
  ]
}
```

В ответ сервер вернет id созданного голосования (Voting).


2 Старт голосования с генерацией ссылки для голосования
--------------------------------------------------------
Для этого необходимо отправить запрос http://localhost:8090/rest/voting/{votingId}/start HTTP-GET,
где votingId - это id голосования

В ответ сервер вернет ссылку для голосования.


3 Закрытие голосования
-----------------------
Для этого необходимо отправить запрос http://localhost:8090/rest/voting/{votingId}/stop HTTP-GET,


4 Отображение статистики (в виде Выбранный пункт - количество)
----------------------------------------------------------------
Для отображения статистики отдельно выбранного пункта необходимо отправить запрос http://localhost:8090/rest/voting/{votingId}/{answerId} HTTP-GET,
где votingId - это id голосования, answerId - id выбранного пункта(ответа).

В ответ сервер вернет число - количество голосов по данному пункту. 


5 Получение данных о голосовании (по сгенерированной ссылке)
------------------------------------------------------------
Для отображения всей статистики необходимо отправить запрос http://localhost:8090/rest/voting/{votingId}/ HTTP-GET,
где votingId - это id голосования

В ответ сервер вернет JSON:
```json
{
  "votingTheme": "celebration",
  "question": "where we will celebrate the holiday ?",
  "answerList": [
    {
      "answerId": 2,
      "answerName": "home",
      "count": 10
    },
    {
      "answerId": 3,
      "answerName": "restaurant",
      "count": 6
    },
    {
      "answerId": 4,
      "answerName": "cottage",
      "count": 15
    }
  ]
}
 ```
 
6 Регистрация голоса
--------------------
Для регитсрации голоса, нескольких голосов необходимо отправить запрос http://localhost:8090/rest/voting/{votingId}/answers 
HTTP-POST (votingId - это id голосования) c JSON, содержащий id ответов (выбранных голосов) формата:
 
 ```json
[
  "2",
  "3"
]
 ```


Получение информации
--------------------
Также для получения информации о доступных операциях сервера можно отправить запрос http://localhost:8090/ HTTP-OPTIONS
В ответ мы получим JSON:
 ```json
[
  {
    "link": "http://localhost:8090/rest/voting/create",
    "method": "POST",
    "description": "generate voting JSON and send HTTP-request for create voting"
  },
  {
    "link": "http://localhost:8090/rest/voting/{votingId}/start",
    "method": "GET",
    "description": "send HTTP-request with voting ID for start voting and get generated link."
  },
  {
    "link": "http://localhost:8090/rest/voting/{votingId}/stop",
    "method": "GET",
    "description": "send HTTP-request with voting ID for stop voting."
  },
  {
    "link": "http://localhost:8090/rest/voting/{votingId}/",
    "method": "GET",
    "description": "send HTTP-request with voting ID for get voting statistic."
  },
  {
    "link": "http://localhost:8090/rest/voting/{votingId}/{answerId}",
    "method": "GET",
    "description": "send HTTP-request with voting ID for get answer statistic."
  },
  {
    "link": "http://localhost:8090/rest/voting/{votingId}/answers",
    "method": "POST",
    "description": "send HTTP-request with voting ID and selected answers Id for selected answers in voting."
  },
  {
    "link": "http://localhost:8090/",
    "method": "OPTIONS",
    "description": "get REST API OPTIONS"
  },
  {
    "link": "http://localhost:8090/rest/voting/{votingId}/ui",
    "method": "GET",
    "description": "send HTTP-request with voting ID for get voting statistic in USER INTERFACE."
  },
  {
    "link": "http://localhost:8090/rest/voting/answers/ui",
    "method": "POST",
    "description": "generate answers ID List and voting ID and send to server for selected votes."
  }
]
 ```
 
 
_____________________________________________________________________


К серверу можно обратиться локально http://localhost:8090/

Для локальной работы с данными будем использовать H2 database.

Чтобы войти в консоль управления БД нужно перейти по адресу: http://localhost:8090/h2-console/

Для входа в H2 database console  JDBC URL:  jdbc:h2:mem:testdb


_________________________________________________________________


Описание работы приложения:
--------------------------
Для наглядности работы сервера (взаимодействия с сервером) я написал frontend client'а.
Он находится в папке frontendClient.  

После запуска приложения, откройте файл frontendClient/html/HomePage.html через браузер.

![1](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/1.png)


1 Создание голосвания
----------------------
Динамическая генерация JSON поможет наглядно сгенерировать JSON.  
После нажатия кнопки Create voting на сервер отправится HTTP-POST запрос с JSON'ом для создания голосования.
В ответ сервер вернет ID созданного объекта голосования.

![2](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/2.png)


2 Старт голосования с генерацией ссылки для голосования, 3 Закрытие голосования
--------------------------------------------------------

![3](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/3.png)

После нажатия на кнопку Start voting на сервер отправится HTTP-GET запрос http://localhost:8090/rest/voting/{votingId}/start
для старта голосования и генерации ссылки

В ответ сервер вернет ссылку для голосования. Например: http://localhost:8090/rest/voting/1

Если отправить GET запрос http://localhost:8090/rest/voting/1 - мы получим статистику голосования в формате JSON

После нажатия на кнопку Stop voting на сервер отправится HTTP-GET запрос http://localhost:8090/rest/voting/{votingId}/stop
для завершения голосования.



UserInterface
-------------
Также для более наглядного просмотра статистики голосования и регистрации голоса, нескольких голосов
Для этого можно отправить запрос http://localhost:8090/rest/voting/1/ui (перейти по ссылке).
В ответ Сервер вернет view - show.ftl


![4](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/ui1.png)
![5](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/ui2.png)




4 Отображение статистики (в виде Выбранный пункт - количество)
----------------------------------------------------------------
В поле вводим id интересуещего нас выбранного пункта(ответа) и нажимаем кнокпу Get_Answer_Statistic_By_Answer_ID.
На сервер отправится запрос  HTTP-GET http://localhost:8090/rest/voting/{votingId}/{answerId} ,
где votingId - это id голосования, answerId - id выбранного пункта(ответа).

В ответ сервер вернет число - количество голосов по данному пункту. 

![6](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/getAnswerStatistic.png)



5 Получение данных о голосовании (по сгенерированной ссылке)
------------------------------------------------------------
При нажатии на кнопку на сервер отправляется запрос HTTP_GET http://localhost:8090/rest/voting/1 - это сгенерированная ссылка.
В ответ мы получим статистику голосования в формате JSON.

![7](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/getVotingStatistic.png)



6 Регистрация голоса
--------------------
Псоле ввода в поле selectedAnswerId вводите id выбираемых вами ответов и нажатия кнопки Add Answer. 
Будет наглядно сформирован JSON объект.

Далее после нажатия кнопки Send selectedAnswerId на сервер будет отправлен HTTP-POST запрос 
http://localhost:8090/rest/voting/{votingId}/answers , содержащий список id выбраных ответов. 


![8](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/selectAnswersId.png)






Получение информации
--------------------
Для получения информации о доступных операциях сервера на сервер отправляется запрос http://localhost:8090/ HTTP-OPTIONS
Для наглядности отображаем ответ в формате JSON.

![9](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/restApiOptions.png)
 



Консоль управления H2 Базой данных 
----------------------------------
Также есть возможность войти в консоль управления БД.

![10](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/10.png)
![11](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/11.png)
![12](https://github.com/DmitrySamsonov/VoteService/raw/master/screenshots/12.png)

