package com.google.crypto.tink.signature;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.Ed25519PublicKey;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class Ed25519PublicKeyManager extends KeyTypeManager<Ed25519PublicKey> {
    public Ed25519PublicKeyManager() {
        super(Ed25519PublicKey.class, new PrimitiveFactory<PublicKeyVerify, Ed25519PublicKey>(PublicKeyVerify.class) { // from class: com.google.crypto.tink.signature.Ed25519PublicKeyManager.1
        });
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    }
}
