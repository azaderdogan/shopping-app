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

  /**
   * PİPE İÇERİSİNE YAPACAĞIMIZ İŞLEMLER SUBSCRİBE OLMAYI ENGELLEMİYOR.
   * RXjs sayesinde oluyor
   * RxJS, olay ve veri kaynaklarını abone olunabilir
   * (subscribable) nesnelere dönüştürüp,
   * bunlar üzerinde operatörler yardımıyla dönüşümler gerçekleştirebildiğiniz,
   * gözlemleyenler (observer) aracılığıyla sonucu
   * tüketebildiğiniz JavaScript'le yazılmış bir
   * reaktif programlama (reactive programming) kütüphanesidir.
   */
  ngOnInit(): void {
    this.apiService.get<Product[]>(this.path).pipe().subscribe(data => {
      this.products = data;
    });
  }

 async addToCart(product: Product) {
//event binding
    console.log(product.description, ' Sepete Eklendi.');
  }
}
