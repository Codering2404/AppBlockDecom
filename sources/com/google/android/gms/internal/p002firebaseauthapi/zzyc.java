package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzyc extends zzalf<zzyc, zza> implements zzamo {
    private static final zzyc zzc;
    private static volatile zzamv<zzyc> zzd;
    private String zze = "";
    private zzalm<zzxe> zzf = zzalf.zzp();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzyc, zza> implements zzamo {
        private zza() {
            super(zzyc.zzc);
        }
    }

    static {
        zzyc zzycVar = new zzyc();
        zzc = zzycVar;
        zzalf.zza((Class<zzyc>) zzyc.class, zzycVar);
    }

    private zzyc() {
    }

    public static zzyc zzb() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzyb.zza[i3 - 1]) {
            case 1:
                return new zzyc();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzxe.class});
            case 4:
                return zzc;
            case 5:
                zzamv<zzyc> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzyc.class) {
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
