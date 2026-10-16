package com.google.common.escape;

import com.google.common.base.Function;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public abstract class Escaper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function f84885a = new Function() { // from class: com.google.common.escape.a
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return this.f84894a.a((String) obj);
        }
    };

    protected Escaper() {
    }

    public abstract String a(String str);
}
