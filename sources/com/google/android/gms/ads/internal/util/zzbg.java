package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzati;
import com.google.android.gms.internal.ads.zzatn;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbg implements zzati {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f70278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbi f70279b;

    zzbg(zzbl zzblVar, String str, zzbi zzbiVar) {
        this.f70278a = str;
        this.f70279b = zzbiVar;
        Objects.requireNonNull(zzblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzati
    public final void zza(zzatn zzatnVar) {
        String str = this.f70278a;
        String string = zzatnVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(string).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(string);
        String string2 = sb.toString();
        int i3 = zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f(string2);
        this.f70279b.zza((Object) null);
    }
}
