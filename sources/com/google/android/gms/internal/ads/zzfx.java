package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfx extends zzfz {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzfx(int i3, long j3) {
        super(i3, null);
        this.zza = j3;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final String toString() {
        List list = this.zzb;
        String strZze = zzfz.zze(this.zzd);
        String string = Arrays.toString(list.toArray());
        String string2 = Arrays.toString(this.zzc.toArray());
        int length = strZze.length();
        StringBuilder sb = new StringBuilder(length + 9 + String.valueOf(string).length() + 13 + String.valueOf(string2).length());
        sb.append(strZze);
        sb.append(" leaves: ");
        sb.append(string);
        sb.append(" containers: ");
        sb.append(string2);
        return sb.toString();
    }

    public final void zza(zzfy zzfyVar) {
        this.zzb.add(zzfyVar);
    }

    public final void zzb(zzfx zzfxVar) {
        this.zzc.add(zzfxVar);
    }

    public final zzfy zzc(int i3) {
        List list = this.zzb;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            zzfy zzfyVar = (zzfy) list.get(i4);
            if (zzfyVar.zzd == i3) {
                return zzfyVar;
            }
        }
        return null;
    }

    public final zzfx zzd(int i3) {
        List list = this.zzc;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            zzfx zzfxVar = (zzfx) list.get(i4);
            if (zzfxVar.zzd == i3) {
                return zzfxVar;
            }
        }
        return null;
    }
}
