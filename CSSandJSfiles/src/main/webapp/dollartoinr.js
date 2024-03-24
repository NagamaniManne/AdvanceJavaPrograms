function convertToINR()
{
	const dollar=document.getElementById("dollar").value;
	const rupees=(parseFloat(dollar)*82.89)
	document.getElementById("rupees").value=rupees.toFixed(2)
}