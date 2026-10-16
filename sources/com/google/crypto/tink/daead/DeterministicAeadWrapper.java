package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DeterministicAeadWrapper implements PrimitiveWrapper<DeterministicAead, DeterministicAead> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f86166a = Logger.getLogger(DeterministicAeadWrapper.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DeterministicAeadWrapper f86167b = new DeterministicAeadWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WrappedDeterministicAead implements DeterministicAead {
    }

    DeterministicAeadWrapper() {
    }

    public static void b() {
        Registry.g(f86167b);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return DeterministicAead.class;
    }
}
