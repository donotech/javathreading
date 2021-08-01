// this is when someone loves deer
function deer(){
	document.getElementById('ilove').src="images/deer.png";
}

// this is when someone loves monkey
function monkey(){
	document.getElementById('ilove').src="images/monkey.png";
}

// this is when someone loves nothing
function gray(){
	document.getElementById('ilove').src="images/gray.png";
}

// this is when anyone loves anything or nothings
function ilove(animal){
	document.getElementById('ilove').src="images/" + animal + ".png";
}

function myAnimal(btnName){
	// console.log(btnName.slice(3,-7));
	// document.getElementById('ilove').src="images/" + btnName.slice(3,-7).toLowerCase() + ".png";
	// console.log(btnName.split(" ")[1].toLowerCase());
	document.getElementById('ilove').src="images/" + btnName.split(" ")[1].toLowerCase() + ".png";
}

/* Day 1 - SESSION 3 */

//////////////////////////////////////////////////////



// cl("Hello, lets start the class!!");
//////////////////////////////////////////////////////

// // &&(AND) logical operator
// var x, age = 340;
// if((65 >= age) && (age >= 20)){
//     x = 'Really Adult';
//     cl(x);
// }else if((4 < age) && (age < 13)){
//     x = 'Really Minor';
//     cl(x);
// }else if(age <= 4){
//     x = 'A baby';
//     cl(x);
// }else if((20 > age) && (age >= 13)){
//     x = 'Teenager';
//     cl(x);
// }else{
//     x = 'Senior Elderly';
//     cl(x);
// }

// // ||(OR) logical operator
// var x, age = 4;
// if(((65 < age) || (age < 20))&&(false)){
//     x = 'Not Really Adult';
//     cl(x);
// }else{
//     x = 'Really Adult';
//     cl(x);
// }

// // !(NOT) logical operator
// var x, age = 36;
// if(!(age > 20)){
//     x = 'Not Really Adult';
//     cl(x);
// }else{
//     x = 'Really Adult';
//     cl(x);
// }

// // equal conditional operator
// var creatureCan = "fly";
// if(creatureCan == "fly"){
//     cl('It\'s a Bird or a Bat or a flying Insect');
// }else{
//     cl('It\'s not a Bird or a Bat or a flying Insect');
// }

// nested if else if
function checkAnimal(id){
    var imageSrc = document.getElementById('ilove').src.split('/');
    var imageInTheBox = imageSrc[imageSrc.length-1];
    var chkResult = document.getElementById('output');
    if(id == 1){
        if(imageInTheBox == "gray.png"){
            chkResult.innerHTML = "Are you blind?";
        }else if(imageInTheBox == "deer.png"){
            chkResult.innerHTML = "Oh! yeah!";
        }else if(imageInTheBox == "monkey.png"){
            chkResult.innerHTML = "Thats not true!";
        }
    }else if(id == 2){
        if(imageInTheBox == "gray.png"){
            chkResult.innerHTML = "Are you blind?";
        }else if(imageInTheBox == "deer.png"){
            chkResult.innerHTML = "Thats not true!";
        }else if(imageInTheBox == "monkey.png"){
            chkResult.innerHTML = "Oh! yeah!";
        }
    }else if(id == 3){
        if(imageInTheBox == "gray.png"){
            chkResult.innerHTML = "Yeah! Where are they?";
        }else if(imageInTheBox == "deer.png"){
            chkResult.innerHTML = "Hmm, anything may run or jump in the dark!";
        }else if(imageInTheBox == "monkey.png"){
            chkResult.innerHTML = "Hmm, anything may hang in the dark! It's creepy!";
        }
    }
}

// switch example
function howPeopleFeels(season){
    switch (season) {
        case "summer":
            cl('It\'s hot!');
            break;
        case "winter":
            cl('It\'s cold!');
            break;
        case "spring":
            cl('It\'s comfortable!');
            break;
        default:
            cl('Not sure how I feel!');
            break;
    }
}

