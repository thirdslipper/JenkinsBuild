import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  title = 'My Bookstore';
  constructor(public route: Router) { }

  ngOnInit() {  }
  isEmployee(): boolean {
    return true;
  }
  isCustomer(): boolean {
    return true;
  }

}
