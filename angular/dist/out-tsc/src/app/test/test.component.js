import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
let TestComponent = class TestComponent {
    constructor(geo) {
        this.geo = geo;
    }
    ngOnInit() {
        this.geo.getTest().subscribe(s => {
            this.locationGivens = s;
            this.locationGivensStrinify = JSON.stringify(this.locationGivens);
        });
    }
};
TestComponent = tslib_1.__decorate([
    Component({
        selector: 'app-test',
        templateUrl: './test.component.html',
        styleUrls: ['./test.component.css']
    })
], TestComponent);
export { TestComponent };
//# sourceMappingURL=test.component.js.map