/* Day 2, SESSION 1 */
function cl(data) {console.log(data);}
// function without '()'
// console.log(cl);


// // function example
// function toCelsius(fahrenheit) {
// 	celsiusVal = (5/9) * (fahrenheit-32);
// 	// cl(celsiusVal);
// 	return celsiusVal;
// }
// cl(toCelsius(77) + " Celsius");
// cl(celsiusVal); // Error

// // Self invoked function
// (function () {
// 	let x = "No one called me! I invoked myself!!";
// 	cl(x);
// })();

// // Normal function
// function mult(a,b) { return a * b; }

// // Arrow function
// newmult = (a,b) => {
// 	a * b;
// 	cl("something");
// };
// cl(mult(2,4));
// cl(newmult(2,4));

// Callback function
function logData(data) {
	console.log(data);
}

function f(a, b, someFnName) {
	let sum = a + b;
	someFnName(sum);
}

// f(2,3,console.log);

// setTimeout, setInterval, clearTimeout, clearInterval
// setTimeout
// setTimeout(function(){f(1,2,logData);}, 3000);

var waitAndAdd = setTimeout(function(){f(1,2,logData);}, 3000);

function clock() {
	let d = new Date();
	document.getElementById("output").innerHTML=
	d.getHours() + ":" +
	d.getMinutes() + ":" +
	d.getSeconds();
}

var oneSecStep = setInterval(clock, 1000);

//////////////////////////////////////////////////////

/* Day 2, SESSION 2 */

// // Promise
// let prom = new Promise(function(resolve, reject) {
// 	let x = Math.random();
// 	if (x > 0.5) {
// 		resolve("OK, as I got " + x);
// 	} else {
// 		reject("Failed as I got " + x);
// 	}
// });

// prom.then(
// 	function(value) {cl(value);},
// 	function(value) {cl(value);}
// );

// //////////////////////////////////////////////////////

// class Cooking{
// 	startCookingFood = () => cl("Cooking started.");
// 	putItems = item => cl(item + " added.");
// 	throwAway = () => cl("Food is thrown away!");
// 	finished = () => cl("Food is prepaired!");
// }

// //////////////////////////////////////////////////////

// gotUpFromYourBed = () => cl("I got up from bed.");
// freshenUp = () => cl("I brushed my teeth.");
// goToTheKitchen = () => cl("I went to the kitchen.");
// orderOnline = () => cl("Zomato delivered food!");
// excercise = () => cl("Keeping my body fit.");
// prepairing = () => cl("Getting ready for the class...");
// attendVlearnClass = () => cl("Started my Zoom class in time.");

// //////////////////////////////////////////////////////

// function waitAwhile(ms) {
// 	return new Promise(resolve => setTimeout(resolve, ms));
// }

// async function prepairForTheClass() {
// 	await waitAwhile(2000);
// 	attendVlearnClass();
// }

// gotUpFromYourBed();
// freshenUp();
// goToTheKitchen();
// var cookFood = new Cooking();
// cookFood.startCookingFood();

// // not salt situation arose
// cl("No salt!!\nAsked my girl_boy_friend to get salt!");
// var getMeSaltPromise = new Promise(function(found,notFound){
// 	if(Math.random() > 0.5){
// 		found("got salt.");
// 	}else{
// 		notFound("couldn't get salt.");
// 	}
// });

// getMeSaltPromise.then(
// 	function(goodStatus) {
// 		cl(goodStatus);
// 		cookFood.putItems('salt');
// 		cookFood.finished();
// 		prepairing();
// 	},

// 	function(badStatus) {
// 		cl(badStatus);
// 		cookFood.throwAway();
// 		orderOnline();
// 		prepairing();
// 	}
// );

// excercise();
// // attendVlearnClass();
// prepairForTheClass();

// //////////////////////////////////////////////////////

/* Day 2, SESSION 3 */
// var d = new Date();
// cl(d);
// console.log(Date.parse("Aug 1, 2021"));

// var d = new Date();
// console.log(d.toString());

