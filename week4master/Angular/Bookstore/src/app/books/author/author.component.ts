import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { Author } from '../shared/author';
import { UserService } from 'src/app/shared/user/user.service';
import { AuthorService } from '../shared/author.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  @Input() openAuthor: Author;
  @Output() submitted = new EventEmitter<boolean>();
  constructor(private userService: UserService,
    private authorService: AuthorService
    ) { }

  ngOnInit() {
    if(!this.openAuthor){
      this.openAuthor=new Author();
    }
  }
  updateAuthor(): void {
    this.authorService.updateAuthor(this.openAuthor).subscribe(
      author=>{
        this.openAuthor=author;
        this.submitted.emit(true);
      }
    )
  }
  isEmployee(): boolean {
    return this.userService.isEmployee();
  }
}
