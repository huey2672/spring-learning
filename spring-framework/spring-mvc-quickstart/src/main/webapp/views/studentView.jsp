<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Student Info</title>
</head>
<body>
<table>
    <tr>
        <td>学号：</td>
        <td>${student.studentId}</td>
    </tr>
    <tr>
        <td>姓名：</td>
        <td>${student.studentName}</td>
    </tr>
    <tr>
        <td>性别：</td>
        <td>${student.sex}</td>
    </tr>
    <tr>
        <td>出生日期：</td>
        <td>${student.dateOfBirth}</td>
    </tr>
</table>
</body>
</html>