package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzi extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzat f70089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f70090b;

    public zzi(Context context, String str, String str2, String str3) {
        super(context);
        zzat zzatVar = new zzat(context, str);
        this.f70089a = zzatVar;
        zzatVar.d(str2);
        zzatVar.c(str3);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f70090b) {
            return false;
        }
        this.f70089a.a(motionEvent);
        return false;
    }
}
