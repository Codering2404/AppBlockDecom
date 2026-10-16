package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesGcmSivKeyFormat;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesGcmSivKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.AesGcmSivKey> {
    AesGcmSivKeyManager() {
        super(com.google.crypto.tink.proto.AesGcmSivKey.class, new PrimitiveFactory<Aead, com.google.crypto.tink.proto.AesGcmSivKey>(Aead.class) { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager.1
        });
    }

    private static boolean g() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat h(int i3, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((AesGcmSivKeyFormat) AesGcmSivKeyFormat.S().J(i3).build(), outputPrefixType);
    }

    public static void i(boolean z2) {
        if (g()) {
            Registry.e(new AesGcmSivKeyManager(), z2);
            AesGcmSivProtoSerialization.a();
        }
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<AesGcmSivKeyFormat, com.google.crypto.tink.proto.AesGcmSivKey>(AesGcmSivKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesGcmSivKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("AES128_GCM_SIV", AesGcmSivKeyManager.h(16, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("AES128_GCM_SIV_RAW", AesGcmSivKeyManager.h(16, outputPrefixType2));
                map.put("AES256_GCM_SIV", AesGcmSivKeyManager.h(32, outputPrefixType));
                map.put("AES256_GCM_SIV_RAW", AesGcmSivKeyManager.h(32, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
