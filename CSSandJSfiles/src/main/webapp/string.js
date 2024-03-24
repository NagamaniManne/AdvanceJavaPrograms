function reverseString()
{
	const stringIn=document.getElementById("stringIn").value;
	var stringOut="";
	for(let i=stringIn.length-1;i>=0;i--)
	{
		stringOut+=stringIn[i]
	}
	document.getElementById("stringOut").value=stringOut;
}