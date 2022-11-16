# CsMoneyService
Сервис для парсинга скинов на сайте cs.money

## Описание
С помощью сервиса очень удобно искать скины по float(поношенности) и по скидам, что не невозможно на самом сайте.
- Сервис запускается на порту 8010
- Сервис написан на Spring Boot
- Все ответы конвертированы в Dto
- Есть возможность фильтровать по скидке, минимальной и максимальной цене, типу, float
- Цены отсортированы по скидке и float
- В качестве репозитория используется кэширование через caffeine
- Если не указан никакой type, то будут получены все имеющиеся типы

## API
GET api/v1/skins - парсинг по скидке
params:
- overprice
- minPrice
- maxPrice
- type (not required)

GET api/v1/skins/float - парсинг по поношенности
params:
- float
- minPrice
- maxPrice
- type (not required)

Типы type которые принимает api:
- knife
- gloves
- pistol
- rifle
- sniper
- smg
