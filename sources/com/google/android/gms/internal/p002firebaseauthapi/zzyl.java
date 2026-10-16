package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyl extends zzalf<zzyl, zza> implements zzamo {
    private static final zzyl zzc;
    private static volatile zzamv<zzyl> zzd;
    private int zze;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzyl, zza> implements zzamo {
        public final zza zza(int i3) {
            zzg();
            ((zzyl) this.zza).zze = i3;
            return this;
        }

        private zza() {
            super(zzyl.zzc);
        }
    }

    static {
        zzyl zzylVar = new zzyl();
        zzc = zzylVar;
        zzalf.zza((Class<zzyl>) zzyl.class, zzylVar);
    }

    private zzyl() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzyl zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzyk.zza[i3 - 1]) {
            case 1:
                return new zzyl();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyl> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzyl.class) {
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
