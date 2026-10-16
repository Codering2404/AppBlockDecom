package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzigf implements Iterator {
    private final ArrayDeque zza;
    private zzicx zzb;

    /* synthetic */ zzigf(zzida zzidaVar, byte[] bArr) {
        if (!(zzidaVar instanceof zzigg)) {
            this.zza = null;
            this.zzb = (zzicx) zzidaVar;
            return;
        }
        zzigg zziggVar = (zzigg) zzidaVar;
        ArrayDeque arrayDeque = new ArrayDeque(zziggVar.zzp());
        this.zza = arrayDeque;
        arrayDeque.push(zziggVar);
        this.zzb = zzb(zziggVar.zzo());
    }

    private final zzicx zzb(zzida zzidaVar) {
        while (zzidaVar instanceof zzigg) {
            zzigg zziggVar = (zzigg) zzidaVar;
            this.zza.push(zziggVar);
            zzidaVar = zziggVar.zzo();
        }
        return (zzicx) zzidaVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzicx next() {
        zzicx zzicxVarZzb;
        zzicx zzicxVar = this.zzb;
        if (zzicxVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzicxVarZzb = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzicxVarZzb = zzb(((zzigg) arrayDeque.pop()).zzF());
        } while (zzicxVarZzb.zzs());
        this.zzb = zzicxVarZzb;
        return zzicxVar;
    }
}
