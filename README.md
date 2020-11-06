# voting system

## Głosujący

### GET

- `/voters` - zwraca listę użytkowników uprawnionych do głosowania

## Projekty

### GET
- `/projects` - zwraca posortowaną (domyślnie Asc) listę projektów na które możemy oddać głos, może choć nie musi przyjmować parametr `order` który przyjmuje wartości (Asc lub Desc).
- `/projects/details/{id}` - zwraca informacje o projekcie z podanym id. Ilośc oddanych głosów za i przeciw, nazwę, opis oraz informację czy możemy oddać na niego głos

### PUT
- `/projects/votable/{id}?can_vote=` - ustawia możliwość oddania głosu na projekt z podanym id. Za parametr can_vote ustawamy (true lub false)

## Głosowanie

### POST

Aby oddać głos na wybrany projekt wysyłamy JSON:

```json
{
    "project_id": "id, projektu na który chcemu oddać głos",
    "vote": "głos za lub przeciw (true lub false)",
    "voter_id": "id głosującego"
}
```
pod adress:

- `/votes`

