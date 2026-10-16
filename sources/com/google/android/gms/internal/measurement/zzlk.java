package com.google.android.gms.internal.measurement;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlk extends zzlm {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    zzlk(byte[] bArr, int i3, int i4) {
        super(null);
        int length = bArr.length;
        if (((length - i4) | i4) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i4)));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zza(int i3, int i4) throws IOException {
        zzr((i3 << 3) | i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzb(int i3, int i4) throws IOException {
        zzr(i3 << 3);
        zzq(i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzc(int i3, int i4) throws IOException {
        zzr(i3 << 3);
        zzr(i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzd(int i3, int i4) throws IOException {
        zzr((i3 << 3) | 5);
        zzs(i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zze(int i3, long j3) throws IOException {
        zzr(i3 << 3);
        zzt(j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzf(int i3, long j3) throws IOException {
        zzr((i3 << 3) | 1);
        zzu(j3);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzg(int i3, boolean z2) throws IOException {
        zzr(i3 << 3);
        zzp(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzh(int i3, String str) throws IOException {
        zzr((i3 << 3) | 2);
        zzx(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzi(int i3, zzlh zzlhVar) throws IOException {
        zzr((i3 << 3) | 2);
        zzj(zzlhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzj(zzlh zzlhVar) throws IOException {
        zzr(zzlhVar.zzc());
        zzlhVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzk(byte[] bArr, int i3, int i4) throws IOException {
        zzr(i4);
        zzv(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    final void zzl(int i3, zznm zznmVar, zznx zznxVar) throws IOException {
        zzr((i3 << 3) | 2);
        zzr(((zzks) zznmVar).zzcd(zznxVar));
        zznxVar.zzf(zznmVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzm(int i3, zznm zznmVar) throws IOException {
        zzr(11);
        zzc(2, i3);
        zzr(26);
        zzo(zznmVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzn(int i3, zzlh zzlhVar) throws IOException {
        zzr(11);
        zzc(2, i3);
        zzi(3, zzlhVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzo(zznm zznmVar) throws IOException {
        zzr(zznmVar.zzcn());
        zznmVar.zzcB(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzp(byte b3) throws IOException {
        int i3 = this.zze;
        try {
            int i4 = i3 + 1;
            try {
                this.zzc[i3] = b3;
                this.zze = i4;
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                i3 = i4;
                throw new zzll(i3, this.zzd, 1, e);
            }
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzq(int i3) throws IOException {
        if (i3 >= 0) {
            zzr(i3);
        } else {
            zzt(i3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzr(int i3) throws IOException {
        int i4;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i5 = this.zze;
        while ((i3 & (-128)) != 0) {
            try {
                i4 = i5 + 1;
                try {
                    this.zzc[i5] = (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    i3 >>>= 7;
                    i5 = i4;
                } catch (IndexOutOfBoundsException e3) {
                    indexOutOfBoundsException = e3;
                    i5 = i4;
                    throw new zzll(i5, this.zzd, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e4) {
                indexOutOfBoundsException = e4;
                throw new zzll(i5, this.zzd, 1, indexOutOfBoundsException);
            }
        }
        i4 = i5 + 1;
        this.zzc[i5] = (byte) i3;
        this.zze = i4;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzs(int i3) throws IOException {
        int i4 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i4] = (byte) i3;
            bArr[i4 + 1] = (byte) (i3 >> 8);
            bArr[i4 + 2] = (byte) (i3 >> 16);
            bArr[i4 + 3] = (byte) (i3 >> 24);
            this.zze = i4 + 4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzll(i4, this.zzd, 4, e3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzt(long j3) throws IOException {
        int i3;
        IndexOutOfBoundsException indexOutOfBoundsException;
        boolean z2 = zzlm.zzd;
        int i4 = this.zze;
        if (!z2 || this.zzd - i4 < 10) {
            while ((j3 & (-128)) != 0) {
                try {
                    int i5 = i4 + 1;
                    try {
                        this.zzc[i4] = (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        j3 >>>= 7;
                        i4 = i5;
                    } catch (IndexOutOfBoundsException e3) {
                        indexOutOfBoundsException = e3;
                        i4 = i5;
                        throw new zzll(i4, this.zzd, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e4) {
                    indexOutOfBoundsException = e4;
                }
            }
            i3 = i4 + 1;
            try {
                this.zzc[i4] = (byte) j3;
            } catch (IndexOutOfBoundsException e5) {
                indexOutOfBoundsException = e5;
                i4 = i3;
                throw new zzll(i4, this.zzd, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j3 & (-128)) != 0) {
                zzop.zzp(this.zzc, i4, (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
                i4++;
            }
            i3 = i4 + 1;
            zzop.zzp(this.zzc, i4, (byte) j3);
        }
        this.zze = i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzu(long j3) throws IOException {
        int i3 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i3] = (byte) j3;
            bArr[i3 + 1] = (byte) (j3 >> 8);
            bArr[i3 + 2] = (byte) (j3 >> 16);
            bArr[i3 + 3] = (byte) (j3 >> 24);
            bArr[i3 + 4] = (byte) (j3 >> 32);
            bArr[i3 + 5] = (byte) (j3 >> 40);
            bArr[i3 + 6] = (byte) (j3 >> 48);
            bArr[i3 + 7] = (byte) (j3 >> 56);
            this.zze = i3 + 8;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzll(i3, this.zzd, 8, e3);
        }
    }

    public final void zzv(byte[] bArr, int i3, int i4) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i4);
            this.zze += i4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzll(this.zze, this.zzd, i4, e3);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzw(byte[] bArr, int i3, int i4) throws IOException {
        zzv(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzx(String str) throws IOException {
        int i3 = this.zze;
        try {
            int iZzz = zzlm.zzz(str.length() * 3);
            int iZzz2 = zzlm.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzr(zzos.zzb(str));
                byte[] bArr = this.zzc;
                int i4 = this.zze;
                this.zze = zzos.zzc(str, bArr, i4, this.zzd - i4);
                return;
            }
            int i5 = i3 + iZzz2;
            this.zze = i5;
            int iZzc = zzos.zzc(str, this.zzc, i5, this.zzd - i5);
            this.zze = i3;
            zzr((iZzc - i3) - iZzz2);
            this.zze = iZzc;
        } catch (zzor e3) {
            this.zze = i3;
            zzF(str, e3);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzll(e4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final int zzy() {
        return this.zzd - this.zze;
    }
}
