package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zad extends zag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f72043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f72044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f72045c;

    zad(Intent intent, Activity activity, int i3) {
        this.f72043a = intent;
        this.f72044b = activity;
        this.f72045c = i3;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void a() {
        Intent intent = this.f72043a;
        if (intent != null) {
            this.f72044b.startActivityForResult(intent, this.f72045c);
        }
    }
}
