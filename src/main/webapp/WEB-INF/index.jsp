<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ninja Gold Game</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <h3>Your Gold: <span class="span"><c:out value="${coin}"></c:out> </span></h3>
</div>
<div class="container">
    <form class="table" action="/farm" method="post">
        <h3>Farm</h3>
        <p>(earns 10-20 gold)</p>
        <input value="Find Gold!" type="submit" class="btn btn-outline-dark">
    </form>
    <form class="table" action="/cave" method="post">
        <h3>Cave</h3>
        <p>(earns 5-10 gold)</p>
        <input value="Find Gold!" type="submit"  class="btn btn-outline-dark">
    </form>
    <form class="table" action="/house" method="post">
        <h3>House</h3>
        <p>(earns 2-5 gold)</p>
        <input value="Find Gold!" type="submit"  class="btn btn-outline-dark">
    </form>
    <form class="table" action="/quest" method="post">
        <h3>Quest</h3>
        <p>(earns/takes 0-50 gold)</p>
        <input value="Find Gold!" type="submit"  class="btn btn-outline-dark">
    </form>
</div>
<div class="container2">
    <h3>Activities</h3>
    <div class="logs">
        <c:forEach var="log" items="${logs}">
            <p><c:out value="${log}"></c:out></p>
        </c:forEach>
    </div>
</div>
</body>
</html>