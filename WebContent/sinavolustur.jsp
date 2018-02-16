<%@page import="ie.bm.proje.view.Kullanici"%>
<%@page import="ie.bm.proje.database.Database"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="baslik2.jsp" />
	<%	//if(!Database.kullaniciDurumKontrol(Kullanici.getSkullaniciadi())){
		//response.sendRedirect("login.jsp");
	//}
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	if(request.getSession().getAttribute("kullanici")==null){
		response.sendRedirect("login.jsp");
	}
	%>
<form action="SinavOlusturServlet">
	<c:out value="Yıl :"></c:out>
	<select name="yil">
		<option>2017-2018</option>
		<option>2018-2019</option>
		<option>2019-2020</option>
	</select> &nbsp;&nbsp;&nbsp;
	<c:out value="Dönem :"></c:out>
	<select name="donem">
		<option>Guz</option>
		<option>Bahar</option>
		<option>Yaz</option>
	</select> &nbsp;&nbsp;&nbsp;
	<c:out value="Sınav Türü :"></c:out>
	<select name="sinavturu">
		<option>Ara Sinav</option>
		<option>Final</option>
		<option>Mazeret</option>
		<option>Butunleme</option>
	</select> <input type="submit" value="Sınav Oluştur" />
</form>

<jsp:include page="sayfatabani.jsp" />