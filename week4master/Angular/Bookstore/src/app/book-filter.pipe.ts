import { Pipe, PipeTransform } from '@angular/core';
import { Book } from './books/shared/book'

@Pipe({
  name: 'bookFilter'
})
export class BookFilterPipe implements PipeTransform {

  transform(items: Book[], searchText: string): Book[] {
    if(!items) {
      return [];
    }
    searchText=searchText.toLowerCase();
    return items.filter(
      book=> {
        const searchNumber: number = +searchText;
        let search: boolean;
        search = book.title.toLowerCase().includes(searchText)
        || book.price === searchNumber
        || book.stock === searchNumber
        || book.isbn10.includes(searchText);
        if(book.isbn13) {
          search = search || book.isbn13.includes(searchText);
        }
        for(let i = 0; i< book.authors.length; i++) {
          search = search || book.authors[i].first.toLowerCase().includes(searchText)||
          book.authors[i].last.toLowerCase().includes(searchText);
        }
        for(let i = 0; i< book.genres.length; i++) {
          search = search || book.genres[i].genre.toLowerCase().includes(searchText);
        }
        return search;
      });
  }

}
