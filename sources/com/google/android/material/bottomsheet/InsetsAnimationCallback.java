package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimationUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class InsetsAnimationCallback extends WindowInsetsAnimationCompat.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f80228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f80229d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f80230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f80231g;

    public InsetsAnimationCallback(View view) {
        super(0);
        this.f80231g = new int[2];
        this.f80228c = view;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void c(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f80228c.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void d(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f80228c.getLocationOnScreen(this.f80231g);
        this.f80229d = this.f80231g[1];
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((WindowInsetsAnimationCompat) it.next()).c() & WindowInsetsCompat.Type.d()) != 0) {
                this.f80228c.setTranslationY(AnimationUtils.c(this.f80230f, 0, r0.b()));
                break;
            }
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat f(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        this.f80228c.getLocationOnScreen(this.f80231g);
        int i3 = this.f80229d - this.f80231g[1];
        this.f80230f = i3;
        this.f80228c.setTranslationY(i3);
        return boundsCompat;
    }
}
