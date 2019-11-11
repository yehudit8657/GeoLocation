import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { GeolocationRestService } from '../geolocation-rest.service';
import { PopularSearch } from '../popular-search';


@Component({
  selector: 'app-init-form',
  templateUrl: './init-form.component.html',
  styleUrls: ['./init-form.component.css']
})
export class InitFormComponent implements OnInit {

  constructor(public geoService: GeolocationRestService) { }

  source: string;
  dest: string;
  popularSearch:PopularSearch = new PopularSearch();
  popularsSearch:PopularSearch[]=[];

  @Output() showResult: EventEmitter<PopularSearch> = new EventEmitter();
  @Output() resultList: EventEmitter<PopularSearch[]> = new EventEmitter();

  getDistance() {
    this.geoService.getDistance(this.source, this.dest).subscribe(data => {
      this.popularSearch.km = data;
      this.getPopularSearch();
      this.getPopularsSearch();
    });
  }

  getPopularSearch(){
    this.geoService.getPopularSearch().subscribe(data=>{
      //this.popularSearch=data;
      this.popularSearch.dest=data.dest;
      this.popularSearch.hits=data.hits;
      this.popularSearch.source=data.source;
      this.showResult.emit(this.popularSearch);
    });
  }
  
  getPopularsSearch(){
    this.geoService.getPopularsSearch().subscribe(data=>{
      this.popularsSearch=data;
      this.resultList.emit(this.popularsSearch);
    });
  }

  ngOnInit() {
  }

}
