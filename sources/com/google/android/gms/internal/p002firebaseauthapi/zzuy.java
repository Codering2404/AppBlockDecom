package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzuy extends zzalf<zzuy, zza> implements zzamo {
    private static final zzuy zzc;
    private static volatile zzamv<zzuy> zzd;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzuy, zza> implements zzamo {
        private zza() {
            super(zzuy.zzc);
        }
    }

    static {
        zzuy zzuyVar = new zzuy();
        zzc = zzuyVar;
        zzalf.zza((Class<zzuy>) zzuy.class, zzuyVar);
    }

    private zzuy() {
    }

    public static zzuy zzb() {
        return zzc;
    }

    public static zzuy zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzuy) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzva.zza[i3 - 1]) {
            case 1:
                return new zzuy();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzamv<zzuy> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzuy.class) {
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
