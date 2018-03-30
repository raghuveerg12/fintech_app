
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].onclick = function(){
        this.classList.toggle("active");
        var panel = this.nextElementSibling;
        if (panel.style.display === "block") {
            panel.style.display = "none";
        } else {
            panel.style.display = "block";
        }
    }
}


var int=0;


function getDetails(value){
	alert(int);
	var a = "2";
	var b = "2";

	alert("value--"+value)

		$.ajax({
            url : 'ajaxtest11',
            data: { 'url': value},
            success : function(data) {
            	
                //Create a HTML Table element.
                var table = $("<table />");
                table[0].border = "1";
         
                var customers = new Array();
                customers.push(["Asks", "Bids", "price","volume"]);         
                //Add the header row.
                var row = $(table[0].insertRow(-1));
              //Add the header row.
                var row = $(table[0].insertRow(-1));
                for (var i = 0; i < 4; i++) {
                    var headerCell = $("<th />");
                    headerCell.html(customers[0][i]);
                    row.append(headerCell);
                }
       
         var count=int+20;
                //Add the data rows.
                alert("int>>"+int+">>>>count>>>"+count);
                for (var i = int; i < int+20; i++) {
                    row = $(table[0].insertRow(-1));
                    for (var j = 0; j < 1; j++) {
                        var cell1 = $("<td />");
                        var cell2 = $("<td />");
                        var cell3 = $("<td />");
                        var cell4 = $("<td />");
                        cell3.html(data[i].price);
                        cell1.html(data[i].asks);
                        cell2.html(data[i].bids);
                        cell4.html(data[i].volume);
                        row.append(cell1);
                        row.append(cell2);
                        row.append(cell3);
                        row.append(cell4);
                    }
                }
         
                var dvTable = $("#dvTable");
                dvTable.html("");
                dvTable.append(table);
                alert("before")
               

        }
	
		});
	}



function pagination(){
	alert("into pagination")
	var req_num_row=10;
	var $tr=jQuery('tbody tr');
	var total_num_row=$tr.length;
	var num_pages=0;
	if(total_num_row % req_num_row ==0){
		num_pages=total_num_row / req_num_row;
	}
	if(total_num_row % req_num_row >=1){
		num_pages=total_num_row / req_num_row;
		num_pages++;
		num_pages=Math.floor(num_pages++);
	}
	for(var i=1; i<=num_pages; i++){
		jQuery('#pagination').append(" "+i+" ");
		alert("i>>>"+i)

	}
	alert("i<<<<>>>"+i)

	$tr.each(function(i){

		jQuery(this).hide();
		if(i+1 <= req_num_row){

			$tr.eq(i).show();
		}
	
	});
	
	jQuery('#pagination a').click(function(e){
		alert("e>>>"+e)
		e.preventDefault();
		$tr.hide();
		var page=jQuery(this).text();
		var temp=page-1;
		var start=temp*req_num_row;
		//alert(start);
		
		for(var i=0; i< req_num_row; i++){
			
			$tr.eq(start+i).show();
		
		}
	});
}


function getths(){
alert("--gethis--");
	alert(document.getElementById("center"))
	document.getElementById("center").innerHTML="<jsp:include page='CenterBody.jsp'/>"
	}

