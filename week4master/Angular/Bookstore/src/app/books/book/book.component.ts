import { Component, OnInit, Input } from '@angular/core';
import { BookService } from '../shared/book.service';
import { AuthorService } from '../shared/author.service';
import { GenreService } from '../shared/genre.service';
import { Book } from '../shared/book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']/*,
  providers: [BookService]*/
})
export class BookComponent implements OnInit {
  @Input() openBook: Book;
  constructor(
    private bookService: BookService,
    private authorService: AuthorService,
    private genreService: GenreService
    ) { }

  ngOnInit() {

  }
  isCustomer(): boolean {
    //todo: check to see if the user is a customer
    return true;
  }
  isEmployee(): boolean{
    //todo: check to see if the user is an employee
    return true;
  }
  addToCart(){
    // toDo: add book to purchase, retrieve purchase from db
  }
  editBook(){
    // todo: edit the book
  }
}
