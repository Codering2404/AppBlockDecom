package com.google.android.libraries.places.internal;

import android.content.Context;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzjp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzblw f78027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f78028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbgv f78029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ScheduledExecutorService f78030d = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f78031e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Long f78032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    zzbfw f78033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f78034h;

    zzjp(Context context, zzblw zzblwVar) {
        this.f78028b = context;
        this.f78027a = zzblwVar;
        this.f78029c = zzbgw.c(zzblwVar);
    }

    public final ListenableFuture a() {
        zzbfw zzbfwVar = this.f78033g;
        if (zzbfwVar == null || zzbfwVar.G() < Instant.now().getEpochSecond()) {
            return Futures.h(b(), new Function() { // from class: com.google.android.libraries.places.internal.zzjo
                @Override // com.google.common.base.Function
                public final /* synthetic */ Object apply(Object obj) {
                    String str = this.f78026a.f78034h;
                    if (str != null) {
                        return str;
                    }
                    throw new IllegalStateException(CbYNFSEGaQj.kzG);
                }
            }, MoreExecutors.a());
        }
        String str = this.f78034h;
        if (str != null) {
            return Futures.f(str);
        }
        throw new IllegalStateException("Signature not generated.");
    }

    public final ListenableFuture b() {
        this.f78031e++;
        Context context = this.f78028b;
        zzbgx zzbgxVarG = zzbgy.G();
        zzbgxVarG.y(context.getPackageName());
        zzbgy zzbgyVar = (zzbgy) zzbgxVarG.zzG();
        zzbgv zzbgvVar = this.f78029c;
        ListenableFuture listenableFutureB = zzcef.b(zzbgvVar.b().d(zzbgw.a(), zzbgvVar.c()), zzbgyVar);
        Futures.a(listenableFutureB, new zzjm(this), MoreExecutors.a());
        return listenableFutureB;
    }

    final String c(long j3) {
        String packageName = this.f78028b.getPackageName();
        int length = packageName.length() + 1;
        long[] jArr = new long[length];
        jArr[0] = j3;
        int i3 = 0;
        while (i3 < packageName.length()) {
            int i4 = i3 + 1;
            jArr[i4] = ((long) packageName.codePointAt(i3)) & 4294967295L;
            i3 = i4;
        }
        long j4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            j4 = ((j4 * 1729) + jArr[i5]) % 131071;
        }
        String strValueOf = String.valueOf(j4);
        this.f78034h = strValueOf;
        return strValueOf;
    }
}
