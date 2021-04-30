import { Component, OnInit } from '@angular/core';
import {PLdataService} from '../pldata.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent{
  club?:String;
  clubmsg?:String;

  constructor(private service:PLdataService) { }

  saveData(){
    let feedback = this.service.saveData(this.club);
    feedback.subscribe(data=> this.clubmsg=data);
  }

}
