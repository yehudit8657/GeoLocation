import { TestBed } from '@angular/core/testing';

import { GeolocationRestService } from './geolocation-rest.service';

describe('GeolocationRestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GeolocationRestService = TestBed.get(GeolocationRestService);
    expect(service).toBeTruthy();
  });
});
