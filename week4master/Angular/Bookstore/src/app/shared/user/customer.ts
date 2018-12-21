import { User } from './user';
import { Address } from './address';
import { Book } from 'src/app/books/shared/book';

export class Customer extends User{
    address: Address;
    readingList: Book[];
}