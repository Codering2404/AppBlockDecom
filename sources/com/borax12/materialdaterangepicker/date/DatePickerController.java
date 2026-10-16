package com.borax12.materialdaterangepicker.date;

import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.borax12.materialdaterangepicker.date.MonthAdapter;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface DatePickerController {
    Calendar a();

    boolean b();

    Calendar c();

    MonthAdapter.CalendarDay d();

    int e();

    void f(DatePickerDialog.OnDateChangedListener onDateChangedListener);

    void g(int i3, int i4, int i5);

    void h();

    Calendar[] i();

    Calendar[] j();

    void k(int i3);

    int l();

    int m();
}
