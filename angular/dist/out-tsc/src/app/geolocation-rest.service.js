import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
let GeolocationRestService = class GeolocationRestService {
    constructor(http) {
        this.http = http;
        this.baseUrl = 'http://localhost:8080';
    }
    getDistance(source, dest) {
        const url = `${this.baseUrl}/getDistance/${source}/${dest}`;
        return this.http.get(url);
    }
    // getPopularSearch():Observable<PopularSearch>{
    //   const url = `${this.baseUrl}/geoLocation/webresources/distance/popularSearch'`;
    //        return this.http.get<PopularSearch>(url);
    // }
    // getPopularsSearch():Observable<PopularSearch[]>{
    //   const url = `${this.baseUrl}`;
    //        return this.http.get<PopularSearch[]>(url);
    // }
    getTest() {
        const url = `${this.baseUrl}/Test`;
        return this.http.get(url);
    }
    addAddress(source, dest) {
        const url = encodeURI(`${this.baseUrl}/addAdress`);
        return this.http.post(url, [{ 'addressGiven': source }, { 'addressGiven': dest }]);
    }
};
GeolocationRestService = tslib_1.__decorate([
    Injectable({
        providedIn: 'root'
    })
], GeolocationRestService);
export { GeolocationRestService };
//# sourceMappingURL=geolocation-rest.service.js.map