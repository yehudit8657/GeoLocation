import { Component, OnInit } from '@angular/core';
import { GeolocationRestService } from '../geolocation-rest.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  constructor(public geo:GeolocationRestService) { }

  locationGivens:any[];
  locationGivensStrinify:String;

  ngOnInit() {
    this.geo.getTest().subscribe(s=> {this.locationGivens = s;
    this.locationGivensStrinify = JSON.stringify(this.locationGivens);
    });
  }

}
