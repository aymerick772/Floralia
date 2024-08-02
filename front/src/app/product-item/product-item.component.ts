import {Component, Input} from '@angular/core';
import {CommonModule} from "@angular/common";
import {PanierService} from "../services/panier.service";
import {ApiService} from "../services/api.service";

@Component({
  selector: 'app-product-item',
  standalone: true,
  imports: [CommonModule,],

  templateUrl: './product-item.component.html',
  styleUrl: './product-item.component.css'
})
export class ProductItemComponent {
  @Input() product: any;
  constructor(private panierService: PanierService, private apiService: ApiService) { }
  addToCart(product: any) {
    // Ajoutez ici la logique pour ajouter le produit au panier
    this.panierService.addToCart(product);
  }
}
