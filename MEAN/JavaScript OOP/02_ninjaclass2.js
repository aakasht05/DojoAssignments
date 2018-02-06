function Ninja(name) {
    var speed = 3;
    var strength = 3;

    this.name = name;
    this.health = 100;

    this.sayName = function () {
        console.log(`My ninja name is ${this.name}`);
    }

    this.showStats = function () {
        console.log(`Name: ${this.name}, Health: ${this.health}, Speed: ${speed}, Strength: ${strength}`);
    }

    this.drinkSake = function () {
        this.health += 10;
        return this;
    }

    this.punch = function (Ninja) {
        Ninja.health -= 5;
        return this;
    }

    this.kick = function (Ninja) {
        Ninja.health -= (15 * strength);
        return this;
    }


}

const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
// -> "My ninja name is Hyabusa!"
ninja1.showStats();
ninja1.drinkSake().drinkSake();
ninja1.showStats();
// -> "Name: Hayabusa, Health: 100, Speed: 3, Strength: 3"

const blueNinja = new Ninja("Goemon");
const redNinja = new Ninja("Bill Gates");
blueNinja.showStats();
redNinja.showStats();
redNinja.punch(blueNinja).punch(blueNinja);
blueNinja.kick(redNinja);
// -> "Bill Gates was kicked by Goemon and lost 15 Health!"

// -> "Goemon was punched twice by Bill Gates and lost 10 Health!"
blueNinja.showStats();
redNinja.showStats();