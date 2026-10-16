package com.applovin.impl.adview;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.e;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class g extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f58351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f58352b;

    public g(e.a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        e eVarA = e.a(aVar, activity);
        this.f58351a = eVarA;
        addView(eVarA);
    }

    public void a(e.a aVar) {
        if (aVar == null || aVar == this.f58351a.getStyle()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f58351a.getLayoutParams();
        removeView(this.f58351a);
        e eVarA = e.a(aVar, getContext());
        this.f58351a = eVarA;
        addView(eVarA);
        this.f58351a.setLayoutParams(layoutParams);
        this.f58351a.a(this.f58352b);
    }

    public void a(int i3, int i4, int i5, int i6) {
        this.f58352b = i3;
        int i7 = i4 + i3 + i5;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i7;
            layoutParams.width = i7;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i7, i7));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i3, i6);
        layoutParams2.setMargins(i5, i5, i5, 0);
        this.f58351a.setLayoutParams(layoutParams2);
        this.f58351a.a(i3);
    }
}
