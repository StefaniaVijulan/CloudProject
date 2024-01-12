import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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
  product = new ProductRequest();
  msg='';
  msgDone= false;
  ngOnInit(): void {
    this.myForm = this.formBuilder.group({
      titleProduct:["", Validators.required],
      priceProduct:[0, Validators.required],
      descriptionProduct:["", Validators.required],
    })
  }

  addCategory(){
    // this._product.addCategory(this.category).subscribe((res)=>{
    //   console.log("Add")
    //   this.msgDone= true
    //   this.msg = "Done adding this category"
    // },
    // (err)=>{
    //   this.msgDone= true
    //   this.msg = "This category exist!"
    // })
  }
}
