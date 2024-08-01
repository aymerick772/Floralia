import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaimentStripeComponent } from './paiment-stripe.component';

describe('PaimentStripeComponent', () => {
  let component: PaimentStripeComponent;
  let fixture: ComponentFixture<PaimentStripeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaimentStripeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaimentStripeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
