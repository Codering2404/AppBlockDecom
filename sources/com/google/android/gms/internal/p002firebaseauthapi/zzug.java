package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzug extends zzalf<zzug, zza> implements zzamo {
    private static final zzug zzc;
    private static volatile zzamv<zzug> zzd;
    private int zze;
    private int zzf;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzug, zza> implements zzamo {
        public final zza zza(int i3) {
            zzg();
            ((zzug) this.zza).zze = i3;
            return this;
        }

        private zza() {
            super(zzug.zzc);
        }
    }

    static {
        zzug zzugVar = new zzug();
        zzc = zzugVar;
        zzalf.zza((Class<zzug>) zzug.class, zzugVar);
    }

    private zzug() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    public static zzug zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzug) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzui.zza[i3 - 1]) {
            case 1:
                return new zzug();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzug> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzug.class) {
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
}
