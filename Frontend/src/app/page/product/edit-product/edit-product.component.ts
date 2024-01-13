import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/model/category/category';
import { Product } from 'src/app/model/product/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit{

  public myForm!:FormGroup;
  constructor(private _router: Router, private formBuilder:FormBuilder, private _product: ProductService) { }
  product = new Product();
  msg='';
  categoriesList: Category[] | undefined;
  msgDone= false;
  ngOnInit(): void {
    this.getAllCategories()
    this.myForm = this.formBuilder.group({
      titleProduct:[this.product.titleProduct, Validators.required],
      priceProduct:[this.product.priceProduct, Validators.required],
      descriptionProduct:[this.product.descriptionProduct, Validators.required],
      category:[this.product.category, Validators.required],
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