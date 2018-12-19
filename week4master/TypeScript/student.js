var Student = /** @class */ (function () {
    // Constructors can take arguments with access modifiers
    // These arguments then act as class variables.
    function Student(firstName, middleInitial, lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.social = '11123421';
        this.haircolor = 'red';
        this.fullName = firstName + ' ' + middleInitial + ' ' + lastName;
    }
    return Student;
}());
var stu = new Student('Stu', 'E', 'Pickles');
