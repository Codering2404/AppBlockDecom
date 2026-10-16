package com.google.android.gms.internal.gtm;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzum extends zzuq {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzum(byte[] bArr, int i3, int i4) {
        super(null);
        int length = bArr.length;
        if (((length - i4) | i4) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i4)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i4;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzK(byte b3) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            bArr[i3] = b3;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzun(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e3);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzL(int i3, boolean z2) throws IOException {
        zzu(i3 << 3);
        zzK(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzM(int i3, zzud zzudVar) throws IOException {
        zzu((i3 << 3) | 2);
        zzu(zzudVar.zzd());
        zzudVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zztt
    public final void zza(byte[] bArr, int i3, int i4) throws IOException {
        zze(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i3, int i4) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zza, this.zzc, i4);
            this.zzc += i4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzun(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i4)), e3);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzh(int i3, int i4) throws IOException {
        zzu((i3 << 3) | 5);
        zzi(i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzi(int i3) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i4 = this.zzc;
            int i5 = i4 + 1;
            this.zzc = i5;
            bArr[i4] = (byte) (i3 & 255);
            int i6 = i4 + 2;
            this.zzc = i6;
            bArr[i5] = (byte) ((i3 >> 8) & 255);
            int i7 = i4 + 3;
            this.zzc = i7;
            bArr[i6] = (byte) ((i3 >> 16) & 255);
            this.zzc = i4 + 4;
            bArr[i7] = (byte) ((i3 >> 24) & 255);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzun(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e3);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzj(int i3, long j3) throws IOException {
        zzu((i3 << 3) | 1);
        zzk(j3);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzk(long j3) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i3 = this.zzc;
            int i4 = i3 + 1;
            this.zzc = i4;
            bArr[i3] = (byte) (((int) j3) & 255);
            int i5 = i3 + 2;
            this.zzc = i5;
            bArr[i4] = (byte) (((int) (j3 >> 8)) & 255);
            int i6 = i3 + 3;
            this.zzc = i6;
            bArr[i5] = (byte) (((int) (j3 >> 16)) & 255);
            int i7 = i3 + 4;
            this.zzc = i7;
            bArr[i6] = (byte) (((int) (j3 >> 24)) & 255);
            int i8 = i3 + 5;
            this.zzc = i8;
            bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
            int i9 = i3 + 6;
            this.zzc = i9;
            bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
            int i10 = i3 + 7;
            this.zzc = i10;
            bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
            this.zzc = i3 + 8;
            bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzun(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e3);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzl(int i3, int i4) throws IOException {
        zzu(i3 << 3);
        zzm(i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzm(int i3) throws IOException {
        if (i3 >= 0) {
            zzu(i3);
        } else {
            zzw(i3);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    final void zzn(int i3, zzzg zzzgVar, zzzt zzztVar) throws IOException {
        zzu((i3 << 3) | 2);
        zzu(((zztl) zzzgVar).zzQ(zzztVar));
        zzztVar.zzm(zzzgVar, this.zze);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzo(int i3, zzzg zzzgVar) throws IOException {
        zzu(11);
        zzt(2, i3);
        zzu(26);
        zzu(zzzgVar.zzX());
        zzzgVar.zzaw(this);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzp(int i3, zzud zzudVar) throws IOException {
        zzu(11);
        zzt(2, i3);
        zzM(3, zzudVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzq(int i3, String str) throws IOException {
        zzu((i3 << 3) | 2);
        zzr(str);
    }

    public final void zzr(String str) throws IOException {
        int i3 = this.zzc;
        try {
            int iZzD = zzuq.zzD(str.length() * 3);
            int iZzD2 = zzuq.zzD(str.length());
            if (iZzD2 != iZzD) {
                zzu(zzaaz.zzc(str));
                byte[] bArr = this.zza;
                int i4 = this.zzc;
                this.zzc = zzaaz.zzb(str, bArr, i4, this.zzb - i4);
                return;
            }
            int i5 = i3 + iZzD2;
            this.zzc = i5;
            int iZzb = zzaaz.zzb(str, this.zza, i5, this.zzb - i5);
            this.zzc = i3;
            zzu((iZzb - i3) - iZzD2);
            this.zzc = iZzb;
        } catch (zzaay e3) {
            this.zzc = i3;
            zzF(str, e3);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzun(e4);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzs(int i3, int i4) throws IOException {
        zzu((i3 << 3) | i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzt(int i3, int i4) throws IOException {
        zzu(i3 << 3);
        zzu(i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzu(int i3) throws IOException {
        while ((i3 & (-128)) != 0) {
            try {
                byte[] bArr = this.zza;
                int i4 = this.zzc;
                this.zzc = i4 + 1;
                bArr[i4] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                i3 >>>= 7;
            } catch (IndexOutOfBoundsException e3) {
                throw new zzun(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e3);
            }
        }
        byte[] bArr2 = this.zza;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        bArr2[i5] = (byte) i3;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzv(int i3, long j3) throws IOException {
        zzu(i3 << 3);
        zzw(j3);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzw(long j3) throws IOException {
        if (!zzuq.zzb || this.zzb - this.zzc < 10) {
            while ((j3 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zza;
                    int i3 = this.zzc;
                    this.zzc = i3 + 1;
                    bArr[i3] = (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    j3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new zzun(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e3);
                }
            }
            byte[] bArr2 = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            bArr2[i4] = (byte) j3;
            return;
        }
        while (true) {
            int i5 = (int) j3;
            if ((j3 & (-128)) == 0) {
                byte[] bArr3 = this.zza;
                int i6 = this.zzc;
                this.zzc = i6 + 1;
                zzaau.zzn(bArr3, i6, (byte) i5);
                return;
            }
            byte[] bArr4 = this.zza;
            int i7 = this.zzc;
            this.zzc = i7 + 1;
            zzaau.zzn(bArr4, i7, (byte) ((i5 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            j3 >>>= 7;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzJ() {
    }
}
