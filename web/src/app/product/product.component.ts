import {Component, OnInit} from '@angular/core';
import {Product} from './product';
import {HttpClient} from '@angular/common/http';
import {BASE_URL} from '../common/config';
import {ApiService} from '../common/api.service';
import {ApiForProductService} from '../services/api-for-product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  providers:[ApiForProductService]
})
export class ProductComponent implements OnInit {
//binding işlemi [] ile yapılır


  constructor(private http: HttpClient, private apiService: ApiService) {
  }

  filterText = '';
  products: Product[];
  title = 'Ürün Listesi';
  path = BASE_URL + '/products';

  ngOnInit(): void {
    this.apiService.get<Product[]>(this.path).subscribe(data => {
      this.products = data;
    });
  }

  addToCart(product: Product) {
//event binding
    console.log(product.description, ' Sepete Eklendi.');
  }
}
