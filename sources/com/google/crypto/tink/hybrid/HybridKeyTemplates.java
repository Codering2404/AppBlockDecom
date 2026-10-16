package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HybridKeyTemplates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f86179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KeyTemplate f86180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KeyTemplate f86181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KeyTemplate f86182d;

    static {
        byte[] bArr = new byte[0];
        f86179a = bArr;
        EllipticCurveType ellipticCurveType = EllipticCurveType.NIST_P256;
        HashType hashType = HashType.SHA256;
        EcPointFormat ecPointFormat = EcPointFormat.UNCOMPRESSED;
        KeyTemplate keyTemplate = AeadKeyTemplates.f86066a;
        OutputPrefixType outputPrefixType = OutputPrefixType.TINK;
        f86180b = a(ellipticCurveType, hashType, ecPointFormat, keyTemplate, outputPrefixType, bArr);
        f86181c = a(ellipticCurveType, hashType, EcPointFormat.COMPRESSED, keyTemplate, OutputPrefixType.RAW, bArr);
        f86182d = a(ellipticCurveType, hashType, ecPointFormat, AeadKeyTemplates.f86070e, outputPrefixType, bArr);
    }

    public static KeyTemplate a(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, OutputPrefixType outputPrefixType, byte[] bArr) {
        return (KeyTemplate) KeyTemplate.X().K(new EciesAeadHkdfPrivateKeyManager().c()).J(outputPrefixType).L(((EciesAeadHkdfKeyFormat) EciesAeadHkdfKeyFormat.S().J(b(ellipticCurveType, hashType, ecPointFormat, keyTemplate, bArr)).build()).b()).build();
    }

    public static EciesAeadHkdfParams b(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, byte[] bArr) {
        EciesHkdfKemParams eciesHkdfKemParams = (EciesHkdfKemParams) EciesHkdfKemParams.U().J(ellipticCurveType).K(hashType).L(ByteString.p(bArr)).build();
        return (EciesAeadHkdfParams) EciesAeadHkdfParams.U().L(eciesHkdfKemParams).J((EciesAeadDemParams) EciesAeadDemParams.S().J(keyTemplate).build()).K(ecPointFormat).build();
    }
}
