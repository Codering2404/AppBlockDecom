package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zabv extends zaag {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GoogleApi f71774c;

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final BaseImplementation.ApiMethodImpl g(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        return this.f71774c.doRead(apiMethodImpl);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final BaseImplementation.ApiMethodImpl h(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        return this.f71774c.doWrite(apiMethodImpl);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper k() {
        return this.f71774c.getLooper();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void q(zada zadaVar) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void r(zada zadaVar) {
    }

    public zabv(GoogleApi googleApi) {
        super(bfIdKSjLOVjG.DewlzCPh);
        this.f71774c = googleApi;
    }
}
