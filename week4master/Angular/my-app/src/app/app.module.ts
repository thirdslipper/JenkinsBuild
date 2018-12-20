import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokemonComponent } from './pokemon/pokemon.component';
import { StatsComponent } from './stats/stats.component';
import { SpritesComponent } from './sprites/sprites.component';
import { PokemonService } from './pokemon.service';

@NgModule({
  declarations: [
    AppComponent,
    PokemonComponent,
    StatsComponent,
    SpritesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [PokemonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
