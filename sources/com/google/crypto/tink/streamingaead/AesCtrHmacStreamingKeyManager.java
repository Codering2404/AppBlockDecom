package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKey;
import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesCtrHmacStreamingKeyManager extends KeyTypeManager<AesCtrHmacStreamingKey> {

    /* JADX INFO: renamed from: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f87301a;

        static {
            int[] iArr = new int[HashType.values().length];
            f87301a = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f87301a[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f87301a[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    AesCtrHmacStreamingKeyManager() {
        super(AesCtrHmacStreamingKey.class, new PrimitiveFactory<StreamingAead, AesCtrHmacStreamingKey>(StreamingAead.class) { // from class: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AesCtrHmacStreamingKeyFormat g(int i3, HashType hashType, int i4, HashType hashType2, int i5, int i6) {
        return (AesCtrHmacStreamingKeyFormat) AesCtrHmacStreamingKeyFormat.T().K((AesCtrHmacStreamingParams) AesCtrHmacStreamingParams.V().J(i6).K(i4).L(hashType).M((HmacParams) HmacParams.T().J(hashType2).K(i5).build()).build()).J(i3).build();
    }

    public static void h(boolean z2) {
        Registry.e(new AesCtrHmacStreamingKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<AesCtrHmacStreamingKeyFormat, AesCtrHmacStreamingKey>(AesCtrHmacStreamingKeyFormat.class) { // from class: com.google.crypto.tink.streamingaead.AesCtrHmacStreamingKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormatG = AesCtrHmacStreamingKeyManager.g(16, hashType, 16, hashType, 32, 4096);
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("AES128_CTR_HMAC_SHA256_4KB", new KeyTypeManager.KeyFactory.KeyFormat(aesCtrHmacStreamingKeyFormatG, outputPrefixType));
                map.put("AES128_CTR_HMAC_SHA256_1MB", new KeyTypeManager.KeyFactory.KeyFormat(AesCtrHmacStreamingKeyManager.g(16, hashType, 16, hashType, 32, 1048576), outputPrefixType));
                map.put("AES256_CTR_HMAC_SHA256_4KB", new KeyTypeManager.KeyFactory.KeyFormat(AesCtrHmacStreamingKeyManager.g(32, hashType, 32, hashType, 32, 4096), outputPrefixType));
                map.put("AES256_CTR_HMAC_SHA256_1MB", new KeyTypeManager.KeyFactory.KeyFormat(AesCtrHmacStreamingKeyManager.g(32, hashType, 32, hashType, 32, 1048576), outputPrefixType));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
