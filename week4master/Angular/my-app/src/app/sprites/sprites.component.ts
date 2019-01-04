import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Sprites } from '../sprites';

@Component({
  selector: 'app-sprites',
  templateUrl: './sprites.component.html',
  styleUrls: ['./sprites.component.css']
})
export class SpritesComponent implements OnInit, OnChanges {
  @Input() sprites: Sprites;
  currentSprite: string;
  constructor() { }

  ngOnInit() {
    this.currentSprite=this.sprites.front_default;
  }
  ngOnChanges(){
    this.currentSprite=this.sprites.front_default;
  }
  advanceSprite(){
    switch (this.currentSprite) {
      case this.sprites.front_default: this.currentSprite = this.sprites.back_default;
      if (this.currentSprite) {
        break;
      }
      case this.sprites.back_default: this.currentSprite = this.sprites.front_female;
      if (this.currentSprite) {
        break;
      }
      case this.sprites.front_female: this.currentSprite = this.sprites.back_female;
      if (this.currentSprite) {
        break;
      }
      case this.sprites.back_female: this.currentSprite = this.sprites.front_shiny;
      if (this.currentSprite) {
        break;
      }
      case this.sprites.front_shiny: this.currentSprite = this.sprites.back_shiny;
      if (this.currentSprite) {
        break;
      }
      case this.sprites.back_shiny: this.currentSprite = this.sprites.front_shiny_female;
      if (this.currentSprite) {
        break;
      }
      case this.sprites.front_shiny_female: this.currentSprite = this.sprites.back_shiny_female;
      if (this.currentSprite) {
        break;
      }
      case this.sprites.back_shiny_female: this.currentSprite = this.sprites.front_default;
      if (this.currentSprite) {
        break;
      }
    }
  }
}
