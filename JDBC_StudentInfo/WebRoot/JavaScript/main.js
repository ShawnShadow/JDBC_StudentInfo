/**
 * 
 */

function alertNull(){
	
	var stu_id = document.getElementsByName("stu_id");
	var name = document.getElementsByName("name");
	var gender = document.getElementsByName("gender");
	var class_no = document.getElementsByName("class_no");
	var birthday = document.getElementsByName("birthday");
	var dept = document.getElementsByName("dept");
	var major = document.getElementsByName("major");
	
	if(stu_id ==""|| name =="" || gender == "" || class_no == ""|| birthday == "" || dept =="" || major ==""){
		
		alert("输入不能为空");
		
	}
	
}