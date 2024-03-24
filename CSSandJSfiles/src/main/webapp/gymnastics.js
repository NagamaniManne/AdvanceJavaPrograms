var dolphins=[], koolas=[], davg=0,kavg=0;
for(let i=0;i<3;i++)
{
	dolphins[i]=parseInt(prompt("Enter Dolphins "+(i+1)+" score"))
	davg+=dolphins[i];
}
for(let i=0;i<3;i++)
{
	koolas[i]=parseInt(prompt("Enter Koolas "+(i+1)+" score"))
	kavg+=koolas[i]
}
const scoreDolphins=davg/3;
const scoreKoolas=kavg/3;
if(davg>=100 && kavg>=100)
{
	if(davg>kavg)
		console.log("Dolphins win the trohpy")
	else if(kavg>davg)
		console.log("Koolas win the trophy")
	else
		console.log("Both win the trophy")
}