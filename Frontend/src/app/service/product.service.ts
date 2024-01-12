import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from '../model/product/product';
import { Category } from '../model/category/category';
import { CategoryRequest } from '../model/category/category-request';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _http: HttpClient, private _router: Router) {  }

  public addProduct(product: Product, idCategory: any):Observable<any>{
    return this._http.post<any>("http://localhost:8090/product?idCategory=" + idCategory, product)
  }

  public getProduct(){
    return this._http.get<any>('http://localhost:8090/product')
  }

  public getCategory(){
    return this._http.get<any>('http://localhost:8090/category')

  }

  public addCategory(category: CategoryRequest):Observable<any>{
    return this._http.post<any>("http://localhost:8090/category", category)

  }
}
