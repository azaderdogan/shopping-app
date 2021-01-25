import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {tap, catchError} from 'rxjs/operators';

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


  get<T>(path = ''): Observable<T> {
    /**
     * pipe isteğe bağlıdır. pipe sayesinde reactive programladık.
     *
     */
    return this.http.get<T>(path).pipe(
      tap(data => console.log(JSON.stringify(data))),
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
