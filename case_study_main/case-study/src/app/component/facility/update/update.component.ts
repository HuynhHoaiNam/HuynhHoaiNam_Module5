import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(private activatedRoute:ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe(next=>{

    },)
  }

  ngOnInit(): void {
  }

}
