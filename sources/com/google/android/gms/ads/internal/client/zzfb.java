package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzbmb;
import com.google.android.gms.internal.ads.zzbmv;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfb implements MediaContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbmb f69934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VideoController f69935b = new VideoController();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbmv f69936c;

    public zzfb(zzbmb zzbmbVar, zzbmv zzbmvVar) {
        this.f69934a = zzbmbVar;
        this.f69936c = zzbmvVar;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean a() {
        try {
            return this.f69934a.zzk();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return false;
        }
    }

    public final zzbmb b() {
        return this.f69934a;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean zza() {
        try {
            return this.f69934a.zzl();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final zzbmv zzb() {
        return this.f69936c;
    }
}
