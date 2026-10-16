package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgyv extends AbstractSet {
    private zzgyv() {
        throw null;
    }

    static int zzd(Set set) {
        return set instanceof zzgyv ? ((zzgyv) set).zzc() : set.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        Set set;
        int iZzd;
        int size;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set) || (iZzd = zzd((set = (Set) obj))) < 0) {
            return false;
        }
        if (set instanceof zzgyv) {
            ((zzgyv) set).zzb();
            size = 0;
        } else {
            size = set.size();
        }
        if (zzc() < size) {
            return false;
        }
        zzgza it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                return false;
            }
            i3++;
        }
        if (i3 == iZzd) {
            return true;
        }
        if (i3 < size) {
            return false;
        }
        Iterator it2 = set.iterator();
        int i4 = 0;
        while (it2.hasNext()) {
            it2.next();
            i4++;
            if (i4 > i3) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @Deprecated
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract zzgza iterator();

    abstract int zzb();

    abstract int zzc();

    /* synthetic */ zzgyv(byte[] bArr) {
    }
}
