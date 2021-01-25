import {Pipe, PipeTransform} from '@angular/core';
import {Product} from './product';

@Pipe({
  name: 'productFilter'
})
export class ProductFilterPipe implements PipeTransform {

  transform(value: Product[], filterText: string): Product[] {

    return filterText
      ? value.filter(product => product.description.toLocaleLowerCase().indexOf(filterText) != -1)
      : value;
  }


}

//two way binding [()]
//one way binding {{}}
