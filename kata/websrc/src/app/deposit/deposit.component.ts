import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account-service.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.scss']
})
export class DepositComponent implements OnInit {

  amount: any = null;
  clientId: any = null;

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
  }

  public validateDeposit() {
    console.log("ok");
    this.accountService.depose(this.clientId, this.amount);
  }

}
