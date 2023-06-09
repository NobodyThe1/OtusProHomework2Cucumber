#language: ru

Функционал: Поиск и сортировка курсов

  Сценарий: Поиск курса
    Пусть Открываем браузер "chrome"
    Пусть Открыта главная страница
    Если Кликнуть на плитку курса "Apache Kafka"
    Тогда Откроется страница курса "Apache Kafka"

  Сценарий: Поиск курса с самой ранней датой старта
    Пусть Открываем браузер "chrome"
    Также Открыта главная страница
    Если Кликнуть на <start_date> плитку курса
    Тогда Откроется страница курса
    Также Вывести название и дату курса в консоль

    Примеры:
    | start_date |
    | ранний     |
    | поздний    |