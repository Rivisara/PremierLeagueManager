import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { matchStats } from 'src/LeagueStats';
import { PLdataService } from '../pldata.service';

let ELEMENTS_DATA: matchStats[];
@Component({
  selector: 'app-match-table',
  templateUrl: './match-table.component.html',
  styleUrls: ['./match-table.component.scss']
})
export class MatchTableComponent implements AfterViewInit,OnInit {

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  displayedColumns: String[] =['MatchDate', 'teamA','teamAscore','teamB','teamBscore'];
  DataSource = new MatTableDataSource<matchStats>(ELEMENTS_DATA);

  constructor(private service:PLdataService){}

  ngAfterViewInit() {
    this.DataSource.paginator = this.paginator;
  }

  ngOnInit() {
    this.getPlData();
  }

  public getPlData(){
    let resp = this.service.getMatchTable();
    resp.subscribe(report=>this.DataSource.data=report  as matchStats[])
  }
}
