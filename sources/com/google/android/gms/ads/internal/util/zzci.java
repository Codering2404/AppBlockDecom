package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.internal.ads.zzcge;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f70322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Activity f70323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f70324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f70325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f70326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f70327f;

    public zzci(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f70323b = activity;
        this.f70322a = view;
        this.f70327f = onGlobalLayoutListener;
    }

    private final void f() {
        if (this.f70324c) {
            return;
        }
        Activity activity = this.f70323b;
        if (activity != null) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f70327f;
            ViewTreeObserver viewTreeObserverH = h(activity);
            if (viewTreeObserverH != null) {
                viewTreeObserverH.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
        View view = this.f70322a;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener2 = this.f70327f;
        com.google.android.gms.ads.internal.zzt.c();
        zzcge.zza(view, onGlobalLayoutListener2);
        this.f70324c = true;
    }

    private final void g() {
        Activity activity = this.f70323b;
        if (activity != null && this.f70324c) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f70327f;
            ViewTreeObserver viewTreeObserverH = h(activity);
            if (viewTreeObserverH != null) {
                viewTreeObserverH.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.f70324c = false;
        }
    }

    private static ViewTreeObserver h(Activity activity) {
        View decorView;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    public final void a(Activity activity) {
        this.f70323b = activity;
    }

    public final void b() {
        this.f70326e = true;
        if (this.f70325d) {
            f();
        }
    }

    public final void c() {
        this.f70326e = false;
        g();
    }

    public final void d() {
        this.f70325d = true;
        if (this.f70326e) {
            f();
        }
    }

    public final void e() {
        this.f70325d = false;
        g();
    }
}
