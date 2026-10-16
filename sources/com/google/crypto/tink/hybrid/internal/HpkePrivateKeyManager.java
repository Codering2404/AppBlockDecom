package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.HpkeKeyFormat;
import com.google.crypto.tink.proto.HpkeParams;
import com.google.crypto.tink.proto.HpkePrivateKey;
import com.google.crypto.tink.proto.HpkePublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HpkePrivateKeyManager extends PrivateKeyTypeManager<HpkePrivateKey, HpkePublicKey> {

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86192a;

        static {
            int[] iArr = new int[com.google.crypto.tink.proto.HpkeKem.values().length];
            f86192a = iArr;
            try {
                iArr[com.google.crypto.tink.proto.HpkeKem.DHKEM_X25519_HKDF_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86192a[com.google.crypto.tink.proto.HpkeKem.DHKEM_P256_HKDF_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86192a[com.google.crypto.tink.proto.HpkeKem.DHKEM_P384_HKDF_SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86192a[com.google.crypto.tink.proto.HpkeKem.DHKEM_P521_HKDF_SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public HpkePrivateKeyManager() {
        super(HpkePrivateKey.class, HpkePublicKey.class, new PrimitiveFactory<HybridDecrypt, HpkePrivateKey>(HybridDecrypt.class) { // from class: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat g(com.google.crypto.tink.proto.HpkeKem hpkeKem, com.google.crypto.tink.proto.HpkeKdf hpkeKdf, com.google.crypto.tink.proto.HpkeAead hpkeAead, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((HpkeKeyFormat) HpkeKeyFormat.S().J((HpkeParams) HpkeParams.U().L(hpkeKem).K(hpkeKdf).J(hpkeAead).build()).build(), outputPrefixType);
    }

    public static void h(boolean z2) {
        Registry.d(new HpkePrivateKeyManager(), new HpkePublicKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<HpkeKeyFormat, HpkePrivateKey>(HpkeKeyFormat.class) { // from class: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                com.google.crypto.tink.proto.HpkeKem hpkeKem = com.google.crypto.tink.proto.HpkeKem.DHKEM_X25519_HKDF_SHA256;
                com.google.crypto.tink.proto.HpkeKdf hpkeKdf = com.google.crypto.tink.proto.HpkeKdf.HKDF_SHA256;
                com.google.crypto.tink.proto.HpkeAead hpkeAead = com.google.crypto.tink.proto.HpkeAead.AES_128_GCM;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", HpkePrivateKeyManager.g(hpkeKem, hpkeKdf, hpkeAead, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", HpkePrivateKeyManager.g(hpkeKem, hpkeKdf, hpkeAead, outputPrefixType2));
                com.google.crypto.tink.proto.HpkeAead hpkeAead2 = com.google.crypto.tink.proto.HpkeAead.AES_256_GCM;
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", HpkePrivateKeyManager.g(hpkeKem, hpkeKdf, hpkeAead2, outputPrefixType));
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkePrivateKeyManager.g(hpkeKem, hpkeKdf, hpkeAead2, outputPrefixType2));
                com.google.crypto.tink.proto.HpkeAead hpkeAead3 = com.google.crypto.tink.proto.HpkeAead.CHACHA20_POLY1305;
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", HpkePrivateKeyManager.g(hpkeKem, hpkeKdf, hpkeAead3, outputPrefixType));
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", HpkePrivateKeyManager.g(hpkeKem, hpkeKdf, hpkeAead3, outputPrefixType2));
                com.google.crypto.tink.proto.HpkeKem hpkeKem2 = com.google.crypto.tink.proto.HpkeKem.DHKEM_P256_HKDF_SHA256;
                map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", HpkePrivateKeyManager.g(hpkeKem2, hpkeKdf, hpkeAead, outputPrefixType));
                map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", HpkePrivateKeyManager.g(hpkeKem2, hpkeKdf, hpkeAead, outputPrefixType2));
                map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", HpkePrivateKeyManager.g(hpkeKem2, hpkeKdf, hpkeAead2, outputPrefixType));
                map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkePrivateKeyManager.g(hpkeKem2, hpkeKdf, hpkeAead2, outputPrefixType2));
                com.google.crypto.tink.proto.HpkeKem hpkeKem3 = com.google.crypto.tink.proto.HpkeKem.DHKEM_P384_HKDF_SHA384;
                com.google.crypto.tink.proto.HpkeKdf hpkeKdf2 = com.google.crypto.tink.proto.HpkeKdf.HKDF_SHA384;
                map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", HpkePrivateKeyManager.g(hpkeKem3, hpkeKdf2, hpkeAead, outputPrefixType));
                map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", HpkePrivateKeyManager.g(hpkeKem3, hpkeKdf2, hpkeAead, outputPrefixType2));
                map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", HpkePrivateKeyManager.g(hpkeKem3, hpkeKdf2, hpkeAead2, outputPrefixType));
                map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", HpkePrivateKeyManager.g(hpkeKem3, hpkeKdf2, hpkeAead2, outputPrefixType2));
                com.google.crypto.tink.proto.HpkeKem hpkeKem4 = com.google.crypto.tink.proto.HpkeKem.DHKEM_P521_HKDF_SHA512;
                com.google.crypto.tink.proto.HpkeKdf hpkeKdf3 = com.google.crypto.tink.proto.HpkeKdf.HKDF_SHA512;
                map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", HpkePrivateKeyManager.g(hpkeKem4, hpkeKdf3, hpkeAead, outputPrefixType));
                map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", HpkePrivateKeyManager.g(hpkeKem4, hpkeKdf3, hpkeAead, outputPrefixType2));
                map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", HpkePrivateKeyManager.g(hpkeKem4, hpkeKdf3, hpkeAead2, outputPrefixType));
                map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", HpkePrivateKeyManager.g(hpkeKem4, hpkeKdf3, hpkeAead2, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
