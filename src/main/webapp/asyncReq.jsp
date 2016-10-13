<% request.setAttribute("pageTitle", "Java 112 Projects"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="jsp/head.jsp" />
    <body>
        <div id="main">
        <!-- Top Section begins,  page's main content goes here -->        
            <c:import url="jsp/ajaxReq_ct.jsp" />
        <!-- Top Section Ends -->
        
        <!-- Mid Section begins -->
            <c:import url="jsp/mid_section.jsp" />
        <!-- Mid Section ends -->
        
        <!-- Bottom Section begins -->
            <c:import url="jsp/bot_section.jsp" />
        <!-- Bottom Section ends -->
        
        </div> <!--End of Main Div-->
    <!-- footer begins -->
        <c:import url="jsp/footer.jsp" />
    <!-- footer ends -->
    </body>
</html>
