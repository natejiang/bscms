$(document).ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#form").validate({		
		  errorElement: "span",
		  rules: 
		  {
	      	"newBroadband.ihomeBroadbandQuantity20": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"newBroadband.ihomeBroadbandQuantity30": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },"newBroadband.ihomeBroadbandQuantity50": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"newBroadband.ihomeBroadbandQuantity100": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"newBroadband.onlyBroadbandQuantity20": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"newBroadband.onlyBroadbandQuantity30": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"newBroadband.onlyBroadbandQuantity50": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"newBroadband.onlyBroadbandQuantity100": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"renewBroadband.ihomeBroadbandQuantity20": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"renewBroadband.ihomeBroadbandQuantity30": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"renewBroadband.ihomeBroadbandQuantity50": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"renewBroadband.ihomeBroadbandQuantity100": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"renewBroadband.onlyBroadbandQuantity20": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"renewBroadband.onlyBroadbandQuantity30": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"renewBroadband.onlyBroadbandQuantity50": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"renewBroadband.onlyBroadbandQuantity100": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			
			"doorToDoor.installedQuantity": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"doorToDoor.repairedQuantity": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"mobileProduct.simQuantity": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"mobileProduct.televisionQuantity": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"mobileProduct.terminalQuantity": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			"customer.customerQuantity": 
	        {
		    	required: true,
				digits:true,
		        range:[0,1000],
		    },
			
		  },
		  messages: 
		  {
		    "newBroadband.ihomeBroadbandQuantity20": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"newBroadband.ihomeBroadbandQuantity30": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"newBroadband.ihomeBroadbandQuantity50": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"newBroadband.ihomeBroadbandQuantity100": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"newBroadband.onlyBroadbandQuantity20": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"newBroadband.onlyBroadbandQuantity30": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"newBroadband.onlyBroadbandQuantity50": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"newBroadband.onlyBroadbandQuantity100": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"renewBroadband.ihomeBroadbandQuantity20": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"renewBroadband.ihomeBroadbandQuantity30": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"renewBroadband.ihomeBroadbandQuantity50": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"renewBroadband.ihomeBroadbandQuantity100": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"renewBroadband.onlyBroadbandQuantity20": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"renewBroadband.onlyBroadbandQuantity30": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"renewBroadband.onlyBroadbandQuantity50": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"renewBroadband.onlyBroadbandQuantity100": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			
			"doorToDoor.installedQuantity": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"doorToDoor.repairedQuantity": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"mobileProduct.simQuantity": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"mobileProduct.televisionQuantity": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"mobileProduct.terminalQuantity": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
			"customer.customerQuantity": 
	        {
		    	required: "请输入数据",
				digits: "请输入合法数据",
		        range: "数值在0~1000之间"
		    },
					 
		  }
		});
	
	  $(".cancel").click(function() {
			validator.resetForm();
	});
});