import { Injectable } from '@angular/core';
import { UserLogin } from '../model/user/user-login';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserRequest } from '../model/user/user-request';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private _http: HttpClient, private _router: Router) {  }

  public loginUserFromRemote(user: UserLogin):Observable<any>{
      return this._http.post<any>("http://localhost:8070/user/login", user)
  }
  public registerUserFromRemote(user: UserRequest):Observable<any>{
    console.log(user)
    return this._http.post<any>("http://localhost:8070/user/register", user)
  }

  //double negate because we want a boolean value
  loggedIn(){
    return !!localStorage.getItem('login')
  }

  logoutUser(){
    localStorage.removeItem('login')
    this._router.navigate(['/login'])
  }

  getToken(){
    return localStorage.getItem('login')
  }
}
