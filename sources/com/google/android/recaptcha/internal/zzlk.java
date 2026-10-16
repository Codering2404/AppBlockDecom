package com.google.android.recaptcha.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzlk extends zzln {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    zzlk(byte[] bArr, int i3, int i4) {
        super(null);
        int length = bArr.length;
        if (((length - i4) | i4) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i4)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i4;
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzb(byte b3) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i3 = this.zzd;
            this.zzd = i3 + 1;
            bArr[i3] = b3;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e3);
        }
    }

    public final void zzc(byte[] bArr, int i3, int i4) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzb, this.zzd, i4);
            this.zzd += i4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i4)), e3);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzd(int i3, boolean z2) throws IOException {
        zzt(i3 << 3);
        zzb(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zze(int i3, zzle zzleVar) throws IOException {
        zzt((i3 << 3) | 2);
        zzt(zzleVar.zzd());
        zzleVar.zzh(this);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzf(int i3, int i4) throws IOException {
        zzt((i3 << 3) | 5);
        zzg(i4);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzg(int i3) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i4 = this.zzd;
            int i5 = i4 + 1;
            this.zzd = i5;
            bArr[i4] = (byte) (i3 & 255);
            int i6 = i4 + 2;
            this.zzd = i6;
            bArr[i5] = (byte) ((i3 >> 8) & 255);
            int i7 = i4 + 3;
            this.zzd = i7;
            bArr[i6] = (byte) ((i3 >> 16) & 255);
            this.zzd = i4 + 4;
            bArr[i7] = (byte) ((i3 >> 24) & 255);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e3);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzh(int i3, long j3) throws IOException {
        zzt((i3 << 3) | 1);
        zzi(j3);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzi(long j3) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i3 = this.zzd;
            int i4 = i3 + 1;
            this.zzd = i4;
            bArr[i3] = (byte) (((int) j3) & 255);
            int i5 = i3 + 2;
            this.zzd = i5;
            bArr[i4] = (byte) (((int) (j3 >> 8)) & 255);
            int i6 = i3 + 3;
            this.zzd = i6;
            bArr[i5] = (byte) (((int) (j3 >> 16)) & 255);
            int i7 = i3 + 4;
            this.zzd = i7;
            bArr[i6] = (byte) (((int) (j3 >> 24)) & 255);
            int i8 = i3 + 5;
            this.zzd = i8;
            bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
            int i9 = i3 + 6;
            this.zzd = i9;
            bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
            int i10 = i3 + 7;
            this.zzd = i10;
            bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
            this.zzd = i3 + 8;
            bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e3);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzj(int i3, int i4) throws IOException {
        zzt(i3 << 3);
        zzk(i4);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzk(int i3) throws IOException {
        if (i3 >= 0) {
            zzt(i3);
        } else {
            zzv(i3);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzl(byte[] bArr, int i3, int i4) throws IOException {
        zzc(bArr, 0, i4);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    final void zzm(int i3, zzoi zzoiVar, zzow zzowVar) throws IOException {
        zzt((i3 << 3) | 2);
        zzt(((zzko) zzoiVar).zza(zzowVar));
        zzowVar.zzj(zzoiVar, this.zza);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzn(int i3, zzoi zzoiVar) throws IOException {
        zzt(11);
        zzs(2, i3);
        zzt(26);
        zzt(zzoiVar.zzo());
        zzoiVar.zze(this);
        zzt(12);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzo(int i3, zzle zzleVar) throws IOException {
        zzt(11);
        zzs(2, i3);
        zze(3, zzleVar);
        zzt(12);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzp(int i3, String str) throws IOException {
        zzt((i3 << 3) | 2);
        zzq(str);
    }

    public final void zzq(String str) throws IOException {
        int i3 = this.zzd;
        try {
            int iZzA = zzln.zzA(str.length() * 3);
            int iZzA2 = zzln.zzA(str.length());
            if (iZzA2 != iZzA) {
                zzt(zzpv.zzc(str));
                byte[] bArr = this.zzb;
                int i4 = this.zzd;
                this.zzd = zzpv.zzb(str, bArr, i4, this.zzc - i4);
                return;
            }
            int i5 = i3 + iZzA2;
            this.zzd = i5;
            int iZzb = zzpv.zzb(str, this.zzb, i5, this.zzc - i5);
            this.zzd = i3;
            zzt((iZzb - i3) - iZzA2);
            this.zzd = iZzb;
        } catch (zzpu e3) {
            this.zzd = i3;
            zzD(str, e3);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzll(e4);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzr(int i3, int i4) throws IOException {
        zzt((i3 << 3) | i4);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzs(int i3, int i4) throws IOException {
        zzt(i3 << 3);
        zzt(i4);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzt(int i3) throws IOException {
        while ((i3 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i4 = this.zzd;
                this.zzd = i4 + 1;
                bArr[i4] = (byte) ((i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) & 255);
                i3 >>>= 7;
            } catch (IndexOutOfBoundsException e3) {
                throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e3);
            }
        }
        byte[] bArr2 = this.zzb;
        int i5 = this.zzd;
        this.zzd = i5 + 1;
        bArr2[i5] = (byte) i3;
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzu(int i3, long j3) throws IOException {
        zzt(i3 << 3);
        zzv(j3);
    }

    @Override // com.google.android.recaptcha.internal.zzln
    public final void zzv(long j3) throws IOException {
        if (!zzln.zzc || this.zzc - this.zzd < 10) {
            while ((j3 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i3 = this.zzd;
                    this.zzd = i3 + 1;
                    bArr[i3] = (byte) ((((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) & 255);
                    j3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new zzll(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e3);
                }
            }
            byte[] bArr2 = this.zzb;
            int i4 = this.zzd;
            this.zzd = i4 + 1;
            bArr2[i4] = (byte) j3;
            return;
        }
        while (true) {
            int i5 = (int) j3;
            if ((j3 & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i6 = this.zzd;
                this.zzd = i6 + 1;
                zzps.zzn(bArr3, i6, (byte) i5);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i7 = this.zzd;
            this.zzd = i7 + 1;
            zzps.zzn(bArr4, i7, (byte) ((i5 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) & 255));
            j3 >>>= 7;
        }
    }
}
