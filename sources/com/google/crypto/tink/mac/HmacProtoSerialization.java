package com.google.crypto.tink.mac;

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
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.util.Bytes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class HmacProtoSerialization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bytes f86361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ParametersSerializer f86362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ParametersParser f86363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final KeySerializer f86364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final KeyParser f86365e;

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.HmacProtoSerialization$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f86367b;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            f86367b = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86367b[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86367b[OutputPrefixType.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86367b[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[HashType.values().length];
            f86366a = iArr2;
            try {
                iArr2[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f86366a[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f86366a[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f86366a[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f86366a[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static {
        Bytes bytesB = Util.b("type.googleapis.com/google.crypto.tink.HmacKey");
        f86361a = bytesB;
        f86362b = ParametersSerializer.a(new com.google.crypto.tink.aead.a(), HmacParameters.class, ProtoParametersSerialization.class);
        f86363c = ParametersParser.a(new b(), bytesB, ProtoParametersSerialization.class);
        f86364d = KeySerializer.a(new c(), HmacKey.class, ProtoKeySerialization.class);
        f86365e = KeyParser.a(new d(), bytesB, ProtoKeySerialization.class);
    }

    public static void a() {
        b(MutableSerializationRegistry.a());
    }

    public static void b(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.e(f86362b);
        mutableSerializationRegistry.d(f86363c);
        mutableSerializationRegistry.c(f86364d);
        mutableSerializationRegistry.b(f86365e);
    }
}
