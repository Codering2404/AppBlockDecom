package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzany {
    private final zzet zza = new zzet();
    private final int[] zzb = new int[Function.MAX_NARGS];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    public final zzcx zza() {
        int i3;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzet zzetVar = this.zza;
        if (zzetVar.zze() == 0 || zzetVar.zzg() != zzetVar.zze() || !this.zzc) {
            return null;
        }
        zzetVar.zzh(0);
        int i4 = this.zzh * this.zzi;
        int[] iArr = new int[i4];
        int i5 = 0;
        while (i5 < i4) {
            int iZzs = zzetVar.zzs();
            if (iZzs != 0) {
                i3 = i5 + 1;
                iArr[i5] = this.zzb[iZzs];
            } else {
                int iZzs2 = zzetVar.zzs();
                if (iZzs2 != 0) {
                    int iZzs3 = iZzs2 & 63;
                    if ((iZzs2 & 64) != 0) {
                        iZzs3 = (iZzs3 << 8) | zzetVar.zzs();
                    }
                    i3 = iZzs3 + i5;
                    Arrays.fill(iArr, i5, i3, (iZzs2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0 ? this.zzb[0] : this.zzb[zzetVar.zzs()]);
                }
            }
            i5 = i3;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcw zzcwVar = new zzcw();
        zzcwVar.zzc(bitmapCreateBitmap);
        zzcwVar.zzi(this.zzf / this.zzd);
        zzcwVar.zzj(0);
        zzcwVar.zzf(this.zzg / this.zze, 0);
        zzcwVar.zzg(0);
        zzcwVar.zzm(this.zzh / this.zzd);
        zzcwVar.zzn(this.zzi / this.zze);
        return zzcwVar.zzr();
    }

    public final void zzb() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zza(0);
        this.zzc = false;
    }

    final /* synthetic */ void zzc(zzet zzetVar, int i3) {
        if (i3 % 5 != 2) {
            return;
        }
        zzetVar.zzk(2);
        int[] iArr = this.zzb;
        Arrays.fill(iArr, 0);
        int i4 = 0;
        for (int i5 = i3 / 5; i4 < i5; i5 = i5) {
            int iZzs = zzetVar.zzs();
            int iZzs2 = zzetVar.zzs();
            int iZzs3 = zzetVar.zzs();
            int iZzs4 = zzetVar.zzs();
            double d3 = iZzs2;
            int iZzs5 = zzetVar.zzs() << 24;
            String str = zzfl.zza;
            double d4 = iZzs3 - 128;
            double d5 = iZzs4 - 128;
            iArr[iZzs] = (Math.max(0, Math.min((int) (d3 + (1.402d * d4)), 255)) << 16) | iZzs5 | (Math.max(0, Math.min((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 255)) << 8) | Math.max(0, Math.min((int) (d3 + (d5 * 1.772d)), 255));
            i4++;
        }
        this.zzc = true;
    }

    final /* synthetic */ void zzd(zzet zzetVar, int i3) {
        int iZzx;
        if (i3 < 4) {
            return;
        }
        zzetVar.zzk(3);
        int i4 = i3 - 4;
        if ((zzetVar.zzs() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            if (i4 < 7 || (iZzx = zzetVar.zzx()) < 4) {
                return;
            }
            this.zzh = zzetVar.zzt();
            this.zzi = zzetVar.zzt();
            this.zza.zza(iZzx - 4);
            i4 = i3 - 11;
        }
        zzet zzetVar2 = this.zza;
        int iZzg = zzetVar2.zzg();
        int iZze = zzetVar2.zze();
        if (iZzg >= iZze || i4 <= 0) {
            return;
        }
        int iMin = Math.min(i4, iZze - iZzg);
        zzetVar.zzm(zzetVar2.zzi(), iZzg, iMin);
        zzetVar2.zzh(iZzg + iMin);
    }

    final /* synthetic */ void zze(zzet zzetVar, int i3) {
        if (i3 < 19) {
            return;
        }
        this.zzd = zzetVar.zzt();
        this.zze = zzetVar.zzt();
        zzetVar.zzk(11);
        this.zzf = zzetVar.zzt();
        this.zzg = zzetVar.zzt();
    }
}
