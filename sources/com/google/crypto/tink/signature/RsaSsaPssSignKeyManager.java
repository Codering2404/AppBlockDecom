package com.google.crypto.tink.signature;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.RsaSsaPssKeyFormat;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.proto.RsaSsaPssPrivateKey;
import com.google.crypto.tink.proto.RsaSsaPssPublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.math.BigInteger;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class RsaSsaPssSignKeyManager extends PrivateKeyTypeManager<RsaSsaPssPrivateKey, RsaSsaPssPublicKey> {
    RsaSsaPssSignKeyManager() {
        super(RsaSsaPssPrivateKey.class, RsaSsaPssPublicKey.class, new PrimitiveFactory<PublicKeySign, RsaSsaPssPrivateKey>(PublicKeySign.class) { // from class: com.google.crypto.tink.signature.RsaSsaPssSignKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPssKeyFormat g(HashType hashType, HashType hashType2, int i3, int i4, BigInteger bigInteger) {
        return (RsaSsaPssKeyFormat) RsaSsaPssKeyFormat.U().K((RsaSsaPssParams) RsaSsaPssParams.U().L(hashType).J(hashType2).K(i3).build()).J(i4).L(ByteString.p(bigInteger.toByteArray())).build();
    }

    public static void h(boolean z2) {
        Registry.d(new RsaSsaPssSignKeyManager(), new RsaSsaPssVerifyKeyManager(), z2);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<RsaSsaPssKeyFormat, RsaSsaPssPrivateKey>(RsaSsaPssKeyFormat.class) { // from class: com.google.crypto.tink.signature.RsaSsaPssSignKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                BigInteger bigInteger = RSAKeyGenParameterSpec.F4;
                RsaSsaPssKeyFormat rsaSsaPssKeyFormatG = RsaSsaPssSignKeyManager.g(hashType, hashType, 32, 3072, bigInteger);
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("RSA_SSA_PSS_3072_SHA256_F4", new KeyTypeManager.KeyFactory.KeyFormat(rsaSsaPssKeyFormatG, outputPrefixType));
                RsaSsaPssKeyFormat rsaSsaPssKeyFormatG2 = RsaSsaPssSignKeyManager.g(hashType, hashType, 32, 3072, bigInteger);
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("RSA_SSA_PSS_3072_SHA256_F4_RAW", new KeyTypeManager.KeyFactory.KeyFormat(rsaSsaPssKeyFormatG2, outputPrefixType2));
                map.put("RSA_SSA_PSS_3072_SHA256_SHA256_32_F4", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPssSignKeyManager.g(hashType, hashType, 32, 3072, bigInteger), outputPrefixType));
                HashType hashType2 = HashType.SHA512;
                map.put("RSA_SSA_PSS_4096_SHA512_F4", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPssSignKeyManager.g(hashType2, hashType2, 64, 4096, bigInteger), outputPrefixType));
                map.put("RSA_SSA_PSS_4096_SHA512_F4_RAW", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPssSignKeyManager.g(hashType2, hashType2, 64, 4096, bigInteger), outputPrefixType2));
                map.put("RSA_SSA_PSS_4096_SHA512_SHA512_64_F4", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPssSignKeyManager.g(hashType2, hashType2, 64, 4096, bigInteger), outputPrefixType));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
