import { TestBed } from '@angular/core/testing';

import { ApiForProductService } from './api-for-product.service';

describe('ApiForProductService', () => {
  let service: ApiForProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiForProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
