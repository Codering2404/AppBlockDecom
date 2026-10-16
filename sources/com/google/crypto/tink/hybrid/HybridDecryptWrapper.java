package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class HybridDecryptWrapper implements PrimitiveWrapper<HybridDecrypt, HybridDecrypt> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f86176a = Logger.getLogger(HybridDecryptWrapper.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HybridDecryptWrapper f86177b = new HybridDecryptWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WrappedHybridDecrypt implements HybridDecrypt {
    }

    HybridDecryptWrapper() {
    }

    public static void b() {
        Registry.g(f86177b);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return HybridDecrypt.class;
    }
}
