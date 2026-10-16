package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesAeadHkdfPrivateKey;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class EciesAeadHkdfPrivateKeyManager extends PrivateKeyTypeManager<EciesAeadHkdfPrivateKey, EciesAeadHkdfPublicKey> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f86168e = new byte[0];

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86170a;

        static {
            int[] iArr = new int[KeyTemplate.OutputPrefixType.values().length];
            f86170a = iArr;
            try {
                iArr[KeyTemplate.OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86170a[KeyTemplate.OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86170a[KeyTemplate.OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86170a[KeyTemplate.OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    EciesAeadHkdfPrivateKeyManager() {
        super(EciesAeadHkdfPrivateKey.class, EciesAeadHkdfPublicKey.class, new PrimitiveFactory<HybridDecrypt, EciesAeadHkdfPrivateKey>(HybridDecrypt.class) { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat h(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, byte[] bArr, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((EciesAeadHkdfKeyFormat) EciesAeadHkdfKeyFormat.S().J(i(ellipticCurveType, hashType, ecPointFormat, keyTemplate, bArr)).build(), outputPrefixType);
    }

    static EciesAeadHkdfParams i(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, byte[] bArr) {
        EciesHkdfKemParams eciesHkdfKemParams = (EciesHkdfKemParams) EciesHkdfKemParams.U().J(ellipticCurveType).K(hashType).L(ByteString.p(bArr)).build();
        return (EciesAeadHkdfParams) EciesAeadHkdfParams.U().L(eciesHkdfKemParams).J((EciesAeadDemParams) EciesAeadDemParams.S().J((com.google.crypto.tink.proto.KeyTemplate) com.google.crypto.tink.proto.KeyTemplate.X().K(keyTemplate.d()).L(ByteString.p(keyTemplate.e())).J(k(keyTemplate.c())).build()).build()).K(ecPointFormat).build();
    }

    public static void j(boolean z2) {
        Registry.d(new EciesAeadHkdfPrivateKeyManager(), new EciesAeadHkdfPublicKeyManager(), z2);
    }

    private static OutputPrefixType k(KeyTemplate.OutputPrefixType outputPrefixType) {
        int i3 = AnonymousClass3.f86170a[outputPrefixType.ordinal()];
        if (i3 == 1) {
            return OutputPrefixType.TINK;
        }
        if (i3 == 2) {
            return OutputPrefixType.LEGACY;
        }
        if (i3 == 3) {
            return OutputPrefixType.RAW;
        }
        if (i3 == 4) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<EciesAeadHkdfKeyFormat, EciesAeadHkdfPrivateKey>(EciesAeadHkdfKeyFormat.class) { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() throws GeneralSecurityException {
                HashMap map = new HashMap();
                EllipticCurveType ellipticCurveType = EllipticCurveType.NIST_P256;
                HashType hashType = HashType.SHA256;
                EcPointFormat ecPointFormat = EcPointFormat.UNCOMPRESSED;
                KeyTemplate keyTemplateA = KeyTemplates.a("AES128_GCM");
                byte[] bArr = EciesAeadHkdfPrivateKeyManager.f86168e;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", EciesAeadHkdfPrivateKeyManager.h(ellipticCurveType, hashType, ecPointFormat, keyTemplateA, bArr, outputPrefixType));
                KeyTemplate keyTemplateA2 = KeyTemplates.a("AES128_GCM");
                byte[] bArr2 = EciesAeadHkdfPrivateKeyManager.f86168e;
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", EciesAeadHkdfPrivateKeyManager.h(ellipticCurveType, hashType, ecPointFormat, keyTemplateA2, bArr2, outputPrefixType2));
                EcPointFormat ecPointFormat2 = EcPointFormat.COMPRESSED;
                map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", EciesAeadHkdfPrivateKeyManager.h(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.a("AES128_GCM"), EciesAeadHkdfPrivateKeyManager.f86168e, outputPrefixType));
                map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", EciesAeadHkdfPrivateKeyManager.h(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.a("AES128_GCM"), EciesAeadHkdfPrivateKeyManager.f86168e, outputPrefixType2));
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", EciesAeadHkdfPrivateKeyManager.h(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.a("AES128_GCM"), EciesAeadHkdfPrivateKeyManager.f86168e, outputPrefixType2));
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", EciesAeadHkdfPrivateKeyManager.h(ellipticCurveType, hashType, ecPointFormat, KeyTemplates.a("AES128_CTR_HMAC_SHA256"), EciesAeadHkdfPrivateKeyManager.f86168e, outputPrefixType));
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", EciesAeadHkdfPrivateKeyManager.h(ellipticCurveType, hashType, ecPointFormat, KeyTemplates.a("AES128_CTR_HMAC_SHA256"), EciesAeadHkdfPrivateKeyManager.f86168e, outputPrefixType2));
                map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", EciesAeadHkdfPrivateKeyManager.h(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.a("AES128_CTR_HMAC_SHA256"), EciesAeadHkdfPrivateKeyManager.f86168e, outputPrefixType));
                map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", EciesAeadHkdfPrivateKeyManager.h(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.a("AES128_CTR_HMAC_SHA256"), EciesAeadHkdfPrivateKeyManager.f86168e, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
