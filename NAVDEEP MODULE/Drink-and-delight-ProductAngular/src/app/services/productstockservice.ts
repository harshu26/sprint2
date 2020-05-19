import { HttpClient } from '@angular/common/http';
import { ProductStock } from '../model/productstock';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable()
export class ProductStockService{
    client:HttpClient;
    constructor(client:HttpClient){
        this.client=client;
    }

    baseUrl = "http://localhost:8086/products";

    addStock(stock:ProductStock): Observable<ProductStock>{
        let url = this.baseUrl+"/add";
        let result :Observable<ProductStock>=this.client.post<ProductStock>(url,stock);
        return result;
    }

    fetchAllStocks():Observable<ProductStock[]>{
        let url = this.baseUrl;
        let result:Observable<ProductStock[]>=this.client.get<ProductStock[]>(url);
        return result;
    }

    findStockById(id:string):Observable<ProductStock>{
        let url = this.baseUrl+"/id/name";
        let result:Observable<ProductStock>=this.client.get<ProductStock>(url);
        return result;
    }
}