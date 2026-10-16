package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeqx extends zzcvs {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzeqx(zzerb zzerbVar, View view, zzcku zzckuVar, zzcxr zzcxrVar, zzfkg zzfkgVar) {
        super(view, null, zzcxrVar, zzfkgVar);
        Objects.requireNonNull(zzerbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzded zze(Set set) {
        return new zzded(Collections.EMPTY_SET);
    }
}
