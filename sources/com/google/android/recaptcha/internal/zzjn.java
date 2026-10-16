package com.google.android.recaptcha.internal;

import java.util.Collection;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzjn extends zzjl implements Queue {
    protected zzjn() {
    }

    @Override // java.util.Queue
    public final Object element() {
        return zzd().element();
    }

    public boolean offer(Object obj) {
        return zzd().offer(obj);
    }

    @Override // java.util.Queue
    @CheckForNull
    public final Object peek() {
        return zzd().peek();
    }

    @Override // java.util.Queue
    @CheckForNull
    public final Object poll() {
        return zzd().poll();
    }

    @Override // java.util.Queue
    public final Object remove() {
        return zzd().remove();
    }

    @Override // com.google.android.recaptcha.internal.zzjl
    protected /* bridge */ /* synthetic */ Collection zzc() {
        throw null;
    }

    protected abstract Queue zzd();
}
