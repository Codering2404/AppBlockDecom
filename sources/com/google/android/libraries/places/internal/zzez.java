package com.google.android.libraries.places.internal;

import com.google.common.cache.LSNn.vfptEEmYY;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzez implements zzasm {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzbmc f77804c = zzbmc.c("Cookie", zzbmg.f76399d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ListenableFuture f77805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzex f77806b;

    public zzez(zzex zwiebackCookieManager) {
        Intrinsics.checkNotNullParameter(zwiebackCookieManager, "zwiebackCookieManager");
        this.f77806b = zwiebackCookieManager;
    }

    @Override // com.google.android.libraries.places.internal.zzasm
    public final zzats b(zzask context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ListenableFuture listenableFutureA = this.f77806b.a();
        this.f77805a = listenableFutureA;
        zzats zzatsVarB = zzats.b(listenableFutureA);
        Intrinsics.checkNotNullExpressionValue(zzatsVarB, "continueAfter(...)");
        return zzatsVarB;
    }

    @Override // com.google.android.libraries.places.internal.zzasm
    public final zzats a(zzask context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = vfptEEmYY.gDIIeGGsxh;
        ListenableFuture listenableFuture = this.f77805a;
        if (listenableFuture == null) {
            zzats zzatsVarA = zzats.a();
            Intrinsics.checkNotNullExpressionValue(zzatsVarA, "proceed(...)");
            return zzatsVarA;
        }
        try {
            Intrinsics.checkNotNull(listenableFuture);
            Object objC = Futures.c(listenableFuture);
            Intrinsics.checkNotNullExpressionValue(objC, "getDone(...)");
            String str2 = (String) objC;
            if (!Intrinsics.areEqual(str2, "")) {
                zzbmg zzbmgVarB = context.b();
                zzbmc zzbmcVar = f77804c;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4);
                sb.append(str);
                sb.append(str2);
                zzbmgVarB.c(zzbmcVar, sb.toString());
            }
        } catch (Exception unused) {
        }
        zzats zzatsVarA2 = zzats.a();
        Intrinsics.checkNotNullExpressionValue(zzatsVarA2, "proceed(...)");
        return zzatsVarA2;
    }
}
