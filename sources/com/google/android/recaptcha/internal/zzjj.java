package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzjj extends zzjn implements Serializable {
    final int zza;
    private final Queue zzb;

    private zzjj(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException(zzji.zza("maxSize (%s) must >= 0", Integer.valueOf(i3)));
        }
        this.zzb = new ArrayDeque(i3);
        this.zza = i3;
    }

    public static zzjj zza(int i3) {
        return new zzjj(i3);
    }

    @Override // com.google.android.recaptcha.internal.zzjl, java.util.Collection, java.util.Queue
    public final boolean add(Object obj) {
        obj.getClass();
        if (this.zza == 0) {
            return true;
        }
        if (size() == this.zza) {
            this.zzb.remove();
        }
        this.zzb.add(obj);
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzjl, java.util.Collection
    public final boolean addAll(Collection collection) {
        int size = collection.size();
        if (size < this.zza) {
            return zzjq.zza(this, collection.iterator());
        }
        clear();
        int i3 = size - this.zza;
        zzjf.zzb(i3 >= 0, "number to skip cannot be negative");
        return zzjq.zza(this, new zzjp(collection, i3).iterator());
    }

    @Override // com.google.android.recaptcha.internal.zzjn, java.util.Queue
    public final boolean offer(Object obj) {
        add(obj);
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzjl, com.google.android.recaptcha.internal.zzjm
    protected final /* synthetic */ Object zzb() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzjn, com.google.android.recaptcha.internal.zzjl
    protected final /* synthetic */ Collection zzc() {
        return this.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzjn
    protected final Queue zzd() {
        return this.zzb;
    }
}
