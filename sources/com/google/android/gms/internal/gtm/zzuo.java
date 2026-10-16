package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzuo extends zzul {
    private final OutputStream zzg;

    zzuo(OutputStream outputStream, int i3) {
        super(i3);
        this.zzg = outputStream;
    }

    private final void zzH() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzI(int i3) throws IOException {
        if (this.zzb - this.zzc < i3) {
            zzH();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzJ() throws IOException {
        if (this.zzc > 0) {
            zzH();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzK(byte b3) throws IOException {
        if (this.zzc == this.zzb) {
            zzH();
        }
        zzc(b3);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzL(int i3, boolean z2) throws IOException {
        zzI(11);
        zzf(i3 << 3);
        zzc(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzM(int i3, zzud zzudVar) throws IOException {
        zzu((i3 << 3) | 2);
        zzu(zzudVar.zzd());
        zzudVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq, com.google.android.gms.internal.gtm.zztt
    public final void zza(byte[] bArr, int i3, int i4) throws IOException {
        zzr(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzh(int i3, int i4) throws IOException {
        zzI(14);
        zzf((i3 << 3) | 5);
        zzd(i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzi(int i3) throws IOException {
        zzI(4);
        zzd(i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzj(int i3, long j3) throws IOException {
        zzI(18);
        zzf((i3 << 3) | 1);
        zze(j3);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzk(long j3) throws IOException {
        zzI(8);
        zze(j3);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzl(int i3, int i4) throws IOException {
        zzI(20);
        zzf(i3 << 3);
        if (i4 >= 0) {
            zzf(i4);
        } else {
            zzg(i4);
        }
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
        zzx(str);
    }

    public final void zzr(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.zzb;
        int i6 = this.zzc;
        int i7 = i5 - i6;
        if (i7 >= i4) {
            System.arraycopy(bArr, 0, this.zza, i6, i4);
            this.zzc += i4;
            this.zzd += i4;
            return;
        }
        System.arraycopy(bArr, 0, this.zza, i6, i7);
        this.zzc = this.zzb;
        this.zzd += i7;
        zzH();
        int i8 = i4 - i7;
        if (i8 <= this.zzb) {
            System.arraycopy(bArr, i7, this.zza, 0, i8);
            this.zzc = i8;
        } else {
            this.zzg.write(bArr, i7, i8);
        }
        this.zzd += i8;
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzs(int i3, int i4) throws IOException {
        zzu((i3 << 3) | i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzt(int i3, int i4) throws IOException {
        zzI(20);
        zzf(i3 << 3);
        zzf(i4);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzu(int i3) throws IOException {
        zzI(5);
        zzf(i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzv(int i3, long j3) throws IOException {
        zzI(20);
        zzf(i3 << 3);
        zzg(j3);
    }

    @Override // com.google.android.gms.internal.gtm.zzuq
    public final void zzw(long j3) throws IOException {
        zzI(10);
        zzg(j3);
    }

    public final void zzx(String str) throws IOException {
        int iZzc;
        try {
            int length = str.length() * 3;
            int iZzD = zzuq.zzD(length);
            int i3 = iZzD + length;
            int i4 = this.zzb;
            if (i3 > i4) {
                byte[] bArr = new byte[length];
                int iZzb = zzaaz.zzb(str, bArr, 0, length);
                zzu(iZzb);
                zzr(bArr, 0, iZzb);
                return;
            }
            if (i3 > i4 - this.zzc) {
                zzH();
            }
            int iZzD2 = zzuq.zzD(str.length());
            int i5 = this.zzc;
            try {
                if (iZzD2 == iZzD) {
                    int i6 = i5 + iZzD2;
                    this.zzc = i6;
                    int iZzb2 = zzaaz.zzb(str, this.zza, i6, this.zzb - i6);
                    this.zzc = i5;
                    iZzc = (iZzb2 - i5) - iZzD2;
                    zzf(iZzc);
                    this.zzc = iZzb2;
                } else {
                    iZzc = zzaaz.zzc(str);
                    zzf(iZzc);
                    this.zzc = zzaaz.zzb(str, this.zza, this.zzc, iZzc);
                }
                this.zzd += iZzc;
            } catch (zzaay e3) {
                this.zzd -= this.zzc - i5;
                this.zzc = i5;
                throw e3;
            } catch (ArrayIndexOutOfBoundsException e4) {
                throw new zzun(e4);
            }
        } catch (zzaay e5) {
            zzF(str, e5);
        }
    }
}
