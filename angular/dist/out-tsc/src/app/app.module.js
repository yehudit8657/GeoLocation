import * as tslib_1 from "tslib";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { PopularSearchItemComponent } from './popular-search-item/popular-search-item.component';
import { ResultComponent } from './result/result.component';
import { FormsModule } from '@angular/forms';
import { InitFormComponent } from './init-form/init-form.component';
import { TestComponent } from './test/test.component';
let AppModule = class AppModule {
};
AppModule = tslib_1.__decorate([
    NgModule({
        declarations: [
            AppComponent,
            PopularSearchItemComponent,
            ResultComponent,
            InitFormComponent,
            TestComponent
        ],
        imports: [
            FormsModule,
            BrowserModule,
            AppRoutingModule,
            HttpClientModule
        ],
        providers: [],
        bootstrap: [AppComponent]
    })
], AppModule);
export { AppModule };
//# sourceMappingURL=app.module.js.map