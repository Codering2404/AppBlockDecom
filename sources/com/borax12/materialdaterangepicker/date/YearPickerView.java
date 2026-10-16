package com.borax12.materialdaterangepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.borax12.materialdaterangepicker.R;
import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class YearPickerView extends ListView implements AdapterView.OnItemClickListener, DatePickerDialog.OnDateChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DatePickerController f65871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private YearAdapter f65872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f65873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f65874d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextViewWithCircularIndicator f65875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f65876g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class YearAdapter extends ArrayAdapter<String> {
        public YearAdapter(Context context, int i3, List list) {
            super(context, i3, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            TextViewWithCircularIndicator textViewWithCircularIndicator = (TextViewWithCircularIndicator) super.getView(i3, view, viewGroup);
            textViewWithCircularIndicator.setAccentColor(YearPickerView.this.f65876g);
            textViewWithCircularIndicator.requestLayout();
            boolean z2 = YearPickerView.this.f65871a.d().f65835b == YearPickerView.f(textViewWithCircularIndicator);
            textViewWithCircularIndicator.b(z2);
            if (z2) {
                YearPickerView.this.f65875f = textViewWithCircularIndicator;
            }
            return textViewWithCircularIndicator;
        }
    }

    public YearPickerView(Context context, DatePickerController datePickerController) {
        super(context);
        this.f65871a = datePickerController;
        datePickerController.f(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Resources resources = context.getResources();
        this.f65873c = resources.getDimensionPixelOffset(R.dimen.f65690a);
        this.f65874d = resources.getDimensionPixelOffset(R.dimen.f65697h);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.f65874d / 3);
        g(context);
        setOnItemClickListener(this);
        setSelector(new StateListDrawable());
        setDividerHeight(0);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(TextView textView) {
        return Integer.valueOf(textView.getText().toString()).intValue();
    }

    private void g(Context context) {
        ArrayList arrayList = new ArrayList();
        for (int iM = this.f65871a.m(); iM <= this.f65871a.l(); iM++) {
            arrayList.add(String.format("%d", Integer.valueOf(iM)));
        }
        YearAdapter yearAdapter = new YearAdapter(context, R.layout.f65727c, arrayList);
        this.f65872b = yearAdapter;
        setAdapter((ListAdapter) yearAdapter);
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerDialog.OnDateChangedListener
    public void a() {
        this.f65872b.notifyDataSetChanged();
        h(this.f65871a.d().f65835b - this.f65871a.m());
    }

    public int getFirstPositionOffset() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public void h(int i3) {
        i(i3, (this.f65873c / 2) - (this.f65874d / 2));
    }

    public void i(final int i3, final int i4) {
        post(new Runnable() { // from class: com.borax12.materialdaterangepicker.date.YearPickerView.1
            @Override // java.lang.Runnable
            public void run() {
                YearPickerView.this.setSelectionFromTop(i3, i4);
                YearPickerView.this.requestLayout();
            }
        });
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4096) {
            accessibilityEvent.setFromIndex(0);
            accessibilityEvent.setToIndex(0);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
        this.f65871a.h();
        TextViewWithCircularIndicator textViewWithCircularIndicator = (TextViewWithCircularIndicator) view;
        if (textViewWithCircularIndicator != null) {
            TextViewWithCircularIndicator textViewWithCircularIndicator2 = this.f65875f;
            if (textViewWithCircularIndicator != textViewWithCircularIndicator2) {
                if (textViewWithCircularIndicator2 != null) {
                    textViewWithCircularIndicator2.b(false);
                    this.f65875f.requestLayout();
                }
                textViewWithCircularIndicator.b(true);
                textViewWithCircularIndicator.requestLayout();
                this.f65875f = textViewWithCircularIndicator;
            }
            this.f65871a.k(f(textViewWithCircularIndicator));
            this.f65872b.notifyDataSetChanged();
        }
    }

    public void setAccentColor(int i3) {
        this.f65876g = i3;
    }
}
