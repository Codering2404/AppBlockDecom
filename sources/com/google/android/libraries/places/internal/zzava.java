package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzava extends zzbdk implements zzbey {
    private zzava() {
        throw null;
    }

    public final List y() {
        return Collections.unmodifiableList(((zzavl) this.f76081b).G());
    }

    public final zzava z(Iterable iterable) {
        w();
        ((zzavl) this.f76081b).I(iterable);
        return this;
    }

    /* synthetic */ zzava(byte[] bArr) {
        super(zzavl.zzp);
    }
}
