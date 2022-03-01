import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account-service.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.scss']
})
export class WithdrawComponent implements OnInit {

  amount: any = null;
  clientId: any = null;

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
  }

  public withdraw() {
    this.accountService.withdraw(this.clientId, this.amount);
  }

}
