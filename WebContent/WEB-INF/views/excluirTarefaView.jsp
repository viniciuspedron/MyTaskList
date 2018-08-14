<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Excluir Tarefa</title>
 </head>
 
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    
    <h3>Excluir Tarefa</h3>
    
    <p style="color: red;">${errorString}</p>
    <a href="listaTarefas">Lista de Tarefas</a>
    
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>