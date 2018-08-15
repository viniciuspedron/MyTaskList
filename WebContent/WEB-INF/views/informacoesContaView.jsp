<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Informações da Conta</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 </head>
 <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
 
    <h3>Olá ${usuario.login}</h3>
 
    Login: <b>${usuario.login}</b>
    <br />
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>