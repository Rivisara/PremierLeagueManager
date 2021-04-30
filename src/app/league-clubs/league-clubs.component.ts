import { Component } from '@angular/core';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';
import { clubStats } from '../clubStats';
import { PLdataService } from '../pldata.service';

@Component({
  selector: 'app-league-clubs',
  templateUrl: './league-clubs.component.html',
  styleUrls: ['./league-clubs.component.scss']
})
export class LeagueClubsComponent {

  club:clubStats = new clubStats("","");
  clubmsg ?:string;
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';


  constructor(private service:PLdataService,private _snackBar: MatSnackBar) {}

  public addclubs(){

    let feedback = this.service.saveClubData(this.club);
    feedback.subscribe(data=> this.clubmsg=data);
    this.club.clubName=""
    this.club.clubLocation=""
    setTimeout(() => {
      this.openSnackBar(this.clubmsg);
    }, 700);
  }

  openSnackBar(clubMassage) {
    this._snackBar.open(clubMassage, 'done', {
      duration: 500,
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
    });
  }

}

