package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class RadialViewGroup extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f82477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f82478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MaterialShapeDrawable f82479c;

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(context).inflate(R.layout.f79685p, this);
        ViewCompat.q0(this, i());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.h6, i3, 0);
        this.f82478b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.i6, 0);
        this.f82477a = new Runnable() { // from class: com.google.android.material.timepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f82533a.t();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    private void h(List list, ConstraintSet constraintSet, int i3) {
        Iterator it = list.iterator();
        float size = 0.0f;
        while (it.hasNext()) {
            constraintSet.t(((View) it.next()).getId(), R.id.f79624c, i3, size);
            size += 360.0f / list.size();
        }
    }

    private Drawable i() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.f82479c = materialShapeDrawable;
        materialShapeDrawable.Y(new RelativeCornerSize(0.5f));
        this.f82479c.a0(ColorStateList.valueOf(-1));
        return this.f82479c;
    }

    private static boolean s(View view) {
        return "skip".equals(view.getTag());
    }

    private void u() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f82477a);
            handler.post(this.f82477a);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.j());
        }
        u();
    }

    int m(int i3) {
        return i3 == 2 ? Math.round(this.f82478b * 0.66f) : this.f82478b;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        u();
    }

    public int q() {
        return this.f82478b;
    }

    public void r(int i3) {
        this.f82478b = i3;
        t();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.f82479c.a0(ColorStateList.valueOf(i3));
    }

    protected void t() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.o(this);
        HashMap map = new HashMap();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != R.id.f79624c && !s(childAt)) {
                int i4 = (Integer) childAt.getTag(R.id.f79650p);
                if (i4 == null) {
                    i4 = 1;
                }
                if (!map.containsKey(i4)) {
                    map.put(i4, new ArrayList());
                }
                ((List) map.get(i4)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            h((List) entry.getValue(), constraintSet, m(((Integer) entry.getKey()).intValue()));
        }
        constraintSet.i(this);
    }
}
