package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaot implements zzanl {
    private final zzet zza = new zzet();

    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i3, int i4, zzank zzankVar, zzdt zzdtVar) {
        zzcx zzcxVarZzr;
        zzet zzetVar = this.zza;
        zzetVar.zzb(bArr, i4 + i3);
        zzetVar.zzh(i3);
        ArrayList arrayList = new ArrayList();
        while (zzetVar.zzd() > 0) {
            zzgtj.zzb(zzetVar.zzd() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int iZzB = zzetVar.zzB() - 8;
            if (zzetVar.zzB() == 1987343459) {
                CharSequence charSequenceZzc = null;
                zzcw zzcwVarZzb = null;
                while (iZzB > 0) {
                    zzgtj.zzb(iZzB >= 8, "Incomplete vtt cue box header found.");
                    int iZzB2 = zzetVar.zzB();
                    int iZzB3 = zzetVar.zzB();
                    int i5 = iZzB - 8;
                    int i6 = iZzB2 - 8;
                    String strZzk = zzfl.zzk(zzetVar.zzi(), zzetVar.zzg(), i6);
                    zzetVar.zzk(i6);
                    if (iZzB3 == 1937011815) {
                        zzcwVarZzb = zzapc.zzb(strZzk);
                    } else if (iZzB3 == 1885436268) {
                        charSequenceZzc = zzapc.zzc(null, strZzk.trim(), Collections.EMPTY_LIST);
                    }
                    iZzB = i5 - i6;
                }
                if (charSequenceZzc == null) {
                    charSequenceZzc = "";
                }
                if (zzcwVarZzb != null) {
                    zzcwVarZzb.zza(charSequenceZzc);
                    zzcxVarZzr = zzcwVarZzb.zzr();
                } else {
                    Pattern pattern = zzapc.zza;
                    zzapb zzapbVar = new zzapb();
                    zzapbVar.zzc = charSequenceZzc;
                    zzcxVarZzr = zzapbVar.zza().zzr();
                }
                arrayList.add(zzcxVarZzr);
            } else {
                zzetVar.zzk(iZzB);
            }
        }
        zzdtVar.zza(new zzand(arrayList, -9223372036854775807L, -9223372036854775807L));
    }
}
