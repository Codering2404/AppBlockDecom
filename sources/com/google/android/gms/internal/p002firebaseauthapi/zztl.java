package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zztl extends zzalf<zztl, zza> implements zzamo {
    private static final zztl zzc;
    private static volatile zzamv<zztl> zzd;
    private int zze;
    private int zzf;
    private zztr zzg;
    private zzajv zzh = zzajv.zza;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zztl, zza> implements zzamo {
        public final zza zza(zzajv zzajvVar) {
            zzg();
            zztl.zza((zztl) this.zza, zzajvVar);
            return this;
        }

        private zza() {
            super(zztl.zzc);
        }

        public final zza zza(zztr zztrVar) {
            zzg();
            zztl.zza((zztl) this.zza, zztrVar);
            return this;
        }
    }

    static {
        zztl zztlVar = new zztl();
        zzc = zztlVar;
        zzalf.zza((Class<zztl>) zztl.class, zztlVar);
    }

    private zztl() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zztl zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zztr zze() {
        zztr zztrVar = this.zzg;
        return zztrVar == null ? zztr.zzd() : zztrVar;
    }

    public final zzajv zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zztn.zza[i3 - 1]) {
            case 1:
                return new zztl();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamv<zztl> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zztl.class) {
                    try {
                        zzaVar = zzd;
                        if (zzaVar == null) {
                            zzaVar = new zzalf.zza(zzc);
                            zzd = zzaVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return zzaVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    static /* synthetic */ void zza(zztl zztlVar, zzajv zzajvVar) {
        zzajvVar.getClass();
        zztlVar.zzh = zzajvVar;
    }

    static /* synthetic */ void zza(zztl zztlVar, zztr zztrVar) {
        zztrVar.getClass();
        zztlVar.zzg = zztrVar;
        zztlVar.zze |= 1;
    }
}
