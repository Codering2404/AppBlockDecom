package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaterialCalendar f80917i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TextView f80920b;

        ViewHolder(TextView textView) {
            super(textView);
            this.f80920b = textView;
        }
    }

    YearGridAdapter(MaterialCalendar materialCalendar) {
        this.f80917i = materialCalendar;
    }

    private View.OnClickListener h(final int i3) {
        return new View.OnClickListener() { // from class: com.google.android.material.datepicker.YearGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YearGridAdapter.this.f80917i.R(YearGridAdapter.this.f80917i.H().g(Month.c(i3, YearGridAdapter.this.f80917i.J().f80866b)));
                YearGridAdapter.this.f80917i.S(MaterialCalendar.CalendarSelector.DAY);
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f80917i.H().n();
    }

    int i(int i3) {
        return i3 - this.f80917i.H().m().f80867c;
    }

    int j(int i3) {
        return this.f80917i.H().m().f80867c + i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ViewHolder viewHolder, int i3) {
        int iJ = j(i3);
        viewHolder.f80920b.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iJ)));
        TextView textView = viewHolder.f80920b;
        textView.setContentDescription(DateStrings.k(textView.getContext(), iJ));
        CalendarStyle calendarStyleI = this.f80917i.I();
        Calendar calendarK = UtcDates.k();
        CalendarItemStyle calendarItemStyle = calendarK.get(1) == iJ ? calendarStyleI.f80765f : calendarStyleI.f80763d;
        Iterator it = this.f80917i.L().o2().iterator();
        while (it.hasNext()) {
            calendarK.setTimeInMillis(((Long) it.next()).longValue());
            if (calendarK.get(1) == iJ) {
                calendarItemStyle = calendarStyleI.f80764e;
            }
        }
        calendarItemStyle.d(viewHolder.f80920b);
        viewHolder.f80920b.setOnClickListener(h(iJ));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.A, viewGroup, false));
    }
}
