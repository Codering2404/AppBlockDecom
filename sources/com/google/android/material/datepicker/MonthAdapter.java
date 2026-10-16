package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.util.Pair;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MonthAdapter extends BaseAdapter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f80872h = UtcDates.m().getMaximum(4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f80873i = (UtcDates.m().getMaximum(5) + UtcDates.m().getMaximum(7)) - 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Month f80874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final DateSelector f80875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Collection f80876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    CalendarStyle f80877d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final CalendarConstraints f80878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final DayViewDecorator f80879g;

    MonthAdapter(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f80874a = month;
        this.f80875b = dateSelector;
        this.f80878f = calendarConstraints;
        this.f80879g = dayViewDecorator;
        this.f80876c = dateSelector.o2();
    }

    private String c(Context context, long j3) {
        return DateStrings.e(context, j3, l(j3), k(j3), g(j3));
    }

    private void f(Context context) {
        if (this.f80877d == null) {
            this.f80877d = new CalendarStyle(context);
        }
    }

    private boolean j(long j3) {
        Iterator it = this.f80875b.o2().iterator();
        while (it.hasNext()) {
            if (UtcDates.a(j3) == UtcDates.a(((Long) it.next()).longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(long j3) {
        return UtcDates.k().getTimeInMillis() == j3;
    }

    private void o(TextView textView, long j3, int i3) {
        boolean zJ;
        CalendarItemStyle calendarItemStyle;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String strC = c(context, j3);
        textView.setContentDescription(strC);
        boolean zO0 = this.f80878f.h().O0(j3);
        if (zO0) {
            textView.setEnabled(true);
            zJ = j(j3);
            textView.setSelected(zJ);
            calendarItemStyle = zJ ? this.f80877d.f80761b : l(j3) ? this.f80877d.f80762c : this.f80877d.f80760a;
        } else {
            zJ = false;
            textView.setEnabled(false);
            calendarItemStyle = this.f80877d.f80766g;
        }
        boolean z2 = zJ;
        DayViewDecorator dayViewDecorator = this.f80879g;
        if (dayViewDecorator == null || i3 == -1) {
            calendarItemStyle.d(textView);
            return;
        }
        Month month = this.f80874a;
        int i4 = month.f80867c;
        int i5 = month.f80866b;
        calendarItemStyle.e(textView, dayViewDecorator.a(context, i4, i5, i3, zO0, z2), this.f80879g.h(context, i4, i5, i3, zO0, z2));
        textView.setCompoundDrawables(this.f80879g.d(context, i4, i5, i3, zO0, z2), this.f80879g.f(context, i4, i5, i3, zO0, z2), this.f80879g.e(context, i4, i5, i3, zO0, z2), this.f80879g.c(context, i4, i5, i3, zO0, z2));
        textView.setContentDescription(this.f80879g.g(context, i4, i5, i3, zO0, z2, strC));
    }

    private void p(MaterialCalendarGridView materialCalendarGridView, long j3) {
        if (Month.d(j3).equals(this.f80874a)) {
            int iH = this.f80874a.h(j3);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(iH) - materialCalendarGridView.getFirstVisiblePosition()), j3, iH);
        }
    }

    int a(int i3) {
        return b() + (i3 - 1);
    }

    int b() {
        return this.f80874a.f(this.f80878f.j());
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i3) {
        if (i3 < b() || i3 > m()) {
            return null;
        }
        return Long.valueOf(this.f80874a.g(n(i3)));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.f(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.f79691v
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L54
            com.google.android.material.datepicker.Month r8 = r5.f80874a
            int r2 = r8.f80869f
            if (r7 < r2) goto L2d
            goto L54
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L5d
        L54:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L5d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L64
            return r0
        L64:
            long r1 = r6.longValue()
            r5.o(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    boolean g(long j3) {
        Iterator it = this.f80875b.w1().iterator();
        while (it.hasNext()) {
            Object obj = ((Pair) it.next()).f34341b;
            if (obj != null && ((Long) obj).longValue() == j3) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f80873i;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3 / this.f80874a.f80868d;
    }

    boolean h(int i3) {
        return i3 % this.f80874a.f80868d == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    boolean i(int i3) {
        return (i3 + 1) % this.f80874a.f80868d == 0;
    }

    boolean k(long j3) {
        Iterator it = this.f80875b.w1().iterator();
        while (it.hasNext()) {
            Object obj = ((Pair) it.next()).f34340a;
            if (obj != null && ((Long) obj).longValue() == j3) {
                return true;
            }
        }
        return false;
    }

    int m() {
        return (b() + this.f80874a.f80869f) - 1;
    }

    int n(int i3) {
        return (i3 - b()) + 1;
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.f80876c.iterator();
        while (it.hasNext()) {
            p(materialCalendarGridView, ((Long) it.next()).longValue());
        }
        DateSelector dateSelector = this.f80875b;
        if (dateSelector != null) {
            Iterator it2 = dateSelector.o2().iterator();
            while (it2.hasNext()) {
                p(materialCalendarGridView, ((Long) it2.next()).longValue());
            }
            this.f80876c = this.f80875b.o2();
        }
    }

    boolean r(int i3) {
        return i3 >= b() && i3 <= m();
    }
}
