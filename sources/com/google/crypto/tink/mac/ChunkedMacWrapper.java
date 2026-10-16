package com.google.crypto.tink.mac;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ChunkedMacWrapper implements PrimitiveWrapper<ChunkedMac, ChunkedMac> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ChunkedMacWrapper f86342a = new ChunkedMacWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    private static class WrappedChunkedMac implements ChunkedMac {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WrappedChunkedMacVerification implements ChunkedMacVerification {
    }

    private ChunkedMacWrapper() {
    }

    static void b() {
        Registry.g(f86342a);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return ChunkedMac.class;
    }
}
