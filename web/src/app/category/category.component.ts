import {Component, OnInit} from '@angular/core';
import {Category} from './Category';
import {BASE_URL} from '../common/config';
import {ApiService} from '../common/api.service';
import {CategoryService} from '../services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
  providers: [CategoryService]
})
export class CategoryComponent implements OnInit {

  constructor(private categoryService: CategoryService) {
  }

  title: 'Kategori Listesi';
  categories: Category[];

  ngOnInit(): void {
    this.categoryService
      .getAllCategories()
      .subscribe(categorySnapshot => this.categories = categorySnapshot);
  }

}
