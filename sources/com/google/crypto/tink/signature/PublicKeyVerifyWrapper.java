package com.google.crypto.tink.signature;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.Registry;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class PublicKeyVerifyWrapper implements PrimitiveWrapper<PublicKeyVerify, PublicKeyVerify> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f87266a = Logger.getLogger(PublicKeyVerifyWrapper.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f87267b = {0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final PublicKeyVerifyWrapper f87268c = new PublicKeyVerifyWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WrappedPublicKeyVerify implements PublicKeyVerify {
    }

    PublicKeyVerifyWrapper() {
    }

    public static void b() {
        Registry.g(f87268c);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return PublicKeyVerify.class;
    }
}
