package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StatusCallback extends IStatusCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder f71614a;

    public StatusCallback(BaseImplementation.ResultHolder resultHolder) {
        this.f71614a = resultHolder;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public void onResult(Status status) {
        this.f71614a.setResult(status);
    }
}
