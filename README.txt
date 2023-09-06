ОПИСАНИЕ:
Тестовый проект для изучения Redis
Сервис считает количество запросов от 1 сессии, выводит результат и сохраняет в редис



ПОРЯДОК РАБОТЫ:
Перед стартом приложения нужно
1)Для начала развернём Redis в Docker-контейнере:
  docker run --name our-redis -p 6379:6379 redis
  еdoc

2) в другой консоли
    Подключимся к Redis c помощью консольного клиента, тоже завёрнутого в Docker-контейнер:
  docker run -it --network container:our-redis redis redis-cli -h 127.0.0.1

 Команды для Redis в консоли:
 можно попробовать положить строчку по ключу:
 127.0.0.1:6379> SET key value

 получить список всех ключей в БД:
127.0.0.1:6379> KEYS *


Docker
1) docker ps - список запущеных контейнеров
2) docker stop #### - остановить контейнер по хешу


Для того, чтобы авторизоваться в spring security , в консоли должна быть запись
Using generated security password: #####-####

можно предопределить данные, указав в properties
spring.security.user.name=user
spring.security.user.password=password
или в файле конфигурации SecurityConfiguration
для inMemoryAuthentication способа прописываются явно

Для того чтобы подлючить сохранение к редису необходимо прописать в properties параметры
#REDIS
spring.session.store-type=redis
server.servlet.session.timeout=5m
server.servlet.session.cookie.max-age=12h
spring.session.redis.flush-mode=on_save
spring.session.redis.namespace=spring:session
spring.redis.host=localhost
spring.redis.password=
spring.redis.port=6379

Для мониторинга инфы скачать на десктоп RedisInsight, выбрать на данных Java serializer
