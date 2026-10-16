package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzara implements zzaqt {
    final /* synthetic */ zzard zza;
    private final zzes zzb;

    public zzara(zzard zzardVar) {
        Objects.requireNonNull(zzardVar);
        this.zza = zzardVar;
        this.zzb = new zzes(new byte[4], 4);
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zzb(zzet zzetVar) {
        if (zzetVar.zzs() == 0 && (zzetVar.zzs() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            zzetVar.zzk(6);
            int iZzd = zzetVar.zzd() / 4;
            for (int i3 = 0; i3 < iZzd; i3++) {
                zzes zzesVar = this.zzb;
                zzetVar.zzl(zzesVar, 4);
                int iZzj = zzesVar.zzj(16);
                zzesVar.zzh(3);
                if (iZzj == 0) {
                    zzesVar.zzh(13);
                } else {
                    int iZzj2 = zzesVar.zzj(13);
                    zzard zzardVar = this.zza;
                    if (zzardVar.zzj().get(iZzj2) == null) {
                        zzardVar.zzj().put(iZzj2, new zzaqu(new zzarb(zzardVar, iZzj2)));
                        zzardVar.zzo(zzardVar.zzn() + 1);
                    }
                }
            }
            this.zza.zzj().remove(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zza(zzfi zzfiVar, zzagb zzagbVar, zzarh zzarhVar) {
    }
}
