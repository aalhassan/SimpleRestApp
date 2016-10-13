$(document).ready(function (){	
	$("#getEvents").bind("click",function(e) {
		var uri = "http://localhost:8080/webServices/sseEvents/";


		if(typeof(EventSource) !== "undefined") {
			var source = new EventSource(uri);
			source.onmessage = function(event){
			renderSSEData(event,"#results");
			};
		} else {
			// Sorry! No server-sent events support..
			$("#results").html("<font color=\"red\">Sorry! No server-sent events support</font>");
		}
		e.preventDefault();
	});
});


function renderSSEData( event, target ) {
	var output = event.data
	$(target).html("<font color=\"blue\">"+output+"</font>");
}
