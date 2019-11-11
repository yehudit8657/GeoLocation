import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopularSearchItemComponent } from './popular-search-item.component';

describe('PopularSearchItemComponent', () => {
  let component: PopularSearchItemComponent;
  let fixture: ComponentFixture<PopularSearchItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopularSearchItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopularSearchItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
