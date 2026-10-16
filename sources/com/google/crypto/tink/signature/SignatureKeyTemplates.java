package com.google.crypto.tink.signature;

import com.google.crypto.tink.proto.EcdsaKeyFormat;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormat;
import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.proto.RsaSsaPssKeyFormat;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.math.BigInteger;
import java.security.spec.RSAKeyGenParameterSpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SignatureKeyTemplates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KeyTemplate f87282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KeyTemplate f87283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KeyTemplate f87284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KeyTemplate f87285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final KeyTemplate f87286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final KeyTemplate f87287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final KeyTemplate f87288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final KeyTemplate f87289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final KeyTemplate f87290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final KeyTemplate f87291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final KeyTemplate f87292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final KeyTemplate f87293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final KeyTemplate f87294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final KeyTemplate f87295n;

    static {
        HashType hashType = HashType.SHA256;
        EllipticCurveType ellipticCurveType = EllipticCurveType.NIST_P256;
        EcdsaSignatureEncoding ecdsaSignatureEncoding = EcdsaSignatureEncoding.DER;
        OutputPrefixType outputPrefixType = OutputPrefixType.TINK;
        f87282a = a(hashType, ellipticCurveType, ecdsaSignatureEncoding, outputPrefixType);
        HashType hashType2 = HashType.SHA512;
        EllipticCurveType ellipticCurveType2 = EllipticCurveType.NIST_P384;
        f87283b = a(hashType2, ellipticCurveType2, ecdsaSignatureEncoding, outputPrefixType);
        EllipticCurveType ellipticCurveType3 = EllipticCurveType.NIST_P521;
        f87284c = a(hashType2, ellipticCurveType3, ecdsaSignatureEncoding, outputPrefixType);
        EcdsaSignatureEncoding ecdsaSignatureEncoding2 = EcdsaSignatureEncoding.IEEE_P1363;
        f87285d = a(hashType, ellipticCurveType, ecdsaSignatureEncoding2, outputPrefixType);
        f87286e = a(hashType2, ellipticCurveType2, ecdsaSignatureEncoding2, outputPrefixType);
        OutputPrefixType outputPrefixType2 = OutputPrefixType.RAW;
        f87287f = a(hashType, ellipticCurveType, ecdsaSignatureEncoding2, outputPrefixType2);
        f87288g = a(hashType2, ellipticCurveType3, ecdsaSignatureEncoding2, outputPrefixType);
        f87289h = (KeyTemplate) KeyTemplate.X().K(new Ed25519PrivateKeyManager().c()).J(outputPrefixType).build();
        f87290i = (KeyTemplate) KeyTemplate.X().K(new Ed25519PrivateKeyManager().c()).J(outputPrefixType2).build();
        BigInteger bigInteger = RSAKeyGenParameterSpec.F4;
        f87291j = b(hashType, 3072, bigInteger, outputPrefixType);
        f87292k = b(hashType, 3072, bigInteger, outputPrefixType2);
        f87293l = b(hashType2, 4096, bigInteger, outputPrefixType);
        f87294m = c(hashType, hashType, 32, 3072, bigInteger);
        f87295n = c(hashType2, hashType2, 64, 4096, bigInteger);
    }

    public static KeyTemplate a(HashType hashType, EllipticCurveType ellipticCurveType, EcdsaSignatureEncoding ecdsaSignatureEncoding, OutputPrefixType outputPrefixType) {
        return (KeyTemplate) KeyTemplate.X().L(((EcdsaKeyFormat) EcdsaKeyFormat.S().J((EcdsaParams) EcdsaParams.U().L(hashType).J(ellipticCurveType).K(ecdsaSignatureEncoding).build()).build()).b()).K(new EcdsaSignKeyManager().c()).J(outputPrefixType).build();
    }

    public static KeyTemplate b(HashType hashType, int i3, BigInteger bigInteger, OutputPrefixType outputPrefixType) {
        return (KeyTemplate) KeyTemplate.X().L(((RsaSsaPkcs1KeyFormat) RsaSsaPkcs1KeyFormat.U().K((RsaSsaPkcs1Params) RsaSsaPkcs1Params.S().J(hashType).build()).J(i3).L(ByteString.p(bigInteger.toByteArray())).build()).b()).K(new RsaSsaPkcs1SignKeyManager().c()).J(outputPrefixType).build();
    }

    public static KeyTemplate c(HashType hashType, HashType hashType2, int i3, int i4, BigInteger bigInteger) {
        return (KeyTemplate) KeyTemplate.X().L(((RsaSsaPssKeyFormat) RsaSsaPssKeyFormat.U().K((RsaSsaPssParams) RsaSsaPssParams.U().L(hashType).J(hashType2).K(i3).build()).J(i4).L(ByteString.p(bigInteger.toByteArray())).build()).b()).K(new RsaSsaPssSignKeyManager().c()).J(OutputPrefixType.TINK).build();
    }
}
