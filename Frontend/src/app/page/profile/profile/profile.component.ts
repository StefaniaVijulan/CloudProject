import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  user: any;
  orderList: any;
  constructor(private _service: AuthService,private _router: Router) {
    this._service.getUser().subscribe((res)=>{
      this.user = res;
    })
    this._service.getUserOrders().subscribe((res1)=>{
      this.orderList = res1
    })
   }
}
