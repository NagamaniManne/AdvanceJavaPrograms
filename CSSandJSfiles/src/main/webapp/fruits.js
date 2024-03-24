//function fruitProcessor(apples,oranges)
//{
//	return `Juice preparing with ${apples} apples and ${oranges}-oranges`
//}
//document.write(fruitProcessor(8,6))
function fruitProcessor(apples,oranges)
{
	const app=cutFruitPieces(apples)
	const orag=cutFruitPieces(oranges)
	return `Juice preparing with ${app}-applePieces and ${orag}-orangePieces`
}
function cutFruitPieces(fruit)
{
	return fruit*4;
}
document.write(fruitProcessor(8,6))