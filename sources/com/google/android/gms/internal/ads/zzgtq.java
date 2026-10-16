package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgtq extends zzgtw {
    final /* synthetic */ zzgsy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgtq(zzgty zzgtyVar, CharSequence charSequence, zzgsy zzgsyVar) {
        super(zzgtyVar, charSequence);
        this.zza = zzgsyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzc(int i3) {
        Matcher matcher = ((zzgtb) this.zza).zza;
        if (matcher.find(i3)) {
            return matcher.start();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzd(int i3) {
        return ((zzgtb) this.zza).zza.end();
    }
}
