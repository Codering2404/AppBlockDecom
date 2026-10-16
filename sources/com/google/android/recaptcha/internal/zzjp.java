package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzjp extends zzjk {
    final /* synthetic */ Iterable zza;
    final /* synthetic */ int zzb;

    zzjp(Iterable iterable, int i3) {
        this.zza = iterable;
        this.zzb = i3;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterable iterable = this.zza;
        if (iterable instanceof List) {
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.zzb), list.size()).iterator();
        }
        int i3 = this.zzb;
        Iterator it = iterable.iterator();
        it.getClass();
        zzjf.zzb(i3 >= 0, "numberToAdvance must be nonnegative");
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            it.next();
        }
        return new zzjo(this, it);
    }
}
