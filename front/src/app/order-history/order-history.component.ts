import { Component } from '@angular/core';
import {CurrencyPipe, NgForOf} from "@angular/common";

interface Order {
  id: number;
  total: number;
}

@Component({
  selector: 'app-order-history',
  standalone: true,
  imports: [
    CurrencyPipe,
    NgForOf
  ],
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent {
  orders: Order[] = [
    { id: 1, total: 100 },
    { id: 2, total: 150 },
    { id: 3, total: 200 },
  ];
}
