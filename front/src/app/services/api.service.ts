import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import { environment } from '../../environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrls = {
    userService: 'http://localhost:8082/users',
    productService:  environment.baseUrls.productService,
    historyService: 'localhost:8082/historiques',
    cartService: 'http://localhost:8084/cart'
  };

  constructor(private http: HttpClient) {
  }

  // User Service methods
  getUser(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrls.userService}/${id}`);
  }

  createUser(user: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrls.userService}`, user);
  }


  handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
  // Product Service methods
  // async getProducts(): Promise<Observable<any>> {
  //    // return this.http.get<any>(`${this.baseUrls.historyService}`);
  //    return this.http.jsonp(this.baseUrls.productService, 'callback').pipe(
  //     catchError(this.handleError('searchHeroes', [])) // then handle the error
  //   );
  //  }
  // getProducts(): Observable<any> {
  //   return this.http.jsonp<any>(`${this.baseUrls.productService}`, 'callback').pipe(
  //     catchError(this.handleError<any>('getProducts'))
  //   );
  // }
  // Product Service methods
 // async getProducts(): Promise<Observable<any>> {
 //    return this.http.jsonp(this.baseUrls.productService , 'callback').pipe(
 //      catchError(this.handleError('searchHeroes', [])) // then handle the error
 //    );
 //  }
  // Product Service methods
  getProducts(): Observable<any> {
    return this.http.jsonp<any>('http://localhost:8081/api/fleurs/fleurss', 'callback').pipe(
      catchError(this.handleError<any>('getProducts'))
    );
  }
  // Product Service methods
  getProduct(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrls.productService}/${id}`);
  }

  createProduct(product: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrls.productService}`, product);
  }

  // History Service methods
  getHistory(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrls.historyService}/${id}`);
  }

  createHistory(history: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrls.historyService}`, history);
  }

  // Cart Service methods
  addToCart(key: string, value: string): Observable<string> {
    let params = new HttpParams().set('key', key).set('value', value);
    return this.http.post<string>(`${this.baseUrls.cartService}/save`, null, {params});
  }

  getFromCart(key: string): Observable<string> {
    let params = new HttpParams().set('key', key);
    return this.http.get<string>(`${this.baseUrls.cartService}/get`, {params});
  }
}
