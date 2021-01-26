import {Seller} from './Seller';

export class Product {
  id:string;
  image: string;
  name: string;
  description: string;
  seller: Seller;
  features: string;
  available: number;
  freeDelivery: boolean;
  deliveryIn: string;
  price: number;
  moneySymbol: string;

}
