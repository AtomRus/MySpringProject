# Мой учебный REST проект

Есть две сущности - сенсор и измерение. Эти сущности связаны отношением OneToMany

Для начала работы нужно создать сенсор
Для этого, нужно послать POST запрос на этот адресс "http://localhost:8080/sensors/registration"
Пример JSON
{
    "sensorName": "MARK-1"
}
Дальше можно создать измерение, послав POST запрос на этот адресс "http://localhost:8080/measurements/add"
Пример JSON
{
    "measurement": "Sunny",
    "temperature": 21,
    "raining": false,
    "sensor": {
        "sensorName": "MARK-1"
    }
}
Теперь можно получить JSON`ы имеющихся сканеров или измерений, послав GET запрос на адресс "http://localhost:8080/sensors" или "http://localhost:8080/measurements"
