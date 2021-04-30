import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddMatchComponent } from './add-match/add-match.component';
import { DataTableComponent } from './data-table/data-table.component';
import { HomeComponent } from './find/home.component';
import { LeagueClubsComponent } from './league-clubs/league-clubs.component';
import { MatchTableComponent } from './match-table/match-table.component';
import {HomePageComponent} from './home-page/home-page.component';

const routes: Routes = [
  { path: 'AddClubs' , component: LeagueClubsComponent},
  { path: 'leagueTable' , component: DataTableComponent},
  { path: 'matchTable' , component: MatchTableComponent},
  { path: 'find' , component: HomeComponent},
  { path: 'addmatch' , component: AddMatchComponent},
  { path: 'homepage' , component: HomePageComponent},
  { path: '**', component: HomePageComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponents = [ LeagueClubsComponent,DataTableComponent,HomeComponent,MatchTableComponent,HomeComponent,AddMatchComponent,HomePageComponent]
