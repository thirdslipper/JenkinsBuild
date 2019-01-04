import { Component, OnInit, Input } from "@angular/core";
import { PokemonService } from '../pokemon.service';
import { Pokemon } from '../pokemon';

@Component({
    selector: 'app-pokemon',
    templateUrl: `./pokemon.component.html`
})
export class PokemonComponent implements OnInit {
    @Input() pokemon: Pokemon;
    constructor(private pokeService: PokemonService){}
    ngOnInit(){
        if(!this.pokemon){
            this.pokemon= this.pokeService.getPokemonSimple();
        }
        console.log(this.pokemon);
    }
}