package com.google.android.material.timepicker;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f82487g = {"12", AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f82488h = {"00", AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f82489i = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimePickerView f82490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeModel f82491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f82492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f82493d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f82494f = false;

    public TimePickerClockPresenter(TimePickerView timePickerView, TimeModel timeModel) {
        this.f82490a = timePickerView;
        this.f82491b = timeModel;
        i();
    }

    private String[] g() {
        return this.f82491b.f82482c == 1 ? f82488h : f82487g;
    }

    private int h() {
        return (this.f82491b.e() * 30) % 360;
    }

    private void j(int i3, int i4) {
        TimeModel timeModel = this.f82491b;
        if (timeModel.f82484f == i4 && timeModel.f82483d == i3) {
            return;
        }
        this.f82490a.performHapticFeedback(4);
    }

    private void l() {
        TimeModel timeModel = this.f82491b;
        int i3 = 1;
        if (timeModel.f82485g == 10 && timeModel.f82482c == 1 && timeModel.f82483d >= 12) {
            i3 = 2;
        }
        this.f82490a.u(i3);
    }

    private void m() {
        TimePickerView timePickerView = this.f82490a;
        TimeModel timeModel = this.f82491b;
        timePickerView.H(timeModel.f82486h, timeModel.e(), this.f82491b.f82484f);
    }

    private void n() {
        o(f82487g, "%d");
        o(f82489i, "%02d");
    }

    private void o(String[] strArr, String str) {
        for (int i3 = 0; i3 < strArr.length; i3++) {
            strArr[i3] = TimeModel.c(this.f82490a.getResources(), strArr[i3], str);
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void a() {
        this.f82490a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void b(float f3, boolean z2) {
        this.f82494f = true;
        TimeModel timeModel = this.f82491b;
        int i3 = timeModel.f82484f;
        int i4 = timeModel.f82483d;
        if (timeModel.f82485g == 10) {
            this.f82490a.v(this.f82493d, false);
            AccessibilityManager accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(this.f82490a.getContext(), AccessibilityManager.class);
            if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                k(12, true);
            }
        } else {
            int iRound = Math.round(f3);
            if (!z2) {
                this.f82491b.j(((iRound + 15) / 30) * 5);
                this.f82492c = this.f82491b.f82484f * 6;
            }
            this.f82490a.v(this.f82492c, z2);
        }
        this.f82494f = false;
        m();
        j(i4, i3);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener
    public void c(int i3) {
        this.f82491b.k(i3);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void d(int i3) {
        k(i3, true);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void e(float f3, boolean z2) {
        if (this.f82494f) {
            return;
        }
        TimeModel timeModel = this.f82491b;
        int i3 = timeModel.f82483d;
        int i4 = timeModel.f82484f;
        int iRound = Math.round(f3);
        TimeModel timeModel2 = this.f82491b;
        if (timeModel2.f82485g == 12) {
            timeModel2.j((iRound + 3) / 6);
            this.f82492c = (float) Math.floor(this.f82491b.f82484f * 6);
        } else {
            int i5 = (iRound + 15) / 30;
            if (timeModel2.f82482c == 1) {
                i5 %= 12;
                if (this.f82490a.r() == 2) {
                    i5 += 12;
                }
            }
            this.f82491b.i(i5);
            this.f82493d = h();
        }
        if (z2) {
            return;
        }
        m();
        j(i3, i4);
    }

    public void i() {
        if (this.f82491b.f82482c == 0) {
            this.f82490a.F();
        }
        this.f82490a.q(this);
        this.f82490a.B(this);
        this.f82490a.A(this);
        this.f82490a.y(this);
        n();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        this.f82493d = h();
        TimeModel timeModel = this.f82491b;
        this.f82492c = timeModel.f82484f * 6;
        k(timeModel.f82485g, false);
        m();
    }

    void k(int i3, boolean z2) {
        boolean z3 = i3 == 12;
        this.f82490a.t(z3);
        this.f82491b.f82485g = i3;
        this.f82490a.D(z3 ? f82489i : g(), z3 ? R.string.f79715n : this.f82491b.d());
        l();
        this.f82490a.v(z3 ? this.f82492c : this.f82493d, z2);
        this.f82490a.s(i3);
        this.f82490a.x(new ClickActionDelegate(this.f82490a.getContext(), R.string.f79712k) { // from class: com.google.android.material.timepicker.TimePickerClockPresenter.1
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.m0(view.getResources().getString(TimePickerClockPresenter.this.f82491b.d(), String.valueOf(TimePickerClockPresenter.this.f82491b.e())));
            }
        });
        this.f82490a.w(new ClickActionDelegate(this.f82490a.getContext(), R.string.f79714m) { // from class: com.google.android.material.timepicker.TimePickerClockPresenter.2
            @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.m0(view.getResources().getString(R.string.f79715n, String.valueOf(TimePickerClockPresenter.this.f82491b.f82484f)));
            }
        });
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.f82490a.setVisibility(0);
    }
}
