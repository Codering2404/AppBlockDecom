package com.google.android.gms.internal.consent_sdk;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpr extends zzpv {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzpr(byte[] bArr, int i3, int i4) {
        super(null);
        int length = bArr.length;
        if (((length - i4) | i4) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i4)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i4;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzJ(byte b3) throws IOException {
        int i3 = this.zzc;
        try {
            int i4 = i3 + 1;
            try {
                this.zza[i3] = b3;
                this.zzc = i4;
            } catch (IndexOutOfBoundsException e3) {
                e = e3;
                i3 = i4;
                throw new zzps(i3, this.zzb, 1, e);
            }
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzK(int i3, boolean z2) throws IOException {
        zzw(i3 << 3);
        zzJ(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzL(byte[] bArr, int i3, int i4) throws IOException {
        zzw(i4);
        zze(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv, com.google.android.gms.internal.consent_sdk.zzpe
    public final void zza(byte[] bArr, int i3, int i4) throws IOException {
        zze(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i3, int i4) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zza, this.zzc, i4);
            this.zzc += i4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzps(this.zzc, this.zzb, i4, e3);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzh(int i3, zzpm zzpmVar) throws IOException {
        zzw((i3 << 3) | 2);
        zzi(zzpmVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzi(zzpm zzpmVar) throws IOException {
        zzw(zzpmVar.zzd());
        zzpmVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzj(int i3, int i4) throws IOException {
        zzw((i3 << 3) | 5);
        zzk(i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzk(int i3) throws IOException {
        int i4 = this.zzc;
        try {
            byte[] bArr = this.zza;
            bArr[i4] = (byte) i3;
            bArr[i4 + 1] = (byte) (i3 >> 8);
            bArr[i4 + 2] = (byte) (i3 >> 16);
            bArr[i4 + 3] = (byte) (i3 >> 24);
            this.zzc = i4 + 4;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzps(i4, this.zzb, 4, e3);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzl(int i3, long j3) throws IOException {
        zzw((i3 << 3) | 1);
        zzm(j3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzm(long j3) throws IOException {
        int i3 = this.zzc;
        try {
            byte[] bArr = this.zza;
            bArr[i3] = (byte) j3;
            bArr[i3 + 1] = (byte) (j3 >> 8);
            bArr[i3 + 2] = (byte) (j3 >> 16);
            bArr[i3 + 3] = (byte) (j3 >> 24);
            bArr[i3 + 4] = (byte) (j3 >> 32);
            bArr[i3 + 5] = (byte) (j3 >> 40);
            bArr[i3 + 6] = (byte) (j3 >> 48);
            bArr[i3 + 7] = (byte) (j3 >> 56);
            this.zzc = i3 + 8;
        } catch (IndexOutOfBoundsException e3) {
            throw new zzps(i3, this.zzb, 8, e3);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzn(int i3, int i4) throws IOException {
        zzw(i3 << 3);
        zzo(i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzo(int i3) throws IOException {
        if (i3 >= 0) {
            zzw(i3);
        } else {
            zzy(i3);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzp(zzrq zzrqVar) throws IOException {
        zzw(zzrqVar.zzn());
        zzrqVar.zzB(this);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzq(int i3, zzrq zzrqVar) throws IOException {
        zzw(11);
        zzv(2, i3);
        zzw(26);
        zzp(zzrqVar);
        zzw(12);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzr(int i3, zzpm zzpmVar) throws IOException {
        zzw(11);
        zzv(2, i3);
        zzh(3, zzpmVar);
        zzw(12);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzs(int i3, String str) throws IOException {
        zzw((i3 << 3) | 2);
        zzt(str);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzt(String str) throws IOException {
        int i3 = this.zzc;
        try {
            int iZzC = zzpv.zzC(str.length() * 3);
            int iZzC2 = zzpv.zzC(str.length());
            if (iZzC2 != iZzC) {
                zzw(zzsy.zzb(str));
                byte[] bArr = this.zza;
                int i4 = this.zzc;
                this.zzc = zzsy.zza(str, bArr, i4, this.zzb - i4);
                return;
            }
            int i5 = i3 + iZzC2;
            this.zzc = i5;
            int iZza = zzsy.zza(str, this.zza, i5, this.zzb - i5);
            this.zzc = i3;
            zzw((iZza - i3) - iZzC2);
            this.zzc = iZza;
        } catch (zzsx e3) {
            this.zzc = i3;
            zzE(str, e3);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzps(e4);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzu(int i3, int i4) throws IOException {
        zzw((i3 << 3) | i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzv(int i3, int i4) throws IOException {
        zzw(i3 << 3);
        zzw(i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzw(int i3) throws IOException {
        int i4;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i5 = this.zzc;
        while ((i3 & (-128)) != 0) {
            try {
                i4 = i5 + 1;
                try {
                    this.zza[i5] = (byte) (i3 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    i3 >>>= 7;
                    i5 = i4;
                } catch (IndexOutOfBoundsException e3) {
                    indexOutOfBoundsException = e3;
                    i5 = i4;
                    throw new zzps(i5, this.zzb, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e4) {
                indexOutOfBoundsException = e4;
                throw new zzps(i5, this.zzb, 1, indexOutOfBoundsException);
            }
        }
        i4 = i5 + 1;
        this.zza[i5] = (byte) i3;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzx(int i3, long j3) throws IOException {
        zzw(i3 << 3);
        zzy(j3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzy(long j3) throws IOException {
        int i3;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i4 = this.zzc;
        if (!zzpv.zzb || this.zzb - i4 < 10) {
            int i5 = i4;
            while ((j3 & (-128)) != 0) {
                try {
                    int i6 = i5 + 1;
                    try {
                        this.zza[i5] = (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        j3 >>>= 7;
                        i5 = i6;
                    } catch (IndexOutOfBoundsException e3) {
                        indexOutOfBoundsException = e3;
                        i5 = i6;
                        throw new zzps(i5, this.zzb, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e4) {
                    indexOutOfBoundsException = e4;
                }
            }
            i3 = i5 + 1;
            try {
                this.zza[i5] = (byte) j3;
            } catch (IndexOutOfBoundsException e5) {
                indexOutOfBoundsException = e5;
                i5 = i3;
                throw new zzps(i5, this.zzb, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j3 & (-128)) != 0) {
                zzsw.zzn(this.zza, i4, (byte) (((int) j3) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
                i4++;
            }
            i3 = i4 + 1;
            zzsw.zzn(this.zza, i4, (byte) j3);
        }
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzI() {
    }
}
