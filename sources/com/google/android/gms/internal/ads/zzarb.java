package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzarb implements zzaqt {
    final /* synthetic */ zzard zza;
    private final zzes zzb;
    private final SparseArray zzc;
    private final SparseIntArray zzd;
    private final int zze;

    public zzarb(zzard zzardVar, int i3) {
        Objects.requireNonNull(zzardVar);
        this.zza = zzardVar;
        this.zzb = new zzes(new byte[5], 5);
        this.zzc = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zze = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zzb(zzet zzetVar) {
        zzard zzardVar;
        int i3;
        zzes zzesVar;
        int i4;
        int i5;
        if (zzetVar.zzs() != 2) {
            return;
        }
        zzard zzardVar2 = this.zza;
        zzfi zzfiVar = (zzfi) zzardVar2.zzh().get(0);
        if ((zzetVar.zzs() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            zzetVar.zzk(1);
            int iZzt = zzetVar.zzt();
            int i6 = 3;
            zzetVar.zzk(3);
            zzes zzesVar2 = this.zzb;
            zzetVar.zzl(zzesVar2, 2);
            zzesVar2.zzh(3);
            int i7 = 13;
            zzardVar2.zzq(zzesVar2.zzj(13));
            zzetVar.zzl(zzesVar2, 2);
            int i8 = 4;
            zzesVar2.zzh(4);
            int i9 = 12;
            zzetVar.zzk(zzesVar2.zzj(12));
            SparseArray sparseArray = this.zzc;
            sparseArray.clear();
            SparseIntArray sparseIntArray = this.zzd;
            sparseIntArray.clear();
            int iZzd = zzetVar.zzd();
            while (iZzd > 0) {
                int i10 = 5;
                zzetVar.zzl(zzesVar2, 5);
                int iZzj = zzesVar2.zzj(8);
                zzesVar2.zzh(i6);
                int iZzj2 = zzesVar2.zzj(i7);
                zzesVar2.zzh(i8);
                int iZzj3 = zzesVar2.zzj(i9);
                int iZzg = zzetVar.zzg();
                int i11 = iZzg + iZzj3;
                String str = null;
                ArrayList arrayList = null;
                int i12 = -1;
                int iZzs = 0;
                while (zzetVar.zzg() < i11) {
                    int iZzs2 = zzetVar.zzs();
                    int iZzg2 = zzetVar.zzg() + zzetVar.zzs();
                    if (iZzg2 > i11) {
                        break;
                    }
                    if (iZzs2 == i10) {
                        long jZzz = zzetVar.zzz();
                        if (jZzz != 1094921523) {
                            if (jZzz != 1161904947) {
                                if (jZzz != 1094921524) {
                                    if (jZzz == 1212503619) {
                                        i5 = 36;
                                        zzardVar = zzardVar2;
                                        i12 = i5;
                                        i3 = iZzg2;
                                        zzesVar = zzesVar2;
                                        i4 = iZzd;
                                    }
                                    zzardVar = zzardVar2;
                                    i3 = iZzg2;
                                    zzesVar = zzesVar2;
                                    i4 = iZzd;
                                }
                                zzardVar = zzardVar2;
                                i3 = iZzg2;
                                zzesVar = zzesVar2;
                                i4 = iZzd;
                                i12 = 172;
                            }
                            zzardVar = zzardVar2;
                            zzesVar = zzesVar2;
                            i4 = iZzd;
                            i12 = 135;
                            i3 = iZzg2;
                        }
                        zzardVar = zzardVar2;
                        i3 = iZzg2;
                        zzesVar = zzesVar2;
                        i4 = iZzd;
                        i12 = 129;
                    } else {
                        if (iZzs2 != 106) {
                            if (iZzs2 == 122) {
                                zzardVar = zzardVar2;
                                zzesVar = zzesVar2;
                                i4 = iZzd;
                                i12 = 135;
                                i3 = iZzg2;
                            } else {
                                if (iZzs2 == 127) {
                                    int iZzs3 = zzetVar.zzs();
                                    if (iZzs3 != 21) {
                                        if (iZzs3 == 14) {
                                            i5 = 136;
                                        } else {
                                            if (iZzs3 == 33) {
                                                i5 = 139;
                                            }
                                            zzardVar = zzardVar2;
                                            i3 = iZzg2;
                                            zzesVar = zzesVar2;
                                            i4 = iZzd;
                                        }
                                    }
                                    zzardVar = zzardVar2;
                                    i3 = iZzg2;
                                    zzesVar = zzesVar2;
                                    i4 = iZzd;
                                    i12 = 172;
                                } else if (iZzs2 == 123) {
                                    i5 = 138;
                                } else if (iZzs2 == 10) {
                                    String strTrim = zzetVar.zzK(3, StandardCharsets.UTF_8).trim();
                                    iZzs = zzetVar.zzs();
                                    zzardVar = zzardVar2;
                                    str = strTrim;
                                    i3 = iZzg2;
                                    zzesVar = zzesVar2;
                                    i4 = iZzd;
                                } else if (iZzs2 == 89) {
                                    ArrayList arrayList2 = new ArrayList();
                                    while (zzetVar.zzg() < iZzg2) {
                                        int i13 = iZzg2;
                                        String strTrim2 = zzetVar.zzK(3, StandardCharsets.UTF_8).trim();
                                        int iZzs4 = zzetVar.zzs();
                                        int i14 = iZzd;
                                        byte[] bArr = new byte[4];
                                        zzetVar.zzm(bArr, 0, 4);
                                        arrayList2.add(new zzare(strTrim2, iZzs4, bArr));
                                        iZzd = i14;
                                        iZzg2 = i13;
                                        zzesVar2 = zzesVar2;
                                        zzardVar2 = zzardVar2;
                                    }
                                    zzardVar = zzardVar2;
                                    i3 = iZzg2;
                                    zzesVar = zzesVar2;
                                    i4 = iZzd;
                                    arrayList = arrayList2;
                                    i12 = 89;
                                } else {
                                    zzardVar = zzardVar2;
                                    i3 = iZzg2;
                                    zzesVar = zzesVar2;
                                    i4 = iZzd;
                                    if (iZzs2 == 111) {
                                        i12 = 257;
                                    }
                                }
                                zzardVar = zzardVar2;
                                i12 = i5;
                                i3 = iZzg2;
                                zzesVar = zzesVar2;
                                i4 = iZzd;
                            }
                        }
                        zzardVar = zzardVar2;
                        i3 = iZzg2;
                        zzesVar = zzesVar2;
                        i4 = iZzd;
                        i12 = 129;
                    }
                    zzetVar.zzk(i3 - zzetVar.zzg());
                    iZzd = i4;
                    zzesVar2 = zzesVar;
                    zzardVar2 = zzardVar;
                    i10 = 5;
                }
                zzard zzardVar3 = zzardVar2;
                zzes zzesVar3 = zzesVar2;
                int i15 = iZzd;
                zzetVar.zzh(i11);
                zzarf zzarfVar = new zzarf(i12, str, iZzs, arrayList, Arrays.copyOfRange(zzetVar.zzi(), iZzg, i11));
                if (iZzj == 6 || iZzj == 5) {
                    iZzj = zzarfVar.zza;
                }
                iZzd = i15 - (iZzj3 + 5);
                if (!zzardVar3.zzk().get(iZzj2)) {
                    zzari zzariVarZzb = zzardVar3.zzi().zzb(iZzj, zzarfVar);
                    sparseIntArray.put(iZzj2, iZzj2);
                    sparseArray.put(iZzj2, zzariVarZzb);
                }
                i8 = 4;
                zzesVar2 = zzesVar3;
                zzardVar2 = zzardVar3;
                i6 = 3;
                i7 = 13;
                i9 = 12;
            }
            zzard zzardVar4 = zzardVar2;
            int size = sparseIntArray.size();
            for (int i16 = 0; i16 < size; i16++) {
                int iKeyAt = sparseIntArray.keyAt(i16);
                int iValueAt = sparseIntArray.valueAt(i16);
                zzardVar4.zzk().put(iKeyAt, true);
                zzardVar4.zzl().put(iValueAt, true);
                zzari zzariVar = (zzari) sparseArray.valueAt(i16);
                if (zzariVar != null) {
                    zzariVar.zza(zzfiVar, zzardVar4.zzm(), new zzarh(iZzt, iKeyAt, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                    zzardVar4.zzj().put(iValueAt, zzariVar);
                }
            }
            zzardVar4.zzj().remove(this.zze);
            zzardVar4.zzo(0);
            if (zzardVar4.zzn() == 0) {
                zzardVar4.zzm().zzv();
                zzardVar4.zzp(true);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zza(zzfi zzfiVar, zzagb zzagbVar, zzarh zzarhVar) {
    }
}
