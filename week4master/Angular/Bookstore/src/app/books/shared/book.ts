import { Genre } from './genre';
import { Author } from './author';

export class Book{
    id: number;
    isbn10: string;
    isbn13: string;
    title: string;
    price: number;
    stock: number;
    cover: string;
    genres: Genre[];
    authors: Author[];
}