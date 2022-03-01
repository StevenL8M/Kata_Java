import { Component, OnInit } from '@angular/core';
import { Operation } from '../operation';
import { AccountService } from '../account-service.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.scss']
})
export class HistoryComponent implements OnInit {

  operations: Operation[] = [];
  clientId: any;

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
  }

  public history() {
    this.accountService.getHistory(this.clientId).subscribe(res => {
      this.operations = res;
    });
  }

}
