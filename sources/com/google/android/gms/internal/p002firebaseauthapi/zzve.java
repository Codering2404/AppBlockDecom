package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzve extends zzalf<zzve, zza> implements zzamo {
    private static final zzve zzc;
    private static volatile zzamv<zzve> zzd;
    private int zze;
    private zzxb zzf;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzve, zza> implements zzamo {
        public final zza zza(zzxb zzxbVar) {
            zzg();
            zzve.zza((zzve) this.zza, zzxbVar);
            return this;
        }

        private zza() {
            super(zzve.zzc);
        }
    }

    static {
        zzve zzveVar = new zzve();
        zzc = zzveVar;
        zzalf.zza((Class<zzve>) zzve.class, zzveVar);
    }

    private zzve() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzve zzc() {
        return zzc;
    }

    public final zzxb zzd() {
        zzxb zzxbVar = this.zzf;
        return zzxbVar == null ? zzxb.zzc() : zzxbVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzvd.zza[i3 - 1]) {
            case 1:
                return new zzve();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzve> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzve.class) {
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

    static /* synthetic */ void zza(zzve zzveVar, zzxb zzxbVar) {
        zzxbVar.getClass();
        zzveVar.zzf = zzxbVar;
        zzveVar.zze |= 1;
    }
}
