package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbnd extends zzbix {
    zzbnd() {
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public void c(int i3) {
        f().c(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public void d() {
        f().d();
    }

    @Override // com.google.android.libraries.places.internal.zzbix
    public void e(String str, Throwable th) {
        f().e(str, th);
    }

    protected abstract zzbix f();

    public final String toString() {
        return MoreObjects.c(this).d("delegate", f()).toString();
    }
}
