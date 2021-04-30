export interface leagueStats {
    wins: number,
    draws: number,
    defeats: number,
    matchPlayed: number,
    goalsReceived: number,
    score: number,
    points: number,
    clubName: String,
    clubLocation: String
}
export interface matchStats {
    matchDate: Date[],
    teamA: String,
    teamB: String,
    teamAscore: number,
    teamBscore: number
}

export interface Date{
    day:number;
    month:number;
    year:number;
}
