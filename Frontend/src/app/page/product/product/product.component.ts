import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
    })
    console.log(this.productsList)
  }
  onSelect(x:any){
    this.selectedJewel = x;
  }
  openModelNewCategory(){
    
  }
}
