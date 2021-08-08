import { Component, OnInit } from '@angular/core';
import { Toc } from 'src/app/shared/model/shared.model';

@Component({
  selector: 'cs-springboot',
  templateUrl: './springboot.component.html',
  styleUrls: ['./springboot.component.scss']
})
export class SpringbootComponent {

  toc: Toc[] =
    [
      {
        id: 1,
        heading: 'Introduction',
        name: 'Introduction',
        route: 'introduction',
        child: []
      },
      {
        id: 2,
        heading: 'Security Rules',
        name: 'Security Rules',
        route: '',
        child: [
          {
            id: 2.1,
            heading: 'IP Pattern',
            name: 'IP Pattern',
            route: 'ippattern',
            child: []
          },
          {
            id: 2.2,
            heading: 'IP Pattern',
            name: 'IP Pattern',
            route: 'ippattern',
            child: []
          }
        ]
      },
      {
        id: 3,
        heading: 'Security Rules',
        name: 'Security Rules',
        route: '',
        child: [
          {
            id: 3.1,
            heading: 'IP Pattern',
            name: 'IP Pattern',
            route: 'ippattern',
            child: []
          },
          {
            id: 3.2,
            heading: 'IP Pattern',
            name: 'IP Pattern',
            route: 'ippattern',
            child: []
          }
        ]
      },
      {
        id: 4,
        heading: 'Introduction',
        name: 'Introduction',
        route: 'introduction',
        child: []
      }
    ];
}
