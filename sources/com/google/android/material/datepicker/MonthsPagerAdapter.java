package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CalendarConstraints f80880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final DateSelector f80881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final DayViewDecorator f80882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MaterialCalendar.OnDayClickListener f80883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f80884m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TextView f80887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final MaterialCalendarGridView f80888c;

        ViewHolder(LinearLayout linearLayout, boolean z2) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.I);
            this.f80887b = textView;
            ViewCompat.n0(textView, true);
            this.f80888c = (MaterialCalendarGridView) linearLayout.findViewById(R.id.E);
            if (z2) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    MonthsPagerAdapter(Context context, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.OnDayClickListener onDayClickListener) {
        Month monthM = calendarConstraints.m();
        Month monthI = calendarConstraints.i();
        Month monthL = calendarConstraints.l();
        if (monthM.compareTo(monthL) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (monthL.compareTo(monthI) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f80884m = (MonthAdapter.f80872h * MaterialCalendar.M(context)) + (MaterialDatePicker.O(context) ? MaterialCalendar.M(context) : 0);
        this.f80880i = calendarConstraints;
        this.f80881j = dateSelector;
        this.f80882k = dayViewDecorator;
        this.f80883l = onDayClickListener;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f80880i.k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return this.f80880i.m().k(i3).j();
    }

    Month h(int i3) {
        return this.f80880i.m().k(i3);
    }

    CharSequence i(int i3) {
        return h(i3).i();
    }

    int j(Month month) {
        return this.f80880i.m().l(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i3) {
        Month monthK = this.f80880i.m().k(i3);
        viewHolder.f80887b.setText(monthK.i());
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.f80888c.findViewById(R.id.E);
        if (materialCalendarGridView.getAdapter() == null || !monthK.equals(materialCalendarGridView.getAdapter().f80874a)) {
            MonthAdapter monthAdapter = new MonthAdapter(monthK, this.f80881j, this.f80880i, this.f80882k);
            materialCalendarGridView.setNumColumns(monthK.f80868d);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.datepicker.MonthsPagerAdapter.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i4, long j3) {
                if (materialCalendarGridView.getAdapter().r(i4)) {
                    MonthsPagerAdapter.this.f80883l.a(materialCalendarGridView.getAdapter().getItem(i4).longValue());
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f79694y, viewGroup, false);
        if (!MaterialDatePicker.O(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f80884m));
        return new ViewHolder(linearLayout, true);
    }
}
