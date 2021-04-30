import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { leagueStats, matchStats } from 'src/LeagueStats';
import { clubStats } from './clubStats';

@Injectable({
  providedIn: 'root'
})

export class PLdataService {

  constructor(private http:HttpClient) { }

  public getLeagueTable(): Observable<leagueStats[]>{
    return this.http.get<leagueStats[]>("http://localhost:8080/table")
  }

  public getLeagueTableScore(): Observable<leagueStats[]>{
    return this.http.get<leagueStats[]>("http://localhost:8080/tablescore")
  }

  public getLeagueTableWins(): Observable<leagueStats[]>{
    return this.http.get<leagueStats[]>("http://localhost:8080/tablewin")
  }

  public getMatchTable(): Observable<matchStats[]>{
    return this.http.get<matchStats[]>("http://localhost:8080/match")
  }

  public saveClubData(clubStats: any): Observable<any>{
    return this.http.post<clubStats[]>("http://localhost:8080/clubs",clubStats,{responseType:'text' as 'json'})
  }

  public saveData(clubS: any): Observable<any>{
    return this.http.post<string>("http://localhost:8080/save",clubS,{responseType:'text' as 'json'})
  }

  public findMatchDate(date: any):Observable<any>{
    return this.http.post<Date[]>("http://localhost:8080/find",date,{responseType:'text' as 'json'})
  }

  public DeleteClubs(name: String):Observable<any>{
    return this.http.post<String>("http://localhost:8080/delete",name,{responseType:'text' as 'json'})
  }

  public findMatch(): Observable<any>{
    return this.http.get<matchStats[]>("http://localhost:8080/findmatch")
  }

  public addmatchDate(date: any): Observable<any>{
    return this.http.post<Date[]>("http://localhost:8080/addmatch",date,{responseType:'text' as 'json'})
  }
}
