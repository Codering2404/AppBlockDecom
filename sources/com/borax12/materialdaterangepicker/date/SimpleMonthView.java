package com.borax12.materialdaterangepicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleMonthView extends MonthView {
    public SimpleMonthView(Context context, AttributeSet attributeSet, DatePickerController datePickerController) {
        super(context, attributeSet, datePickerController);
    }

    @Override // com.borax12.materialdaterangepicker.date.MonthView
    public void c(Canvas canvas, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if (this.f65854r == i5) {
            canvas.drawCircle(i6, i7 - (MonthView.P / 3), MonthView.T, this.f65842f);
        }
        if (m(i3, i4, i5)) {
            this.f65840c.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else {
            this.f65840c.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        }
        if (n(i3, i4, i5)) {
            this.f65840c.setColor(this.J);
        } else if (this.f65854r == i5) {
            this.f65840c.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            this.f65840c.setColor(this.F);
        } else if (this.f65853q && this.f65855s == i5) {
            this.f65840c.setColor(this.H);
        } else {
            this.f65840c.setColor(m(i3, i4, i5) ? this.I : this.E);
        }
        canvas.drawText(String.format("%d", Integer.valueOf(i5)), i6, i7, this.f65840c);
    }
}
