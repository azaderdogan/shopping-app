import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductComponent} from './product/product.component';
import {Category} from './category/Category';
import {CategoryComponent} from './category/category.component';

/**
 * full yazmamon sebebi route kessinlikle bir şey yazılmamışsa demek istiyorum
 */
const routes: Routes = [
  {path:'',redirectTo:'products',pathMatch:'full'},
  {path:'products',component:ProductComponent},
  {path:'category',component:CategoryComponent},
  {path:'products/category/:categoryId',component:ProductComponent},//categoryProduct
  {path:'products/:productId',component:ProductComponent},//productDetail
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
