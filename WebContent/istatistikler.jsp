<%@page import="ie.bm.proje.view.Kullanici"%>
<%@page import="ie.bm.proje.database.Database"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="baslik2.jsp" />
<%
	//if (!Database.kullaniciDurumKontrol(Kullanici.getSkullaniciadi())) {
		//response.sendRedirect("login.jsp");
	//}
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");

	if(request.getSession().getAttribute("kullanici")==null){
		response.sendRedirect("login.jsp");
	}
%>


<jsp:include page="sayfatabani.jsp" />