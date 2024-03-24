/*function palindrome()
{
	var word=document.getElementById("word").value;
	var revword="";
	for(let i=word.length-1;i>=0;i--)
	{
		revword+=word[i]
	}
	if(revword==word)
	{
		document.getElementById("rev").value=revword
		alert("palindrome")
	}	
	else{
		document.getElementById("rev").value=revword
		alert("Not a palindrome")
	}
}*/
function palindrome()
{
	var num=document.getElementById("num").value;
	var rev=0,temp,rem;
	temp=num;
	while(temp>0)
	{
		rem=parseInt(temp%10)
		rev=rev*10+rem
		temp=parseInt(temp/10)
	}
	if(num==rev)
	{
		document.getElementById("revnum").value=rev
		alert("palindrome")
	}	
	else{
		document.getElementById("revnum").value=rev
		alert("Not a palindrome")
	}
}