import { Component, OnInit } from '@angular/core';
import { Purchase } from '../purchase/shared/purchase';
import { Book } from '../books/shared/book';
import { BookService } from '../books/shared/book.service';
import { PurchaseService } from '../purchase/shared/purchase.service';
import { UserService } from '../shared/user/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public books: Book[];
  private purchases: Purchase[];

  width = 600;
  height = 400;
  type = 'column2d';
  dataFormat = 'json';

  constructor(
    private bookService: BookService,
    private purchaseService: PurchaseService,
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {
    this.bookService.getBooks().subscribe(resp => this.books = resp);
    this.purchaseService.getPurchases().subscribe(resp => this.purchases = resp);
  }
  isEmployee(): boolean {
    return this.userService.isEmployee();
  }
  totalSales(): number {
    let total = 0;
    if (this.purchases) {
      this.purchases.forEach(purch=> {
        if(purch.status!== 'OPEN') {
          total+=purch.total;
        }
      });
    }
    return total;
  }
  numSales(): number {
    let total = 0;
    if (this.purchases) {
      this.purchases.forEach(purch => {
        if (purch.status !== 'OPEN') {
          total += 1;
        }
      });
    }
    return total;
  }
  goToBook(b: Book): void {
    this.router.navigate(['/books/', b.id]);
  }
  getBookDataSource(): any {
    const dataSource = {
      'chart': {
        'caption': 'Book Stock',
        'subCaption': 'Stock of each book',
        'numberPrefix': '',
        'theme': 'ocean'
      },
      'data': null
    };
    dataSource.data = this.getBookData();
    return dataSource;
  }
  getBookData(): any[] {
    const data = [];
    if (!this.books) {
      return data;
    }
    this.books.forEach(b => {
      data.push({
        'label': b.title,
        'value': b.stock
      });
    });
    return data;
  }
  getPurchaseDataSource(): any {
    const dataSource = {
      'chart': {
        'caption': 'Purchases',
        'subCaption': 'Money per Purchase',
        'numberPrefix': '',
        'theme': 'ocean'
      },
      'data': null
    };
    dataSource.data = this.getPurchaseData();
    return dataSource;
  }
  getPurchaseData(): any[] {
    const data = [];
    if (!this.purchases) {
      return data;
    }
    this.purchases.forEach(p => {
      data.push({
        'label': 'P' + p.id,
        'value': p.total
      });
    });
    return data;
  }
  
}
