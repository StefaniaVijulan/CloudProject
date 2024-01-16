import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/model/category/category';
import { Product } from 'src/app/model/product/product';
import { ProductRequest } from 'src/app/model/product/product-request';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product-forms',
  templateUrl: './product-forms.component.html',
  styleUrls: ['./product-forms.component.css']
})
export class ProductFormsComponent implements OnInit{

  public myForm!:FormGroup;
  constructor(private _router: Router, private formBuilder:FormBuilder, private _product: ProductService) { }
  product = new Product();
  msg='';
  categoriesList: Category[] | undefined;
  msgDone= false;
  ngOnInit(): void {
    this.getAllCategories()
    this.myForm = this.formBuilder.group({
      titleProduct:["", Validators.required],
      priceProduct:[0, Validators.required],
      descriptionProduct:["", Validators.required],
      category:[0, Validators.required],
    })
  }
  

  

  getAllCategories(){
    this._product.getCategory().subscribe((res)=>{
      this.categoriesList = res;
    })
  }
  addCategory(){
    this._product.addProduct(this.product, this.product.category).subscribe((res)=>{
      this.msgDone= true
      this.msg = "Done adding this product"
    },
    (err)=>{
      this.msgDone= true
      this.msg = "This product exist!"
    })
  }
}
