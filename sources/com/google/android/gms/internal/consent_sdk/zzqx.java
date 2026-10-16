package com.google.android.gms.internal.consent_sdk;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzqx implements Iterator {
    private final Iterator zza;

    public zzqx(Iterator it) {
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        return entry.getValue() instanceof zzqz ? new zzqw(entry, null) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
    }
}
