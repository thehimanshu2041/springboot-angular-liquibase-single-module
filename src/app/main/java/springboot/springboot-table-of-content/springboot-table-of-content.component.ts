import { Component, Input, OnInit } from '@angular/core';
import { Toc } from 'src/app/shared/model/shared.model';

@Component({
  selector: 'cs-springboot-table-of-content',
  templateUrl: './springboot-table-of-content.component.html',
  styleUrls: ['./springboot-table-of-content.component.scss']
})
export class SpringbootTableOfContentComponent {

  @Input() toc: Toc[];

}
