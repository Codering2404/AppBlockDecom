package com.google.crypto.tink.prf;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class PrfSetWrapper implements PrimitiveWrapper<Prf, PrfSet> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PrfSetWrapper f86419a = new PrfSetWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WrappedPrfSet extends PrfSet {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Immutable
        private static class PrfWithMonitoring implements Prf {
        }
    }

    public static void b() {
        Registry.g(f86419a);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return PrfSet.class;
    }
}
