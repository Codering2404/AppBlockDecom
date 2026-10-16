package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapq implements zzarg {
    private final List zza;

    public zzapq(int i3, List list) {
        this.zza = list;
    }

    private final zzaqw zzc(zzarf zzarfVar) {
        return new zzaqw(zze(zzarfVar), "video/mp2t");
    }

    private final zzarl zzd(zzarf zzarfVar) {
        return new zzarl(zze(zzarfVar), "video/mp2t");
    }

    private final List zze(zzarf zzarfVar) {
        String str;
        int i3;
        List listSingletonList;
        zzet zzetVar = new zzet(zzarfVar.zze);
        List arrayList = this.zza;
        while (zzetVar.zzd() > 0) {
            int iZzs = zzetVar.zzs();
            int iZzg = zzetVar.zzg() + zzetVar.zzs();
            if (iZzs == 134) {
                arrayList = new ArrayList();
                int iZzs2 = zzetVar.zzs() & 31;
                for (int i4 = 0; i4 < iZzs2; i4++) {
                    String strZzK = zzetVar.zzK(3, StandardCharsets.UTF_8);
                    int iZzs3 = zzetVar.zzs();
                    boolean z2 = (iZzs3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
                    if (z2) {
                        i3 = iZzs3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i3 = 1;
                    }
                    byte bZzs = (byte) zzetVar.zzs();
                    zzetVar.zzk(1);
                    if (z2) {
                        int i5 = bZzs & 64;
                        int i6 = zzdq.zza;
                        listSingletonList = Collections.singletonList(i5 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzt zztVar = new zzt();
                    zztVar.zzo(str);
                    zztVar.zze(strZzK);
                    zztVar.zzL(i3);
                    zztVar.zzr(listSingletonList);
                    arrayList.add(zztVar.zzO());
                }
            }
            zzetVar.zzh(iZzg);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzarg
    public final SparseArray zza() {
        return new SparseArray();
    }

    @Override // com.google.android.gms.internal.ads.zzarg
    public final zzari zzb(int i3, zzarf zzarfVar) {
        if (i3 != 2) {
            if (i3 == 3 || i3 == 4) {
                return new zzaqm(new zzaqf(zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
            }
            if (i3 == 21) {
                return new zzaqm(new zzaqd("video/mp2t"));
            }
            if (i3 == 27) {
                return new zzaqm(new zzaqa(zzc(zzarfVar), false, false, "video/mp2t"));
            }
            if (i3 == 36) {
                return new zzaqm(new zzaqc(zzc(zzarfVar), "video/mp2t"));
            }
            if (i3 == 45) {
                return new zzaqm(new zzaqg("video/mp2t"));
            }
            if (i3 == 89) {
                return new zzaqm(new zzaps(zzarfVar.zzd, "video/mp2t"));
            }
            if (i3 == 172) {
                return new zzaqm(new zzapm(zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
            }
            if (i3 == 257) {
                return new zzaqu(new zzaql("application/vnd.dvb.ait", "video/mp2t"));
            }
            if (i3 != 128) {
                if (i3 != 129) {
                    if (i3 != 138) {
                        if (i3 == 139) {
                            return new zzaqm(new zzapr(zzarfVar.zzb, zzarfVar.zza(), 5408, "video/mp2t"));
                        }
                        switch (i3) {
                            case 15:
                                return new zzaqm(new zzapp(false, zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
                            case 16:
                                return new zzaqm(new zzapy(zzd(zzarfVar), "video/mp2t"));
                            case 17:
                                return new zzaqm(new zzaqe(zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
                            default:
                                switch (i3) {
                                    case 134:
                                        return new zzaqu(new zzaql("application/x-scte35", "video/mp2t"));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new zzaqm(new zzapr(zzarfVar.zzb, zzarfVar.zza(), 4096, "video/mp2t"));
                }
                return new zzaqm(new zzapj(zzarfVar.zzb, zzarfVar.zza(), "video/mp2t"));
            }
        }
        return new zzaqm(new zzapv(zzd(zzarfVar), "video/mp2t"));
    }

    public zzapq() {
        this(0);
    }

    public zzapq(int i3) {
        this.zza = zzgwm.zzi();
    }
}
