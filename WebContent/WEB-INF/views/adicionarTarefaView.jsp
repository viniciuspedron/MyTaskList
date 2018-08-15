<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Adicionar Tarefa</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
       
      <h3>Adicionar Tarefa</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="adicionarTarefa">
         <table border="0">
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
				    <select name="status" value="${tarefa.status}">
				        <option id="0">Em Aberto</option>
				        <option id="1">Concluído</option>
				    </select>
				</td>
		    </tr>
            <tr>
               <td colspan="2">   
               	   </br>                
                   <input type="submit" value="Adicionar" />
                   <a href="listaTarefas">Voltar</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>