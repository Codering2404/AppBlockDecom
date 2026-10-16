package com.google.crypto.tink.aead;

import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.util.Bytes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AesGcmProtoSerialization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bytes f86102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ParametersSerializer f86103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ParametersParser f86104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final KeySerializer f86105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final KeyParser f86106e;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.AesGcmProtoSerialization$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86107a;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            f86107a = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86107a[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86107a[OutputPrefixType.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86107a[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        Bytes bytesB = Util.b("type.googleapis.com/google.crypto.tink.AesGcmKey");
        f86102a = bytesB;
        f86103b = ParametersSerializer.a(new a(), AesGcmParameters.class, ProtoParametersSerialization.class);
        f86104c = ParametersParser.a(new b(), bytesB, ProtoParametersSerialization.class);
        f86105d = KeySerializer.a(new c(), AesGcmKey.class, ProtoKeySerialization.class);
        f86106e = KeyParser.a(new d(), bytesB, ProtoKeySerialization.class);
    }

    public static void a() {
        b(MutableSerializationRegistry.a());
    }

    public static void b(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.e(f86103b);
        mutableSerializationRegistry.d(f86104c);
        mutableSerializationRegistry.c(f86105d);
        mutableSerializationRegistry.b(f86106e);
    }
}
