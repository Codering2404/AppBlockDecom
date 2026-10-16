package com.borax12.materialdaterangepicker.time;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import com.borax12.materialdaterangepicker.R;
import java.util.Calendar;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RadialPickerLayout extends FrameLayout implements View.OnTouchListener {
    private float A;
    private AccessibilityManager B;
    private AnimatorSet C;
    private Handler D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f65911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f65912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f65913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TimePickerDialog f65914d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OnValueSelectedListener f65915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f65916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f65917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f65918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f65919j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f65920k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f65921l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private CircleView f65922m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AmPmCirclesView f65923n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private RadialTextsView f65924o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RadialTextsView f65925p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RadialSelectorView f65926q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private RadialSelectorView f65927r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f65928s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int[] f65929t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f65930u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f65931v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f65932w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f65933x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f65934y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f65935z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnValueSelectedListener {
        void f(int i3, int i4, boolean z2);
    }

    public RadialPickerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65931v = -1;
        this.D = new Handler();
        setOnTouchListener(this);
        this.f65911a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f65912b = ViewConfiguration.getTapTimeout();
        this.f65932w = false;
        CircleView circleView = new CircleView(context);
        this.f65922m = circleView;
        addView(circleView);
        AmPmCirclesView amPmCirclesView = new AmPmCirclesView(context);
        this.f65923n = amPmCirclesView;
        addView(amPmCirclesView);
        RadialSelectorView radialSelectorView = new RadialSelectorView(context);
        this.f65926q = radialSelectorView;
        addView(radialSelectorView);
        RadialSelectorView radialSelectorView2 = new RadialSelectorView(context);
        this.f65927r = radialSelectorView2;
        addView(radialSelectorView2);
        RadialTextsView radialTextsView = new RadialTextsView(context);
        this.f65924o = radialTextsView;
        addView(radialTextsView);
        RadialTextsView radialTextsView2 = new RadialTextsView(context);
        this.f65925p = radialTextsView2;
        addView(radialTextsView2);
        k();
        this.f65913c = -1;
        this.f65930u = true;
        View view = new View(context);
        this.f65928s = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f65928s.setBackgroundColor(getResources().getColor(R.color.f65688v));
        this.f65928s.setVisibility(4);
        addView(this.f65928s);
        this.B = (AccessibilityManager) context.getSystemService("accessibility");
        this.f65916g = false;
    }

    private int getCurrentlyShowingValue() {
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            return this.f65917h;
        }
        if (currentItemShowing == 1) {
            return this.f65918i;
        }
        return -1;
    }

    private int h(float f3, float f4, boolean z2, Boolean[] boolArr) {
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            return this.f65926q.a(f3, f4, z2, boolArr);
        }
        if (currentItemShowing == 1) {
            return this.f65927r.a(f3, f4, z2, boolArr);
        }
        return -1;
    }

    private boolean j(int i3) {
        return this.f65919j && i3 <= 12 && i3 != 0;
    }

    private void k() {
        this.f65929t = new int[361];
        int i3 = 1;
        int i4 = 8;
        int i5 = 0;
        for (int i6 = 0; i6 < 361; i6++) {
            this.f65929t[i6] = i5;
            if (i3 == i4) {
                i5 += 6;
                i4 = i5 == 360 ? 7 : i5 % 30 == 0 ? 14 : 4;
                i3 = 1;
            } else {
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int l(int r5, boolean r6, boolean r7, boolean r8) {
        /*
            r4 = this;
            r0 = -1
            if (r5 != r0) goto L4
            return r0
        L4:
            int r0 = r4.getCurrentItemShowing()
            r1 = 0
            r2 = 1
            if (r7 != 0) goto L13
            if (r0 != r2) goto L13
            int r5 = r4.s(r5)
            goto L17
        L13:
            int r5 = r(r5, r1)
        L17:
            if (r0 != 0) goto L1e
            com.borax12.materialdaterangepicker.time.RadialSelectorView r7 = r4.f65926q
            r3 = 30
            goto L21
        L1e:
            com.borax12.materialdaterangepicker.time.RadialSelectorView r7 = r4.f65927r
            r3 = 6
        L21:
            r7.c(r5, r6, r8)
            r7.invalidate()
            r7 = 360(0x168, float:5.04E-43)
            if (r0 != 0) goto L3d
            boolean r8 = r4.f65919j
            if (r8 == 0) goto L3a
            if (r5 != 0) goto L35
            if (r6 == 0) goto L35
        L33:
            r1 = r7
            goto L43
        L35:
            if (r5 != r7) goto L42
            if (r6 != 0) goto L42
            goto L43
        L3a:
            if (r5 != 0) goto L42
            goto L33
        L3d:
            if (r5 != r7) goto L42
            if (r0 != r2) goto L42
            goto L43
        L42:
            r1 = r5
        L43:
            int r5 = r1 / r3
            if (r0 != 0) goto L51
            boolean r7 = r4.f65919j
            if (r7 == 0) goto L51
            if (r6 != 0) goto L51
            if (r1 == 0) goto L51
            int r5 = r5 + 12
        L51:
            int r6 = r4.getCurrentItemShowing()
            if (r6 != 0) goto L62
            com.borax12.materialdaterangepicker.time.RadialTextsView r6 = r4.f65924o
            r6.setSelection(r5)
            com.borax12.materialdaterangepicker.time.RadialTextsView r6 = r4.f65924o
            r6.invalidate()
            return r5
        L62:
            int r6 = r4.getCurrentItemShowing()
            if (r6 != r2) goto L72
            com.borax12.materialdaterangepicker.time.RadialTextsView r6 = r4.f65925p
            r6.setSelection(r5)
            com.borax12.materialdaterangepicker.time.RadialTextsView r6 = r4.f65925p
            r6.invalidate()
        L72:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.borax12.materialdaterangepicker.time.RadialPickerLayout.l(int, boolean, boolean, boolean):int");
    }

    private void n(int i3, int i4) {
        if (i3 == 0) {
            q(0, i4);
            this.f65926q.c((i4 % 12) * 30, j(i4), false);
            this.f65926q.invalidate();
            this.f65924o.setSelection(i4);
            this.f65924o.invalidate();
            return;
        }
        if (i3 == 1) {
            q(1, i4);
            this.f65927r.c(i4 * 6, false, false);
            this.f65927r.invalidate();
            this.f65925p.setSelection(i4);
            this.f65924o.invalidate();
        }
    }

    private void q(int i3, int i4) {
        if (i3 == 0) {
            this.f65917h = i4;
            return;
        }
        if (i3 == 1) {
            this.f65918i = i4;
            return;
        }
        if (i3 == 2) {
            if (i4 == 0) {
                this.f65917h %= 12;
            } else if (i4 == 1) {
                this.f65917h = (this.f65917h % 12) + 12;
            }
        }
    }

    private static int r(int i3, int i4) {
        int i5 = (i3 / 30) * 30;
        int i6 = i5 + 30;
        if (i4 != 1) {
            if (i4 == -1) {
                if (i3 == i5) {
                    return i5 - 30;
                }
            } else if (i3 - i5 < i6 - i3) {
            }
            return i5;
        }
        return i6;
    }

    private int s(int i3) {
        int[] iArr = this.f65929t;
        if (iArr == null) {
            return -1;
        }
        return iArr[i3];
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        accessibilityEvent.getText().clear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(10, getHours());
        calendar.set(12, getMinutes());
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), calendar.getTimeInMillis(), this.f65919j ? 129 : 1));
        return true;
    }

    public int getCurrentItemShowing() {
        int i3 = this.f65921l;
        if (i3 == 0 || i3 == 1) {
            return i3;
        }
        Log.e("RadialPickerLayout", "Current item showing was unfortunately set to " + this.f65921l);
        return -1;
    }

    public int getHours() {
        return this.f65917h;
    }

    public int getIsCurrentlyAmOrPm() {
        int i3 = this.f65917h;
        if (i3 < 12) {
            return 0;
        }
        return i3 < 24 ? 1 : -1;
    }

    public int getMinutes() {
        return this.f65918i;
    }

    public void m(int i3, boolean z2) {
        if (i3 != 0 && i3 != 1) {
            Log.e("RadialPickerLayout", "TimePicker does not support view at index " + i3);
            return;
        }
        int currentItemShowing = getCurrentItemShowing();
        this.f65921l = i3;
        if (!z2 || i3 == currentItemShowing) {
            int i4 = i3 == 0 ? 255 : 0;
            int i5 = i3 == 1 ? 255 : 0;
            float f3 = i4;
            this.f65924o.setAlpha(f3);
            this.f65926q.setAlpha(f3);
            float f4 = i5;
            this.f65925p.setAlpha(f4);
            this.f65927r.setAlpha(f4);
            return;
        }
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[4];
        if (i3 == 1) {
            objectAnimatorArr[0] = this.f65924o.getDisappearAnimator();
            objectAnimatorArr[1] = this.f65926q.getDisappearAnimator();
            objectAnimatorArr[2] = this.f65925p.getReappearAnimator();
            objectAnimatorArr[3] = this.f65927r.getReappearAnimator();
        } else if (i3 == 0) {
            objectAnimatorArr[0] = this.f65924o.getReappearAnimator();
            objectAnimatorArr[1] = this.f65926q.getReappearAnimator();
            objectAnimatorArr[2] = this.f65925p.getDisappearAnimator();
            objectAnimatorArr[3] = this.f65927r.getDisappearAnimator();
        }
        AnimatorSet animatorSet = this.C;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.C.end();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.C = animatorSet2;
        animatorSet2.playTogether(objectAnimatorArr);
        this.C.start();
    }

    public void o(Context context, boolean z2) {
        this.f65922m.b(context, z2);
        this.f65923n.c(context, z2);
        this.f65924o.e(context, z2);
        this.f65925p.e(context, z2);
        this.f65926q.d(context, z2);
        this.f65927r.d(context, z2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.borax12.materialdaterangepicker.time.RadialPickerLayout.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void p(int i3, int i4) {
        n(0, i3);
        n(1, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0051  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performAccessibilityAction(int r5, android.os.Bundle r6) {
        /*
            r4 = this;
            boolean r6 = super.performAccessibilityAction(r5, r6)
            r0 = 1
            if (r6 == 0) goto L8
            return r0
        L8:
            r6 = 4096(0x1000, float:5.74E-42)
            r1 = 0
            if (r5 != r6) goto Lf
            r5 = r0
            goto L16
        Lf:
            r6 = 8192(0x2000, float:1.148E-41)
            if (r5 != r6) goto L15
            r5 = -1
            goto L16
        L15:
            r5 = r1
        L16:
            if (r5 == 0) goto L55
            int r6 = r4.getCurrentlyShowingValue()
            int r2 = r4.getCurrentItemShowing()
            if (r2 != 0) goto L27
            int r6 = r6 % 12
            r3 = 30
            goto L2c
        L27:
            if (r2 != r0) goto L2b
            r3 = 6
            goto L2c
        L2b:
            r3 = r1
        L2c:
            int r6 = r6 * r3
            int r5 = r(r6, r5)
            int r5 = r5 / r3
            if (r2 != 0) goto L40
            boolean r6 = r4.f65919j
            if (r6 == 0) goto L3c
            r6 = 23
        L3a:
            r3 = r1
            goto L43
        L3c:
            r6 = 12
            r3 = r0
            goto L43
        L40:
            r6 = 55
            goto L3a
        L43:
            if (r5 <= r6) goto L47
            r5 = r3
            goto L4a
        L47:
            if (r5 >= r3) goto L4a
            r5 = r6
        L4a:
            r4.n(r2, r5)
            com.borax12.materialdaterangepicker.time.RadialPickerLayout$OnValueSelectedListener r6 = r4.f65915f
            if (r6 == 0) goto L54
            r6.f(r2, r5, r1)
        L54:
            return r0
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.borax12.materialdaterangepicker.time.RadialPickerLayout.performAccessibilityAction(int, android.os.Bundle):boolean");
    }

    public void setAccentColor(int i3) {
        this.f65926q.setAccentColor(i3);
        this.f65927r.setAccentColor(i3);
        this.f65923n.setAccentColor(i3);
        this.f65922m.setAccentColor(i3);
    }

    public void setAmOrPm(int i3) {
        this.f65923n.setAmOrPm(i3);
        this.f65923n.invalidate();
        q(2, i3);
    }

    public void setOnValueSelectedListener(OnValueSelectedListener onValueSelectedListener) {
        this.f65915f = onValueSelectedListener;
    }

    public boolean t(boolean z2) {
        if (this.f65933x && !z2) {
            return false;
        }
        this.f65930u = z2;
        this.f65928s.setVisibility(z2 ? 4 : 0);
        return true;
    }

    public void i(Context context, TimePickerDialog timePickerDialog, int i3, int i4, boolean z2) {
        if (this.f65916g) {
            Log.e("RadialPickerLayout", "Time has already been initialized.");
            return;
        }
        this.f65914d = timePickerDialog;
        this.f65919j = z2;
        boolean z3 = this.B.isTouchExplorationEnabled() || this.f65919j;
        this.f65920k = z3;
        this.f65922m.a(context, z3);
        this.f65922m.invalidate();
        if (!this.f65920k) {
            this.f65923n.b(context, i3 < 12 ? 0 : 1);
            this.f65923n.invalidate();
        }
        Resources resources = context.getResources();
        int[] iArr = {12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] iArr2 = {0, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] iArr3 = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
        String[] strArr = new String[12];
        String[] strArr2 = new String[12];
        String[] strArr3 = new String[12];
        int i5 = 0;
        for (int i6 = 12; i5 < i6; i6 = 12) {
            String str = HcgZcEUYo.VhN;
            strArr[i5] = z2 ? String.format("%02d", Integer.valueOf(iArr2[i5])) : String.format(str, Integer.valueOf(iArr[i5]));
            strArr2[i5] = String.format(str, Integer.valueOf(iArr[i5]));
            strArr3[i5] = String.format("%02d", Integer.valueOf(iArr3[i5]));
            i5++;
        }
        RadialTextsView radialTextsView = this.f65924o;
        if (!z2) {
            strArr2 = null;
        }
        radialTextsView.c(resources, strArr, strArr2, this.f65920k, true);
        this.f65924o.setSelection(z2 ? i3 : iArr[i3 % 12]);
        this.f65924o.invalidate();
        this.f65925p.c(resources, strArr3, null, this.f65920k, false);
        this.f65925p.setSelection(i4);
        this.f65925p.invalidate();
        q(0, i3);
        q(1, i4);
        this.f65926q.b(context, this.f65920k, z2, true, (i3 % 12) * 30, j(i3));
        this.f65927r.b(context, this.f65920k, false, false, i4 * 6, false);
        this.f65916g = true;
    }
}
