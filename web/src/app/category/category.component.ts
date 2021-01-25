import { Component, OnInit } from '@angular/core';
import {Category} from './Category';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  constructor() { }
  title:"Kategori Listesi";
  categories: Category[]= [
    {id:"1",name:"Telefon",code:"telefonpr001"},
    {id:"2",name:"Ev Aletleri",code:"evaletleri001"},
    {id:"3",name:"Kırtasiye",code:"kirtasiyepr001"},
  ];
  ngOnInit(): void {
  }

}
