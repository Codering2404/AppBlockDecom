package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlc extends zzlg {
    private final int zzc;

    zzlc(byte[] bArr, int i3, int i4) {
        super(bArr);
        zzlh.zzj(0, i4, bArr.length);
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final byte zza(int i3) {
        int i4 = this.zzc;
        if (((i4 - (i3 + 1)) | i3) >= 0) {
            return ((zzlg) this).zza[i3];
        }
        if (i3 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i3);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 18 + String.valueOf(i4).length());
        sb2.append("Index > length: ");
        sb2.append(i3);
        sb2.append(", ");
        sb2.append(i4);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    final byte zzb(int i3) {
        return ((zzlg) this).zza[i3];
    }

    @Override // com.google.android.gms.internal.measurement.zzlg, com.google.android.gms.internal.measurement.zzlh
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    protected final int zzd() {
        return 0;
    }
}
