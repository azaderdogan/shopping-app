import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {tap, catchError} from 'rxjs/operators';
import {BASE_URL} from './config';

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

  baseUrl = BASE_URL;

  /**
   * pipe isteğe bağlıdır. pipe sayesinde reactive programladık.
   *
   */
  get<T>(path = ''): Observable<T> {
console.log(this.baseUrl + path)
    return this.http.get<T>(this.baseUrl + path).pipe(
      // tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError),
    );
  }

  post(path = '', paramsData) {
    this.http.post(path, paramsData);
  }

  private handleError(err: HttpErrorResponse) {
    let errorMessage = '';
    //eğer hata bir hata eventi ise
    if (err.error instanceof ErrorEvent) {
      errorMessage = 'Bir hata oluştu : ' + err.error.message;
    } else {
      errorMessage = 'Sistemsel bir hata' + err.message;
    }
    return throwError(errorMessage);
  }
}
