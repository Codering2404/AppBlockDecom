package com.google.android.libraries.places.internal;

import androidx.collection.SimpleArrayMap;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zzro {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzrm f78515d = zzrm.a(Boolean.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzro f78516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SimpleArrayMap f78517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f78518c = false;

    /* synthetic */ zzro(zzro zzroVar, SimpleArrayMap simpleArrayMap, byte[] bArr) {
        if (zzroVar != null) {
            Preconditions.d(zzroVar.f78518c);
        }
        this.f78516a = zzroVar;
        this.f78517b = simpleArrayMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static zzro a(zzro zzroVar, zzro zzroVar2) {
        if (zzroVar.c()) {
            return zzroVar2;
        }
        if (zzroVar2.c()) {
            return zzroVar;
        }
        ImmutableSet<zzro> immutableSetB = ImmutableSet.B(zzroVar, zzroVar2);
        if (immutableSetB.isEmpty()) {
            return zzrn.f78514e;
        }
        if (immutableSetB.size() == 1) {
            return (zzro) immutableSetB.iterator().next();
        }
        int size = 0;
        for (zzro zzroVar3 : immutableSetB) {
            do {
                size += zzroVar3.f78517b.size();
                zzroVar3 = zzroVar3.f78516a;
            } while (zzroVar3 != null);
        }
        if (size == 0) {
            return zzrn.f78514e;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(size);
        for (zzro zzroVar4 : immutableSetB) {
            do {
                int i3 = 0;
                while (true) {
                    SimpleArrayMap simpleArrayMap2 = zzroVar4.f78517b;
                    if (i3 >= simpleArrayMap2.size()) {
                        break;
                    }
                    Preconditions.m(simpleArrayMap.put((zzrm) simpleArrayMap2.f(i3), simpleArrayMap2.j(i3)) == null, "Duplicate bindings: %s", simpleArrayMap2.f(i3));
                    i3++;
                }
                zzroVar4 = zzroVar4.f78516a;
            } while (zzroVar4 != null);
        }
        return new zzrn(null, simpleArrayMap, 0 == true ? 1 : 0).b();
    }

    final zzro b() {
        if (this.f78518c) {
            throw new IllegalStateException("Already frozen");
        }
        this.f78518c = true;
        zzro zzroVar = this.f78516a;
        return (zzroVar == null || !this.f78517b.isEmpty()) ? this : zzroVar;
    }

    public final boolean c() {
        return this == zzrn.f78514e;
    }

    final boolean d(zzrm zzrmVar) {
        if (this.f78517b.containsKey(zzrmVar)) {
            return true;
        }
        zzro zzroVar = this.f78516a;
        return zzroVar != null && zzroVar.d(zzrmVar);
    }

    final boolean e() {
        return this.f78518c;
    }

    final /* synthetic */ SimpleArrayMap g() {
        return this.f78517b;
    }

    final /* synthetic */ boolean h() {
        return this.f78518c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SpanExtras<");
        for (zzro zzroVar = this; zzroVar != null; zzroVar = zzroVar.f78516a) {
            for (int i3 = 0; i3 < zzroVar.f78517b.size(); i3++) {
                sb.append(this.f78517b.j(i3));
                sb.append("], ");
            }
        }
        sb.append(">");
        return sb.toString();
    }
}
