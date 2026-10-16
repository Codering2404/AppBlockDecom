package com.google.android.gms.internal.ads;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.google.android.gms.internal.ads.zzhap;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzhbc extends zzhap.zzf {
    private static final zzhaz zzbq;
    private static final zzhce zzbr = new zzhce(zzhbc.class);
    volatile int remainingField;
    volatile Set<Throwable> seenExceptionsField = null;

    zzhbc(int i3) {
        this.remainingField = i3;
    }

    final Set zzB() {
        Set<Throwable> set = this.seenExceptionsField;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzf(setNewSetFromMap);
        zzbq.zza(this, null, setNewSetFromMap);
        Set<Throwable> set2 = this.seenExceptionsField;
        Objects.requireNonNull(set2);
        return set2;
    }

    final int zzC() {
        return zzbq.zzb(this);
    }

    abstract void zzf(Set set);

    static {
        Throwable th;
        zzhaz zzhbbVar;
        byte[] bArr = null;
        try {
            zzhbbVar = new zzhba(bArr);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzhbbVar = new zzhbb(bArr);
        }
        zzbq = zzhbbVar;
        if (th != null) {
            zzbr.zza().logp(Level.SEVERE, QaXmqxvjHhxVy.ZEd, "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }
}
