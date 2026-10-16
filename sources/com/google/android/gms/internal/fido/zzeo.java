package com.google.android.gms.internal.fido;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeo extends zzei {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zze;
    private static final ConcurrentLinkedQueue zzf;
    private volatile zzdp zzg;

    static {
        String str = Build.FINGERPRINT;
        zza = str == null || "robolectric".equals(str);
        String str2 = Build.HARDWARE;
        zzb = "goldfish".equals(str2) || "ranchu".equals(str2);
        String str3 = Build.TYPE;
        zzc = "eng".equals(str3) || "userdebug".equals(str3);
        zzd = new AtomicReference();
        zze = new AtomicLong();
        zzf = new ConcurrentLinkedQueue();
    }

    private zzeo(String str) {
        super(str);
        if (zza || zzb) {
            this.zzg = new zzej().zza(zza());
        } else if (zzc) {
            this.zzg = zzeu.zzc().zzb(false).zza(zza());
        } else {
            this.zzg = null;
        }
    }

    public static zzdp zzb(String str) {
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zzek) atomicReference.get()).zza(str);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char cCharAt = str.charAt(length);
                if (cCharAt != '$') {
                    if (cCharAt == '.') {
                        break;
                    }
                } else {
                    str = str.replace('$', '.');
                    break;
                }
            } else {
                break;
            }
        }
        zzeo zzeoVar = new zzeo(str);
        zzem.zza.offer(zzeoVar);
        if (zzd.get() != null) {
            while (true) {
                zzeo zzeoVar2 = (zzeo) zzem.zza.poll();
                if (zzeoVar2 == null) {
                    break;
                }
                zzeoVar2.zzg = ((zzek) zzd.get()).zza(zzeoVar2.zza());
            }
            if (((zzen) zzf.poll()) != null) {
                zze.getAndDecrement();
                throw null;
            }
        }
        return zzeoVar;
    }
}
