package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class PrfHmacJce implements Prf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f87471c = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f87472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Key f87473b;

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.PrfHmacJce$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends ThreadLocal<Mac> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrfHmacJce f87474a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Mac initialValue() {
            try {
                Mac mac = (Mac) EngineFactory.f87433c.a(this.f87474a.f87472a);
                mac.init(this.f87474a.f87473b);
                return mac;
            } catch (GeneralSecurityException e3) {
                throw new IllegalStateException(e3);
            }
        }
    }
}
