package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesCtrHmacAeadKeyManager extends KeyTypeManager<AesCtrHmacAeadKey> {
    AesCtrHmacAeadKeyManager() {
        super(AesCtrHmacAeadKey.class, new PrimitiveFactory<Aead, AesCtrHmacAeadKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat g(int i3, int i4, int i5, int i6, HashType hashType, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat(h(i3, i4, i5, i6, hashType), outputPrefixType);
    }

    private static AesCtrHmacAeadKeyFormat h(int i3, int i4, int i5, int i6, HashType hashType) {
        AesCtrKeyFormat aesCtrKeyFormat = (AesCtrKeyFormat) AesCtrKeyFormat.T().K((AesCtrParams) AesCtrParams.S().J(i4).build()).J(i3).build();
        return (AesCtrHmacAeadKeyFormat) AesCtrHmacAeadKeyFormat.T().J(aesCtrKeyFormat).K((HmacKeyFormat) HmacKeyFormat.T().K((HmacParams) HmacParams.T().J(hashType).K(i6).build()).J(i5).build()).build();
    }

    public static void i(boolean z2) {
        Registry.e(new AesCtrHmacAeadKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility a() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<AesCtrHmacAeadKeyFormat, AesCtrHmacAeadKey>(AesCtrHmacAeadKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("AES128_CTR_HMAC_SHA256", AesCtrHmacAeadKeyManager.g(16, 16, 32, 16, hashType, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("AES128_CTR_HMAC_SHA256_RAW", AesCtrHmacAeadKeyManager.g(16, 16, 32, 16, hashType, outputPrefixType2));
                map.put("AES256_CTR_HMAC_SHA256", AesCtrHmacAeadKeyManager.g(32, 16, 32, 32, hashType, outputPrefixType));
                map.put("AES256_CTR_HMAC_SHA256_RAW", AesCtrHmacAeadKeyManager.g(32, 16, 32, 32, hashType, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
