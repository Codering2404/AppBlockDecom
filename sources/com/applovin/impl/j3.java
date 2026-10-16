package com.applovin.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.applovin.impl.adview.AppLovinWebViewBase;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j3 extends AppLovinWebViewBase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f60597b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f60598a;

    public j3(Context context) {
        super(context);
        this.f60598a = new AtomicReference();
        if (f60597b == null) {
            try {
                WebView.class.getDeclaredMethod("onTouchEvent", MotionEvent.class);
                f60597b = Boolean.TRUE;
            } catch (NoSuchMethodException unused) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "WebView.onTouchEvent() not implemented");
                f60597b = Boolean.FALSE;
            }
        }
    }

    public boolean a() {
        return this.f60598a.get() != null;
    }

    public MotionEvent getAndClearLastClickEvent() {
        return (MotionEvent) this.f60598a.getAndSet(null);
    }

    public MotionEvent getLastClickEvent() {
        return (MotionEvent) this.f60598a.get();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f60598a.set(MotionEvent.obtain(motionEvent));
        if (f60597b.booleanValue()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
