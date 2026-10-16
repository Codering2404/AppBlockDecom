package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesGcmHkdfStreamingKeyManager extends KeyTypeManager<AesGcmHkdfStreamingKey> {
    AesGcmHkdfStreamingKeyManager() {
        super(AesGcmHkdfStreamingKey.class, new PrimitiveFactory<StreamingAead, AesGcmHkdfStreamingKey>(StreamingAead.class) { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesGcmHkdfStreamingKeyFormat g(int i3, HashType hashType, int i4, int i5) {
        return (AesGcmHkdfStreamingKeyFormat) AesGcmHkdfStreamingKeyFormat.T().J(i3).K((AesGcmHkdfStreamingParams) AesGcmHkdfStreamingParams.U().J(i5).K(i4).L(hashType).build()).build();
    }

    public static void h(boolean z2) {
        Registry.e(new AesGcmHkdfStreamingKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<AesGcmHkdfStreamingKeyFormat, AesGcmHkdfStreamingKey>(AesGcmHkdfStreamingKeyFormat.class) { // from class: com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormatG = AesGcmHkdfStreamingKeyManager.g(16, hashType, 16, 4096);
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("AES128_GCM_HKDF_4KB", new KeyTypeManager.KeyFactory.KeyFormat(aesGcmHkdfStreamingKeyFormatG, outputPrefixType));
                map.put("AES128_GCM_HKDF_1MB", new KeyTypeManager.KeyFactory.KeyFormat(AesGcmHkdfStreamingKeyManager.g(16, hashType, 16, 1048576), outputPrefixType));
                map.put("AES256_GCM_HKDF_4KB", new KeyTypeManager.KeyFactory.KeyFormat(AesGcmHkdfStreamingKeyManager.g(32, hashType, 32, 4096), outputPrefixType));
                map.put("AES256_GCM_HKDF_1MB", new KeyTypeManager.KeyFactory.KeyFormat(AesGcmHkdfStreamingKeyManager.g(32, hashType, 32, 1048576), outputPrefixType));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
