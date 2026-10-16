package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaor {
    private boolean zzd;
    private boolean zze;
    private int[] zzf;
    private int zzg;
    private int zzh;
    private Rect zzi;
    private long zzb = -9223372036854775807L;
    private long zzc = -9223372036854775807L;
    private final int[] zza = new int[4];
    private int zzj = -1;
    private int zzk = -1;

    private static int zzg(int[] iArr, int i3) {
        if (i3 >= iArr.length) {
            i3 = 0;
        }
        return iArr[i3];
    }

    private static int zzh(int i3, int i4) {
        return (i3 & 16777215) | ((i4 * 17) << 24);
    }

    private final void zzi(zzes zzesVar, boolean z2, Rect rect, int[] iArr) {
        int i3;
        int i4;
        int i5 = !z2 ? 1 : 0;
        int iWidth = rect.width();
        int i6 = i5 * iWidth;
        int iHeight = rect.height();
        while (true) {
            int i7 = 0;
            do {
                int iZzj = 0;
                for (int i8 = 1; iZzj < i8 && i8 <= 64; i8 <<= 2) {
                    if (zzesVar.zzc() < 4) {
                        i3 = -1;
                        i4 = 0;
                        break;
                    }
                    iZzj = (iZzj << 4) | zzesVar.zzj(4);
                }
                i3 = iZzj & 3;
                i4 = iZzj < 4 ? iWidth : iZzj >> 2;
                int iMin = Math.min(i4, iWidth - i7);
                if (iMin > 0) {
                    int i9 = i6 + iMin;
                    Arrays.fill(iArr, i6, i9, this.zza[i3]);
                    i7 += iMin;
                    i6 = i9;
                }
            } while (i7 < iWidth);
            i5 += 2;
            if (i5 >= iHeight) {
                return;
            }
            i6 = i5 * iWidth;
            zzesVar.zzm();
        }
    }

    public final void zza(String str) {
        int i3;
        String strTrim = str.trim();
        String str2 = zzfl.zza;
        for (String str3 : strTrim.split("\\r?\\n", -1)) {
            if (str3.startsWith("palette: ")) {
                String[] strArrSplit = str3.substring(9).split(",", -1);
                this.zzf = new int[strArrSplit.length];
                for (int i4 = 0; i4 < strArrSplit.length; i4++) {
                    int[] iArr = this.zzf;
                    try {
                        i3 = Integer.parseInt(strArrSplit[i4].trim(), 16);
                    } catch (RuntimeException e3) {
                        zzeg.zzd("VobsubParser", "Parsing color failed", e3);
                        i3 = 0;
                    }
                    iArr[i4] = i3;
                }
            } else if (str3.startsWith("size: ")) {
                String[] strArrSplit2 = str3.substring(6).trim().split("x", -1);
                if (strArrSplit2.length != 2) {
                    StringBuilder sb = new StringBuilder(str3.length() + 36);
                    sb.append("Ignoring malformed IDX size line: '");
                    sb.append(str3);
                    sb.append("'");
                    zzeg.zzc("VobsubParser", sb.toString());
                } else {
                    try {
                        this.zzg = Integer.parseInt(strArrSplit2[0]);
                        this.zzh = Integer.parseInt(strArrSplit2[1]);
                        this.zzd = true;
                    } catch (RuntimeException e4) {
                        zzeg.zzd("VobsubParser", "Parsing IDX failed", e4);
                    }
                }
            }
        }
    }

    public final zzcx zzb(zzet zzetVar) {
        Rect rect;
        if (this.zzf == null || !this.zzd || !this.zze || (rect = this.zzi) == null || this.zzj == -1 || this.zzk == -1 || rect.width() < 2 || this.zzi.height() < 2) {
            return null;
        }
        Rect rect2 = this.zzi;
        int[] iArr = new int[rect2.width() * rect2.height()];
        zzes zzesVar = new zzes();
        zzetVar.zzh(this.zzj);
        zzesVar.zza(zzetVar);
        zzi(zzesVar, true, rect2, iArr);
        zzetVar.zzh(this.zzk);
        zzesVar.zza(zzetVar);
        zzi(zzesVar, false, rect2, iArr);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
        zzcw zzcwVar = new zzcw();
        zzcwVar.zzc(bitmapCreateBitmap);
        zzcwVar.zzi(rect2.left / this.zzg);
        zzcwVar.zzj(0);
        zzcwVar.zzf(rect2.top / this.zzh, 0);
        zzcwVar.zzg(0);
        zzcwVar.zzm(rect2.width() / this.zzg);
        zzcwVar.zzn(rect2.height() / this.zzh);
        return zzcwVar.zzr();
    }

    public final void zzc() {
        this.zzb = -9223372036854775807L;
        this.zzc = -9223372036854775807L;
        this.zze = false;
        this.zzi = null;
        this.zzj = -1;
        this.zzk = -1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0069. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:25:0x005a
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:104)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    final /* synthetic */ void zzd(com.google.android.gms.internal.ads.zzet r19) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaor.zzd(com.google.android.gms.internal.ads.zzet):void");
    }

    final /* synthetic */ long zze() {
        return this.zzb;
    }

    final /* synthetic */ long zzf() {
        return this.zzc;
    }
}
