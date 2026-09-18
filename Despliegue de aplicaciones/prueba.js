console.log("Hola Mundo"); //Imprimir por pantalla 

console.log("5");

console.log(5);

console.log(5+2);

console.log(5-2);

console.log(5*2);

console.log(5 / 2);

// variables

const nombre = "Pepe"; // Const para declarar variables con datos que no cambian
let edad = 30; // Let variables con datos que pueden cambiar

//var esta en desuso

//Si nombre = "Juan" dara error porq es const

//Tipos de datos primitivos
    //String
    let miNombre = "Laura";

    //Numeros
    let age = 45; //Entero
    let height = 1.79; //Decimal

    //Booleanos 
    let isTeacher = true;
    let isStudent = false;

    //Undefined
    let undefinedValue;
    console.log(undefinedValue);

    // Null
    let nullValue = null;

    //Symbol (sirve para hacer identificadores)
    let mySymbol = Symbol("mysymbol");

    //BigInt
    let myBigInt = BigInt(34133134444444441241234324123);
    let myBigInt2 = 34133134444444441241234324123n;

    console.log(typeof miNombre); // Te dice el tipo de dato que es la variable
    

//Operadores aritmeticos

let a = 5;

let b = 10;

console.log(a+b);
console.log(a-b);
console.log(a*b);
console.log(a/b);

console.log(a%b); //Modulo
console.log(a**b); //Exponente

a++; //Incremento

b--; //Decremento

myVariable += 2;
myVariable -= 2;
myVariable *= 2;
myVariable /= 2;
myVariable %= 2;
myVariable **= 2;

console.log(a>b);
console.log(a<b);
console.log(a>=b);
console.log(a<=b);
console.log(a == b); //Igualdad por valor
console.log(a === b); //Igualdad por identidad (Valor y tipo) o igualdad estricta

console.log(0 == false);




