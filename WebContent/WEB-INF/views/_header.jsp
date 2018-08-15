<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
  <div style="float: left">
     <h1>MyTaskList</h1>
     
     <div>
	   <a href="${pageContext.request.contextPath}/">Home</a>
	   |
	   <a href="${pageContext.request.contextPath}/listaTarefas">Tarefas</a>
	   |
	   <a href="${pageContext.request.contextPath}/informacoesConta">Informações da Conta</a>
	   |
	   <a href="${pageContext.request.contextPath}/login">Login</a>
	</div>  

  </div>
 
  <div style="float: right; padding: 10px; text-align: right;">
	Olá <b>${usuarioLogado.login}</b>
  <br/>

</div>

    <br/>
  	<br/>
  	<br/>
  	<br/>
