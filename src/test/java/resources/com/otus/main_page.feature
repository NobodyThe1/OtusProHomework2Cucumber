#language: ru

Функционал: Поиск и сортировка курсов

  Сценарий: Поиск курса
    Пусть Открываем браузер "chrome"
    Пусть Открыта главная страница
    Если Кликнуть на плитку курса "Apache Kafka"
    Тогда Откроется страница курса "Apache Kafka"

  Сценарий: Поиск курса с самой ранней датой старта
    Пусть Открываем браузер "chrome"
    Пусть Открыта главная страница
    Если Найден курс с самой ранней датой старта
    Тогда Название и дата старта курса выводятся в консоль