package com.google.crypto.tink.signature;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class EcdsaVerifyKeyManager extends KeyTypeManager<com.google.crypto.tink.proto.EcdsaPublicKey> {
    public EcdsaVerifyKeyManager() {
        super(com.google.crypto.tink.proto.EcdsaPublicKey.class, new PrimitiveFactory<PublicKeyVerify, com.google.crypto.tink.proto.EcdsaPublicKey>(PublicKeyVerify.class) { // from class: com.google.crypto.tink.signature.EcdsaVerifyKeyManager.1
        });
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility a() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
    }
}
