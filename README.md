# Task3_fightingGame
---
15.01.2023 Original task:
>Короч, нужно сделать консольную, пошаговую игру типа файтинга. 

>В начале игры можно будет выбрать персонажа за кого ты будешь играть и противника. (чтобы не придумывать своих персов берут часто из какой-то игры, тип мортол комбота) 

>У каждого персонажа есть свое хп и силы (на счет баланса между персонажами не думай)

>После выбора персонажей, начинается бой, где тебе предлагается сделать удар, будут 3 варианта удара (удар рукой, удар ногой, удар головой), каждый из них будет наносить рандомное значение в каком то диапазоне относительно параметра силы.  

>После того как ты нанес удар, противник наносит ответный удар (тип удара должен делать компьютер, то есть рандомно выбирать его)

>У кого закончились жизни тот проиграл и игра начинается с начала выбора персонажей.

---

>По поводу реализации, здесь нужно будет выделить общие поля и методы, которые относется к каждому персу, и вынести их в абстрактный класс. Методы ударов нужно вынести в интерфейс и реализовать уже в классах. Должен быть отдельный класс запуска меню. В методе main должен быть код, которые просто запускает игру по типу myGame.start()

>В этой задаче максимальный акцент на ООП делаем. Можем завтра к примеру созвониться чтобы голосом проговорить если не понятно что-то
---
16.01.2023 Task update
---
>1) Нужно разбить на пакеты (папки). В основном мы проектируем систему, где 1 файл имеет 1 класс, а эти классы потом разбиваем на пакеты

>2) Пусть у Entity поля healthPoints, power, name будут private и инициализироваться через конструктор базового класса, а то тебе приходиться в каждом дочернем классе заново их прописывать  

>3) Вынеси генерацию подсчет удара относительно силы в какой-то статичный класс, а то много одинакового кода

>4) В классе Entity есть к примеру такой метод "void death(){}", если у него нет дефолтной реализацией, то можно дописать к нему "abstract void death()", тогда его обязательно нужно будет реализовывать в наследуемых классах 

>5) Ты правильно делаешь, что работаешь на уровни Entity со всеми бойцами. Я предлагаю всех персонажей пихнуть в масси. И уже относительно индекса выбирать игрока. Тогда не придется расширять код с логикой switch case и т д, если добавить новых персов.

>А так все норм)
---
18.01.2023 Task update
---
>1) Давай блок switch вынесем в отдельную функцию, а то ниже полная копипаста получается 
https://github.com/kot0fey/Task3_fightingGame/blob/b05d91d520f712900bb5b84ff2229ca3dba02a70/src/com/task3/Game.java#L41

>2) Давай это тоже вынесем в отдельный статичный класс, типа EntityCharacter и там будет статичное поле с этими данными. Это будет место где храняться все наши персонажи
https://github.com/kot0fey/Task3_fightingGame/blob/b05d91d520f712900bb5b84ff2229ca3dba02a70/src/com/task3/Game.java#L22

>3) Надо убрать жесткую привязку на 5, ведь нам может понадобиться добавить еще одного персонажа 
https://github.com/kot0fey/Task3_fightingGame/blob/b05d91d520f712900bb5b84ff2229ca3dba02a70/src/com/task3/Game.java#L25

>4)Надо сделать, чтобы данное тайтл генерился динамически относительно кол-во персонажей в EntityCharacter 
https://github.com/kot0fey/Task3_fightingGame/blob/b05d91d520f712900bb5b84ff2229ca3dba02a70/src/com/task3/Game.java#L21

>5) Методы в строчку нельзя писать, какой бы он маленький не был, всегда переноси скобки энтером (Я не придираюсь бро, просто есть общие нормы, лучше быстрее к ним привыкнуть)
https://github.com/kot0fey/Task3_fightingGame/blob/b05d91d520f712900bb5b84ff2229ca3dba02a70/src/com/task3/Entity.java#L16
(Поправь везде, где есть подобное)

>6) Незачем передавать параметр rand, так как оно из вне не высчитывается и просто передается экземпляр класса Random. Можешь создать папку под названием utils и там добавить статичный метод, который будет высчитывать рандомное число или выполнять какие-то вычисления по формулам дамага
https://github.com/kot0fey/Task3_fightingGame/blob/b05d91d520f712900bb5b84ff2229ca3dba02a70/src/com/task3/Entity.java#L23

>7) И давай расширим функционал какого-то персонажа. К примеру переопредели метод у скорпиона, мол когда у него хп падают ниже 30%, то его удар головой наносит в 2 раза больше дамага
---
21.01.2023 Task update
---
>Да, норм. Только есть файлы где код чуть поехал 

>1) Пройдись по все файлам и зажми комбинацию клавиш clrl + alt + L и он подравняет код. Всегда его юзай, кода закончишь писать 

>2) Может ты уже знаешь, но по мимо практики нужно не забывать теории и уметь обьяснить каждый парадигм в ООП. Посмотри про такие парадигмы как Абстракция, Инкапсуляция, Наследование, Полиморфизм, Агрегация, Ассоциация, Композицая. Вероятное определение многих ты знаешь, но так пробегись, повтори именно теорию 

>3) И еще надо бы реализовать пару паттернов. Паттерны это не какие-то определенные инструменты в джава как интерфейс или класс, это некий наиболее оптимальный подход к решению задаче.
Прочитай и реализуй паттерн Singleton в своем классе EntityCharacter, то есть чтобы обеспечивался всегда один инстанст данного экземпляра класса и еще добавь туда метод refresh, который будет обновлять всех персонажей, чтобы убрать 2 массива и оставить 1

>4) Мелка правка, функции всегда называются с маленькой буквы 
https://github.com/kot0fey/Task3_fightingGame/blob/c992ef3ae72059993233bf07a111ff3b9341c8c7/src/com/utils/Rand.java#L6
---
25.01.2023 Task update
---
>1) Вынеси все такста в статичный константные поля в класс и замени их них тут. Это улучшит визуал кода и будет удобно менять заголовки при необходимости 
https://github.com/kot0fey/Task3_fightingGame/blob/fc7df50ad80ea65bc5201d30cb53e37a60532496/src/com/task3/Game.java#L12

>2) Основная задача сейчас реализовать паттерн Стратегия, это поведенческий паттерн, который позволить динамически менять некий алгоритм системы.
Задача такая, давай добавим возможность выбирать оружия нашим персонажам. То есть после выбора перса нам предложат выбрать и оружие. Каждое оружие будет давать какой-то бонус (плюс к силе или здоровью, или и то и то)
То есть в твоем базовом классе появится интерфейс WeaponStrategy, который будет возвращать объект с полями health и damage, и ты будет плюсовать их к своим статам. Будет 3 оружия, клинок, меч, топор (можешь больше) с разными бонусами. Бот тоже должен рандомно выбирать оружие 

>Предлагаю отдельно реализовать стратегию, по какому нибуть примеру, а потом реализовывать уже у себя в проекте 
https://javarush.com/groups/posts/2271-pattern-proektirovanija-strategija
---
30.01.2023 Task update
---
>1) Давай вынесем в какой-то базовый класс эти поля и методы повторяющиеся во всех оружиях
https://github.com/kot0fey/Task3_fightingGame/blob/45b17dd3a7551dbd73161c409458ab76e16155d0/src/com/task3/weapons/WeaponAxe.java#L4

>2) Сможешь другие классы тоже расфасовать по папкам как weapon, типа папка персонажи и игра и еще на твой выбор

>3) Когда долго играю появляется баг, что я выбираю персонажа и перед боем сразу выигрываю
