




/*function orderListCheck() {
		
		alert("버튼이 작동합니다.");
		
		$.ajax({
			type:		"get",
			url:		"/order/orderList",
			data:		{paramMap},
			dataType:	"json",
			success:	function(data) {
					alert("주문목록을 조회합니다.");
					
					var str = '';
					$.each(data, function(key, value) {
						str += <td align="center" class="o_date">'+ value.o_date + '</td>;
						str += <td align="center" class="o_num">' + value.o_num + '</td>;
						str += <td align="center" class="b_num"> '+ value.b_num + '</td>;
						str += <td align="center" class="b_id">'  + value.b_id + '</td>;
						str += <td align="center" class="o_name">'+ value.o_name + '</td>;
						str += <td align="center" class="o_price">'+ value.o_price + '</td>;
						str += <td align="center" class="o_state">'+ value.o_state + '</td>;
	         
	         		});
	         		$(".orderListCheck").html(str);
	         		
			},
			
			error:		function(data) {
				alert("주문목록 조회에 실패했습니다.");
			},
			
			complete: function(data) {
	         console.log(data);
	        } // End - complete
	      
	   }); // End - aJax

        
} // End - fn_orderListCheck()*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    