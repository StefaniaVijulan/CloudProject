import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/model/product/product';
import { ProductService } from 'src/app/service/product.service';
import * as moment from 'moment';
import { OrderRequest } from 'src/app/model/order/order-request';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{

  currentData: any;
  filteredProducts: Product[] =[]
  totalPrice = 0;
  taxPrice = 0
  orderPrice = 0
  orderAdded: boolean = false;
  constructor(private _service : ProductService, private _router : Router, private _orderService: OrderService){}

  ngOnInit(): void {
    this.currentData = moment().format('yyyy MMM dd, hh:mm a')
    this._service.getProduct().subscribe((res)=>{
      this.filteredProducts = res.filter((product: { idProduct: number; }) => this._service.productIds.includes(product.idProduct));
      for(let i=0; i<this.filteredProducts.length; i++){
        this.orderPrice += this.filteredProducts[i].priceProduct;
        this.taxPrice += this.filteredProducts[i].priceProduct *19 /100;
        this.totalPrice += this.filteredProducts[i].priceProduct *19 /100 + this.filteredProducts[i].priceProduct;

      }
      this.orderPrice =  Math.round(this.orderPrice *100)/100
      this.taxPrice   =  Math.round(this.taxPrice *100)/100
      this.totalPrice = Math.round(this.totalPrice *100)/100

    })
   
  }
  addOrder(){
    var order = new OrderRequest()
    order.dateOrder = moment().format("yyyy-MM-DD")
    order.totalPriceOrder = this.totalPrice
    order.priceOrder = this.orderPrice
    order.taxPriceOrder = this.taxPrice;
    order.productIds = this._service.productIds
    this._orderService.addOrder(order).subscribe((res)=>{
      this.orderAdded = true;
    })
  }

}
