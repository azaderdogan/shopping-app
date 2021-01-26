import {Injectable} from '@angular/core';
import {Category} from '../category/Category';
import {ApiService} from '../common/api.service';
import {Observable} from 'rxjs';

@Injectable()
export class CategoryService {

  constructor(private apiService: ApiService) {
  }

  private path = 'category';

  getAllCategories(): Observable<Category[]> {
    return this.apiService.get<Category[]>(this.path);
  }
}
