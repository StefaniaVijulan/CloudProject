import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRequest } from 'src/app/model/user/user-request';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  public myForm!:FormGroup;
  constructor(private _service: AuthService,private _router: Router, private formBuilder:FormBuilder) { }
  userRequest = new UserRequest();
  msg='';
  ngOnInit(): void {
    this.myForm = this.formBuilder.group({
      firstNameUser:["", Validators.required],
      lastNameUser:["", Validators.required],
      emailUser:["",[Validators.required, Validators.email]],
      usernameUser:["", Validators.required],
      passwordUser:["", [Validators.required, Validators.minLength(5)]],
      addressUser:["", Validators.required],
    })
  }
  register(){
    console.log(this.userRequest)
    this._service.registerUserFromRemote(this.userRequest).subscribe(
      data =>{
        console.log("response recive");
        localStorage.setItem('token', JSON.stringify(data))
        this.msg="Register successful";
        this._router.navigate(['/login']);
      },
      error =>{
        console.log(error)
        console.log("exception occured");
        this.msg = error.error;
      }
      
    )
  }
}
