<%@page import="ie.bm.proje.view.Kullanici"%>
<%@page import="ie.bm.proje.database.Database"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="baslik2.jsp" />

<!--  <form action="CevapAnahtariOkutServlet" method="post"
	enctype="multipart/form-data">
	<input type="file" name="file" /> <input type="submit"
		value="Cevap Anahtarını Gönder" />
</form>
<form action="CevapAnahtariniDosyadanOkuServlet" method="post"
	enctype="multipart/form-data">
	<input type="submit" value="İşlemleri Başlat" />
</form>-->
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
<form action="CevapAnahtariServlet" method="get">
		<div class="ingilizce">

			<div class="dersadi">İNGİLİZCE</div>
			<table>
				<tr>
					<td>Soru 1</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce1" value="A" />A</td>
					<td><input type="radio" name="ingilizce1" value="B" />B</td>
					<td><input type="radio" name="ingilizce1" value="C" />C</td>
					<td><input type="radio" name="ingilizce1" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 2</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce2" value="A" />A</td>
					<td><input type="radio" name="ingilizce2" value="B" />B</td>
					<td><input type="radio" name="ingilizce2" value="C" />C</td>
					<td><input type="radio" name="ingilizce2" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 3</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce3" value="A" />A</td>
					<td><input type="radio" name="ingilizce3" value="B" />B</td>
					<td><input type="radio" name="ingilizce3" value="C" />C</td>
					<td><input type="radio" name="ingilizce3" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 4</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce4" value="A" />A</td>
					<td><input type="radio" name="ingilizce4" value="B" />B</td>
					<td><input type="radio" name="ingilizce4" value="C" />C</td>
					<td><input type="radio" name="ingilizce4" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 5</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce5" value="A" />A</td>
					<td><input type="radio" name="ingilizce5" value="B" />B</td>
					<td><input type="radio" name="ingilizce5" value="C" />C</td>
					<td><input type="radio" name="ingilizce5" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 6</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce6" value="A" />A</td>
					<td><input type="radio" name="ingilizce6" value="B" />B</td>
					<td><input type="radio" name="ingilizce6" value="C" />C</td>
					<td><input type="radio" name="ingilizce6" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 7</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce7" value="A" />A</td>
					<td><input type="radio" name="ingilizce7" value="B" />B</td>
					<td><input type="radio" name="ingilizce7" value="C" />C</td>
					<td><input type="radio" name="ingilizce7" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 8</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce8" value="A" />A</td>
					<td><input type="radio" name="ingilizce8" value="B" />B</td>
					<td><input type="radio" name="ingilizce8" value="C" />C</td>
					<td><input type="radio" name="ingilizce8" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 9</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce9" value="A" />A</td>
					<td><input type="radio" name="ingilizce9" value="B" />B</td>
					<td><input type="radio" name="ingilizce9" value="C" />C</td>
					<td><input type="radio" name="ingilizce9" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 10</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce10" value="A" />A</td>
					<td><input type="radio" name="ingilizce10" value="B" />B</td>
					<td><input type="radio" name="ingilizce10" value="C" />C</td>
					<td><input type="radio" name="ingilizce10" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 11</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce11" value="A" />A</td>
					<td><input type="radio" name="ingilizce11" value="B" />B</td>
					<td><input type="radio" name="ingilizce11" value="C" />C</td>
					<td><input type="radio" name="ingilizce11" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 12</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce12" value="A" />A</td>
					<td><input type="radio" name="ingilizce12" value="B" />B</td>
					<td><input type="radio" name="ingilizce12" value="C" />C</td>
					<td><input type="radio" name="ingilizce12" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 13</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce13" value="A" />A</td>
					<td><input type="radio" name="ingilizce13" value="B" />B</td>
					<td><input type="radio" name="ingilizce13" value="C" />C</td>
					<td><input type="radio" name="ingilizce13" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 14</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce14" value="A" />A</td>
					<td><input type="radio" name="ingilizce14" value="B" />B</td>
					<td><input type="radio" name="ingilizce14" value="C" />C</td>
					<td><input type="radio" name="ingilizce14" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 15</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce15" value="A" />A</td>
					<td><input type="radio" name="ingilizce15" value="B" />B</td>
					<td><input type="radio" name="ingilizce15" value="C" />C</td>
					<td><input type="radio" name="ingilizce15" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 16</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce16" value="A" />A</td>
					<td><input type="radio" name="ingilizce16" value="B" />B</td>
					<td><input type="radio" name="ingilizce16" value="C" />C</td>
					<td><input type="radio" name="ingilizce16" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 17</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce17" value="A" />A</td>
					<td><input type="radio" name="ingilizce17" value="B" />B</td>
					<td><input type="radio" name="ingilizce17" value="C" />C</td>
					<td><input type="radio" name="ingilizce17" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 18</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce18" value="A" />A</td>
					<td><input type="radio" name="ingilizce18" value="B" />B</td>
					<td><input type="radio" name="ingilizce18" value="C" />C</td>
					<td><input type="radio" name="ingilizce18" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 19</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce19" value="A" />A</td>
					<td><input type="radio" name="ingilizce19" value="B" />B</td>
					<td><input type="radio" name="ingilizce19" value="C" />C</td>
					<td><input type="radio" name="ingilizce19" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 20</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce20" value="A" />A</td>
					<td><input type="radio" name="ingilizce20" value="B" />B</td>
					<td><input type="radio" name="ingilizce20" value="C" />C</td>
					<td><input type="radio" name="ingilizce20" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 21</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce21" value="A" />A</td>
					<td><input type="radio" name="ingilizce21" value="B" />B</td>
					<td><input type="radio" name="ingilizce21" value="C" />C</td>
					<td><input type="radio" name="ingilizce21" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 22</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce22" value="A" />A</td>
					<td><input type="radio" name="ingilizce22" value="B" />B</td>
					<td><input type="radio" name="ingilizce22" value="C" />C</td>
					<td><input type="radio" name="ingilizce22" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 23</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce23" value="A" />A</td>
					<td><input type="radio" name="ingilizce23" value="B" />B</td>
					<td><input type="radio" name="ingilizce23" value="C" />C</td>
					<td><input type="radio" name="ingilizce23" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 24</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce24" value="A" />A</td>
					<td><input type="radio" name="ingilizce24" value="B" />B</td>
					<td><input type="radio" name="ingilizce24" value="C" />C</td>
					<td><input type="radio" name="ingilizce24" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 25</td>
					<td>:</td>
					<td><input type="radio" name="ingilizce25" value="A" />A</td>
					<td><input type="radio" name="ingilizce25" value="B" />B</td>
					<td><input type="radio" name="ingilizce25" value="C" />C</td>
					<td><input type="radio" name="ingilizce25" value="D" />D</td>
				</tr>
			</table>
		</div>
		<div class="inkilap">


			<div class="dersadi">ATATÜRK İLKELERİ ve İNKILAP TARİHİ</div>
			<table>

				<tr>
					<td>Soru 1</td>
					<td>:</td>
					<td><input type="radio" name="inkilap1" value="A" />A</td>
					<td><input type="radio" name="inkilap1" value="B" />B</td>
					<td><input type="radio" name="inkilap1" value="C" />C</td>
					<td><input type="radio" name="inkilap1" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 2</td>
					<td>:</td>
					<td><input type="radio" name="inkilap2" value="A" />A</td>
					<td><input type="radio" name="inkilap2" value="B" />B</td>
					<td><input type="radio" name="inkilap2" value="C" />C</td>
					<td><input type="radio" name="inkilap2" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 3</td>
					<td>:</td>
					<td><input type="radio" name="inkilap3" value="A" />A</td>
					<td><input type="radio" name="inkilap3" value="B" />B</td>
					<td><input type="radio" name="inkilap3" value="C" />C</td>
					<td><input type="radio" name="inkilap3" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 4</td>
					<td>:</td>
					<td><input type="radio" name="inkilap4" value="A" />A</td>
					<td><input type="radio" name="inkilap4" value="B" />B</td>
					<td><input type="radio" name="inkilap4" value="C" />C</td>
					<td><input type="radio" name="inkilap4" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 5</td>
					<td>:</td>
					<td><input type="radio" name="inkilap5" value="A" />A</td>
					<td><input type="radio" name="inkilap5" value="B" />B</td>
					<td><input type="radio" name="inkilap5" value="C" />C</td>
					<td><input type="radio" name="inkilap5" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 6</td>
					<td>:</td>
					<td><input type="radio" name="inkilap6" value="A" />A</td>
					<td><input type="radio" name="inkilap6" value="B" />B</td>
					<td><input type="radio" name="inkilap6" value="C" />C</td>
					<td><input type="radio" name="inkilap6" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 7</td>
					<td>:</td>
					<td><input type="radio" name="inkilap7" value="A" />A</td>
					<td><input type="radio" name="inkilap7" value="B" />B</td>
					<td><input type="radio" name="inkilap7" value="C" />C</td>
					<td><input type="radio" name="inkilap7" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 8</td>
					<td>:</td>
					<td><input type="radio" name="inkilap8" value="A" />A</td>
					<td><input type="radio" name="inkilap8" value="B" />B</td>
					<td><input type="radio" name="inkilap8" value="C" />C</td>
					<td><input type="radio" name="inkilap8" value="D" />D</td>

				</tr>

				<tr>
					<td>Soru 9</td>
					<td>:</td>
					<td><input type="radio" name="inkilap9" value="A" />A</td>
					<td><input type="radio" name="inkilap9" value="B" />B</td>
					<td><input type="radio" name="inkilap9" value="C" />C</td>
					<td><input type="radio" name="inkilap9" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 10</td>
					<td>:</td>
					<td><input type="radio" name="inkilap10" value="A" />A</td>
					<td><input type="radio" name="inkilap10" value="B" />B</td>
					<td><input type="radio" name="inkilap10" value="C" />C</td>
					<td><input type="radio" name="inkilap10" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 11</td>
					<td>:</td>
					<td><input type="radio" name="inkilap11" value="A" />A</td>
					<td><input type="radio" name="inkilap11" value="B" />B</td>
					<td><input type="radio" name="inkilap11" value="C" />C</td>
					<td><input type="radio" name="inkilap11" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 12</td>
					<td>:</td>
					<td><input type="radio" name="inkilap12" value="A" />A</td>
					<td><input type="radio" name="inkilap12" value="B" />B</td>
					<td><input type="radio" name="inkilap12" value="C" />C</td>
					<td><input type="radio" name="inkilap12" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 13</td>
					<td>:</td>
					<td><input type="radio" name="inkilap13" value="A" />A</td>
					<td><input type="radio" name="inkilap13" value="B" />B</td>
					<td><input type="radio" name="inkilap13" value="C" />C</td>
					<td><input type="radio" name="inkilap13" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 14</td>
					<td>:</td>
					<td><input type="radio" name="inkilap14" value="A" />A</td>
					<td><input type="radio" name="inkilap14" value="B" />B</td>
					<td><input type="radio" name="inkilap14" value="C" />C</td>
					<td><input type="radio" name="inkilap14" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 15</td>
					<td>:</td>
					<td><input type="radio" name="inkilap15" value="A" />A</td>
					<td><input type="radio" name="inkilap15" value="B" />B</td>
					<td><input type="radio" name="inkilap15" value="C" />C</td>
					<td><input type="radio" name="inkilap15" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 16</td>
					<td>:</td>
					<td><input type="radio" name="inkilap16" value="A" />A</td>
					<td><input type="radio" name="inkilap16" value="B" />B</td>
					<td><input type="radio" name="inkilap16" value="C" />C</td>
					<td><input type="radio" name="inkilap16" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 17</td>
					<td>:</td>
					<td><input type="radio" name="inkilap17" value="A" />A</td>
					<td><input type="radio" name="inkilap17" value="B" />B</td>
					<td><input type="radio" name="inkilap17" value="C" />C</td>
					<td><input type="radio" name="inkilap17" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 18</td>
					<td>:</td>
					<td><input type="radio" name="inkilap18" value="A" />A</td>
					<td><input type="radio" name="inkilap18" value="B" />B</td>
					<td><input type="radio" name="inkilap18" value="C" />C</td>
					<td><input type="radio" name="inkilap18" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 19</td>
					<td>:</td>
					<td><input type="radio" name="inkilap19" value="A" />A</td>
					<td><input type="radio" name="inkilap19" value="B" />B</td>
					<td><input type="radio" name="inkilap19" value="C" />C</td>
					<td><input type="radio" name="inkilap19" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 20</td>
					<td>:</td>
					<td><input type="radio" name="inkilap20" value="A" />A</td>
					<td><input type="radio" name="inkilap20" value="B" />B</td>
					<td><input type="radio" name="inkilap20" value="C" />C</td>
					<td><input type="radio" name="inkilap20" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 21</td>
					<td>:</td>
					<td><input type="radio" name="inkilap21" value="A" />A</td>
					<td><input type="radio" name="inkilap21" value="B" />B</td>
					<td><input type="radio" name="inkilap21" value="C" />C</td>
					<td><input type="radio" name="inkilap21" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 22</td>
					<td>:</td>
					<td><input type="radio" name="inkilap22" value="A" />A</td>
					<td><input type="radio" name="inkilap22" value="B" />B</td>
					<td><input type="radio" name="inkilap22" value="C" />C</td>
					<td><input type="radio" name="inkilap22" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 23</td>
					<td>:</td>
					<td><input type="radio" name="inkilap23" value="A" />A</td>
					<td><input type="radio" name="inkilap23" value="B" />B</td>
					<td><input type="radio" name="inkilap23" value="C" />C</td>
					<td><input type="radio" name="inkilap23" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 24</td>
					<td>:</td>
					<td><input type="radio" name="inkilap24" value="A" />A</td>
					<td><input type="radio" name="inkilap24" value="B" />B</td>
					<td><input type="radio" name="inkilap24" value="C" />C</td>
					<td><input type="radio" name="inkilap24" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 25</td>
					<td>:</td>
					<td><input type="radio" name="inkilap25" value="A" />A</td>
					<td><input type="radio" name="inkilap25" value="B" />B</td>
					<td><input type="radio" name="inkilap25" value="C" />C</td>
					<td><input type="radio" name="inkilap25" value="D" />D</td>
				</tr>
			</table>
		</div>
		<div class="turkdili">

			<div class="dersadi">TÜRK DİLİ</div>
			<table>

				<tr>
					<td>Soru 1</td>
					<td>:</td>
					<td><input type="radio" name="turkdili1" value="A" />A</td>
					<td><input type="radio" name="turkdili1" value="B" />B</td>
					<td><input type="radio" name="turkdili1" value="C" />C</td>
					<td><input type="radio" name="turkdili1" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 2</td>
					<td>:</td>
					<td><input type="radio" name="turkdili2" value="A" />A</td>
					<td><input type="radio" name="turkdili2" value="B" />B</td>
					<td><input type="radio" name="turkdili2" value="C" />C</td>
					<td><input type="radio" name="turkdili2" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 3</td>
					<td>:</td>
					<td><input type="radio" name="turkdili3" value="A" />A</td>
					<td><input type="radio" name="turkdili3" value="B" />B</td>
					<td><input type="radio" name="turkdili3" value="C" />C</td>
					<td><input type="radio" name="turkdili3" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 4</td>
					<td>:</td>
					<td><input type="radio" name="turkdili4" value="A" />A</td>
					<td><input type="radio" name="turkdili4" value="B" />B</td>
					<td><input type="radio" name="turkdili4" value="C" />C</td>
					<td><input type="radio" name="turkdili4" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 5</td>
					<td>:</td>
					<td><input type="radio" name="turkdili5" value="A" />A</td>
					<td><input type="radio" name="turkdili5" value="B" />B</td>
					<td><input type="radio" name="turkdili5" value="C" />C</td>
					<td><input type="radio" name="turkdili5" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 6</td>
					<td>:</td>
					<td><input type="radio" name="turkdili6" value="A" />A</td>
					<td><input type="radio" name="turkdili6" value="B" />B</td>
					<td><input type="radio" name="turkdili6" value="C" />C</td>
					<td><input type="radio" name="turkdili6" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 7</td>
					<td>:</td>
					<td><input type="radio" name="turkdili7" value="A" />A</td>
					<td><input type="radio" name="turkdili7" value="B" />B</td>
					<td><input type="radio" name="turkdili7" value="C" />C</td>
					<td><input type="radio" name="turkdili7" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 8</td>
					<td>:</td>
					<td><input type="radio" name="turkdili8" value="A" />A</td>
					<td><input type="radio" name="turkdili8" value="B" />B</td>
					<td><input type="radio" name="turkdili8" value="C" />C</td>
					<td><input type="radio" name="turkdili8" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 9</td>
					<td>:</td>
					<td><input type="radio" name="turkdili9" value="A" />A</td>
					<td><input type="radio" name="turkdili9" value="B" />B</td>
					<td><input type="radio" name="turkdili9" value="C" />C</td>
					<td><input type="radio" name="turkdili9" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 10</td>
					<td>:</td>
					<td><input type="radio" name="turkdili10" value="A" />A</td>
					<td><input type="radio" name="turkdili10" value="B" />B</td>
					<td><input type="radio" name="turkdili10" value="C" />C</td>
					<td><input type="radio" name="turkdili10" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 11</td>
					<td>:</td>
					<td><input type="radio" name="turkdili11" value="A" />A</td>
					<td><input type="radio" name="turkdili11" value="B" />B</td>
					<td><input type="radio" name="turkdili11" value="C" />C</td>
					<td><input type="radio" name="turkdili11" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 12</td>
					<td>:</td>
					<td><input type="radio" name="turkdili12" value="A" />A</td>
					<td><input type="radio" name="turkdili12" value="B" />B</td>
					<td><input type="radio" name="turkdili12" value="C" />C</td>
					<td><input type="radio" name="turkdili12" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 13</td>
					<td>:</td>
					<td><input type="radio" name="turkdili13" value="A" />A</td>
					<td><input type="radio" name="turkdili13" value="B" />B</td>
					<td><input type="radio" name="turkdili13" value="C" />C</td>
					<td><input type="radio" name="turkdili13" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 14</td>
					<td>:</td>
					<td><input type="radio" name="turkdili14" value="A" />A</td>
					<td><input type="radio" name="turkdili14" value="B" />B</td>
					<td><input type="radio" name="turkdili14" value="C" />C</td>
					<td><input type="radio" name="turkdili14" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 15</td>
					<td>:</td>
					<td><input type="radio" name="turkdili15" value="A" />A</td>
					<td><input type="radio" name="turkdili15" value="B" />B</td>
					<td><input type="radio" name="turkdili15" value="C" />C</td>
					<td><input type="radio" name="turkdili15" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 16</td>
					<td>:</td>
					<td><input type="radio" name="turkdili16" value="A" />A</td>
					<td><input type="radio" name="turkdili16" value="B" />B</td>
					<td><input type="radio" name="turkdili16" value="C" />C</td>
					<td><input type="radio" name="turkdili16" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 17</td>
					<td>:</td>
					<td><input type="radio" name="turkdili17" value="A" />A</td>
					<td><input type="radio" name="turkdili17" value="B" />B</td>
					<td><input type="radio" name="turkdili17" value="C" />C</td>
					<td><input type="radio" name="turkdili17" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 18</td>
					<td>:</td>
					<td><input type="radio" name="turkdili18" value="A" />A</td>
					<td><input type="radio" name="turkdili18" value="B" />B</td>
					<td><input type="radio" name="turkdili18" value="C" />C</td>
					<td><input type="radio" name="turkdili18" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 19</td>
					<td>:</td>
					<td><input type="radio" name="turkdili19" value="A" />A</td>
					<td><input type="radio" name="turkdili19" value="B" />B</td>
					<td><input type="radio" name="turkdili19" value="C" />C</td>
					<td><input type="radio" name="turkdili19" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 20</td>
					<td>:</td>
					<td><input type="radio" name="turkdili20" value="A" />A</td>
					<td><input type="radio" name="turkdili20" value="B" />B</td>
					<td><input type="radio" name="turkdili20" value="C" />C</td>
					<td><input type="radio" name="turkdili20" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 21</td>
					<td>:</td>
					<td><input type="radio" name="turkdili21" value="A" />A</td>
					<td><input type="radio" name="turkdili21" value="B" />B</td>
					<td><input type="radio" name="turkdili21" value="C" />C</td>
					<td><input type="radio" name="turkdili21" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 22</td>
					<td>:</td>
					<td><input type="radio" name="turkdili22" value="A" />A</td>
					<td><input type="radio" name="turkdili22" value="B" />B</td>
					<td><input type="radio" name="turkdili22" value="C" />C</td>
					<td><input type="radio" name="turkdili22" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 23</td>
					<td>:</td>
					<td><input type="radio" name="turkdili23" value="A" />A</td>
					<td><input type="radio" name="turkdili23" value="B" />B</td>
					<td><input type="radio" name="turkdili23" value="C" />C</td>
					<td><input type="radio" name="turkdili23" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 24</td>
					<td>:</td>
					<td><input type="radio" name="turkdili24" value="A" />A</td>
					<td><input type="radio" name="turkdili24" value="B" />B</td>
					<td><input type="radio" name="turkdili24" value="C" />C</td>
					<td><input type="radio" name="turkdili24" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 25</td>
					<td>:</td>
					<td><input type="radio" name="turkdili25" value="A" />A</td>
					<td><input type="radio" name="turkdili25" value="B" />B</td>
					<td><input type="radio" name="turkdili25" value="C" />C</td>
					<td><input type="radio" name="turkdili25" value="D" />D</td>
				</tr>
			</table>

		</div>
		<div class="temelbiltek">

			<div class="dersadi">TEMEL BİLGİ TEKNOLOJİSİ KULLANIMI</div>
			<table>

				<tr>
					<td>Soru 1</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek1" value="A" />A</td>
					<td><input type="radio" name="temelbiltek1" value="B" />B</td>
					<td><input type="radio" name="temelbiltek1" value="C" />C</td>
					<td><input type="radio" name="temelbiltek1" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 2</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek2" value="A" />A</td>
					<td><input type="radio" name="temelbiltek2" value="B" />B</td>
					<td><input type="radio" name="temelbiltek2" value="C" />C</td>
					<td><input type="radio" name="temelbiltek2" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 3</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek3" value="A" />A</td>
					<td><input type="radio" name="temelbiltek3" value="B" />B</td>
					<td><input type="radio" name="temelbiltek3" value="C" />C</td>
					<td><input type="radio" name="temelbiltek3" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 4</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek4" value="A" />A</td>
					<td><input type="radio" name="temelbiltek4" value="B" />B</td>
					<td><input type="radio" name="temelbiltek4" value="C" />C</td>
					<td><input type="radio" name="temelbiltek4" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 5</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek5" value="A" />A</td>
					<td><input type="radio" name="temelbiltek5" value="B" />B</td>
					<td><input type="radio" name="temelbiltek5" value="C" />C</td>
					<td><input type="radio" name="temelbiltek5" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 6</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek6" value="A" />A</td>
					<td><input type="radio" name="temelbiltek6" value="B" />B</td>
					<td><input type="radio" name="temelbiltek6" value="C" />C</td>
					<td><input type="radio" name="temelbiltek6" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 7</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek7" value="A" />A</td>
					<td><input type="radio" name="temelbiltek7" value="B" />B</td>
					<td><input type="radio" name="temelbiltek7" value="C" />C</td>
					<td><input type="radio" name="temelbiltek7" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 8</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek8" value="A" />A</td>
					<td><input type="radio" name="temelbiltek8" value="B" />B</td>
					<td><input type="radio" name="temelbiltek8" value="C" />C</td>
					<td><input type="radio" name="temelbiltek8" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 9</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek9" value="A" />A</td>
					<td><input type="radio" name="temelbiltek9" value="B" />B</td>
					<td><input type="radio" name="temelbiltek9" value="C" />C</td>
					<td><input type="radio" name="temelbiltek9" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 10</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek10" value="A" />A</td>
					<td><input type="radio" name="temelbiltek10" value="B" />B</td>
					<td><input type="radio" name="temelbiltek10" value="C" />C</td>
					<td><input type="radio" name="temelbiltek10" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 11</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek11" value="A" />A</td>
					<td><input type="radio" name="temelbiltek11" value="B" />B</td>
					<td><input type="radio" name="temelbiltek11" value="C" />C</td>
					<td><input type="radio" name="temelbiltek11" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 12</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek12" value="A" />A</td>
					<td><input type="radio" name="temelbiltek12" value="B" />B</td>
					<td><input type="radio" name="temelbiltek12" value="C" />C</td>
					<td><input type="radio" name="temelbiltek12" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 13</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek13" value="A" />A</td>
					<td><input type="radio" name="temelbiltek13" value="B" />B</td>
					<td><input type="radio" name="temelbiltek13" value="C" />C</td>
					<td><input type="radio" name="temelbiltek13" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 14</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek14" value="A" />A</td>
					<td><input type="radio" name="temelbiltek14" value="B" />B</td>
					<td><input type="radio" name="temelbiltek14" value="C" />C</td>
					<td><input type="radio" name="temelbiltek14" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 15</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek15" value="A" />A</td>
					<td><input type="radio" name="temelbiltek15" value="B" />B</td>
					<td><input type="radio" name="temelbiltek15" value="C" />C</td>
					<td><input type="radio" name="temelbiltek15" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 16</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek16" value="A" />A</td>
					<td><input type="radio" name="temelbiltek16" value="B" />B</td>
					<td><input type="radio" name="temelbiltek16" value="C" />C</td>
					<td><input type="radio" name="temelbiltek16" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 17</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek17" value="A" />A</td>
					<td><input type="radio" name="temelbiltek17" value="B" />B</td>
					<td><input type="radio" name="temelbiltek17" value="C" />C</td>
					<td><input type="radio" name="temelbiltek17" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 18</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek18" value="A" />A</td>
					<td><input type="radio" name="temelbiltek18" value="B" />B</td>
					<td><input type="radio" name="temelbiltek18" value="C" />C</td>
					<td><input type="radio" name="temelbiltek18" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 19</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek19" value="A" />A</td>
					<td><input type="radio" name="temelbiltek19" value="B" />B</td>
					<td><input type="radio" name="temelbiltek19" value="C" />C</td>
					<td><input type="radio" name="temelbiltek19" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 20</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek20" value="A" />A</td>
					<td><input type="radio" name="temelbiltek20" value="B" />B</td>
					<td><input type="radio" name="temelbiltek20" value="C" />C</td>
					<td><input type="radio" name="temelbiltek20" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 21</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek21" value="A" />A</td>
					<td><input type="radio" name="temelbiltek21" value="B" />B</td>
					<td><input type="radio" name="temelbiltek21" value="C" />C</td>
					<td><input type="radio" name="temelbiltek21" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 22</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek22" value="A" />A</td>
					<td><input type="radio" name="temelbiltek22" value="B" />B</td>
					<td><input type="radio" name="temelbiltek22" value="C" />C</td>
					<td><input type="radio" name="temelbiltek22" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 23</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek23" value="A" />A</td>
					<td><input type="radio" name="temelbiltek23" value="B" />B</td>
					<td><input type="radio" name="temelbiltek23" value="C" />C</td>
					<td><input type="radio" name="temelbiltek23" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 24</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek24" value="A" />A</td>
					<td><input type="radio" name="temelbiltek24" value="B" />B</td>
					<td><input type="radio" name="temelbiltek24" value="C" />C</td>
					<td><input type="radio" name="temelbiltek24" value="D" />D</td>
				</tr>

				<tr>
					<td>Soru 25</td>
					<td>:</td>
					<td><input type="radio" name="temelbiltek25" value="A" />A</td>
					<td><input type="radio" name="temelbiltek25" value="B" />B</td>
					<td><input type="radio" name="temelbiltek25" value="C" />C</td>
					<td><input type="radio" name="temelbiltek25" value="D" />D</td>
				</tr>
			</table>
		</div>
		<input type="submit" value="İşlemleri Başlat" onclick="myFunction()"/>
		<p id="lutfenbekleyiniz1"></p>
		<script>
			function myFunction() {
    			document.getElementById("lutfenbekleyiniz1").innerHTML = "Sınav sonuçları oluşturuluyor. Lütfen bekleyiniz...";
			}
		</script>
	</form>
<jsp:include page="sayfatabani.jsp" />