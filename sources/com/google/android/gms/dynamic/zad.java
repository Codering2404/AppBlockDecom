package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zad implements zah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FrameLayout f72386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LayoutInflater f72387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ViewGroup f72388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f72389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f72390e;

    zad(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f72390e = deferredLifecycleHelper;
        this.f72386a = frameLayout;
        this.f72387b = layoutInflater;
        this.f72388c = viewGroup;
        this.f72389d = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int a() {
        return 2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void b(LifecycleDelegate lifecycleDelegate) {
        this.f72386a.removeAllViews();
        this.f72386a.addView(this.f72390e.f72372a.f(this.f72387b, this.f72388c, this.f72389d));
    }
}
