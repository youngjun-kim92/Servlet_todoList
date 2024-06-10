<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Todo Read</title>
</head>
<body>
<div>
    <input type ="text" name ="tno" value="${dto.tno}" readonly>
</div>
<div>
    <input type ="text" name ="title" value="${dto.title}" readonly>
</div>
<div>
    <input type ="date" name ="dueDate" value="${dto.dueDate}">
</div>
<div>
    <input type ="checkbox" name ="finished" value=${dto.finished ? "checked":""} readonly>
</div>
<div>
    <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
    <a href="/todo/list">List</a>
</div>
</body>
</html>