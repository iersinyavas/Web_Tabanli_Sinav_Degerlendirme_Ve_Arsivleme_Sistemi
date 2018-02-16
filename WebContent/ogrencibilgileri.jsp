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
<form action="OgrenciBilgileriniGetirServlet" method="get">
	<table>
		<tr>
			<td>Öğrenci Numarası</td>
			<td>:</td>
			<td><input type="text" size="11" name="ogrencinumarasi1"></input></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td><c:out value="Yıl :"></c:out> <select name="yil1">
					<option>2017-2018</option>
					<option>2018-2019</option>
					<option>2019-2020</option>
			</select></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td><c:out value="Dönem :"></c:out> <select name="donem1">
					<option>Guz</option>
					<option>Bahar</option>
					<option>Yaz</option>
			</select></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td><c:out value="Sınav Türü :"></c:out> <select
				name="sinavturu1">
					<option>Ara Sinav</option>
					<option>Final</option>
					<option>Mazeret</option>
					<option>Butunleme</option>
			</select></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td><input type="submit" value="Öğrencinin Bilgilerini Getir"></input></td>
		</tr>
	</table>
</form>

<jsp:include page="sayfatabani.jsp" />