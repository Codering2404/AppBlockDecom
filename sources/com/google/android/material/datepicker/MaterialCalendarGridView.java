package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f80823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f80824b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i3, Rect rect) {
        if (i3 == 33) {
            setSelection(getAdapter().m());
        } else if (i3 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i3, rect);
        }
    }

    private View c(int i3) {
        return getChildAt(i3 - getFirstVisiblePosition());
    }

    private static int d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(Long l3, Long l4, Long l5, Long l6) {
        return l3 == null || l4 == null || l5 == null || l6 == null || l5.longValue() > l4.longValue() || l6.longValue() < l3.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int iA;
        int iD;
        int iA2;
        int iD2;
        int width;
        int i3;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = materialCalendarGridView.getAdapter();
        DateSelector dateSelector = adapter.f80875b;
        CalendarStyle calendarStyle = adapter.f80877d;
        int iMax = Math.max(adapter.b(), materialCalendarGridView.getFirstVisiblePosition());
        int iMin = Math.min(adapter.m(), materialCalendarGridView.getLastVisiblePosition());
        Long item = adapter.getItem(iMax);
        Long item2 = adapter.getItem(iMin);
        for (Pair pair : dateSelector.w1()) {
            Object obj = pair.f34340a;
            if (obj == null) {
                materialCalendarGridView = this;
            } else if (pair.f34341b != null) {
                Long l3 = (Long) obj;
                long jLongValue = l3.longValue();
                Long l4 = (Long) pair.f34341b;
                long jLongValue2 = l4.longValue();
                if (!e(item, item2, l3, l4)) {
                    boolean zO = ViewUtils.o(materialCalendarGridView);
                    if (jLongValue < item.longValue()) {
                        iD = adapter.h(iMax) ? 0 : !zO ? materialCalendarGridView.c(iMax - 1).getRight() : materialCalendarGridView.c(iMax - 1).getLeft();
                        iA = iMax;
                    } else {
                        materialCalendarGridView.f80823a.setTimeInMillis(jLongValue);
                        iA = adapter.a(materialCalendarGridView.f80823a.get(5));
                        iD = d(materialCalendarGridView.c(iA));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iD2 = adapter.i(iMin) ? materialCalendarGridView.getWidth() : !zO ? materialCalendarGridView.c(iMin).getRight() : materialCalendarGridView.c(iMin).getLeft();
                        iA2 = iMin;
                    } else {
                        materialCalendarGridView.f80823a.setTimeInMillis(jLongValue2);
                        iA2 = adapter.a(materialCalendarGridView.f80823a.get(5));
                        iD2 = d(materialCalendarGridView.c(iA2));
                    }
                    int itemId = (int) adapter.getItemId(iA);
                    int i4 = iMax;
                    int i5 = iMin;
                    int itemId2 = (int) adapter.getItemId(iA2);
                    while (itemId <= itemId2) {
                        int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                        int numColumns2 = (numColumns + materialCalendarGridView.getNumColumns()) - 1;
                        View viewC = materialCalendarGridView.c(numColumns);
                        int top = viewC.getTop() + calendarStyle.f80760a.c();
                        MonthAdapter monthAdapter = adapter;
                        int bottom = viewC.getBottom() - calendarStyle.f80760a.b();
                        if (zO) {
                            int i6 = iA2 > numColumns2 ? 0 : iD2;
                            width = numColumns > iA ? getWidth() : iD;
                            i3 = i6;
                        } else {
                            i3 = numColumns > iA ? 0 : iD;
                            width = iA2 > numColumns2 ? getWidth() : iD2;
                        }
                        canvas.drawRect(i3, top, width, bottom, calendarStyle.f80767h);
                        itemId++;
                        materialCalendarGridView = this;
                        adapter = monthAdapter;
                    }
                    materialCalendarGridView = this;
                    iMax = i4;
                    iMin = i5;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z2, int i3, Rect rect) {
        if (z2) {
            a(i3, rect);
        } else {
            super.onFocusChanged(false, i3, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (!super.onKeyDown(i3, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i3) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i4) {
        if (!this.f80824b) {
            super.onMeasure(i3, i4);
            return;
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i3) {
        if (i3 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i3);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f80823a = UtcDates.m();
        if (MaterialDatePicker.O(getContext())) {
            setNextFocusLeftId(R.id.f79620a);
            setNextFocusRightId(R.id.f79626d);
        }
        this.f80824b = MaterialDatePicker.Q(getContext());
        ViewCompat.m0(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.k0(null);
            }
        });
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof MonthAdapter)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
