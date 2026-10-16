package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxt extends zzalf<zzxt, zza> implements zzamo {
    private static final zzxt zzc;
    private static volatile zzamv<zzxt> zzd;
    private int zze;
    private int zzf;
    private zzxw zzg;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class zza extends zzalf.zzb<zzxt, zza> implements zzamo {
        public final zza zza(zzxw zzxwVar) {
            zzg();
            zzxt.zza((zzxt) this.zza, zzxwVar);
            return this;
        }

        private zza() {
            super(zzxt.zzc);
        }
    }

    static {
        zzxt zzxtVar = new zzxt();
        zzc = zzxtVar;
        zzalf.zza((Class<zzxt>) zzxt.class, zzxtVar);
    }

    private zzxt() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamv<zzxt> zze() {
        return (zzamv) zzc.zza(zzalf.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzxw zzd() {
        zzxw zzxwVar = this.zzg;
        return zzxwVar == null ? zzxw.zzd() : zzxwVar;
    }

    public static zzxt zza(zzajv zzajvVar, zzaku zzakuVar) throws zzall {
        return (zzxt) zzalf.zza(zzc, zzajvVar, zzakuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalf
    protected final Object zza(int i3, Object obj, Object obj2) {
        zzamv zzaVar;
        switch (zzxv.zza[i3 - 1]) {
            case 1:
                return new zzxt();
            case 2:
                return new zza();
            case 3:
                return zzalf.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamv<zzxt> zzamvVar = zzd;
                if (zzamvVar != null) {
                    return zzamvVar;
                }
                synchronized (zzxt.class) {
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

    static /* synthetic */ void zza(zzxt zzxtVar, zzxw zzxwVar) {
        zzxwVar.getClass();
        zzxtVar.zzg = zzxwVar;
        zzxtVar.zze |= 1;
    }
}
