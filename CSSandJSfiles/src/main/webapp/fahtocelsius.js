function convertToCelsius()
{
	const fahren=document.getElementById("fahren").value;
	const cel=(parseFloat(fahren)-32)*5/9;
	document.getElementById("celsius").value=cel.toFixed(2);
}