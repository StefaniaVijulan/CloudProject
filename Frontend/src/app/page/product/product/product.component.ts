import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductRequest } from 'src/app/model/product/product-request';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit{
  selectedJewel: any;
  productsList: any;

  constructor(private _service : ProductService, private _router : Router){}


  ngOnInit(): void {
    
   this._service.getProduct().subscribe((res)=>{
    this.productsList = res;
    this.productsList.forEach((product: { idProduct: number; }) => {
      if (this.isProductDisabled(product.idProduct)) {
        this.disableButton(product.idProduct);
      }
    });
    })
  }
  deleteProduct(id:any){
    this._service.deleteProduct(id).subscribe(()=>{
      window.location.reload();

    }, (err)=>{
        window.location.reload();
    })
  }

  editProduct(product: ProductRequest){

  }
  
  isProductDisabled(productId: number): boolean {
    return this._service.getProductIds().includes(productId);
  }

  disableButton(productId: number): void {
    var buttonId = 'product_' + productId;
    var buttonId = 'product_' + productId;
    var buttonElement = document.getElementById(buttonId);

    if (buttonElement) {
      buttonElement.setAttribute('disabled', 'true');
    }
  }
  addProduct(id: any){

    this._service.addProductId(id);
    this.disableButton(id)
  }
}
