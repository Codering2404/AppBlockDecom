package com.google.crypto.tink.signature;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class RsaSsaPkcs1VerifyKeyManager extends KeyTypeManager<RsaSsaPkcs1PublicKey> {
    public RsaSsaPkcs1VerifyKeyManager() {
        super(RsaSsaPkcs1PublicKey.class, new PrimitiveFactory<PublicKeyVerify, RsaSsaPkcs1PublicKey>(PublicKeyVerify.class) { // from class: com.google.crypto.tink.signature.RsaSsaPkcs1VerifyKeyManager.1
        });
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility a() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey";
    }
}
