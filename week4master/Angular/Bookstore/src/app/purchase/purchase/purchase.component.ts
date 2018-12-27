import { Component, OnInit, Input } from '@angular/core';
import { PurchaseService } from '../shared/purchase.service';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { Purchase } from '../shared/purchase';
import { Customer } from '../../shared/user/customer';
import { Book } from '../../books/shared/book';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit { 
  @Input() openPurchase: Purchase;

  constructor(
    private purchaseService: PurchaseService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    if (!this.openPurchase) {
      this.openPurchase = new Purchase();
      this.openPurchase.cust = new Customer();
    }
    const id = +this.route.snapshot.paramMap.get('id');
    if (id) {
      console.log(+id);
      this.purchaseService.getPurchase(id).subscribe(purch => this.openPurchase=purch);     
    }
  }
  add(book: Book): void {
    this.purchaseService.addBook(this.openPurchase, book)
    .subscribe(purch => this.openPurchase = purch);
  }
  sub(book: Book): void {
    this.purchaseService.subBook(this.openPurchase, book)
    .subscribe(purch => this.openPurchase = purch);
  }

  purchase(): void {
    this.openPurchase.status = 'CLOSED';
    this.purchaseService.updatePurchase(this.openPurchase)
    .subscribe(p => this.openPurchase = p);
  }
  isOpen(): boolean {
    return this.openPurchase.status === 'OPEN';
  }
  emptyCart(): void {
    this.purchaseService.emptyCart(this.openPurchase)
    .subscribe(p => this.router.navigate(['/books']));
  }
}
