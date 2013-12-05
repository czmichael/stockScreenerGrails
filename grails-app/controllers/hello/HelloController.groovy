package hello

import com.ztech.StockService;

class HelloController {

	StockService stockService
	
    def index() { 
    	render stockService.getStock()
		
		
    }
}
