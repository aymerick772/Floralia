import { Injectable } from '@angular/core';

interface Product {
  name: string;
  // Ajoutez d'autres propriétés du produit ici
}

interface CartItem {
  product: Product;
  quantity: number;
}

@Injectable({
  providedIn: 'root'
})

// Définir une interface pour les produits

export class PanierService {

  constructor() { }

  // Définir le type du tableau cartItems
   cartItems: CartItem[] = [];

  getCartItems() {
    return this.cartItems;
  }

  addToCart(product: Product) {
    let item = this.cartItems.find(i => i.product.name === product.name);

    if (item) {
      item.quantity++;
    } else {
      this.cartItems.push({ product, quantity: 1 });
    }
  }

  removeFromCart(item: CartItem) {
    const index = this.cartItems.indexOf(item);
    if (index > -1) {
      this.cartItems.splice(index, 1);
    }
  }
}
