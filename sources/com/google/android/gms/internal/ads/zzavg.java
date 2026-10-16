package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzavg implements zzave {
    private int zza = (((((~1539942439) & 2070175971) | 1100945533) + ((1539942439 & (-1166483302)) | (-2145608135))) - 96382817) ^ (1143565421 % 981914693);
    private final byte[] zzb = new byte[(((((~991039875) & 475472926) | 1225689584) + ((991039875 & 357672014) | 1805818736)) - (-1256743880)) ^ (1671581032 % 1337434154)];
    private final zzavi zzc;

    public zzavg(zzavi zzaviVar) {
        this.zzc = zzaviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final byte zza(zzavq zzavqVar, int i3) {
        int i4 = ((((~1264448664) & 231739608) | 1128901767) + ((1264448664 & 479203675) | 860794247)) - 1823332376;
        int i5 = 1761855727 % 1384724137;
        int i6 = (((((~143154913) & 992498304) | 439467622) + ((143154913 & 1627930754) | 1212551295)) - (-2089988634)) ^ (2033018190 % 70061690);
        int i7 = ((((~1661299468) & 613450408) | 2017391535) + ((1661299468 & 109051904) | 2071555381)) - (-441392543);
        int i8 = 1694830070 % 1383960411;
        int i9 = i3 >>> i6;
        if (i9 != this.zza) {
            this.zzc.zza(i9, this.zzb);
            this.zza = i9;
        }
        int i10 = i7 ^ i8;
        return (byte) (((zzavqVar.zzb(i3) ^ this.zzb[i3 % (i4 ^ i5)]) << i10) >> i10);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final zzavq zzb(zzavq zzavqVar, int i3, int i4) {
        if (i3 < 0 || i3 > i4 || i4 > zzavqVar.zza.length) {
            throw new IndexOutOfBoundsException();
        }
        byte[] bArr = new byte[i4 - i3];
        int i5 = 0;
        while (i3 < i4) {
            bArr[i5] = zza(zzavqVar, i3);
            i3++;
            i5++;
        }
        return zzavq.zze(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final /* bridge */ /* synthetic */ zzave zzc() {
        return new zzavg(this.zzc);
    }
}
