import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserLogin } from 'src/app/model/user/user-login';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  userLogin = new UserLogin()
  message = '';
  constructor(private _service : AuthService, private _router : Router) { }

  ngOnInit(): void {
  }

  loginUser(){
    this._service.loginUserFromRemote(this.userLogin).subscribe(
      data => {
        console.log("Response was received");
        localStorage.setItem('login', "true")
        this._router.navigate(['/dashboard'])
      },
      error => {
        console.log("Exception has occured");
        this.message="Wrong email or password, please Retry!";
    }     
    )
  }
}
