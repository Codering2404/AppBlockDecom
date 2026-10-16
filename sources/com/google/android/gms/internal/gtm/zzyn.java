package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyn extends zztn implements RandomAccess, zzyo {

    @Deprecated
    public static final zzyo zza;
    private static final zzyn zzb;
    private final List zzc;

    static {
        zzyn zzynVar = new zzyn(false);
        zzb = zzynVar;
        zza = zzynVar;
    }

    public zzyn() {
        this(10);
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzud ? ((zzud) obj).zzm(zzye.zzb) : zzye.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i3, Object obj) {
        zza();
        this.zzc.add(i3, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final boolean addAll(int i3, Collection collection) {
        zza();
        if (collection instanceof zzyo) {
            collection = ((zzyo) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i3, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        Object objRemove = this.zzc.remove(i3);
        ((AbstractList) this).modCount++;
        return zzj(objRemove);
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        zza();
        return zzj(this.zzc.set(i3, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.gtm.zzyd
    public final /* bridge */ /* synthetic */ zzyd zzd(int i3) {
        if (i3 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i3);
        arrayList.addAll(this.zzc);
        return new zzyn(arrayList);
    }

    @Override // com.google.android.gms.internal.gtm.zzyo
    public final zzyo zze() {
        return zzc() ? new zzaap(this) : this;
    }

    @Override // com.google.android.gms.internal.gtm.zzyo
    public final Object zzf(int i3) {
        return this.zzc.get(i3);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i3) {
        Object obj = this.zzc.get(i3);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzud) {
            zzud zzudVar = (zzud) obj;
            String strZzm = zzudVar.zzm(zzye.zzb);
            if (zzudVar.zzi()) {
                this.zzc.set(i3, strZzm);
            }
            return strZzm;
        }
        byte[] bArr = (byte[]) obj;
        String strZzd = zzye.zzd(bArr);
        if (zzaaz.zze(bArr)) {
            this.zzc.set(i3, strZzd);
        }
        return strZzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzyo
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.gtm.zzyo
    public final void zzi(zzud zzudVar) {
        zza();
        this.zzc.add(zzudVar);
        ((AbstractList) this).modCount++;
    }

    public zzyn(int i3) {
        ArrayList arrayList = new ArrayList(i3);
        super(true);
        this.zzc = arrayList;
    }

    private zzyn(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzyn(boolean z2) {
        super(false);
        this.zzc = Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
