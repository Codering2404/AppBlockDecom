package com.google.crypto.tink.prf;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacPrfKey;
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HmacPrfParams;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HmacPrfKeyManager extends KeyTypeManager<HmacPrfKey> {

    /* JADX INFO: renamed from: com.google.crypto.tink.prf.HmacPrfKeyManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86413a;

        static {
            int[] iArr = new int[HashType.values().length];
            f86413a = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86413a[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86413a[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86413a[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f86413a[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public HmacPrfKeyManager() {
        super(HmacPrfKey.class, new PrimitiveFactory<Prf, HmacPrfKey>(Prf.class) { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager.1
        });
    }

    public static void f(boolean z2) {
        Registry.e(new HmacPrfKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility a() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.HmacPrfKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<HmacPrfKeyFormat, HmacPrfKey>(HmacPrfKeyFormat.class) { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                HmacPrfKeyFormat hmacPrfKeyFormat = (HmacPrfKeyFormat) HmacPrfKeyFormat.T().K((HmacPrfParams) HmacPrfParams.S().J(HashType.SHA256).build()).J(32).build();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("HMAC_SHA256_PRF", new KeyTypeManager.KeyFactory.KeyFormat(hmacPrfKeyFormat, outputPrefixType));
                map.put("HMAC_SHA512_PRF", new KeyTypeManager.KeyFactory.KeyFormat((HmacPrfKeyFormat) HmacPrfKeyFormat.T().K((HmacPrfParams) HmacPrfParams.S().J(HashType.SHA512).build()).J(64).build(), outputPrefixType));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
