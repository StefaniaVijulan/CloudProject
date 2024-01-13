import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './page/login/login.component';
import { RegisterComponent } from './page/register/register.component';
import { ProductComponent } from './page/product/product/product.component';
import { CategoryFormsComponent } from './page/product/category-forms/category-forms.component';
import { ProductFormsComponent } from './page/product/product-forms/product-forms.component';
import { EditProductComponent } from './page/product/edit-product/edit-product.component';
import { ProductService } from './service/product.service';
import { OrderComponent } from './page/order/order/order.component';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './page/profile/profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProductComponent,
    CategoryFormsComponent,
    ProductFormsComponent,
    EditProductComponent,
    OrderComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
