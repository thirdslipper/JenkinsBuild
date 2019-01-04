import { Component, OnInit, Input } from '@angular/core';
import { BookService } from '../shared/book.service';
import { AuthorService } from '../shared/author.service';
import { GenreService } from '../shared/genre.service';
import { Book } from '../shared/book';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/shared/user/user.service';
import { PurchaseService } from 'src/app/purchase/shared/purchase.service';

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
    private genreService: GenreService,
    private userService: UserService,
    private purchaseService: PurchaseService,
    private router: Router,
    private route: ActivatedRoute
    ) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    if(id) {
      this.bookService.getBook(id).subscribe(book=>this.openBook=book);
    }

  }
  isCustomer(): boolean {
    return this.userService.isCustomer();
  }
  isEmployee(): boolean{
    return this.userService.isEmployee();
  }
  addToCart(){
    this.purchaseService.createPurchase().subscribe(
      purch => {
        // once the purchase is returned.
        // we need to add a book to it.
        this.purchaseService.addBook(purch, this.openBook)
          .subscribe(updatedPurchase => {
            //once this is done. we navigate to our purchase
            this.router.navigate(['/purch',updatedPurchase.id]);
          })
      }
    )
  }
  editBook(){
    this.router.navigate(['/books/edit',this.openBook.id]);
  }
}
