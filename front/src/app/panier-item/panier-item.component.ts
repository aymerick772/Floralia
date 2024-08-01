import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-panier-item',
  standalone: true,
  imports: [CommonModule,],
  templateUrl: './panier-item.component.html',
  styleUrl: './panier-item.component.css'
})
export class PanierItemComponent {
  @Input() item: any;
  @Output() remove = new EventEmitter<any>();

  removeFromCart(item: any) {
    this.remove.emit(this.item);
  }
}
