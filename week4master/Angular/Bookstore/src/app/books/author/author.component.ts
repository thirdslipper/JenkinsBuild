import { Component, OnInit, Input} from '@angular/core';
import { Author } from '../shared/author';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  @Input() openAuthor: Author;
  constructor() { }

  ngOnInit() {
  }

}
