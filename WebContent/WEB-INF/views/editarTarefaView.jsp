<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
	    $(function(){
	        $("#status").val( '${tarefa.status}' );
	    });
	</script>
   <head>
      <meta charset="UTF-8">
      <title>Editar Tarefa</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Editar Tarefa</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty tarefa}">
         <form method="POST" action="${pageContext.request.contextPath}/editarTarefa">
            <input type="hidden" name="id" value="${tarefa.id}" />
            <table border="0">
               <tr>
                  <td>ID</td>
                  <td style="color:red;">${tarefa.id}</td>
               </tr>
               <tr>
	               <td>Título</td>
	               <td><input type="text" name="titulo" value="${tarefa.titulo}" /></td>
	            </tr>
	            <tr>
	               <td>Descrição</td>
	               <td><input type="text" name="descricao" value="${tarefa.descricao}" /></td>
	            </tr>
				<tr>
					<td>Status</td>
					<td align="left">
					    <select id="status" name="status" value="${tarefa.status}">
					        <option value="Em Aberto">Em Aberto</option>
					        <option value="Concluído">Concluído</option>
					    </select>
					</td>
			    </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Editar" />
                      <a href="${pageContext.request.contextPath}/listaTarefas">Voltar</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>