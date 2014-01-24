package com.ztech

class StockService {

    def getStock() {
		def sector = new Sector(id:null, name:"computer")
		sector.save()
    }
}
