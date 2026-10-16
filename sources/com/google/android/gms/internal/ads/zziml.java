package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziml extends AbstractList {
    private static final zzimm zzc = zzimm.zzb(zziml.class);
    final List zza;
    final Iterator zzb;

    public zziml(List list, Iterator it) {
        this.zza = list;
        this.zzb = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        List list = this.zza;
        if (list.size() > i3) {
            return list.get(i3);
        }
        Iterator it = this.zzb;
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        list.add(it.next());
        return get(i3);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzimk(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        zzimm zzimmVar = zzc;
        zzimmVar.zza("potentially expensive size() call");
        zzimmVar.zza("blowup running");
        while (true) {
            Iterator it = this.zzb;
            if (!it.hasNext()) {
                return this.zza.size();
            }
            this.zza.add(it.next());
        }
    }
}
