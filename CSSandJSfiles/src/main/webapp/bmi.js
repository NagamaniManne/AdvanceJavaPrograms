let massRatan=parseInt(prompt("Enter mass of Ratan"))
let massAnu=parseInt(prompt("Enter mass of Anu"))
let heightRatan=parseFloat(prompt("Enter height of Ratan"))
let heightAnu=parseFloat(prompt("ENter height of Anu"))
var BMIRatan,BMIAnu;
BMIRatan=massRatan/(heightRatan*heightRatan)
BMIAnu=massAnu/(heightAnu*heightAnu)
console.log(`BMI of Ratan is ${BMIRatan}`)
console.log(`BMI of Anu is ${BMIAnu}`)
document.write(`BMI of Ratan is ${BMIRatan}<br>`)
document.write(`BMI of Anu is ${BMIAnu}<br>`)
var RatanHigherBMI;
RatanHigherBMI=BMIRatan>BMIAnu;
if(RatanHigherBMI){
	console.log(`BMI of Ratan is heigher than BMI of Anu`)
	document.writeln(`BMI of Ratan is heigher than BMI of Anu<br>`)
}
else
{
	console.log(`BMI of Ratan is less than BMI of Anu`)
	document.write(`BMI of Ratan is less than BMI of Anu<br>`)
}