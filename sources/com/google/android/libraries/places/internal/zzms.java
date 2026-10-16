package com.google.android.libraries.places.internal;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzms implements zzbie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbih f78222a;

    private zzms(zzbih zzbihVar) {
        this.f78222a = zzbihVar;
    }

    public static zzms b(zzbih zzbihVar) {
        return new zzms(zzbihVar);
    }

    public static Context c(Context context) {
        Context applicationContext = context.getApplicationContext();
        zzbig.a(applicationContext);
        return applicationContext;
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Context zzb() {
        return c((Context) this.f78222a.zzb());
    }
}
