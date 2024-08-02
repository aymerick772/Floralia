import {Component, OnInit} from '@angular/core';
import {ProductFilterComponent} from "../product-filter/product-filter.component";
import {ProductItemComponent} from "../product-item/product-item.component";
import {ProductService} from "../services/product.service";
import {CommonModule} from "@angular/common";
import {ApiService} from "../services/api.service";
import {Observable, of} from "rxjs";

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [
    ProductFilterComponent,
    ProductItemComponent,
    CommonModule
  ],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})

export class ProductListComponent implements OnInit {
  products: any[] = [];
  products$: Observable<any[]> =new Observable<any[]>();
  //
  constructor(private apiService: ApiService, private productService: ProductService) { }
  //
  async ngOnInit() {
    this.products = this.productService.getProducts();

    this.products$ = await this.apiService.getProducts();
    // Afficher les valeurs dans products$ avec subscribe
    this.products$.subscribe(
      products => alert('Products$: ' + JSON.stringify(products, null, 2)),
      error => console.log('Error fetching products$: ' + JSON.stringify(error, null, 2))
    );
  }
}
