function validateForm()
{
	var proId=document.getElementById("proId").value;
	var proName=document.getElementById("proName").value;
	var proPrice=document.getElementById("proPrice").value;
	var proBrand=document.getElementById("proBrand").value;
	var proMadeIn=document.getElementById("proMadeIn").value;
	var proMfgDate=document.getElementById("proMfgDate").value;
	var proExpDate=document.getElementById("proExpDate").value;
	
	
	if(proId.trim()==="" || proName.trim()==="" || proPrice.trim()==="" || proBrand.trim()==="" || proMadeIn.trim()==="")
	{
		alert("All fields must be filled out");
		return false;
	}
	
	if(proPrice<0)
	{
		alert("Product Price must be a NON_NEGATIVE value");
		return false;
	}
	
	if(proName.length>50 || proBrand.length>50)
	{
		alert("Product Name and Product Brand must be less than 50 characters");
		return false;
	}
	
	var manufacturingDateObj=new Date(proMfgDate);
	var expiryDateObj=new Date(proExpDate);
	
	if(manufacturingDateObj>expiryDateObj)
	{
		alert("Manufacturing date cannot be Greater than Expiry date.");
		return false;
		
	}
	
	return true;
}