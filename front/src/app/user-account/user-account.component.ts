import { Component } from '@angular/core';
import {UserProfileComponent} from "../user-profile/user-profile.component";
import {OrderHistoryComponent} from "../order-history/order-history.component";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-user-account',
  standalone: true,
  imports: [
    UserProfileComponent,
    OrderHistoryComponent,
    CommonModule
  ],
  templateUrl: './user-account.component.html',
  styleUrl: './user-account.component.css'
})
export class UserAccountComponent {

}
