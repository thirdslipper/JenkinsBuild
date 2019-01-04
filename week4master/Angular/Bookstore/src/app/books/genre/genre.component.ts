import { Component, OnInit } from '@angular/core';
import { Genre } from '../shared/genre';
import { GenreService } from '../shared/genre.service';

@Component({
  selector: 'app-genre',
  templateUrl: './genre.component.html',
  styleUrls: ['./genre.component.css']
})
export class GenreComponent implements OnInit {
  genres: Genre[];
  genre: Genre;
  constructor(private genreService: GenreService) { }

  ngOnInit() {
    this.genreService.getgenres().subscribe(genres => this.genres=genres);
    this.genre = new Genre();
  }
  submit(){
    this.genreService.updategenre(this.genre).subscribe(
      genre => {
        this.genre=new Genre();
        this.genres.push(genre);
      }
    )
  }

}
