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
<c:if test="${not empty hatamesaji}">
	<p>${hatamesaji}</p>
</c:if>
<c:if test="${not empty optiklerokutuldu}">
	<p>${optiklerokutuldu}</p>
</c:if>
<c:if test="${not empty islemlertamamlandi}">
	<p>${islemlertamamlandi}</p>
</c:if>
<c:if test="${not empty genelbasari}">
	<p>${genelbasari}</p>
</c:if>
<jsp:include page="sayfatabani.jsp" />