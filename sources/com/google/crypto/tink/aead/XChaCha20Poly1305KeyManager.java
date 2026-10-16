package com.google.crypto.tink.aead;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.XChaCha20Poly1305KeyFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class XChaCha20Poly1305KeyManager extends KeyTypeManager<com.google.crypto.tink.proto.XChaCha20Poly1305Key> {
    XChaCha20Poly1305KeyManager() {
        super(com.google.crypto.tink.proto.XChaCha20Poly1305Key.class, new PrimitiveFactory<Aead, com.google.crypto.tink.proto.XChaCha20Poly1305Key>(Aead.class) { // from class: com.google.crypto.tink.aead.XChaCha20Poly1305KeyManager.1
        });
    }

    public static void f(boolean z2) {
        Registry.e(new XChaCha20Poly1305KeyManager(), z2);
        XChaCha20Poly1305ProtoSerialization.a();
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<XChaCha20Poly1305KeyFormat, com.google.crypto.tink.proto.XChaCha20Poly1305Key>(XChaCha20Poly1305KeyFormat.class) { // from class: com.google.crypto.tink.aead.XChaCha20Poly1305KeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                map.put("XCHACHA20_POLY1305", new KeyTypeManager.KeyFactory.KeyFormat(XChaCha20Poly1305KeyFormat.R(), KeyTemplate.OutputPrefixType.TINK));
                map.put("XCHACHA20_POLY1305_RAW", new KeyTypeManager.KeyFactory.KeyFormat(XChaCha20Poly1305KeyFormat.R(), KeyTemplate.OutputPrefixType.RAW));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
