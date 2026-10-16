package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DataHolderResult implements Result, Releasable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Status f71559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final DataHolder f71560b;

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f71559a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
        DataHolder dataHolder = this.f71560b;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
