# Team3. task1. Voting 

 ` Команда проекта:  Дмитрий Булавицкий, Павел Клименко, Анна Микулич`

Приложение предназначено для проведения голосования по двум номинациям:
1. Номинация Singer - можно проголосовать только за одного исполнителя.
2. Номинация Genres - можно проголосовать за  3 - 5 жанров.

Также есть возможность просмотреть статистику голосования.

> Логическая модель базы данных

![schema](https://github.com/annomik/git-demo-backup/blob/main/Database%20model%20-%20Voting%20new.jpg)


## В приложении предусмотрены следующие страницы и функции:
## 1. Страница приветствия
```sh
 (GET) http://host:port/WarFileName/welcome
  ```
## 2. Страница исполнителей
На данной странице предусмотрено выполнение следующих действий:

 Просмотреть  список исполнителей: 
```sh
 (GET) http://host:port/WarFileName/singer
  ```
  Добавить, обновить, удалить исполнителя:
```sh
 (POST)   http://host:port/WarFileName/singer?add=(singer_name) 
 (PUT)    http://host:port/WarFileName/singer?updateId=(singer_id)&newName=(new_singer_name)
 (DELETE) http://host:port/WarFileName/singer?deleteId=(singer_id)
  ```
## 3. Страница жанров
На данной странице предусмотрено выполнение следующих действий:

Просмотреть список жанров: 
 ```sh
 (GET) http://host:port/WarFileName/genre
  ```
 Добавить, обновить, удалить жанр:
  ```sh
 (POST)   http://host:port/WarFileName/genre?add=(genre_name) 
 (PUT)    http://host:port/WarFileName/genre?updateId=(genre_id)&newName=(new_genre_name)
 (DELETE) http://host:port/WarFileName/genre?deleteId=(genre_id)
  ```  
 ## 4. Страница голосования
URL "/vote"  (1 vote singer, 3-5 votes for genres)
```sh
 (POST)  http://host:port/WarFileName/vote?singer=(singer_id)&genre=(genre_id)&genre=(genre_id)&genre=(genre_id)&message=(message)&email=(email)
 ``` 
 После отправки голоса пользователь получает на электронную почту информацию о своем выборе жанров и исполнителя.
 ## 5. Страница результатов голосования
  На данной станице можно увидеть текущие результаты голосования:
  ```sh
 (GET) http://host:port/WarFileName/result
 ``` 
 
