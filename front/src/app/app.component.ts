import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ProductListComponent} from "./product-list/product-list.component";
import {UserAccountComponent} from "./user-account/user-account.component";
import {PanierComponent} from "./panier/panier.component";
import {CommonModule} from "@angular/common";



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ProductListComponent, UserAccountComponent, PanierComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front';
}
