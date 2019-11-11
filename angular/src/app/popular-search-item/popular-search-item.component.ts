import { Component, OnInit, Input } from '@angular/core';
import { PopularSearch } from '../popular-search';

@Component({
  selector: 'app-popular-search-item',
  templateUrl: './popular-search-item.component.html',
  styleUrls: ['./popular-search-item.component.css']
})
export class PopularSearchItemComponent implements OnInit {
  constructor() { }

  @Input()
  item:PopularSearch=new PopularSearch();

  ngOnInit() {
  }

}
