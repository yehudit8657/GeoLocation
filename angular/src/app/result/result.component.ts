import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { InitFormComponent } from '../init-form/init-form.component';
import { GeolocationRestService } from '../geolocation-rest.service';
import { PopularSearch } from '../popular-search';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  
  constructor() { }

  @Input()
  popularSearch:PopularSearch;

  @Input()
  popularsSearch: PopularSearch[];
  
  @Output() 
  hideResult: EventEmitter<boolean> = new EventEmitter();

  ngOnInit() {
  }

  hide(){
    this.hideResult.emit(false);
  }

}
