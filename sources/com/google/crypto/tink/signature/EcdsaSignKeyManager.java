package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.EcdsaKeyFormat;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class EcdsaSignKeyManager extends PrivateKeyTypeManager<com.google.crypto.tink.proto.EcdsaPrivateKey, com.google.crypto.tink.proto.EcdsaPublicKey> {
    EcdsaSignKeyManager() {
        super(com.google.crypto.tink.proto.EcdsaPrivateKey.class, com.google.crypto.tink.proto.EcdsaPublicKey.class, new PrimitiveFactory<PublicKeySign, com.google.crypto.tink.proto.EcdsaPrivateKey>(PublicKeySign.class) { // from class: com.google.crypto.tink.signature.EcdsaSignKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat g(HashType hashType, EllipticCurveType ellipticCurveType, EcdsaSignatureEncoding ecdsaSignatureEncoding, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((EcdsaKeyFormat) EcdsaKeyFormat.S().J((EcdsaParams) EcdsaParams.U().L(hashType).J(ellipticCurveType).K(ecdsaSignatureEncoding).build()).build(), outputPrefixType);
    }

    public static void h(boolean z2) {
        Registry.d(new EcdsaSignKeyManager(), new EcdsaVerifyKeyManager(), z2);
        EcdsaProtoSerialization.a();
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility a() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<EcdsaKeyFormat, com.google.crypto.tink.proto.EcdsaPrivateKey>(EcdsaKeyFormat.class) { // from class: com.google.crypto.tink.signature.EcdsaSignKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                EllipticCurveType ellipticCurveType = EllipticCurveType.NIST_P256;
                EcdsaSignatureEncoding ecdsaSignatureEncoding = EcdsaSignatureEncoding.DER;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("ECDSA_P256", EcdsaSignKeyManager.g(hashType, ellipticCurveType, ecdsaSignatureEncoding, outputPrefixType));
                EcdsaSignatureEncoding ecdsaSignatureEncoding2 = EcdsaSignatureEncoding.IEEE_P1363;
                map.put("ECDSA_P256_IEEE_P1363", EcdsaSignKeyManager.g(hashType, ellipticCurveType, ecdsaSignatureEncoding2, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("ECDSA_P256_RAW", EcdsaSignKeyManager.g(hashType, ellipticCurveType, ecdsaSignatureEncoding2, outputPrefixType2));
                map.put("ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX", EcdsaSignKeyManager.g(hashType, ellipticCurveType, ecdsaSignatureEncoding2, outputPrefixType2));
                HashType hashType2 = HashType.SHA512;
                EllipticCurveType ellipticCurveType2 = EllipticCurveType.NIST_P384;
                map.put("ECDSA_P384", EcdsaSignKeyManager.g(hashType2, ellipticCurveType2, ecdsaSignatureEncoding, outputPrefixType));
                map.put("ECDSA_P384_IEEE_P1363", EcdsaSignKeyManager.g(hashType2, ellipticCurveType2, ecdsaSignatureEncoding2, outputPrefixType));
                map.put("ECDSA_P384_SHA512", EcdsaSignKeyManager.g(hashType2, ellipticCurveType2, ecdsaSignatureEncoding, outputPrefixType));
                map.put("ECDSA_P384_SHA384", EcdsaSignKeyManager.g(HashType.SHA384, ellipticCurveType2, ecdsaSignatureEncoding, outputPrefixType));
                EllipticCurveType ellipticCurveType3 = EllipticCurveType.NIST_P521;
                map.put("ECDSA_P521", EcdsaSignKeyManager.g(hashType2, ellipticCurveType3, ecdsaSignatureEncoding, outputPrefixType));
                map.put("ECDSA_P521_IEEE_P1363", EcdsaSignKeyManager.g(hashType2, ellipticCurveType3, ecdsaSignatureEncoding2, outputPrefixType));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
