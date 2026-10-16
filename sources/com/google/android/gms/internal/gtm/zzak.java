package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzak extends zzxv implements zzzh {
    private static final zzak zza;
    private int zzd;
    private zzac zzf;
    private byte zzh = 2;
    private zzyd zze = zzxv.zzah();
    private String zzg = "";

    static {
        zzak zzakVar = new zzak();
        zza = zzakVar;
        zzxv.zzan(zzak.class, zzakVar);
    }

    private zzak() {
    }

    public static zzaj zzd() {
        return (zzaj) zza.zzY();
    }

    public static zzak zzf() {
        return zza;
    }

    public static zzak zzg(byte[] bArr, zzxf zzxfVar) throws zzyg {
        return (zzak) zzxv.zzaf(zza, bArr, zzxfVar);
    }

    static /* synthetic */ void zzk(zzak zzakVar, zzac zzacVar) {
        zzacVar.getClass();
        zzakVar.zzf = zzacVar;
        zzakVar.zzd |= 1;
    }

    static /* synthetic */ void zzl(zzak zzakVar, String str) {
        str.getClass();
        zzakVar.zzd |= 2;
        zzakVar.zzg = str;
    }

    public final int zza() {
        return this.zze.size();
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", zzai.class, "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzak();
        }
        zzn zznVar = null;
        if (i4 == 4) {
            return new zzaj(zznVar);
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

    public final String zzh() {
        return this.zzg;
    }

    public final List zzi() {
        return this.zze;
    }

    public final boolean zzm() {
        return (this.zzd & 1) != 0;
    }
}
