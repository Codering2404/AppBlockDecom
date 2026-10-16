package com.borax12.materialdaterangepicker.date;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleDayPickerView extends DayPickerView {
    public SimpleDayPickerView(Context context, DatePickerController datePickerController) {
        super(context, datePickerController);
    }

    @Override // com.borax12.materialdaterangepicker.date.DayPickerView
    public MonthAdapter b(Context context, DatePickerController datePickerController) {
        return new SimpleMonthAdapter(context, datePickerController);
    }
}
