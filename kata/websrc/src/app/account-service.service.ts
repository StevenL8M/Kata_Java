import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Operation } from './operation';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  accountUrl: string;

  constructor(private http: HttpClient) {
    this.accountUrl = 'http://localhost:8080/account';
  }

  public depose(clientId: number, amount: number) {
    let headers = { 'Content-type': 'application/json' };
    let req = this.http.post(this.accountUrl + "/" + clientId + "/depose", amount, { headers } );
    req.subscribe();
  }

  public withdraw(clientId: number, amount: number) {
    let headers = { 'Content-type': 'application/json', 'Access-Control-Allow-Origin': '*'};
    let req = this.http.get(this.accountUrl + "/" + clientId + "/withdraw" + "/" + amount, { headers } );
    req.subscribe();
  }

  public getHistory(clientId: number) : Observable<Operation[]> {
    let headers = { 'Content-type': 'application/json', 'Access-Control-Allow-Origin': '*'};
    return this.http.get<Operation[]>(this.accountUrl + "/" + clientId + "/history", { headers } );
  }

}
