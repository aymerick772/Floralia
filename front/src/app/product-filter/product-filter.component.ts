import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-filter',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-filter.component.html',
  styleUrls: ['./product-filter.component.css']
})
export class ProductFilterComponent implements OnInit {
  categories: string[] = []; // Liste des catégories à afficher dans le menu déroulant
  @Output() categorySelected = new EventEmitter<string>(); // Événement pour émettre la catégorie sélectionnée

  ngOnInit() {
    // Initialisation des catégories (remplacez cela par un appel de service si nécessaire)
    this.categories = ['Electronics', 'Books', 'Clothing', 'Home', 'Toys'];
  }

  // Fonction appelée lorsque la catégorie est changée
  filterByCategory(selectedCategory: string) {
    this.categorySelected.emit(selectedCategory); // Émet la catégorie sélectionnée
  }
}
