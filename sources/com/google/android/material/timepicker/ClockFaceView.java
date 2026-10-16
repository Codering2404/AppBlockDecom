package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ClockHandView f82412d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f82413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RectF f82414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f82415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SparseArray f82416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AccessibilityDelegateCompat f82417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f82418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float[] f82419l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f82420m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f82421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f82422o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f82423p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String[] f82424q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f82425r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ColorStateList f82426s;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Q);
    }

    private RadialGradient B(RectF rectF, TextView textView) {
        textView.getHitRect(this.f82413f);
        this.f82414g.set(this.f82413f);
        textView.getLineBounds(0, this.f82415h);
        RectF rectF2 = this.f82414g;
        Rect rect = this.f82415h;
        rectF2.inset(rect.left, rect.top);
        if (RectF.intersects(rectF, this.f82414g)) {
            return new RadialGradient(rectF.centerX() - this.f82414g.left, rectF.centerY() - this.f82414g.top, rectF.width() * 0.5f, this.f82418k, this.f82419l, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private TextView C(RectF rectF) {
        float f3 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i3 = 0; i3 < this.f82416i.size(); i3++) {
            TextView textView2 = (TextView) this.f82416i.get(i3);
            if (textView2 != null) {
                textView2.getHitRect(this.f82413f);
                this.f82414g.set(this.f82413f);
                this.f82414g.union(rectF);
                float fWidth = this.f82414g.width() * this.f82414g.height();
                if (fWidth < f3) {
                    textView = textView2;
                    f3 = fWidth;
                }
            }
        }
        return textView;
    }

    private static float D(float f3, float f4, float f5) {
        return Math.max(Math.max(f3, f4), f5);
    }

    private void G(int i3) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f82416i.size();
        boolean z2 = false;
        for (int i4 = 0; i4 < Math.max(this.f82424q.length, size); i4++) {
            TextView textView = (TextView) this.f82416i.get(i4);
            if (i4 >= this.f82424q.length) {
                removeView(textView);
                this.f82416i.remove(i4);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.f79683n, (ViewGroup) this, false);
                    this.f82416i.put(i4, textView);
                    addView(textView);
                }
                textView.setText(this.f82424q[i4]);
                textView.setTag(R.id.D, Integer.valueOf(i4));
                int i5 = (i4 / 12) + 1;
                textView.setTag(R.id.f79650p, Integer.valueOf(i5));
                if (i5 > 1) {
                    z2 = true;
                }
                ViewCompat.m0(textView, this.f82417j);
                textView.setTextColor(this.f82426s);
                if (i3 != 0) {
                    textView.setContentDescription(getResources().getString(i3, this.f82424q[i4]));
                }
            }
        }
        this.f82412d.s(z2);
    }

    private void z() {
        RectF rectFF = this.f82412d.f();
        TextView textViewC = C(rectFF);
        for (int i3 = 0; i3 < this.f82416i.size(); i3++) {
            TextView textView = (TextView) this.f82416i.get(i3);
            if (textView != null) {
                textView.setSelected(textView == textViewC);
                textView.getPaint().setShader(B(rectFF, textView));
                textView.invalidate();
            }
        }
    }

    int A() {
        return this.f82412d.e();
    }

    void E(int i3) {
        this.f82412d.o(i3);
    }

    public void F(String[] strArr, int i3) {
        this.f82424q = strArr;
        G(i3);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void e(float f3, boolean z2) {
        if (Math.abs(this.f82425r - f3) > 0.001f) {
            this.f82425r = f3;
            z();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo).k0(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(1, this.f82424q.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        z();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iD = (int) (this.f82423p / D(this.f82421n / displayMetrics.heightPixels, this.f82422o / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iD, 1073741824);
        setMeasuredDimension(iD, iD);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void r(int i3) {
        if (i3 != q()) {
            super.r(i3);
            this.f82412d.n(q());
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    protected void t() {
        super.t();
        for (int i3 = 0; i3 < this.f82416i.size(); i3++) {
            ((TextView) this.f82416i.get(i3)).setVisibility(0);
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82413f = new Rect();
        this.f82414g = new RectF();
        this.f82415h = new Rect();
        this.f82416i = new SparseArray();
        this.f82419l = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.S1, i3, R.style.U);
        Resources resources = getResources();
        ColorStateList colorStateListA = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.U1);
        this.f82426s = colorStateListA;
        LayoutInflater.from(context).inflate(R.layout.f79684o, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.f79648o);
        this.f82412d = clockHandView;
        this.f82420m = resources.getDimensionPixelSize(R.dimen.M);
        int colorForState = colorStateListA.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.f82418k = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AppCompatResources.a(context, R.color.V).getDefaultColor();
        ColorStateList colorStateListA2 = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.T1);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.timepicker.ClockFaceView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (!ClockFaceView.this.isShown()) {
                    return true;
                }
                ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                ClockFaceView.this.r(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f82412d.j()) - ClockFaceView.this.f82420m);
                return true;
            }
        });
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f82417j = new AccessibilityDelegateCompat() { // from class: com.google.android.material.timepicker.ClockFaceView.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                int iIntValue = ((Integer) view.getTag(R.id.D)).intValue();
                if (iIntValue > 0) {
                    accessibilityNodeInfoCompat.S0((View) ClockFaceView.this.f82416i.get(iIntValue - 1));
                }
                accessibilityNodeInfoCompat.l0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, iIntValue, 1, false, view.isSelected()));
                accessibilityNodeInfoCompat.j0(true);
                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f34572i);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean j(View view, int i4, Bundle bundle) {
                if (i4 != 16) {
                    return super.j(view, i4, bundle);
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                view.getHitRect(ClockFaceView.this.f82413f);
                float fCenterX = ClockFaceView.this.f82413f.centerX();
                float fCenterY = ClockFaceView.this.f82413f.centerY();
                ClockFaceView.this.f82412d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
                ClockFaceView.this.f82412d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
                return true;
            }
        };
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        F(strArr, 0);
        this.f82421n = resources.getDimensionPixelSize(R.dimen.Z);
        this.f82422o = resources.getDimensionPixelSize(R.dimen.f79555a0);
        this.f82423p = resources.getDimensionPixelSize(R.dimen.O);
    }
}
