package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxq extends zzalf<zzxq, zza> implements zzamo {
    private static final zzxq zzc;
    private static volatile zzamv<zzxq> zzd;
    private String zze = "";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzxq, zza> implements zzamo {
        public final zza zza(String str) {
            zzg();
            zzxq.zza((zzxq) this.zza, str);
            return this;
        }

        private zza() {
            super(zzxq.zzc);
        }
    }

    static {
        zzxq zzxqVar = new zzxq();
        zzc = zzxqVar;
        zzalf.zza((Class<zzxq>) zzxq.class, zzxqVar);
    }

    private zzxq() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzxq zzc() {
        return zzc;
    }

    public final String zzd() {
        return this.zze;
    }

    public static zzxq zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzxq) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzxs.zza[i3 - 1]) {
            case 1:
                return new zzxq();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxq> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzxq.class) {
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

    static /* synthetic */ void zza(zzxq zzxqVar, String str) {
        str.getClass();
        zzxqVar.zze = str;
    }
}
