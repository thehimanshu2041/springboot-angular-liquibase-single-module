import { Component, Input, OnChanges } from '@angular/core';
import { getValidationResult } from 'src/app/shared/directives/password-strength-validator.directive';

const Meter = ['Worst', 'Bad', 'Weak', 'Good', 'Strong'];

@Component({
  selector: 'ts-password-strength-meter',
  templateUrl: './password-strength-meter.component.html',
  styleUrls: ['./password-strength-meter.component.scss']
})
export class PasswordStrengthMeterComponent implements OnChanges {
  @Input()
  password: string;

  strength = 0;
  meter = Meter;
  feedback: string;
  suggestions: string[];

  async ngOnChanges() {
    if (this.password) {
      const results = await getValidationResult(this.password);
      this.strength = results.score;
      this.feedback = results.feedback.warning;
      this.suggestions = results.feedback.suggestions;
    } else {
      this.strength = -1;
      this.feedback = null;
    }
  }
}
