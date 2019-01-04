import { Injectable } from '@angular/core';
import { Pokemon } from './pokemon';
import { Sprites } from './sprites';
import { Stat } from './stat';
import { HttpClient } from '@angular/common/http';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private pokemon: Pokemon;
  constructor(private http: HttpClient) { 
    this.pokemon = {
      sprites: new Sprites(),
      stats: [],
      id: 1,
      name: 'Bulbasaur',
      height: 1,
      weight: 2
    };
  }
  getPokemon(id:number): Observable<Pokemon>{
    return this.http.get('https://pokeapi.co/api/v2/pokemon/'+id+'/').pipe(
      map(resp => resp as Pokemon)
    );
  }
  getPokemonSimple(): Pokemon {
    return this.pokemon;
  }
}
