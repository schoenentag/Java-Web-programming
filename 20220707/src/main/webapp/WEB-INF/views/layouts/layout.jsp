<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title> <!-- tiles.xml의 name 그대로... -->
</head>
<body>
    <div align="center">
        <tiles:insertAttribute name="header" />
        <hr>
        <tiles:insertAttribute name="body" />
        <hr>
        <tiles:insertAttribute name="footer" />
    </div>

</body>
</html>