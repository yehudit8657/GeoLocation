import * as tslib_1 from "tslib";
import { Component, Output, EventEmitter } from '@angular/core';
import { InitFormComponent } from '../init-form/init-form.component';
let ResultComponent = class ResultComponent {
    constructor(geoService) {
        this.geoService = geoService;
        this.initForm = new InitFormComponent(this.geoService);
        this.hideResult = new EventEmitter();
    }
    ngOnInit() {
    }
    hide() {
        this.hideResult.emit(false);
    }
};
tslib_1.__decorate([
    Output()
], ResultComponent.prototype, "hideResult", void 0);
ResultComponent = tslib_1.__decorate([
    Component({
        selector: 'app-result',
        templateUrl: './result.component.html',
        styleUrls: ['./result.component.css']
    })
], ResultComponent);
export { ResultComponent };
//# sourceMappingURL=result.component.js.map