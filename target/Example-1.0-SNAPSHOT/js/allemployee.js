var showAllEmployee = function () {
    $.ajax({
        type: "POST",
        url: "AllEmployee",
        success: function (response)
        {
            console.log(response);
            var json_obj = response;//parse JSON
            console.log(json_obj);
            var output = "";
            for (var i in json_obj)
            {
                output += "<tr><td><a href='modifyemployee.htm?idemp=" + json_obj[i].id + "'>" + json_obj[i].id + "</a></td><td>" + json_obj[i].name + "</td><td>" + json_obj[i].age + "</td><td>" + json_obj[i].dept + "</td><td>" + json_obj[i].salary + "</td><td><button>Delete</button></td></tr>";
            }

            $('#myTable > tbody').append(output);
            btnDeleteClick();
        },
        dataType: "json"//set to JSON    
    });

};

var btnAddClick = function () {
    $("#btnAdd").click(function () {
        document.location.href = 'addemployee.htm';
    });
};


var btnDeleteClick = function () {
    $('#myTable').find('tr').find('td:last').find('button').click(function () {
        var id = $(this).parents('tr').find('td:first').text();
        if (confirm('Are you sure?'))
        {
            $.ajax({
                        type: "POST",
                        url: "DeleteEmployee",
                        data: {'id': id},
                        success: function (response)
                        {
                            console.log(response);
                            if (response === "success") {
                                alert("Delete Employee Successful!");
                                location.reload();
                            } else {
                                alert("Delete Employee Fail!");
                            }
                        }
                    });
        } else {
            alert('A wise decision!');
        }
    });
};
