package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class HybridEncryptWrapper implements PrimitiveWrapper<HybridEncrypt, HybridEncrypt> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HybridEncryptWrapper f86178a = new HybridEncryptWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WrappedHybridEncrypt implements HybridEncrypt {
    }

    HybridEncryptWrapper() {
    }

    public static void b() {
        Registry.g(f86178a);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return HybridEncrypt.class;
    }
}
