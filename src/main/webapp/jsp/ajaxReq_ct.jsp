<div class="top_top"></div>
        <div id="header" class="top_content">
            <c:import url="jsp/top_nav.jsp" />			  
            <!--Beginning of included content -->
           	<% session.setAttribute("requestPage", "analyzer_results.jsp"); %>
            <h1 class="question">CtoF Converter</h1>  <br/> <br/> 
                <form name="ctof" id= "ctof" action="" method="GET"  accept-charset="utf-8">
                <table>
                <tr><td>Enter Celsius Value: </td><td><input type="text" id="celsius" value="" size="4" required/></td></tr>
                </table> <br/> <br/> 
               
				<!--<a href="#" class="button"/>Convert</a>-->
				<input type = "submit" id="submitBut" value="Convert"/>
                </form> <br/> <br/>  
				<div id="results">Result Here...</div>  <br/> <br/> 
				<script type="text/javascript" src="js/asyncRequest.js"></script>
            <!--End of included content -->
        </div>  <!--End of header Div-->
        
<div class="top_bot"></div>

