import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { matchStats } from 'src/LeagueStats';
import { PLdataService } from '../pldata.service';
import {DateObj} from '../object';

let ELEMENTS_DATA: matchStats[];

@Component({
  selector: 'app-add-match',
  templateUrl: './add-match.component.html',
  styleUrls: ['./add-match.component.scss']
})
export class AddMatchComponent implements AfterViewInit, OnInit {
  splitDate?:string[];
  str?:string;
  date?:Date;
  matchdateObj?:DateObj;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  displayedColumns: String[] =['MatchDate', 'teamA','teamAscore','teamB','teamBscore'];
  DataSource = new MatTableDataSource<matchStats>(ELEMENTS_DATA);


  constructor(private service:PLdataService){}

  ngOnInit() {
    this.getmatchData();
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

  public getmatchData(){
    let resp = this.service.getMatchTable();
    resp.subscribe(reports=>this.DataSource.data=reports  as matchStats[]);
  }

  public sendDate() {
    let feedback = this.service.addmatchDate(this.matchdateObj);
    feedback.subscribe(data => this.matchdateObj = data);
  }
}
