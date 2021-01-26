import {Injectable} from '@angular/core';
import {ApiService} from '../common/api.service';
import {Product} from '../product/product';
import {Observable} from 'rxjs';

@Injectable()
export class ProductService {

  constructor(private apiService: ApiService) {
  }

  private path = 'products';
  private byCategoryId = this.path+'/category/';

  getAllProduct(): Observable<Product[]> {
    return this.apiService.get<Product[]>(this.path);
  }
  getProductsByCategoryId(categoryId:string): Observable<Product[]> {
    return this.apiService.get<Product[]>(this.byCategoryId+categoryId);
  }
}
