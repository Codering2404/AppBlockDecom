package com.google.android.material.timepicker;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Chip f82518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Chip f82519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClockHandView f82520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ClockFaceView f82521d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MaterialButtonToggleGroup f82522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View.OnClickListener f82523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OnPeriodChangeListener f82524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private OnSelectionChange f82525i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private OnDoubleTapListener f82526j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface OnDoubleTapListener {
        void d();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface OnPeriodChangeListener {
        void c(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface OnSelectionChange {
        void d(int i3);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void C() {
        Chip chip = this.f82518a;
        int i3 = R.id.f79635h0;
        chip.setTag(i3, 12);
        this.f82519b.setTag(i3, 10);
        this.f82518a.setOnClickListener(this.f82523g);
        this.f82519b.setOnClickListener(this.f82523g);
        this.f82518a.setAccessibilityClassName("android.view.View");
        this.f82519b.setAccessibilityClassName("android.view.View");
    }

    private void E() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.timepicker.TimePickerView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                OnDoubleTapListener onDoubleTapListener = TimePickerView.this.f82526j;
                if (onDoubleTapListener == null) {
                    return false;
                }
                onDoubleTapListener.d();
                return true;
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.google.android.material.timepicker.TimePickerView.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.f82518a.setOnTouchListener(onTouchListener);
        this.f82519b.setOnTouchListener(onTouchListener);
    }

    private void G(Chip chip, boolean z2) {
        chip.setChecked(z2);
        ViewCompat.o0(chip, z2 ? 2 : 0);
    }

    public static /* synthetic */ void h(TimePickerView timePickerView, MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z2) {
        if (!z2) {
            timePickerView.getClass();
            return;
        }
        OnPeriodChangeListener onPeriodChangeListener = timePickerView.f82524h;
        if (onPeriodChangeListener != null) {
            onPeriodChangeListener.c(i3 == R.id.f79654r ? 1 : 0);
        }
    }

    void A(OnPeriodChangeListener onPeriodChangeListener) {
        this.f82524h = onPeriodChangeListener;
    }

    void B(OnSelectionChange onSelectionChange) {
        this.f82525i = onSelectionChange;
    }

    public void D(String[] strArr, int i3) {
        this.f82521d.F(strArr, i3);
    }

    public void F() {
        this.f82522f.setVisibility(0);
    }

    public void H(int i3, int i4, int i5) {
        this.f82522f.e(i3 == 1 ? R.id.f79654r : R.id.f79652q);
        Locale locale = getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(i5));
        String str2 = String.format(locale, "%02d", Integer.valueOf(i4));
        if (!TextUtils.equals(this.f82518a.getText(), str)) {
            this.f82518a.setText(str);
        }
        if (TextUtils.equals(this.f82519b.getText(), str2)) {
            return;
        }
        this.f82519b.setText(str2);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (view == this && i3 == 0) {
            this.f82519b.sendAccessibilityEvent(8);
        }
    }

    public void q(ClockHandView.OnRotateListener onRotateListener) {
        this.f82520c.b(onRotateListener);
    }

    int r() {
        return this.f82521d.A();
    }

    public void s(int i3) {
        G(this.f82518a, i3 == 12);
        G(this.f82519b, i3 == 10);
    }

    public void t(boolean z2) {
        this.f82520c.m(z2);
    }

    void u(int i3) {
        this.f82521d.E(i3);
    }

    public void v(float f3, boolean z2) {
        this.f82520c.q(f3, z2);
    }

    public void w(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.m0(this.f82518a, accessibilityDelegateCompat);
    }

    public void x(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.m0(this.f82519b, accessibilityDelegateCompat);
    }

    public void y(ClockHandView.OnActionUpListener onActionUpListener) {
        this.f82520c.t(onActionUpListener);
    }

    void z(OnDoubleTapListener onDoubleTapListener) {
        this.f82526j = onDoubleTapListener;
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82523g = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TimePickerView.this.f82525i != null) {
                    TimePickerView.this.f82525i.d(((Integer) view.getTag(R.id.f79635h0)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.f79688s, this);
        this.f82521d = (ClockFaceView) findViewById(R.id.f79646n);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.f79656s);
        this.f82522f = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.OnButtonCheckedListener() { // from class: com.google.android.material.timepicker.e
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i4, boolean z2) {
                TimePickerView.h(this.f82535a, materialButtonToggleGroup2, i4, z2);
            }
        });
        this.f82518a = (Chip) findViewById(R.id.f79664x);
        this.f82519b = (Chip) findViewById(R.id.f79660u);
        this.f82520c = (ClockHandView) findViewById(R.id.f79648o);
        E();
        C();
    }
}
