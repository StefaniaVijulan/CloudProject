import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { OrderRequest } from '../model/order/order-request';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private _http: HttpClient, private _router: Router) {  }

  addOrder(order: OrderRequest):Observable<any>{
    var idUser = localStorage.getItem('idUser')
    console.log(order)
    return this._http.post<any>("http://localhost:8080/order?idUser="+ idUser, order)
  }
}
