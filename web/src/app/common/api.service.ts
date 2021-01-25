import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

//root global etiketi verir.
/**
 * Dependency ınjection @Injectable
 * Bu da proje ayağa kalktığı zaman instantance oluşur
 */
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private  http: HttpClient) {
  }


  get<T>(path = '') {
    return this.http.get<T>(path);
  }

  post(path = '', paramsData) {
    this.http.post(path, paramsData);
  }

}
