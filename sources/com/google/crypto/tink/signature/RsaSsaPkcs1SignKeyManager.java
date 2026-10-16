package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormat;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.math.BigInteger;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class RsaSsaPkcs1SignKeyManager extends PrivateKeyTypeManager<RsaSsaPkcs1PrivateKey, RsaSsaPkcs1PublicKey> {
    RsaSsaPkcs1SignKeyManager() {
        super(RsaSsaPkcs1PrivateKey.class, RsaSsaPkcs1PublicKey.class, new PrimitiveFactory<PublicKeySign, RsaSsaPkcs1PrivateKey>(PublicKeySign.class) { // from class: com.google.crypto.tink.signature.RsaSsaPkcs1SignKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPkcs1KeyFormat g(HashType hashType, int i3, BigInteger bigInteger) {
        return (RsaSsaPkcs1KeyFormat) RsaSsaPkcs1KeyFormat.U().K((RsaSsaPkcs1Params) RsaSsaPkcs1Params.S().J(hashType).build()).J(i3).L(ByteString.p(bigInteger.toByteArray())).build();
    }

    public static void h(boolean z2) {
        Registry.d(new RsaSsaPkcs1SignKeyManager(), new RsaSsaPkcs1VerifyKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility a() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<RsaSsaPkcs1KeyFormat, RsaSsaPkcs1PrivateKey>(RsaSsaPkcs1KeyFormat.class) { // from class: com.google.crypto.tink.signature.RsaSsaPkcs1SignKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                BigInteger bigInteger = RSAKeyGenParameterSpec.F4;
                RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormatG = RsaSsaPkcs1SignKeyManager.g(hashType, 3072, bigInteger);
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("RSA_SSA_PKCS1_3072_SHA256_F4", new KeyTypeManager.KeyFactory.KeyFormat(rsaSsaPkcs1KeyFormatG, outputPrefixType));
                RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormatG2 = RsaSsaPkcs1SignKeyManager.g(hashType, 3072, bigInteger);
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("RSA_SSA_PKCS1_3072_SHA256_F4_RAW", new KeyTypeManager.KeyFactory.KeyFormat(rsaSsaPkcs1KeyFormatG2, outputPrefixType2));
                map.put("RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPkcs1SignKeyManager.g(hashType, 3072, bigInteger), outputPrefixType2));
                HashType hashType2 = HashType.SHA512;
                map.put("RSA_SSA_PKCS1_4096_SHA512_F4", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPkcs1SignKeyManager.g(hashType2, 4096, bigInteger), outputPrefixType));
                map.put("RSA_SSA_PKCS1_4096_SHA512_F4_RAW", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPkcs1SignKeyManager.g(hashType2, 4096, bigInteger), outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
