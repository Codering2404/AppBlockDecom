package com.google.crypto.tink.jwt;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class JwtPublicKeySignWrapper implements PrimitiveWrapper<JwtPublicKeySignInternal, JwtPublicKeySign> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JwtPublicKeySignWrapper f86300a = new JwtPublicKeySignWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    private static class WrappedJwtPublicKeySign implements JwtPublicKeySign {
    }

    JwtPublicKeySignWrapper() {
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class a() {
        return JwtPublicKeySign.class;
    }
}
