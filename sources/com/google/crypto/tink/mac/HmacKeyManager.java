package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HmacKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.HmacKey> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PrimitiveConstructor f86343d = PrimitiveConstructor.a(new a(), HmacKey.class, ChunkedMac.class);

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.HmacKeyManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86345a;

        static {
            int[] iArr = new int[HashType.values().length];
            f86345a = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86345a[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86345a[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86345a[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f86345a[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public HmacKeyManager() {
        super(com.google.crypto.tink.proto.HmacKey.class, new PrimitiveFactory<Mac, com.google.crypto.tink.proto.HmacKey>(Mac.class) { // from class: com.google.crypto.tink.mac.HmacKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat g(int i3, int i4, HashType hashType, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((HmacKeyFormat) HmacKeyFormat.T().K((HmacParams) HmacParams.T().J(hashType).K(i4).build()).J(i3).build(), outputPrefixType);
    }

    public static void h(boolean z2) {
        Registry.e(new HmacKeyManager(), z2);
        HmacProtoSerialization.a();
        MutablePrimitiveRegistry.a().b(f86343d);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility a() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<HmacKeyFormat, com.google.crypto.tink.proto.HmacKey>(HmacKeyFormat.class) { // from class: com.google.crypto.tink.mac.HmacKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("HMAC_SHA256_128BITTAG", HmacKeyManager.g(32, 16, hashType, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("HMAC_SHA256_128BITTAG_RAW", HmacKeyManager.g(32, 16, hashType, outputPrefixType2));
                map.put("HMAC_SHA256_256BITTAG", HmacKeyManager.g(32, 32, hashType, outputPrefixType));
                map.put("HMAC_SHA256_256BITTAG_RAW", HmacKeyManager.g(32, 32, hashType, outputPrefixType2));
                HashType hashType2 = HashType.SHA512;
                map.put("HMAC_SHA512_128BITTAG", HmacKeyManager.g(64, 16, hashType2, outputPrefixType));
                map.put("HMAC_SHA512_128BITTAG_RAW", HmacKeyManager.g(64, 16, hashType2, outputPrefixType2));
                map.put("HMAC_SHA512_256BITTAG", HmacKeyManager.g(64, 32, hashType2, outputPrefixType));
                map.put("HMAC_SHA512_256BITTAG_RAW", HmacKeyManager.g(64, 32, hashType2, outputPrefixType2));
                map.put("HMAC_SHA512_512BITTAG", HmacKeyManager.g(64, 64, hashType2, outputPrefixType));
                map.put("HMAC_SHA512_512BITTAG_RAW", HmacKeyManager.g(64, 64, hashType2, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
