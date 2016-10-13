$(document).ready(function (){	
	$("form").bind("submit",function(e) {		
		var uri = "http://localhost:8080/webServices/ctofservice/";
		var append =  $("#celsius").val();
		getF (uri ,append);
		e.preventDefault();
	});
});

function getF (uri) {
	$.ajax({
		url: uri,
		success: function( data ) {	
					renderXml (data, "ctofoutput", "#results");
		},
		fail: function(data) {
					alert ("Failed");			
		}
	});
}

function getF (uri, append) {
	$.ajax({		
		url: uri,
		beforeSend: function ( jqXHR, settings) {
					//alert(settings.url);
					settings.url += append;
		},
		success: function( data ) {									
					renderXml (data, "ctofoutput", "#results");
		},
		fail: function(data) {
					alert ("Failed");			
		}
	});
}

function renderXml( xml, xmlAttr, target ) {
	var output = $(xml).find(xmlAttr).text();
	$(target).html("<font color=\"blue\">"+output+"</font>");
}
 