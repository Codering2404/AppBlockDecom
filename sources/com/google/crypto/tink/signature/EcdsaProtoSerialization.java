package com.google.crypto.tink.signature;

import com.google.crypto.tink.aead.a;
import com.google.crypto.tink.aead.b;
import com.google.crypto.tink.aead.c;
import com.google.crypto.tink.aead.d;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.util.Bytes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class EcdsaProtoSerialization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bytes f87250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Bytes f87251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ParametersSerializer f87252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ParametersParser f87253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final KeySerializer f87254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final KeyParser f87255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final KeySerializer f87256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final KeyParser f87257h;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.EcdsaProtoSerialization$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f87258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f87259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f87260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ int[] f87261d;

        static {
            int[] iArr = new int[EcdsaSignatureEncoding.values().length];
            f87261d = iArr;
            try {
                iArr[EcdsaSignatureEncoding.IEEE_P1363.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f87261d[EcdsaSignatureEncoding.DER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EllipticCurveType.values().length];
            f87260c = iArr2;
            try {
                iArr2[EllipticCurveType.NIST_P256.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f87260c[EllipticCurveType.NIST_P384.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f87260c[EllipticCurveType.NIST_P521.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[OutputPrefixType.values().length];
            f87259b = iArr3;
            try {
                iArr3[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f87259b[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f87259b[OutputPrefixType.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f87259b[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[HashType.values().length];
            f87258a = iArr4;
            try {
                iArr4[HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f87258a[HashType.SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f87258a[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        Bytes bytesB = Util.b("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey");
        f87250a = bytesB;
        Bytes bytesB2 = Util.b("type.googleapis.com/google.crypto.tink.EcdsaPublicKey");
        f87251b = bytesB2;
        f87252c = ParametersSerializer.a(new a(), EcdsaParameters.class, ProtoParametersSerialization.class);
        f87253d = ParametersParser.a(new b(), bytesB, ProtoParametersSerialization.class);
        f87254e = KeySerializer.a(new c(), EcdsaPublicKey.class, ProtoKeySerialization.class);
        f87255f = KeyParser.a(new d(), bytesB2, ProtoKeySerialization.class);
        f87256g = KeySerializer.a(new c(), EcdsaPrivateKey.class, ProtoKeySerialization.class);
        f87257h = KeyParser.a(new d(), bytesB, ProtoKeySerialization.class);
    }

    public static void a() {
        b(MutableSerializationRegistry.a());
    }

    public static void b(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.e(f87252c);
        mutableSerializationRegistry.d(f87253d);
        mutableSerializationRegistry.c(f87254e);
        mutableSerializationRegistry.b(f87255f);
        mutableSerializationRegistry.c(f87256g);
        mutableSerializationRegistry.b(f87257h);
    }
}
