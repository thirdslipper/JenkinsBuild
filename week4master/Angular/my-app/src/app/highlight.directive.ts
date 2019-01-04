import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  currColor: string;
  constructor(private el: ElementRef) { }

  @HostListener('mouseenter')
  bob(){
    this.currColor=this.el.nativeElement.style.backgroundColor;
    this.highlight('yellow');
  }
  @HostListener('mouseleave')
  unhighlight(){
    this.highlight(this.currColor);
  }
  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor=color;
  }
}
