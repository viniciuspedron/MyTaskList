<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   </head>
   <body>
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Login</h3>
      <p style="color: red;">${errorString}</p>
 
 
      <form method="POST" action="${pageContext.request.contextPath}/login">
         <table border="0">
            <tr>
               <td>Login do Usuário</td>
               <td><input type="text" name="login" value= "${usuario.login}" /> </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="text" name="senha" value= "${usuario.senha}" /> </td>
            </tr>
            <tr>
               <td>Manter logado</td>
               <td><input type="checkbox" name="manterLogado" value= "S" /> </td>
            </tr>
            <tr>
               <td colspan ="2">
                  <input type="submit" value="Entrar" />
                  <a href="${pageContext.request.contextPath}/">Voltar</a>
               </td>
            </tr>
         </table>
      </form>
 
      <p style="color:green;">User Name: supero, password: supero</p>
 
      <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>