package com.google.crypto.tink.prf;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesCmacPrfKey;
import com.google.crypto.tink.proto.AesCmacPrfKeyFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesCmacPrfKeyManager extends KeyTypeManager<AesCmacPrfKey> {
    AesCmacPrfKeyManager() {
        super(AesCmacPrfKey.class, new PrimitiveFactory<Prf, AesCmacPrfKey>(Prf.class) { // from class: com.google.crypto.tink.prf.AesCmacPrfKeyManager.1
        });
    }

    public static void f(boolean z2) {
        Registry.e(new AesCmacPrfKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCmacPrfKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<AesCmacPrfKeyFormat, AesCmacPrfKey>(AesCmacPrfKeyFormat.class) { // from class: com.google.crypto.tink.prf.AesCmacPrfKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                AesCmacPrfKeyFormat aesCmacPrfKeyFormat = (AesCmacPrfKeyFormat) AesCmacPrfKeyFormat.S().J(32).build();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("AES256_CMAC_PRF", new KeyTypeManager.KeyFactory.KeyFormat(aesCmacPrfKeyFormat, outputPrefixType));
                map.put("AES_CMAC_PRF", new KeyTypeManager.KeyFactory.KeyFormat((AesCmacPrfKeyFormat) AesCmacPrfKeyFormat.S().J(32).build(), outputPrefixType));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
