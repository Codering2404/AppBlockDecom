package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyr extends zzalf<zzyr, zza> implements zzamo {
    private static final zzyr zzc;
    private static volatile zzamv<zzyr> zzd;
    private int zze;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzyr, zza> implements zzamo {
        private zza() {
            super(zzyr.zzc);
        }
    }

    static {
        zzyr zzyrVar = new zzyr();
        zzc = zzyrVar;
        zzalf.zza((Class<zzyr>) zzyr.class, zzyrVar);
    }

    private zzyr() {
    }

    public static zzyr zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public static zzyr zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzyr) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzyq.zza[i3 - 1]) {
            case 1:
                return new zzyr();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyr> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzyr.class) {
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
