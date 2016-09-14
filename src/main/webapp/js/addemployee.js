var btnAddEmployeClick = function () {
    $("#btnAddEmployee").click(function () {
        var message = "";
        if ($("#id").val().is(":empty")) {
            message += "Please input ID \n";
        }
        if($("#name").is(":empty")){
            message += "Please input Name \n";
        }
        if($("#age").is(":empty")){
            message += "Please input Age \n";
        }
        if($("#dept").is(":empty")){
            message += "Please input Dept \n";
        }
        if($("#salary").is(":empty")){
            message += "Please input Salary";
        }
        
        if(message !== null){
            alert(message);
        }
        else {
            getResultAddEmployee();
        }
    });
};

var getResultAddEmployee = function () {

    $.ajax({
        type: "POST",
        url: "AddEmployee",
        data: {'id': $("#id").val(), 'name': $("#name").val(), 'age': $("#age").val(), 'dept': $("#dept").val(), 'salary': $("#salary").val()},
        success: function (response)
        {
            console.log(response);
            if (response === "success") {
                alert("Add Employee Successful!");
                document.location.href = 'allemployee.htm';
            } else {
                alert("Add Employee Fail!");
            }
        }
    });
};


