package com.google.android.gms.ads.preload;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzch;
import com.google.android.gms.ads.internal.util.client.zzo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final zzch f70820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdFormat f70821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f70822c;

    protected zzb(Context context, AdFormat adFormat) {
        this.f70820a = com.google.android.gms.ads.zzb.a(context);
        this.f70822c = context.getApplicationContext();
        this.f70821b = adFormat;
    }

    public final void a() {
        try {
            this.f70820a.zzv(this.f70821b.b());
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
        }
    }
}
