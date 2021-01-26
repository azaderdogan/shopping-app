import {Component, OnInit} from '@angular/core';
import {Product} from './product';
import {ProductService} from '../services/product.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  providers: [ProductService]
})
export class ProductComponent implements OnInit {
//binding işlemi [] ile yapılır

  /**
   * routerlarda id yakalamak için activatedRoute modulunu import ediyoruz
   * @param productService
   */
  constructor(
    private productService: ProductService,
    private activatedRoute: ActivatedRoute
  ) { }

  filterText = '';
  products: Product[];
  title = 'Ürün Listesi';


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
  categoryId:string;
  ngOnInit(): void {

    this.activatedRoute.params.subscribe(params =>{this.categoryId = params["categoryId"]});
    this.productService
      .getAllProduct()
      .subscribe(snapshot => this.products = snapshot);
    console.log(this.categoryId)
  //  this.productService.getProductsByCategoryId(this.categoryId).subscribe(data => this.products = data);
  }

  async addToCart(product: Product) {
//event binding
    console.log(product.description, ' Sepete Eklendi.');
  }
}
