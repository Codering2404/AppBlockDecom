package com.borax12.materialdaterangepicker.date;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.borax12.materialdaterangepicker.Utils;
import com.borax12.materialdaterangepicker.date.DatePickerDialog;
import com.borax12.materialdaterangepicker.date.MonthAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DayPickerView extends ListView implements AbsListView.OnScrollListener, DatePickerDialog.OnDateChangedListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f65808r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static SimpleDateFormat f65809s = new SimpleDateFormat("yyyy", Locale.getDefault());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f65810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f65811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f65812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f65813d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Context f65814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Handler f65815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected MonthAdapter.CalendarDay f65816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected MonthAdapter f65817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected MonthAdapter.CalendarDay f65818j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f65819k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected long f65820l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f65821m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f65822n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private DatePickerController f65823o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f65824p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected ScrollStateRunnable f65825q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class ScrollStateRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f65828a;

        protected ScrollStateRunnable() {
        }

        public void a(AbsListView absListView, int i3) {
            DayPickerView.this.f65815g.removeCallbacks(this);
            this.f65828a = i3;
            DayPickerView.this.f65815g.postDelayed(this, 40L);
        }

        @Override // java.lang.Runnable
        public void run() {
            DayPickerView dayPickerView;
            int i3;
            DayPickerView.this.f65822n = this.f65828a;
            if (Log.isLoggable("MonthFragment", 3)) {
                Log.d("MonthFragment", "new scroll state: " + this.f65828a + " old state: " + DayPickerView.this.f65821m);
            }
            int i4 = this.f65828a;
            if (i4 == 0 && (i3 = (dayPickerView = DayPickerView.this).f65821m) != 0) {
                if (i3 != 1) {
                    dayPickerView.f65821m = i4;
                    View childAt = dayPickerView.getChildAt(0);
                    int i5 = 0;
                    while (childAt != null && childAt.getBottom() <= 0) {
                        i5++;
                        childAt = DayPickerView.this.getChildAt(i5);
                    }
                    if (childAt == null) {
                        return;
                    }
                    boolean z2 = (DayPickerView.this.getFirstVisiblePosition() == 0 || DayPickerView.this.getLastVisiblePosition() == DayPickerView.this.getCount() - 1) ? false : true;
                    int top = childAt.getTop();
                    int bottom = childAt.getBottom();
                    int height = DayPickerView.this.getHeight() / 2;
                    if (!z2 || top >= DayPickerView.f65808r) {
                        return;
                    }
                    if (bottom > height) {
                        DayPickerView.this.smoothScrollBy(top, 250);
                        return;
                    } else {
                        DayPickerView.this.smoothScrollBy(bottom, 250);
                        return;
                    }
                }
            }
            DayPickerView.this.f65821m = i4;
        }
    }

    public DayPickerView(Context context, DatePickerController datePickerController) {
        super(context);
        this.f65810a = 6;
        this.f65811b = false;
        this.f65812c = 7;
        this.f65813d = 1.0f;
        this.f65816h = new MonthAdapter.CalendarDay();
        this.f65818j = new MonthAdapter.CalendarDay();
        this.f65821m = 0;
        this.f65822n = 0;
        this.f65825q = new ScrollStateRunnable();
        f(context);
        setController(datePickerController);
    }

    private MonthAdapter.CalendarDay c() {
        MonthAdapter.CalendarDay accessibilityFocus;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof MonthView) && (accessibilityFocus = ((MonthView) childAt).getAccessibilityFocus()) != null) {
                return accessibilityFocus;
            }
        }
        return null;
    }

    private static String d(MonthAdapter.CalendarDay calendarDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendarDay.f65835b, calendarDay.f65836c, calendarDay.f65837d);
        return (("" + calendar.getDisplayName(2, 2, Locale.getDefault())) + " ") + f65809s.format(calendar.getTime());
    }

    private boolean i(MonthAdapter.CalendarDay calendarDay) {
        if (calendarDay == null) {
            return false;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof MonthView) && ((MonthView) childAt).q(calendarDay)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.borax12.materialdaterangepicker.date.DatePickerDialog.OnDateChangedListener
    public void a() {
        e(this.f65823o.d(), false, true, true);
    }

    public abstract MonthAdapter b(Context context, DatePickerController datePickerController);

    public boolean e(MonthAdapter.CalendarDay calendarDay, boolean z2, boolean z3, boolean z4) {
        View childAt;
        if (z3) {
            this.f65816h.a(calendarDay);
        }
        this.f65818j.a(calendarDay);
        int iM = ((calendarDay.f65835b - this.f65823o.m()) * 12) + calendarDay.f65836c;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            childAt = getChildAt(i3);
            if (childAt == null) {
                break;
            }
            int top = childAt.getTop();
            if (Log.isLoggable("MonthFragment", 3)) {
                Log.d("MonthFragment", "child at " + i3 + " has top " + top);
            }
            if (top >= 0) {
                break;
            }
            i3 = i4;
        }
        int positionForView = childAt != null ? getPositionForView(childAt) : 0;
        if (z3) {
            this.f65817i.g(this.f65816h);
        }
        if (Log.isLoggable("MonthFragment", 3)) {
            Log.d("MonthFragment", "GoTo position " + iM);
        }
        if (iM != positionForView || z4) {
            setMonthDisplayed(this.f65818j);
            this.f65821m = 2;
            if (z2) {
                smoothScrollToPositionFromTop(iM, f65808r, 250);
                return true;
            }
            g(iM);
        } else if (z3) {
            setMonthDisplayed(this.f65816h);
        }
        return false;
    }

    public void f(Context context) {
        this.f65815g = new Handler();
        setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        setDrawSelectorOnTop(false);
        this.f65814f = context;
        j();
    }

    public void g(final int i3) {
        clearFocus();
        post(new Runnable() { // from class: com.borax12.materialdaterangepicker.date.DayPickerView.1
            @Override // java.lang.Runnable
            public void run() {
                DayPickerView.this.setSelection(i3);
            }
        });
        onScrollStateChanged(this, 0);
    }

    public int getMostVisiblePosition() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int height = getHeight();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < height) {
            View childAt = getChildAt(i4);
            if (childAt == null) {
                break;
            }
            int bottom = childAt.getBottom();
            int iMin = Math.min(bottom, height) - Math.max(0, childAt.getTop());
            if (iMin > i5) {
                i6 = i4;
                i5 = iMin;
            }
            i4++;
            i3 = bottom;
        }
        return firstVisiblePosition + i6;
    }

    protected void h() {
        MonthAdapter monthAdapter = this.f65817i;
        if (monthAdapter == null) {
            this.f65817i = b(getContext(), this.f65823o);
        } else {
            monthAdapter.g(this.f65816h);
        }
        setAdapter((ListAdapter) this.f65817i);
    }

    protected void j() {
        setCacheColorHint(0);
        setDivider(null);
        setItemsCanFocus(true);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(this);
        setFadingEdgeLength(0);
        setFriction(ViewConfiguration.getScrollFriction() * this.f65813d);
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        MonthAdapter.CalendarDay calendarDayC = c();
        super.layoutChildren();
        if (this.f65824p) {
            this.f65824p = false;
        } else {
            i(calendarDayC);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setItemCount(-1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
        if (((MonthView) absListView.getChildAt(0)) == null) {
            return;
        }
        this.f65820l = (absListView.getFirstVisiblePosition() * r2.getHeight()) - r2.getBottom();
        this.f65821m = this.f65822n;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        this.f65825q.a(absListView, i3);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i3, Bundle bundle) {
        View childAt;
        if (i3 != 4096 && i3 != 8192) {
            return super.performAccessibilityAction(i3, bundle);
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        MonthAdapter.CalendarDay calendarDay = new MonthAdapter.CalendarDay((firstVisiblePosition / 12) + this.f65823o.m(), firstVisiblePosition % 12, 1);
        if (i3 == 4096) {
            int i4 = calendarDay.f65836c + 1;
            calendarDay.f65836c = i4;
            if (i4 == 12) {
                calendarDay.f65836c = 0;
                calendarDay.f65835b++;
            }
        } else if (i3 == 8192 && (childAt = getChildAt(0)) != null && childAt.getTop() >= -1) {
            int i5 = calendarDay.f65836c - 1;
            calendarDay.f65836c = i5;
            if (i5 == -1) {
                calendarDay.f65836c = 11;
                calendarDay.f65835b--;
            }
        }
        Utils.e(this, d(calendarDay));
        e(calendarDay, true, false, true);
        this.f65824p = true;
        return true;
    }

    public void setAccentColor(int i3) {
        this.f65817i.f(i3);
    }

    public void setController(DatePickerController datePickerController) {
        this.f65823o = datePickerController;
        datePickerController.f(this);
        h();
        a();
    }

    protected void setMonthDisplayed(MonthAdapter.CalendarDay calendarDay) {
        this.f65819k = calendarDay.f65836c;
        invalidateViews();
    }
}
