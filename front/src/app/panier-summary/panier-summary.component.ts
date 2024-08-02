import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-panier-summary',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './panier-summary.component.html',
  styleUrls: ['./panier-summary.component.css']
})
export class PanierSummaryComponent {
  @Input() items: any[] = []; // Utilisation de @Input pour recevoir les données

  constructor() { } // Pas besoin d'injection ici

  getTotalItems(): number {
    return this.items.reduce((total, item) => total + item.quantity, 0);
  }

  getTotalPrice(): number {
    return this.items.reduce((total, item) => total + (item.quantity * item.product.id), 0);
  }
}
