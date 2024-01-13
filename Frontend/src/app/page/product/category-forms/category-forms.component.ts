import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/model/category/category';
import { CategoryRequest } from 'src/app/model/category/category-request';
import { Product } from 'src/app/model/product/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-category-forms',
  templateUrl: './category-forms.component.html',
  styleUrls: ['./category-forms.component.css']
})
export class CategoryFormsComponent implements OnInit{

  public myForm!:FormGroup;
  constructor(private _router: Router, private formBuilder:FormBuilder, private _product: ProductService) { }
  category = new CategoryRequest();
  msg='';
  msgDone= false;
  ngOnInit(): void {
    this.myForm = this.formBuilder.group({
      nameCategory:["", Validators.required],
    })
  }

  addCategory(){
    this._product.addCategory(this.category).subscribe((res)=>{
      this.msgDone= true
      this.msg = "Done adding this category"
    },
    (err)=>{
      this.msgDone= true
      this.msg = "This category exist!"
    })
  }
}
