package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesGcmKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.AesGcmKey> {
    AesGcmKeyManager() {
        super(com.google.crypto.tink.proto.AesGcmKey.class, new PrimitiveFactory<Aead, com.google.crypto.tink.proto.AesGcmKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesGcmKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat g(int i3, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((AesGcmKeyFormat) AesGcmKeyFormat.S().J(i3).build(), outputPrefixType);
    }

    public static void h(boolean z2) {
        Registry.e(new AesGcmKeyManager(), z2);
        AesGcmProtoSerialization.a();
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility a() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<AesGcmKeyFormat, com.google.crypto.tink.proto.AesGcmKey>(AesGcmKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesGcmKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("AES128_GCM", AesGcmKeyManager.g(16, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("AES128_GCM_RAW", AesGcmKeyManager.g(16, outputPrefixType2));
                map.put("AES256_GCM", AesGcmKeyManager.g(32, outputPrefixType));
                map.put("AES256_GCM_RAW", AesGcmKeyManager.g(32, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
