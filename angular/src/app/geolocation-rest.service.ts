import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Distance } from './distance';
import { PopularSearch } from './popular-search';

@Injectable({
  providedIn: 'root'
})
export class GeolocationRestService {

  constructor(public http:HttpClient) { }


  baseUrl = 'http://localhost:8081';

  getDistance(source:String, dest:String): Observable<any> {
    const url = `${this.baseUrl}/getDistance/${source}/${dest}`;
         return this.http.get<any>(url);
  }
  getPopularSearch():Observable<PopularSearch>{
    const url = `${this.baseUrl}/getPopularSearch`;
         return this.http.get<PopularSearch>(url);
  }
  getPopularsSearch():Observable<PopularSearch[]>{
    const url = `${this.baseUrl}/getPopularSearchList`;
         return this.http.get<PopularSearch[]>(url);
  }
  getTest():Observable<any> {
    const url = `${this.baseUrl}/Test`;
    return this.http.get<any[]>(url);
  }

  addAddress(source:String, dest:String):Observable<any>{
    const url = encodeURI(`${this.baseUrl}/addAdress`);
    return this.http.post(url,[{'addressGiven':source},{'addressGiven':dest}]);
  }
}
