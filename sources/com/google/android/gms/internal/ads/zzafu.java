package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafu implements zzage {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    private static final zzaft zzc = new zzaft(zzafr.zza);
    private static final zzaft zzd = new zzaft(zzafq.zza);
    private zzgwm zze;
    private final zzanj zzf = new zzane();

    private final void zzc(int i3, List list) {
        switch (i3) {
            case 0:
                list.add(new zzapi());
                break;
            case 1:
                list.add(new zzapl());
                break;
            case 2:
                list.add(new zzapo(0));
                break;
            case 3:
                list.add(new zzahp(0));
                break;
            case 4:
                zzafy zzafyVarZza = zzc.zza(0);
                if (zzafyVarZza == null) {
                    list.add(new zzaig(0));
                } else {
                    list.add(zzafyVarZza);
                }
                break;
            case 5:
                list.add(new zzaij());
                break;
            case 6:
                list.add(new zzakh(this.zzf, 0));
                break;
            case 7:
                list.add(new zzakp(0));
                break;
            case 8:
                zzanj zzanjVar = this.zzf;
                list.add(new zzalr(zzanjVar, 704, null, null, zzgwm.zzi(), null));
                list.add(new zzamc(zzanjVar, 160));
                break;
            case 9:
                list.add(new zzams());
                break;
            case 10:
                list.add(new zzaqs());
                break;
            case 11:
                if (this.zze == null) {
                    this.zze = zzgwm.zzi();
                }
                list.add(new zzard(1, 0, this.zzf, new zzfi(0L), new zzapq(0, this.zze), 112800));
                break;
            case 12:
                list.add(new zzarq());
                break;
            case 14:
                list.add(new zzaiq(0));
                break;
            case 15:
                zzafy zzafyVarZza2 = zzd.zza(new Object[0]);
                if (zzafyVarZza2 != null) {
                    list.add(zzafyVarZza2);
                }
                break;
            case 16:
                list.add(new zzaht(0, this.zzf));
                break;
            case 17:
                list.add(new zzanc());
                break;
            case 18:
                list.add(new zzarv());
                break;
            case 19:
                list.add(new zzaib());
                break;
            case 20:
                list.add(new zzaip(0));
                break;
            case 21:
                list.add(new zzaia());
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final synchronized zzafy[] zza() {
        return zzb(Uri.EMPTY, new HashMap());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    @Override // com.google.android.gms.internal.ads.zzage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.google.android.gms.internal.ads.zzafy[] zzb(android.net.Uri r24, java.util.Map r25) {
        /*
            Method dump skipped, instruction units count: 1028
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafu.zzb(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzafy[]");
    }
}
