import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from '../model/product/product';
import { Category } from '../model/category/category';
import { CategoryRequest } from '../model/category/category-request';
import { OrderRequest } from '../model/order/order-request';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public productIds:  number[] = [];
  constructor(private _http: HttpClient, private _router: Router) {  }

  public addProduct(product: Product, idCategory: any):Observable<any>{
    var productValue = new Product();
    productValue.descriptionProduct = product.descriptionProduct;
    productValue.titleProduct = product.titleProduct;
    productValue.priceProduct = product.priceProduct;
    return this._http.post<any>("http://localhost:8090/product?idCategory=" + idCategory, productValue)
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

  public deleteProduct(idProduct: string):Observable<any>{
    return this._http.delete<any>("http://localhost:8090/product?idProduct=" +  idProduct)

  }

  addProductId(id: number): void {
    this.productIds.push(id);
  }

  getProductIds(): number[] {
    return this.productIds;
  }

}
