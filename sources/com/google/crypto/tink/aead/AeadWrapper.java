package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AeadWrapper implements PrimitiveWrapper<Aead, Aead> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f86074a = Logger.getLogger(AeadWrapper.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AeadWrapper f86075b = new AeadWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WrappedAead implements Aead {
    }

    AeadWrapper() {
    }

    public static void b() {
        Registry.g(f86075b);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return Aead.class;
    }
}
