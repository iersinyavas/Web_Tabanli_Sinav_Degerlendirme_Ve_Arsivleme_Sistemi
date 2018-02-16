<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="baslik.jsp" />
<script type="text/javascript">
	function DisableBackButton() {
		window.history.forward()
	}
	DisableBackButton();
	window.onload = DisableBackButton;
	window.onpageshow = function(evt) {
		if (evt.persisted)
			DisableBackButton()
	}
	window.onunload = function() {
		void (0)
	}
</script>

<div>
	<div id="">
		<form action="KayitKontrolServlet" method="post">
			<table>
				<tr>
					<td>Adınız</td>
					<td>:</td>
					<td><input type="text" size="10" name="ad"></input></td>
				</tr>
				<tr>
					<td>Soyadınız</td>
					<td>:</td>
					<td><input type="text" size="10" name="soyad"></input></td>
				</tr>
				<tr>
					<td>Kullanıcı Adınız</td>
					<td>:</td>
					<td><input type="text" size="10" name="kullaniciadi"></input></td>
				</tr>
				<tr>
					<td>Şifre</td>
					<td>:</td>
					<td><input type="password" size="10" name="sifre"></input></td>
				</tr>
			</table>
			<c:if test="${not empty kayitkontrolmesaji}">
				<p>${kayitkontrolmesaji}</p>
			</c:if>
			<c:if test="${not empty kullanicivarmesaji}">
				<p>${kullanicivarmesaji}</p>
			</c:if>
			<input type="submit" value="Kaydol" />
		</form>
	</div>
	<div id="">
		<form action="KullaniciSayfasiServlet" method="post">
			<table>
				<tr>
					<td>Kullanıcı Adınız</td>
					<td>:</td>
					<td><input type="text" size="10" name="kullaniciadi1"></input></td>
				</tr>
				<tr>
					<td>Şifre</td>
					<td>:</td>
					<td><input type="password" size="10" name="sifre1"></input></td>
				</tr>
			</table>
			<c:if test="${not empty mesaj}">
				<p>${mesaj}</p>
			</c:if>
			<input type="submit" value="Giriş Yap"></input>
		</form>
	</div>
</div>

<jsp:include page="sayfatabani.jsp" />