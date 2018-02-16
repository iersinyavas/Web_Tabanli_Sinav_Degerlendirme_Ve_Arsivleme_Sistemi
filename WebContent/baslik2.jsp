<%@page import="ie.bm.proje.view.Kullanici"%>
<%@page import="ie.bm.proje.database.Database"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Bilecik Şeyh Edebali Üniversitesi Açık Ve Uzaktan Öğrenme
	Merkezi</title>
<link rel="stylesheet" href="style.css" />
<style>
img {
	padding: 0;
	max-height: 100%;
	min-width: 100%;
}
</style>
</head>
<body>

	<div id="header">
		<img src="images/baum.png">
	</div>
	
	<div class="menu">
		<ul>
			<li><a id="sinavolustur" href="sinavolustur.jsp">Sınav
					Oluştur</a></li>
			<li><a id="optikoku" href="optikoku.jsp">Optik Oku</a></li>
			<li><a id="cevapanahtari2" href="cevapanahtari2.jsp">Cevap
					Anahtarı</a></li>
			<li><a id="sinavsonuclari">Sınav Sonuçları</a>
				<div class="acilirmenu">
					<ul>
						<li><a class="istatistikler" href="istatistikler.jsp">İstatistikler</a></li>
						<li><a class="ogrencilistesi" href="sinavsonuclari.jsp">Öğrenci Listesi</a></li>
						<li><a class="ogrencibilgileri" href="ogrencibilgileri.jsp">Öğrenci Bilgisi</a></li>
						<li><a class="nothesabi" href="nothesabi.jsp">Genel Ortalama Hesabı</a></li>
					</ul>
				</div></li>
			<li><a id="login" href="UyeCikisServlet">Çıkış</a></li>
		</ul>
	</div>
	<div id="content">
	<div id="kullaniciadi">
		<c:if test="${not empty kullanici}">
			<span>Sayın, ${kullanici} hoşgeldiniz</span>
		</c:if>
	</div>
	