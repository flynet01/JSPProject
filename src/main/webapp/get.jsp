 <html>
 <body>
 <h2>Get Time</h2>
 <%@ page import="com.sample.PageBean"%>
<%
     System.out.println( "Getting date now" );
    PageBean pb = new PageBean(session);
%>
 The time is <%= session.getAttribute("current.time") %>
 <br /><%= pb.getCacheSize() %>
 <br /><%= pb.getServerCacheSize() %>
 <br /><%= pb.getEjbCacheSize() %>
 <br /><%= pb.getCacheContent() %>
 </body>
 </html>




