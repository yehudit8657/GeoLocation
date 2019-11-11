import * as tslib_1 from "tslib";
import { Component, Input } from '@angular/core';
import { PopularSearch } from '../popular-search';
let PopularSearchItemComponent = class PopularSearchItemComponent {
    constructor() {
        this.item = new PopularSearch();
    }
    ngOnInit() {
    }
};
tslib_1.__decorate([
    Input()
], PopularSearchItemComponent.prototype, "item", void 0);
PopularSearchItemComponent = tslib_1.__decorate([
    Component({
        selector: 'app-popular-search-item',
        templateUrl: './popular-search-item.component.html',
        styleUrls: ['./popular-search-item.component.css']
    })
], PopularSearchItemComponent);
export { PopularSearchItemComponent };
//# sourceMappingURL=popular-search-item.component.js.map