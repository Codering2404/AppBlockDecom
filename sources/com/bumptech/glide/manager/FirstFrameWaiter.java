package com.bumptech.glide.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class FirstFrameWaiter implements FrameWaiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set f67023a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f67024b;

    FirstFrameWaiter() {
    }

    static void b(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }

    @Override // com.bumptech.glide.manager.FrameWaiter
    public void a(Activity activity) {
        if (!this.f67024b && this.f67023a.add(activity)) {
            final View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() { // from class: com.bumptech.glide.manager.FirstFrameWaiter.1
                @Override // android.view.ViewTreeObserver.OnDrawListener
                public void onDraw() {
                    Util.x(new Runnable() { // from class: com.bumptech.glide.manager.FirstFrameWaiter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HardwareConfigState.b().h();
                            FirstFrameWaiter.this.f67024b = true;
                            FirstFrameWaiter.b(decorView, this);
                            FirstFrameWaiter.this.f67023a.clear();
                        }
                    });
                }
            });
        }
    }
}
