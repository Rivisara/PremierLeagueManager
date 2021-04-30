import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { PLdataService } from '../pldata.service';
import { leagueStats } from '../../LeagueStats';
import { MatPaginator } from '@angular/material/paginator';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';

let ELEMENT_DATA: leagueStats[];
@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.scss']
})

export class DataTableComponent implements AfterViewInit , OnInit {
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;


  displayedColumns: String[] = ['clubName','clubLocation','matchPlayed','wins', 'draws','defeats','score','goalsReceived','points','delete']
  dataSource = new MatTableDataSource<leagueStats>(ELEMENT_DATA);
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  clubmsg ?:string;

  constructor(private service:PLdataService,private _snackBar: MatSnackBar){}

  ngOnInit() {
    this.getPlData();
    this.sortWins();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  deleteclub(clubName)
  {
    let feedback = this.service.DeleteClubs(clubName);
    feedback.subscribe(data=> this.clubmsg=data);
    this.getPlData()
    setTimeout(() => {
      this.openSnackBar(this.clubmsg);
    }, 1000);
  }

  openSnackBar(clubMassage) {
    this._snackBar.open(clubMassage, 'done', {
      duration: 500,
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

  public getPlData(){
    let resp = this.service.getLeagueTable();
    resp.subscribe(report=>this.dataSource.data=report  as leagueStats[])
  }

  sortWins(){
    let resp = this.service.getLeagueTableWins();
    resp.subscribe(report=>this.dataSource.data=report  as leagueStats[])
  }

  sortScore(){
    let resp = this.service.getLeagueTableScore();
    resp.subscribe(report=>this.dataSource.data=report  as leagueStats[])
  }

}
