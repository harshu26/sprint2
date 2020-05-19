import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddStockComponent } from './add-stock/add-stock.component';
import { ListStockComponent } from './list-stock/list-stock.component';
import { AddSupplierComponent } from './add-supplier/add-supplier.component';
import { ListSupplierComponent } from './list-supplier/list-supplier.component';
import { StockMgtComponent } from './stock-mgt/stock-mgt.component';
import { UpdateStockComponent } from './update-stock/update-stock.component';


const routes: Routes = [
  {
    path:'stock-mgt',
    component:StockMgtComponent
  }
  ,
  {
    path:'add-stock',
    component: AddStockComponent
  }
  ,
  {
    path:'list-stock',
    component:ListStockComponent
  }
  ,
  {
    path:'update-stock',
    component: UpdateStockComponent
  }
  ,
  {
    path:'add-supplier',
    component:AddSupplierComponent
  }
  ,
  {
    path:"list-supplier",
    component:ListSupplierComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
