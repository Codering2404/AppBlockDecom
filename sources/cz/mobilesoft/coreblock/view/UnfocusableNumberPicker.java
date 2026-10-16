package cz.mobilesoft.coreblock.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import cz.mobilesoft.coreblock.util.view.ViewHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class UnfocusableNumberPicker extends NumberPicker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NumberPicker.Formatter f130070a;

    public UnfocusableNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        getChildAt(0).setVisibility(4);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        ViewHelper.h(view.getContext(), view);
    }

    public int b(String str) {
        Rect rect = new Rect();
        ((EditText) getChildAt(0)).getPaint().getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    public boolean d(int i3) {
        if (this.f130070a == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = b(this.f130070a.format(i3));
        setLayoutParams(layoutParams);
        return true;
    }

    public NumberPicker.Formatter getFormatter() {
        return this.f130070a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setDescendantFocusability(393216);
        setWrapSelectorWheel(false);
    }

    @Override // android.widget.NumberPicker, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.NumberPicker, android.view.View
    public boolean performClick() {
        return false;
    }

    @Override // android.widget.NumberPicker, android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setAlpha(z2 ? 1.0f : 0.35f);
    }

    @Override // android.widget.NumberPicker
    public void setFormatter(NumberPicker.Formatter formatter) {
        super.setFormatter(formatter);
        this.f130070a = formatter;
        post(new Runnable() { // from class: cz.mobilesoft.coreblock.view.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f133457a.c();
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        super.addView(view, i3);
        ViewHelper.h(view.getContext(), view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, int i4) {
        super.addView(view, i3, i4);
        ViewHelper.h(view.getContext(), view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        ViewHelper.h(view.getContext(), view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        ViewHelper.h(view.getContext(), view);
    }
}
