package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaq implements PendingResultUtil.ResultConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Response f72068a;

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* bridge */ /* synthetic */ Object a(Result result) {
        this.f72068a.b(result);
        return this.f72068a;
    }
}
