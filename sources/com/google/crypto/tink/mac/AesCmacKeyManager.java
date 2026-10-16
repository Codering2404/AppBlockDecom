package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.proto.AesCmacParams;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesCmacKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.AesCmacKey> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PrimitiveConstructor f86326d = PrimitiveConstructor.a(new a(), AesCmacKey.class, ChunkedMac.class);

    AesCmacKeyManager() {
        super(com.google.crypto.tink.proto.AesCmacKey.class, new PrimitiveFactory<Mac, com.google.crypto.tink.proto.AesCmacKey>(Mac.class) { // from class: com.google.crypto.tink.mac.AesCmacKeyManager.1
        });
    }

    public static void f(boolean z2) {
        Registry.e(new AesCmacKeyManager(), z2);
        AesCmacProtoSerialization.a();
        MutablePrimitiveRegistry.a().b(f86326d);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<AesCmacKeyFormat, com.google.crypto.tink.proto.AesCmacKey>(AesCmacKeyFormat.class) { // from class: com.google.crypto.tink.mac.AesCmacKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                AesCmacKeyFormat aesCmacKeyFormat = (AesCmacKeyFormat) AesCmacKeyFormat.T().J(32).K((AesCmacParams) AesCmacParams.S().J(16).build()).build();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("AES_CMAC", new KeyTypeManager.KeyFactory.KeyFormat(aesCmacKeyFormat, outputPrefixType));
                map.put("AES256_CMAC", new KeyTypeManager.KeyFactory.KeyFormat((AesCmacKeyFormat) AesCmacKeyFormat.T().J(32).K((AesCmacParams) AesCmacParams.S().J(16).build()).build(), outputPrefixType));
                map.put("AES256_CMAC_RAW", new KeyTypeManager.KeyFactory.KeyFormat((AesCmacKeyFormat) AesCmacKeyFormat.T().J(32).K((AesCmacParams) AesCmacParams.S().J(16).build()).build(), KeyTemplate.OutputPrefixType.RAW));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
