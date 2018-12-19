export class Feline {
    public static readonly NUM_LEGS=4;
    meow: string;
    fur: string;
    constructor(purr: string, fur: string) {
        this.meow = purr;
        this.fur = fur;
    }
    // Classes can have "methods" but they're still functions
    speak(){
        console.log(this.meow);
    }
}

export class Lion extends Feline {
    public static origin = "Africa";
    roar: string;
    constructor(purr: string, fur: string, roar: string) {
        super(purr, fur);
        this.roar=roar;
    }
    speak(){
        console.log(this.roar);
    }
}