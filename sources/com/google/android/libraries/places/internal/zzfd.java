package com.google.android.libraries.places.internal;

import android.util.Log;
import com.google.common.util.concurrent.FutureCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzfd implements FutureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzfe f77809a;

    zzfd(zzfe zzfeVar) {
        this.f77809a = zzfeVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Log.w("ZBCC", "Failed to get session", throwable);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        zzbhg response = (zzbhg) obj;
        Intrinsics.checkNotNullParameter(response, "response");
        String strG = response.G();
        Intrinsics.checkNotNullExpressionValue(strG, "getValidatedNidCookie(...)");
        if (strG.length() > 0) {
            zzex zzexVar = this.f77809a.f77812c;
            String strG2 = response.G();
            Intrinsics.checkNotNullExpressionValue(strG2, "getValidatedNidCookie(...)");
            zzexVar.b(strG2);
        }
    }
}
