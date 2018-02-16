<%@page import="ie.bm.proje.view.Kullanici"%>
<%@page import="ie.bm.proje.database.Database"%>
<%@page import="ie.bm.proje.model.Dosya"%>
<%@page import="java.io.IOException"%>
<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="java.io.File"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="ie.bm.proje.view.OgrenciBilgileri"%>
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
<div id="ogrencibilgileri">
	<table>
		<tr>
			<td>Öğrenci TC No</td>
			<td>:</td>
			<td><c:out value="${ogrtcno}"></c:out></td>
		</tr>
		<tr>
			<td>Yıl</td>
			<td>:</td>
			<td><c:out value="${yil}"></c:out></td>
		</tr>
		<tr>
			<td>Dönem</td>
			<td>:</td>
			<td><c:out value="${donem}"></c:out></td>
		</tr>
		<tr>
			<td>Kitapçık Türü</td>
			<td>:</td>
			<td><c:out value="${kitapcikturu}"></c:out></td>
		</tr>
		<tr>
			<td>Oturum Bilgisi</td>
			<td>:</td>
			<td><c:out value="${oturum}"></c:out></td>
		</tr>
		<tr>
			<td>Sınav Türü</td>
			<td>:</td>
			<td><c:out value="${sinavturu}"></c:out></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>İngilizce</td>
			<td>-----</td>
			<td>Doğru</td>
			<td>:</td>
			<td><c:out value="${ingilizceds}"></c:out></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>Yanlış</td>
			<td>:</td>
			<td><c:out value="${ingilizceys}"></c:out></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>Not</td>
			<td>:</td>
			<td><c:out value="${puaningilizce}"></c:out></td>
		</tr>
		<tr>
			<td>Atatürk İlkeleri ve İnkılap Tarihi</td>
			<td>-----</td>
			<td>Doğru</td>
			<td>:</td>
			<td><c:out value="${inkilapds}"></c:out></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>Yanlış</td>
			<td>:</td>
			<td><c:out value="${inkilapys}"></c:out></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>Not</td>
			<td>:</td>
			<td><c:out value="${puaninkilap}"></c:out></td>
		</tr>
		<tr>
			<td>Türk Dili</td>
			<td>-----</td>
			<td>Doğru</td>
			<td>:</td>
			<td><c:out value="${turkdilids}"></c:out></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>Yanlış</td>
			<td>:</td>
			<td><c:out value="${turkdiliys}"></c:out></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>Not</td>
			<td>:</td>
			<td><c:out value="${puanturkdili}"></c:out></td>
		</tr>
		<tr>
			<td>Temel Bilgi Teknolojisi Kullanımı</td>
			<td>-----</td>
			<td>Doğru</td>
			<td>:</td>
			<td><c:out value="${temelbiltekds}"></c:out></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>Yanlış</td>
			<td>:</td>
			<td><c:out value="${temelbiltekys}"></c:out></td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>Not</td>
			<td>:</td>
			<td><c:out value="${puantemelbiltek}"></c:out></td>
		</tr>
	</table>
</div>
<form>
	<div class="optik">
		<%
			try {
				String resimadi = "E:\\OptikOkumaProjesi\\OptikOkuma\\WebContent\\images\\optik\\optik.jpg";
				BufferedImage bufferedImage = ImageIO.read(new File(resimadi));
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				if(bufferedImage != null){
					ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
				}else{
					String hatamesaji = "Belirtilen kriterlere uygun kayıt bulunamadı!";
					request.setAttribute("hatamesaji", hatamesaji);
					request.getRequestDispatcher("kullanicisayfasi.jsp").forward(request, response);
				}
				
				byteArrayOutputStream.flush();
				byte[] imageInByteArray = byteArrayOutputStream.toByteArray();
				byteArrayOutputStream.close();
				String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
		%>
		<img class="img-responsive" src="data:image/jpg;base64, <%=b64%>" />
		<%
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}
		
		Dosya dosya = new Dosya();
		File optik[] = dosya.optikDosyasiniGetir();
		for (File file : optik) {
			file.delete();
		}
		%>
	</div>
</form>
<jsp:include page="sayfatabani.jsp" />