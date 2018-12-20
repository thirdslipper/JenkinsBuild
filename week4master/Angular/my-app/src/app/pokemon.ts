import { Sprites } from './sprites';
import { Stat } from './stat';

export class Pokemon {
    id: number;
    name: string;
    height: number;
    weight: number;
    stats: Stat[];
    sprites: Sprites;
}
