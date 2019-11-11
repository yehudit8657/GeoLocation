import { Component, OnInit } from '@angular/core';
import { PopularSearch } from './popular-search';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  popularSearch:PopularSearch;
  showResult:boolean = false;
  popularsSearch:PopularSearch[];

  ngOnInit() { }

  showResultFunc(result:PopularSearch){
    this.popularSearch = result;
    this.showResult = !this.showResult;
  }
  getResultList(result:PopularSearch[]){
    this.popularsSearch=result;
  }
}
