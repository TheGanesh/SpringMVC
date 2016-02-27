<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>All TODO tasks</h2>

<script type="text/javascript" src="../../scripts/jquery-1.11.1.min.js"></script>

<script type="text/javascript">

    var addTaskToList = function () {

        var requestJson = {
            todoId: $("#todoId").val(),
            todoName: $("#todoName").val()
        };

        $.ajax({
            url: "/spring/api/todo",
            type: "POST",
            headers: {
                "Content-Type": "application/json",
                "X-AUTH-TOKEN": "sampleToken"
            },
            data: JSON.stringify(requestJson),
            success: function (data) {

                var taskList = "";
                for (var i = 0; i < data.length; i++) {
                    taskList += "<ul> <li>" + data[i].todoId + " , " + data[i].todoName + "</li></ul>";
                }

                $("#tasksDiv").html(taskList);
            },
            error: function () {
                alert("API call failed.")
            }
        });
    };

    $(document).ready(function () {

        $("#submit").click(function () {
            addTaskToList();
        });

    });

</script>


<div id="tasksDiv">

    <c:if test="${not empty tasks}">

        <ul>
            <c:forEach var="task" items="${tasks}">
                <li>${task}</li>
            </c:forEach>
        </ul>

    </c:if>

</div>


<div id="addtaskDiv">

    <p><input type="text" id="todoId"></p>

    <p><input type="text" id="todoName"></p>

    <p><input type="submit" id="submit" value="Add New Task"></p>

</div>


</body>
</html>