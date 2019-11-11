import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
let AppComponent = class AppComponent {
    constructor() {
        this.popular = [
            { source: 'aaa', dest: 'bbb', hits: 1 },
            { source: 'ccc', dest: 'ddd', hits: 1 },
            { source: 'eee', dest: 'fff', hits: 1 },
            { source: 'ggg', dest: 'hhh', hits: 1 },
            { source: 'iii', dest: 'jjj', hits: 1 }
        ];
        this.showResult = false;
    }
    ngOnInit() { }
    showResultFunc(result) {
        this.showResult = result;
    }
};
AppComponent = tslib_1.__decorate([
    Component({
        selector: 'app-root',
        templateUrl: './app.component.html',
        styleUrls: ['./app.component.css']
    })
], AppComponent);
export { AppComponent };
//# sourceMappingURL=app.component.js.map