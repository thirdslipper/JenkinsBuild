class Student implements Person{
    //no modifier indicates pulic.
    //public firstName: string;
    //lastName: string; 
    fullName: string;
    private social = '11123421';
    protected haircolor= 'red';

    // Constructors can take arguments with access modifiers
    // These arguments then act as class variables.
    constructor(public firstName: string, protected middleInitial: string,
        public lastName: string) {
            this.fullName=firstName+' '+middleInitial+' '+lastName;
        }
}

interface Person {
    firstName: string;
    lastName: string;
}
let stu = new Student('Stu', 'E', 'Pickles');
