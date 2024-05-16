import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { ManageMakesComponent } from './components/manage-makes/manage-makes.component';

const routes: Routes = [
  { path: '', component: AdminDashboardComponent },  // Default route for admin
  { path: 'dashboard', component: AdminDashboardComponent },
  { path: 'manage-makes', component: ManageMakesComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
