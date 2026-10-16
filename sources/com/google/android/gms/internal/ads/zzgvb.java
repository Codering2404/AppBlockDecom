package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzgvb extends zzguz implements List {
    final /* synthetic */ zzgvc zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgvb(zzgvc zzgvcVar, Object obj, List list, zzguz zzguzVar) {
        super(zzgvcVar, obj, list, zzguzVar);
        Objects.requireNonNull(zzgvcVar);
        this.zzf = zzgvcVar;
    }

    @Override // java.util.List
    public final void add(int i3, Object obj) {
        zza();
        boolean zIsEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i3, obj);
        zzgvc zzgvcVar = this.zzf;
        zzgvcVar.zzq(zzgvcVar.zzp() + 1);
        if (zIsEmpty) {
            zzc();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i3, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.zzb).addAll(i3, collection);
        if (!zAddAll) {
            return zAddAll;
        }
        int size2 = this.zzb.size();
        zzgvc zzgvcVar = this.zzf;
        zzgvcVar.zzq(zzgvcVar.zzp() + (size2 - size));
        if (size != 0) {
            return zAddAll;
        }
        zzc();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zza();
        return ((List) this.zzb).get(i3);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        zza();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        zza();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        zza();
        return new zzgva(this);
    }

    @Override // java.util.List
    public final Object remove(int i3) {
        zza();
        Object objRemove = ((List) this.zzb).remove(i3);
        this.zzf.zzq(r0.zzp() - 1);
        zzb();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i3, Object obj) {
        zza();
        return ((List) this.zzb).set(i3, obj);
    }

    @Override // java.util.List
    public final List subList(int i3, int i4) {
        zza();
        List listSubList = ((List) this.zzb).subList(i3, i4);
        zzguz zzguzVar = this.zzc;
        if (zzguzVar == null) {
            zzguzVar = this;
        }
        return this.zzf.zzg(this.zza, listSubList, zzguzVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i3) {
        zza();
        return new zzgva(this, i3);
    }
}
