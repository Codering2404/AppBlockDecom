package com.google.crypto.tink.mac;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MacWrapper implements PrimitiveWrapper<Mac, Mac> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f86377a = Logger.getLogger(MacWrapper.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f86378b = {0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final MacWrapper f86379c = new MacWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WrappedMac implements Mac {
    }

    MacWrapper() {
    }

    public static void b() {
        Registry.g(f86379c);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return Mac.class;
    }
}
