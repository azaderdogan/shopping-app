import { Injectable } from '@angular/core';

/**
 * global değilde service özel oluşturulmak istenirse;
 * ilgili classın @Component içinde @Providers içerisinde belirtilir.
 * ona ait bir instance oluşturur.
 */
@Injectable()
export class ApiForProductService {

  constructor() { }
}
