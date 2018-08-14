<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>MyTaskList</title>
  </head>
  <body>
 
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>

    </br>
	Página de demonstração utilizando JSP, Servlet &amp; JDBC. 
	</br>
    <b>Contém as seguintes funcionalidades:</b>
    <ul>
       <li>Login</li>
       <li>Informações do Usuário em Cookies</li>
       <li>Lista de tarefas</li>
       <li>Criar, editar ou excluir tarefas</li>
    </ul>

     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>