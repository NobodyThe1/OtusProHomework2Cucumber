#language: ru

Функционал: Поиск и сортировка курсов

  Сценарий: Поиск курса
    Пусть Открываем браузер "chrome"
    Пусть Открыта главная страница
    Если Кликнуть на плитку курса "Специализация Fullstack Developer"
    Тогда Откроется страница курса "Специализация Fullstack Developer"

  Структура сценария: Поиск курса с самой ранней датой старта
    Пусть Открываем браузер "chrome"
    Также Открыта главная страница
    Если Кликнуть на <start_date> плитку курса и вывести название курса в консоль
    Тогда Откроется страница курса

    Примеры:
      | start_date |
      | ранний     |
      | поздний    |