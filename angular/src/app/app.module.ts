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

@NgModule({
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
export class AppModule { }
