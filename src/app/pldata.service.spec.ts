import { TestBed } from '@angular/core/testing';

import { PLdataService } from './pldata.service';

describe('PLdataService', () => {
  let service: PLdataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PLdataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
