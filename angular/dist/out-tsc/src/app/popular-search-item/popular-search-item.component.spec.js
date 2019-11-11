import { async, TestBed } from '@angular/core/testing';
import { PopularSearchItemComponent } from './popular-search-item.component';
describe('PopularSearchItemComponent', () => {
    let component;
    let fixture;
    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [PopularSearchItemComponent]
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
//# sourceMappingURL=popular-search-item.component.spec.js.map