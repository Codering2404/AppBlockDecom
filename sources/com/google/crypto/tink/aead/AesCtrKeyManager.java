package com.google.crypto.tink.aead;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.subtle.IndCpaCipher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class AesCtrKeyManager extends KeyTypeManager<AesCtrKey> {

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.AesCtrKeyManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends PrimitiveFactory<IndCpaCipher, AesCtrKey> {
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<AesCtrKeyFormat, AesCtrKey>(AesCtrKeyFormat.class) { // from class: com.google.crypto.tink.aead.AesCtrKeyManager.2
        };
    }
}
