package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.Ed25519KeyFormat;
import com.google.crypto.tink.proto.Ed25519PrivateKey;
import com.google.crypto.tink.proto.Ed25519PublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Ed25519PrivateKeyManager extends PrivateKeyTypeManager<Ed25519PrivateKey, Ed25519PublicKey> {
    Ed25519PrivateKeyManager() {
        super(Ed25519PrivateKey.class, Ed25519PublicKey.class, new PrimitiveFactory<PublicKeySign, Ed25519PrivateKey>(PublicKeySign.class) { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager.1
        });
    }

    public static void f(boolean z2) {
        Registry.d(new Ed25519PrivateKeyManager(), new Ed25519PublicKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<Ed25519KeyFormat, Ed25519PrivateKey>(Ed25519KeyFormat.class) { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                map.put("ED25519", new KeyTypeManager.KeyFactory.KeyFormat(Ed25519KeyFormat.R(), KeyTemplate.OutputPrefixType.TINK));
                Ed25519KeyFormat ed25519KeyFormatR = Ed25519KeyFormat.R();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("ED25519_RAW", new KeyTypeManager.KeyFactory.KeyFormat(ed25519KeyFormatR, outputPrefixType));
                map.put("ED25519WithRawOutput", new KeyTypeManager.KeyFactory.KeyFormat(Ed25519KeyFormat.R(), outputPrefixType));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
