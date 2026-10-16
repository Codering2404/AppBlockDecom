package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzud extends zzalf<zzud, zza> implements zzamo {
    private static final zzud zzc;
    private static volatile zzamv<zzud> zzd;
    private int zze;
    private zzajv zzf = zzajv.zza;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzud, zza> implements zzamo {
        public final zza zza(zzajv zzajvVar) {
            zzg();
            zzud.zza((zzud) this.zza, zzajvVar);
            return this;
        }

        private zza() {
            super(zzud.zzc);
        }
    }

    static {
        zzud zzudVar = new zzud();
        zzc = zzudVar;
        zzalf.zza((Class<zzud>) zzud.class, zzudVar);
    }

    private zzud() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamv<zzud> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajv zzd() {
        return this.zzf;
    }

    public static zzud zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzud) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzuf.zza[i3 - 1]) {
            case 1:
                return new zzud();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzud> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzud.class) {
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

    static /* synthetic */ void zza(zzud zzudVar, zzajv zzajvVar) {
        zzajvVar.getClass();
        zzudVar.zzf = zzajvVar;
    }
}
