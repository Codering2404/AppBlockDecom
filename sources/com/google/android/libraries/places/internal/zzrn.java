package com.google.android.libraries.places.internal;

import androidx.collection.SimpleArrayMap;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzrn extends zzro {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final zzro f78514e;

    static {
        zzro zzroVarB = new zzrn(null, new SimpleArrayMap(0)).b();
        f78514e = zzroVarB;
        zzrn zzrnVar = new zzrn(zzroVarB, new SimpleArrayMap(), null);
        boolean z2 = !zzrnVar.h();
        Boolean bool = Boolean.TRUE;
        Preconditions.A(z2, "Can't mutate after handing to trace");
        Preconditions.t(bool);
        zzrm zzrmVar = zzro.f78515d;
        Preconditions.A(!zzrnVar.d(zzrmVar), "Key already present");
        zzrnVar.g().put(zzrmVar, bool);
        zzrnVar.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private zzrn(zzro zzroVar, SimpleArrayMap simpleArrayMap) {
        super(null, simpleArrayMap, 0 == true ? 1 : 0);
    }

    /* synthetic */ zzrn(zzro zzroVar, SimpleArrayMap simpleArrayMap, byte[] bArr) {
        super(zzroVar, simpleArrayMap, null);
    }
}
