package com.google.crypto.tink.subtle;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.EngineWrapper;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class EngineFactory<T_WRAPPER extends EngineWrapper<JcePrimitiveT>, JcePrimitiveT> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EngineFactory f87432b = new EngineFactory(new EngineWrapper.TCipher());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EngineFactory f87433c = new EngineFactory(new EngineWrapper.TMac());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EngineFactory f87434d = new EngineFactory(new EngineWrapper.TSignature());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final EngineFactory f87435e = new EngineFactory(new EngineWrapper.TMessageDigest());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EngineFactory f87436f = new EngineFactory(new EngineWrapper.TKeyAgreement());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EngineFactory f87437g = new EngineFactory(new EngineWrapper.TKeyPairGenerator());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final EngineFactory f87438h = new EngineFactory(new EngineWrapper.TKeyFactory());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Policy f87439a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AndroidPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EngineWrapper f87440a;

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public Object a(String str) {
            Iterator it = EngineFactory.b("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f87440a.a(str, (Provider) it.next());
                } catch (Exception e3) {
                    if (exc == null) {
                        exc = e3;
                    }
                }
            }
            return this.f87440a.a(str, null);
        }

        private AndroidPolicy(EngineWrapper engineWrapper) {
            this.f87440a = engineWrapper;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DefaultPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EngineWrapper f87441a;

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public Object a(String str) {
            return this.f87441a.a(str, null);
        }

        private DefaultPolicy(EngineWrapper engineWrapper) {
            this.f87441a = engineWrapper;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FipsPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EngineWrapper f87442a;

        private FipsPolicy(EngineWrapper engineWrapper) {
            this.f87442a = engineWrapper;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public Object a(String str) throws GeneralSecurityException {
            Iterator it = EngineFactory.b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.f87442a.a(str, (Provider) it.next());
                } catch (Exception e3) {
                    if (exc == null) {
                        exc = e3;
                    }
                }
            }
            throw new GeneralSecurityException(bfIdKSjLOVjG.KjhOsoFqahVTHO, exc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface Policy<JcePrimitiveT> {
        Object a(String str);
    }

    public EngineFactory(EngineWrapper engineWrapper) {
        if (TinkFipsUtil.c()) {
            this.f87439a = new FipsPolicy(engineWrapper);
        } else if (SubtleUtil.a()) {
            this.f87439a = new AndroidPolicy(engineWrapper);
        } else {
            this.f87439a = new DefaultPolicy(engineWrapper);
        }
    }

    public static List b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public Object a(String str) {
        return this.f87439a.a(str);
    }
}
