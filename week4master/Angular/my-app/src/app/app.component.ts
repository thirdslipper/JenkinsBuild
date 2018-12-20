import { Component, OnInit } from '@angular/core';
import { Pokemon } from './pokemon';
import { PokemonService } from './pokemon.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Richard\'s App';
  searchId: number;
  pokemon: Pokemon;

  constructor(private pokeService: PokemonService){}
  ngOnInit(){
    this.searchId=169;
  }
  search(){
    this.pokeService.getPokemon(this.searchId).subscribe(
      resp => {
        this.pokemon = resp;
        console.log(this.pokemon);
      }
    );
    
  }
}
