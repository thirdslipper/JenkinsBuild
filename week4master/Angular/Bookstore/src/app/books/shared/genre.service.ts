import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from 'src/app/shared/url.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Genre } from './genre';

@Injectable({
  providedIn: 'root'
})
export class GenreService {private appUrl = this.urlService.getURL() + '/genres';
private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

constructor(
  private http: HttpClient,
  private urlService: UrlService
) { }

getgenres(): Observable<Genre[]> {
  return this.http.get(this.appUrl, { withCredentials: true })
    .pipe(map(
      resp => resp as Genre[]
    ));
}

getGenre(id: number): Observable<Genre> {
  return this.http.get(this.appUrl + '/' + id, { withCredentials: true })
    .pipe(map(
      resp => resp as Genre
    ));
}

updategenre(genre: Genre): Observable<Genre> {
  const body = JSON.stringify(genre);
  console.log(body);
  if (!genre.id) {
    console.log('creating genre');
    return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true })
      .pipe(map(
        resp => resp as Genre
      ));
  }
  const url = this.appUrl + '/' + genre.id;
  return this.http.put(url, body, { headers: this.headers, withCredentials: true })
    .pipe(map(
      resp => resp as Genre
    ));
}
}
