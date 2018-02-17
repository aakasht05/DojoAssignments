class Bike{
    
    constructor(
        public price: number, 
        public max_speed: string, 
        public miles?: number){
            this.price = price;
            this.max_speed = max_speed;
            if (miles == undefined){
                this.miles = 0;
            }
            else{
            this.miles = miles;
            }
        }
    
    displayInfo(){
        console.log(`Price: ${this.price}, Max Speed: ${this.max_speed}, Total Miles: ${this.miles}`);
    }

    ride(){
        this.miles += 10;
        console.log("Riding");
        return this;
    }

    reverse(){
        if(this.miles >= 5){
            this.miles -= 5;
            console.log("Reversing");
        }
        else{
            console.log("Not reversing. Not enough miles")
        }
        return this;
    }
}

let bike1 = new Bike(200, "25mph", 50);
let bike2 = new Bike(300, "40mph");
let bike3 = new Bike(500, "100mph");

bike1.displayInfo()
bike1.ride().ride().ride().reverse().displayInfo();

bike2.displayInfo();
bike2.ride().ride().reverse().reverse().displayInfo();

bike3.displayInfo();
bike3.reverse().reverse().reverse().displayInfo()
