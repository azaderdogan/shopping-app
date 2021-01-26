import {Component, OnInit} from '@angular/core';
import {Category} from './Category';
import {BASE_URL} from '../common/config';
import {ApiService} from '../common/api.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  path = BASE_URL + '/category';

  constructor(private apiService: ApiService) {
  }

  title: 'Kategori Listesi';
  categories: Category[];

  ngOnInit(): void {
    this.apiService
      .get<Category[]>(this.path)
      .subscribe(categories => this.categories = categories);
  }

}
