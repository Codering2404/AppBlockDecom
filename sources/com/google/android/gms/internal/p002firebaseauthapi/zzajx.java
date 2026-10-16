package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzajx implements Comparator<zzajv> {
    zzajx() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzajv zzajvVar, zzajv zzajvVar2) {
        zzajv zzajvVar3 = zzajvVar;
        zzajv zzajvVar4 = zzajvVar2;
        zzakb zzakbVar = (zzakb) zzajvVar3.iterator();
        zzakb zzakbVar2 = (zzakb) zzajvVar4.iterator();
        while (zzakbVar.hasNext() && zzakbVar2.hasNext()) {
            int iCompare = Integer.compare(zzajv.zza(zzakbVar.zza()), zzajv.zza(zzakbVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzajvVar3.zzb(), zzajvVar4.zzb());
    }
}
