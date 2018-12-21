import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BookShelfComponent } from 'src/app/books/book-shelf/book-shelf.component';
import { AuthorListComponent } from 'src/app/books/author-list/author-list.component';
import { EditBookComponent } from 'src/app/books/edit-book/edit-book.component';
import { BookComponent } from 'src/app/books/book/book.component';
import { GenreComponent } from 'src/app/books/genre/genre.component';

const routes=[
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: BookShelfComponent
  },
  {
    path: 'books/edit/:id',
    component: EditBookComponent
  },
  {
    path: 'books/edit',
    component: EditBookComponent
  },
  {
    path: 'books/:id',
    component: BookComponent
  },
  {
    path: 'books',
    component: BookShelfComponent
  },
  {
    path: 'authors',
    component: AuthorListComponent
  },
  {
    path: 'genres',
    component: GenreComponent
  }
]
@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class RoutingModule { }
