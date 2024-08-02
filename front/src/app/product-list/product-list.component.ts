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
  styleUrls: ['./product-list.component.css']
})

export class ProductListComponent implements OnInit {
  product: any[] = [];
  products: Observable<any> = of([]);
  //
  constructor(private apiService: ApiService, private productService: ProductService) { }
  //
  async ngOnInit() {
    // this.products = this.apiService.getProducts();
    this.product = this.productService.getProducts();

    try {
      const data = await this.apiService.getProducts().toPromise();
      this.products = of(data);
    } catch (error) {
      console.error('Erreur lors de la récupération des produits', error);
    }
    // Afficher les valeurs dans products$ avec subscribe
    this.products.subscribe(
      products => console.log('Products$: ' + JSON.stringify(products, null, 2)),
      error => console.log('Error fetching products$: ' + JSON.stringify(error, null, 2))
    );
  }


  // async ngOnInit() {
  //   // this.products$ = this.apiService.getProducts();
  //   // this.products$.subscribe((
  //   //   data => console.log('Produits récupérés :', data),
  //   //     error => console.error('Erreur lors de la récupération des produits :', error)
  //   // ));
  //   try {
  //     const data = await this.apiService.getProducts().toPromise();
  //
  //     this.products = data.fleurs;
  //
  //     console.log( JSON.stringify(this.products, null, 2));
  //   } catch (error) {
  //     console.error('Error fetching products$: ' + JSON.stringify(error, null, 2));
  //   }
  // }

}
