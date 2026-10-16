package com.google.android.gms.internal.consent_sdk;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpt extends zzpq {
    private final OutputStream zzg;

    zzpt(OutputStream outputStream, int i3) {
        super(i3);
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.zzg = outputStream;
    }

    private final void zzG() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzH(int i3) throws IOException {
        if (this.zzb - this.zzc < i3) {
            zzG();
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzI() throws IOException {
        if (this.zzc > 0) {
            zzG();
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzJ(byte b3) throws IOException {
        if (this.zzc == this.zzb) {
            zzG();
        }
        zzc(b3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzK(int i3, boolean z2) throws IOException {
        zzH(11);
        zzf(i3 << 3);
        zzc(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzL(byte[] bArr, int i3, int i4) throws IOException {
        zzw(i4);
        zzz(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv, com.google.android.gms.internal.consent_sdk.zzpe
    public final void zza(byte[] bArr, int i3, int i4) throws IOException {
        zzz(bArr, 0, i4);
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
        zzH(14);
        zzf((i3 << 3) | 5);
        zzd(i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzk(int i3) throws IOException {
        zzH(4);
        zzd(i3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzl(int i3, long j3) throws IOException {
        zzH(18);
        zzf((i3 << 3) | 1);
        zze(j3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzm(long j3) throws IOException {
        zzH(8);
        zze(j3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzn(int i3, int i4) throws IOException {
        zzH(20);
        zzf(i3 << 3);
        if (i4 >= 0) {
            zzf(i4);
        } else {
            zzg(i4);
        }
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
        int iZzb;
        try {
            int length = str.length() * 3;
            int iZzC = zzpv.zzC(length);
            int i3 = iZzC + length;
            int i4 = this.zzb;
            if (i3 > i4) {
                byte[] bArr = new byte[length];
                int iZza = zzsy.zza(str, bArr, 0, length);
                zzw(iZza);
                zzz(bArr, 0, iZza);
                return;
            }
            if (i3 > i4 - this.zzc) {
                zzG();
            }
            int iZzC2 = zzpv.zzC(str.length());
            int i5 = this.zzc;
            try {
                if (iZzC2 == iZzC) {
                    int i6 = i5 + iZzC2;
                    this.zzc = i6;
                    int iZza2 = zzsy.zza(str, this.zza, i6, i4 - i6);
                    this.zzc = i5;
                    iZzb = (iZza2 - i5) - iZzC2;
                    zzf(iZzb);
                    this.zzc = iZza2;
                } else {
                    iZzb = zzsy.zzb(str);
                    zzf(iZzb);
                    this.zzc = zzsy.zza(str, this.zza, this.zzc, iZzb);
                }
                this.zzd += iZzb;
            } catch (zzsx e3) {
                this.zzd -= this.zzc - i5;
                this.zzc = i5;
                throw e3;
            } catch (ArrayIndexOutOfBoundsException e4) {
                throw new zzps(e4);
            }
        } catch (zzsx e5) {
            zzE(str, e5);
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzu(int i3, int i4) throws IOException {
        zzw((i3 << 3) | i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzv(int i3, int i4) throws IOException {
        zzH(20);
        zzf(i3 << 3);
        zzf(i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzw(int i3) throws IOException {
        zzH(5);
        zzf(i3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzx(int i3, long j3) throws IOException {
        zzH(20);
        zzf(i3 << 3);
        zzg(j3);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpv
    public final void zzy(long j3) throws IOException {
        zzH(10);
        zzg(j3);
    }

    public final void zzz(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.zzb;
        int i6 = this.zzc;
        int i7 = i5 - i6;
        if (i7 >= i4) {
            System.arraycopy(bArr, 0, this.zza, i6, i4);
            this.zzc += i4;
            this.zzd += i4;
            return;
        }
        byte[] bArr2 = this.zza;
        System.arraycopy(bArr, 0, bArr2, i6, i7);
        this.zzc = i5;
        this.zzd += i7;
        zzG();
        int i8 = i4 - i7;
        if (i8 <= i5) {
            System.arraycopy(bArr, i7, bArr2, 0, i8);
            this.zzc = i8;
        } else {
            this.zzg.write(bArr, i7, i8);
        }
        this.zzd += i8;
    }
}
