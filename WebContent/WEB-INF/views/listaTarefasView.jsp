<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Lista de Tarefas</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 </head>
 <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
 
    <h3>Lista de Tarefas</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ID</th>
          <th>Título</th>
          <th>Descrição</th>
          <th>Status</th>
          <th>Editar</th>
          <th>Excluir</th>
       </tr>
       <c:forEach items="${listaTarefas}" var="tarefa" >
          <tr>
             <td>${tarefa.id}</td>
             <td>${tarefa.titulo}</td>
             <td>${tarefa.descricao}</td>
             <td>${tarefa.status}
             </td>
             <td>
                <a href="editarTarefa?id=${tarefa.id}">Editar</a>
             </td>
             <td>
                <a href="excluirTarefa?id=${tarefa.id}">Excluir</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
	</br>
    <a href="adicionarTarefa" >AdicionarTarefa</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>