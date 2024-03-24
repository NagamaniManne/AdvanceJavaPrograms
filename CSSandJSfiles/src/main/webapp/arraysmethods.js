var numbers=[19,76,56,23,43,12]
numbers.push(10,26,89)
console.log("after push -> "+numbers)
numbers.pop()
console.log("after pop -> "+numbers) 
numbers.splice(2,2,7)
console.log("after splice -> "+numbers)
numbers.shift()
console.log("after shift -> "+numbers)
numbers.unshift(10,11,12)
console.log("after unshift -> "+numbers)
numbers.slice(0,4)
console.log("after slice -> "+numbers)
console.log(numbers.indexOf(26))
var n2=[100,200,300]
console.log("after concat"+numbers.concat(n2))


var prices=[10,20,30,40,50]
prices.filter(n=>n>20)
	.map(n=>n/5)
	.forEach(n=>document.write(n+"<br>"))
	
var sum=numbers.reduce((n1,n2)=>n1+n2)
console.log(sum)