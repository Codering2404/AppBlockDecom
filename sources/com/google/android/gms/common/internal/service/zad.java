package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zad extends zaa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder f72033a;

    public zad(BaseImplementation.ResultHolder resultHolder) {
        this.f72033a = resultHolder;
    }

    @Override // com.google.android.gms.common.internal.service.zaa, com.google.android.gms.common.internal.service.zak
    public final void l3(int i3) {
        this.f72033a.setResult(new Status(i3));
    }
}
