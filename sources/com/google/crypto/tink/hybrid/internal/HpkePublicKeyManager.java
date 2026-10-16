package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.HpkePublicKey;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HpkePublicKeyManager extends KeyTypeManager<HpkePublicKey> {
    public HpkePublicKeyManager() {
        super(HpkePublicKey.class, new PrimitiveFactory<HybridEncrypt, HpkePublicKey>(HybridEncrypt.class) { // from class: com.google.crypto.tink.hybrid.internal.HpkePublicKeyManager.1
        });
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }
}
