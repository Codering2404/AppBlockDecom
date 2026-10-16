package com.google.crypto.tink.daead;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesSivKey;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesSivKeyManager extends KeyTypeManager<AesSivKey> {
    AesSivKeyManager() {
        super(AesSivKey.class, new PrimitiveFactory<DeterministicAead, AesSivKey>(DeterministicAead.class) { // from class: com.google.crypto.tink.daead.AesSivKeyManager.1
        });
    }

    public static void f(boolean z2) {
        Registry.e(new AesSivKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<AesSivKeyFormat, AesSivKey>(AesSivKeyFormat.class) { // from class: com.google.crypto.tink.daead.AesSivKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                map.put("AES256_SIV", new KeyTypeManager.KeyFactory.KeyFormat((AesSivKeyFormat) AesSivKeyFormat.S().J(64).build(), KeyTemplate.OutputPrefixType.TINK));
                map.put("AES256_SIV_RAW", new KeyTypeManager.KeyFactory.KeyFormat((AesSivKeyFormat) AesSivKeyFormat.S().J(64).build(), KeyTemplate.OutputPrefixType.RAW));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
