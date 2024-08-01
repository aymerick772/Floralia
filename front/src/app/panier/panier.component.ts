import {Component, OnInit} from '@angular/core';
import {PanierService} from "../services/panier.service";
import {PanierSummaryComponent} from "../panier-summary/panier-summary.component";
import {PanierItemComponent} from "../panier-item/panier-item.component";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-panier',
  standalone: true,
  imports: [
    CommonModule,
    PanierSummaryComponent,
    PanierItemComponent
  ],
  templateUrl: './panier.component.html',
  styleUrl: './panier.component.css'
})

export class PanierComponent implements OnInit {
  cartItems: any[] = [];
  //
  constructor(  private cartService: PanierService) {
  }

  ngOnInit() {
    this.cartItems = this.cartService.getCartItems();
  }
}
