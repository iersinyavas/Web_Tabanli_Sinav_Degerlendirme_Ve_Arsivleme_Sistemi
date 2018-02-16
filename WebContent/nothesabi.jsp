<%@page import="ie.bm.proje.view.Kullanici"%>
<%@page import="ie.bm.proje.database.Database"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="baslik2.jsp" />
	<%	//if(!Database.kullaniciDurumKontrol(Kullanici.getSkullaniciadi())){
		//response.sendRedirect("login.jsp");
	//}
	
	//if(!Kullanici.isSdurum()){ response.sendRedirect("login.jsp"); }
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	if(request.getSession().getAttribute("kullanici")==null){
		response.sendRedirect("login.jsp");
	}
	%>
<div>
	<form action="GenelOrtalamaServlet">

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

		<table>
			<tr>
				<td>Arasınav</td>
				<td>:</td>
				<td>%<input type="text" name="arasinavorani" size="5"></td>
			</tr>
			<tr>
				<td>Final</td>
				<td>:</td>
				<td>%<input type="text" name="finalorani" size="5"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Genel Ortalama"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="sayfatabani.jsp" />