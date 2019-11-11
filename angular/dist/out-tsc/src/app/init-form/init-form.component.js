import * as tslib_1 from "tslib";
import { Component, Output, EventEmitter } from '@angular/core';
let InitFormComponent = class InitFormComponent {
    constructor(geoService) {
        this.geoService = geoService;
        this.popularSearch = { source: "ירושלים", dest: "תל אביב", hits: 25 };
        this.showResult = new EventEmitter();
    }
    addAddress() {
        this.geoService.addAddress(this.source, this.dest).subscribe(s => s);
    }
    getDistance() {
        this.showResult.emit(true);
        this.geoService.addAddress(this.source, this.dest).subscribe(data => {
            this.km = data;
        });
        // this.getPopularSearch();
    }
    // getPopularSearch(){
    //   this.geoService.getPopularSearch().subscribe(data=>{
    //     this.popularSearch=data;
    //   });
    // }
    // getPopularsSearch(){
    //   this.geoService.getPopularsSearch().subscribe(data=>{
    //     this.popularsSearch=data;
    //   });
    // }
    ngOnInit() {
    }
};
tslib_1.__decorate([
    Output()
], InitFormComponent.prototype, "showResult", void 0);
InitFormComponent = tslib_1.__decorate([
    Component({
        selector: 'app-init-form',
        templateUrl: './init-form.component.html',
        styleUrls: ['./init-form.component.css']
    })
], InitFormComponent);
export { InitFormComponent };
//# sourceMappingURL=init-form.component.js.map