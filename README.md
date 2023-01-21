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