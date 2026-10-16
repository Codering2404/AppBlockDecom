package com.google.android.gms.internal.play_billing;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzez extends zzfc {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    zzez(byte[] bArr, int i3, int i4) {
        super(null);
        int length = bArr.length;
        if (((length - i4) | i4) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i4)));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final int zza() {
        return this.zzd - this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzb(byte b3) throws IOException {
        int i3 = this.zze;
        try {
            int i4 = i3 + 1;
            try {
                this.zzc[i3] = b3;
                this.zze = i4;
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                i3 = i4;
                throw new zzfa(i3, this.zzd, 1, e);
            }
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
        }
    }

    public final void zzc(byte[] bArr, int i3, int i4) throws IOException {
        try {
            System.arraycopy(bArr, i3, this.zzc, this.zze, i4);
            this.zze += i4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzfa(this.zze, this.zzd, i4, e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzd(int i3, boolean z2) throws IOException {
        zzu(i3 << 3);
        zzb(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zze(byte[] bArr, int i3, int i4) throws IOException {
        zzu(i4);
        zzc(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzf(int i3, zzev zzevVar) throws IOException {
        zzu((i3 << 3) | 2);
        zzg(zzevVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzg(zzev zzevVar) throws IOException {
        zzu(zzevVar.zze());
        zzevVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzh(int i3, int i4) throws IOException {
        zzu((i3 << 3) | 5);
        zzi(i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzi(int i3) throws IOException {
        int i4 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i4] = (byte) i3;
            bArr[i4 + 1] = (byte) (i3 >> 8);
            bArr[i4 + 2] = (byte) (i3 >> 16);
            bArr[i4 + 3] = (byte) (i3 >> 24);
            this.zze = i4 + 4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzfa(i4, this.zzd, 4, e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzj(int i3, long j3) throws IOException {
        zzu((i3 << 3) | 1);
        zzk(j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzk(long j3) throws IOException {
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
            throw new zzfa(i3, this.zzd, 8, e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzl(int i3, int i4) throws IOException {
        zzu(i3 << 3);
        zzm(i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzm(int i3) throws IOException {
        if (i3 >= 0) {
            zzu(i3);
        } else {
            zzw(i3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzn(zzhb zzhbVar) throws IOException {
        zzu(zzhbVar.zzn());
        zzhbVar.zzD(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzo(int i3, zzhb zzhbVar) throws IOException {
        zzu(11);
        zzt(2, i3);
        zzu(26);
        zzn(zzhbVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzp(int i3, zzev zzevVar) throws IOException {
        zzu(11);
        zzt(2, i3);
        zzf(3, zzevVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzq(int i3, String str) throws IOException {
        zzu((i3 << 3) | 2);
        zzr(str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzr(String str) throws IOException {
        int i3 = this.zze;
        try {
            int iZzy = zzfc.zzy(str.length() * 3);
            int iZzy2 = zzfc.zzy(str.length());
            if (iZzy2 != iZzy) {
                zzu(zzin.zzb(str));
                byte[] bArr = this.zzc;
                int i4 = this.zze;
                this.zze = zzin.zza(str, bArr, i4, this.zzd - i4);
                return;
            }
            int i5 = i3 + iZzy2;
            this.zze = i5;
            int iZza = zzin.zza(str, this.zzc, i5, this.zzd - i5);
            this.zze = i3;
            zzu((iZza - i3) - iZzy2);
            this.zze = iZza;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzfa(e3);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzs(int i3, int i4) throws IOException {
        zzu((i3 << 3) | i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzt(int i3, int i4) throws IOException {
        zzu(i3 << 3);
        zzu(i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzu(int i3) throws IOException {
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
                    throw new zzfa(i5, this.zzd, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e4) {
                indexOutOfBoundsException = e4;
                throw new zzfa(i5, this.zzd, 1, indexOutOfBoundsException);
            }
        }
        i4 = i5 + 1;
        this.zzc[i5] = (byte) i3;
        this.zze = i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzv(int i3, long j3) throws IOException {
        zzu(i3 << 3);
        zzw(j3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfc
    public final void zzw(long j3) throws IOException {
        int i3;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i4 = this.zze;
        if (!zzfc.zzc || this.zzd - i4 < 10) {
            int i5 = i4;
            while ((j3 & (-128)) != 0) {
                try {
                    int i6 = i5 + 1;
                    try {
                        this.zzc[i5] = (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        j3 >>>= 7;
                        i5 = i6;
                    } catch (IndexOutOfBoundsException e3) {
                        indexOutOfBoundsException = e3;
                        i5 = i6;
                        throw new zzfa(i5, this.zzd, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e4) {
                    indexOutOfBoundsException = e4;
                }
            }
            i3 = i5 + 1;
            try {
                this.zzc[i5] = (byte) j3;
            } catch (IndexOutOfBoundsException e5) {
                indexOutOfBoundsException = e5;
                i5 = i3;
                throw new zzfa(i5, this.zzd, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j3 & (-128)) != 0) {
                zzii.zzn(this.zzc, i4, (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
                i4++;
            }
            i3 = i4 + 1;
            zzii.zzn(this.zzc, i4, (byte) j3);
        }
        this.zze = i3;
    }
}
