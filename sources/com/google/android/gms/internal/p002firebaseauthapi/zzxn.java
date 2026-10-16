package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxn extends zzalf<zzxn, zza> implements zzamo {
    private static final zzxn zzc;
    private static volatile zzamv<zzxn> zzd;
    private int zze;
    private int zzf;
    private zzxq zzg;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzxn, zza> implements zzamo {
        public final zza zza(zzxq zzxqVar) {
            zzg();
            zzxn.zza((zzxn) this.zza, zzxqVar);
            return this;
        }

        private zza() {
            super(zzxn.zzc);
        }
    }

    static {
        zzxn zzxnVar = new zzxn();
        zzc = zzxnVar;
        zzalf.zza((Class<zzxn>) zzxn.class, zzxnVar);
    }

    private zzxn() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamv<zzxn> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzxq zzd() {
        zzxq zzxqVar = this.zzg;
        return zzxqVar == null ? zzxq.zzc() : zzxqVar;
    }

    public static zzxn zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzxn) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzxp.zza[i3 - 1]) {
            case 1:
                return new zzxn();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxn> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzxn.class) {
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

    static /* synthetic */ void zza(zzxn zzxnVar, zzxq zzxqVar) {
        zzxqVar.getClass();
        zzxnVar.zzg = zzxqVar;
        zzxnVar.zze |= 1;
    }
}
