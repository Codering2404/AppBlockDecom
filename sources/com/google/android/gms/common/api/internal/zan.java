package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zan extends zabw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Dialog f71852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zao f71853b;

    zan(zao zaoVar, Dialog dialog) {
        this.f71853b = zaoVar;
        this.f71852a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void a() {
        this.f71853b.f71855b.d();
        if (this.f71852a.isShowing()) {
            this.f71852a.dismiss();
        }
    }
}
