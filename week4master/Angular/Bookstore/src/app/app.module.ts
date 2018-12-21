import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { BookComponent } from './books/book/book.component';
import { BookShelfComponent } from './books/book-shelf/book-shelf.component';
import { AuthorComponent } from './books/author/author.component';
import { GenreComponent } from './books/genre/genre.component';
import { EditBookComponent } from './books/edit-book/edit-book.component';
import { AuthorListComponent } from './books/author-list/author-list.component';
import { LoginComponent } from './core/login/login.component';
import { NavBarComponent } from './core/nav-bar/nav-bar.component';
import { AuthorService } from './books/shared/author.service';
import { GenreService } from './books/shared/genre.service';
import { BookService } from './books/shared/book.service';
import { UrlService } from './shared/url.service';
import { RoutingModule } from './routing/routing/routing.module';
import { BookFilterPipe } from './book-filter.pipe';
import { UserService } from './shared/user/user.service';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    BookShelfComponent,
    AuthorComponent,
    GenreComponent,
    EditBookComponent,
    AuthorListComponent,
    LoginComponent,
    NavBarComponent,
    BookFilterPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RoutingModule
  ],
  providers: [
    AuthorService,
    GenreService,
    BookService,
    UrlService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
