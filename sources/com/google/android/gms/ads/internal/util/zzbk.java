package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzata;
import com.google.android.gms.internal.ads.zzate;
import com.google.android.gms.internal.ads.zzatk;
import com.google.android.gms.internal.ads.zzaub;
import com.google.android.gms.internal.ads.zzcfw;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbk extends zzate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcfw f70284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.util.client.zzl f70285b;

    public zzbk(String str, Map map, zzcfw zzcfwVar) {
        super(0, str, new zzbj(zzcfwVar));
        this.f70284a = zzcfwVar;
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        this.f70285b = zzlVar;
        zzlVar.b(str, "GET", null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzate
    protected final zzatk zzr(zzata zzataVar) {
        return zzatk.zza(zzataVar, zzaub.zza(zzataVar));
    }

    @Override // com.google.android.gms.internal.ads.zzate
    protected final /* bridge */ /* synthetic */ void zzs(Object obj) {
        zzata zzataVar = (zzata) obj;
        Map map = zzataVar.zzc;
        int i3 = zzataVar.zza;
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = this.f70285b;
        zzlVar.d(map, i3);
        byte[] bArr = zzataVar.zzb;
        if (com.google.android.gms.ads.internal.util.client.zzl.j() && bArr != null) {
            zzlVar.f(bArr);
        }
        this.f70284a.zzc(zzataVar);
    }
}
