import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { matchStats } from 'src/LeagueStats';
import { PLdataService } from '../pldata.service';
import { DateObj } from '../object';
import {MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition} from '@angular/material/snack-bar';

let ELEMENTS_DATA: matchStats[];
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements AfterViewInit, OnInit {

  splitDate?:string[];
  str?:string;
  date?:Date;
  matchdateObj?:DateObj;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';

  displayedColumns: String[] =['MatchDate', 'teamA','teamAscore','teamB','teamBscore'];
  DataSource = new MatTableDataSource<matchStats>(ELEMENTS_DATA);
  msg ?:string;


  constructor(private service:PLdataService,private _snackBar: MatSnackBar){}

  ngOnInit() {
    this.getmData();
  }

  ngAfterViewInit() {
    this.DataSource.paginator = this.paginator;
  }

  test(){
    this.str= this.date?.toLocaleDateString();
    console.log(this.str);
    this.splitDate = this.str?.split("/",3);
    console.log(this.splitDate);
    this.datePass()
  }

  datePass(){
    this.matchdateObj = new DateObj();
    if (this.splitDate) {
      this.matchdateObj.day = Number(this.splitDate[0]);
    }
    if (this.splitDate) {
      this.matchdateObj.month = Number(this.splitDate[1]);
    }
    if (this.splitDate) {
      this.matchdateObj.year = Number(this.splitDate[2]);
    }
    console.log(this.matchdateObj);
    this.sendDate();
  }

  public getmData(){
    let resp = this.service.findMatch();
    resp.subscribe(reports=>this.DataSource.data=reports  as matchStats[]);
    console.log(this.msg)
  }

  public sendDate() {
    let feedback = this.service.findMatchDate(this.matchdateObj);
    feedback.subscribe(data => this.matchdateObj = data);
  }

  openSnackBar(clubMassage) {
    this._snackBar.open(clubMassage, 'done', {
      duration: 500,
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

}
