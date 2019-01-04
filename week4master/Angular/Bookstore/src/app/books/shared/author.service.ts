import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { Author } from './author';
import { UrlService } from 'src/app/shared/url.service';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  private appUrl = this.urlSource.getURL()+'/authors';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient, private urlSource: UrlService) { }

  getAuthor(id: number): Observable<Author> {
    return this.http.get(this.appUrl + '/' + id, { withCredentials: true }).pipe(
      map( resp => resp as Author ));
  }
  getAuthors(): Observable<Author[]> {
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
      map( resp => resp as Author[] ));
  }
  updateAuthor(author: Author): Observable<Author> {
    const body = JSON.stringify(author);
    if(!author.id) {
      return this.http
      .post(this.appUrl, body, {headers: this.headers, withCredentials: true})
      .pipe(map(resp=>resp as Author));
    }
    const url = this.appUrl+'/'+author.id;
    return this.http
    .put(url, body, {headers: this.headers, withCredentials:true})
    .pipe(map(resp=>resp as Author));
  }
}
