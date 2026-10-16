package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapd implements zzanl {
    private final zzet zza = new zzet();
    private final zzaou zzb = new zzaou();

    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i3, int i4, zzank zzankVar, zzdt zzdtVar) {
        zzet zzetVar = this.zza;
        zzetVar.zzb(bArr, i4 + i3);
        zzetVar.zzh(i3);
        ArrayList arrayList = new ArrayList();
        try {
            int iZzg = zzetVar.zzg();
            Charset charset = StandardCharsets.UTF_8;
            String strZzN = zzetVar.zzN(charset);
            if (strZzN == null || !strZzN.startsWith("WEBVTT")) {
                zzetVar.zzh(iZzg);
                throw zzat.zzb("Expected WEBVTT. Got ".concat(String.valueOf(zzetVar.zzN(charset))), null);
            }
            while (!TextUtils.isEmpty(zzetVar.zzN(StandardCharsets.UTF_8))) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                byte b3 = -1;
                int iZzg2 = 0;
                while (b3 == -1) {
                    iZzg2 = zzetVar.zzg();
                    String strZzN2 = zzetVar.zzN(StandardCharsets.UTF_8);
                    b3 = strZzN2 == null ? (byte) 0 : "STYLE".equals(strZzN2) ? (byte) 2 : strZzN2.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                }
                zzetVar.zzh(iZzg2);
                if (b3 == 0) {
                    zzanf.zza(new zzapg(arrayList2), zzankVar, zzdtVar);
                    return;
                }
                if (b3 == 1) {
                    while (!TextUtils.isEmpty(zzetVar.zzN(StandardCharsets.UTF_8))) {
                    }
                } else if (b3 != 2) {
                    zzaow zzaowVarZza = zzapc.zza(zzetVar, arrayList);
                    if (zzaowVarZza != null) {
                        arrayList2.add(zzaowVarZza);
                    }
                } else {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    zzetVar.zzN(StandardCharsets.UTF_8);
                    arrayList.addAll(this.zzb.zza(zzetVar));
                }
            }
        } catch (zzat e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
