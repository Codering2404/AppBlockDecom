package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzro extends zzxv implements zzzh {
    private static final zzro zza;
    private int zzd;
    private long zze;
    private zzac zzf;
    private zzak zzg;
    private byte zzh = 2;

    static {
        zzro zzroVar = new zzro();
        zza = zzroVar;
        zzxv.zzan(zzro.class, zzroVar);
    }

    private zzro() {
    }

    public static zzrn zze() {
        return (zzrn) zza.zzY();
    }

    public static zzro zzg(InputStream inputStream, zzxf zzxfVar) throws IOException {
        return (zzro) zzxv.zzae(zza, inputStream, zzxfVar);
    }

    static /* synthetic */ void zzh(zzro zzroVar, long j3) {
        zzroVar.zzd |= 1;
        zzroVar.zze = j3;
    }

    static /* synthetic */ void zzi(zzro zzroVar, zzac zzacVar) {
        zzacVar.getClass();
        zzroVar.zzf = zzacVar;
        zzroVar.zzd |= 2;
    }

    static /* synthetic */ void zzj(zzro zzroVar, zzak zzakVar) {
        zzakVar.getClass();
        zzroVar.zzg = zzakVar;
        zzroVar.zzd |= 4;
    }

    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔂ\u0000\u0002ᔉ\u0001\u0003ᐉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzro();
        }
        zzrm zzrmVar = null;
        if (i4 == 4) {
            return new zzrn(zzrmVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final zzac zzc() {
        zzac zzacVar = this.zzf;
        return zzacVar == null ? zzac.zzk() : zzacVar;
    }

    public final zzak zzd() {
        zzak zzakVar = this.zzg;
        return zzakVar == null ? zzak.zzf() : zzakVar;
    }

    public final boolean zzk() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzl() {
        return (this.zzd & 4) != 0;
    }
}
