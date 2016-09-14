var showEmployee = function () {
    var param = getParameter("idemp");
    $.ajax({
        type: "GET",
        url: "ModifyEmployee",
        data: {idemp: param},
        success: function (response)
        {
            console.log(response);
            var json_obj = response;//parse JSON
            console.log(json_obj);
            $("#id").val(json_obj.id);
            $("#name").val(json_obj.name);
            $("#age").val(json_obj.age);
            $("#dept").val(json_obj.dept);
            $("#salary").val(json_obj.salary);
        },
        dataType: "json"//set to JSON    
    });
};

var getParameter = function (name) {
    var results = new RegExp('[\?&]' + name + '=([^#]*)').exec(window.location.href);
    if (results === null) {
        return null;
    } else {
        return results[1] || 0;
    }
};

var getResultUpdateEmployee = function () {
    $.ajax({
        type: "POST",
        url: "ModifyEmployee",
        data : {'id':$("#id").val(),'name':$("#name").val(),'age':$("#age").val(), 'dept':$("#dept").val(),'salary':$("#salary").val()},
        success: function (response)
        {
            console.log(response);
            if(response === "success"){
                alert("Modify Employee Successful!");
                document.location.href = 'allemployee.htm';
            }else{
                alert("Modify Employee Fail!");
            }
        }
    });
};

var btnUpdateClick = function () {
    $("#btnUpdate").click(function () {
        getResultUpdateEmployee();
    });
}