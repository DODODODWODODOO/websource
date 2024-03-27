<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.io.BufferedOutputStream" %>
<%@ page import="java.io.FileInputStream" %>
<% 

    // 클라이언트가 요청한 fileName 가져오기
    // 96882988-979e-4a45-bad2-dbeaa66af865_bg1.jpg
        String fileName = request.getParameter("fileName");

        // 서버에 저장된 폴더 경로 지정
        String fDownloadPath = "c:\\upload";
        // c:\\upload\\96882988-979e-4a45-bad2-dbeaa66af865_bg1.jpg
        String filePath = fDownloadPath + "\\" + fileName;

        // 하드디스크에 있는 파일 읽기
        FileInputStream in = new FileInputStream(filePath);

        // 브라우저가 응답할 때 읽어온 파일 보내기
        response.setContentType("application/octet-stream");
        fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");

        int start = fileName.lastIndexOf("_");
        String oriName = fileName.substring(start + 1);

        response.setHeader("Content-Disposition", "attachment;filename=" + oriName);

        out.clear();
        out = pageContext.pushBody();

        BufferedOutputStream buf = new BufferedOutputStream(response.getOutputStream());

        int numRead;
        byte b[] = new byte[4096];
        while ((numRead = in.read(b, 0, b.length)) != -1) {
            buf.write(b, 0, numRead);
        }
        buf.flush();
        buf.close();
        in.close();

%>

