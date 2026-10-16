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
final class AesGcmSivProtoSerialization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bytes f86115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ParametersSerializer f86116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ParametersParser f86117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final KeySerializer f86118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final KeyParser f86119e;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.AesGcmSivProtoSerialization$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86120a;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            f86120a = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86120a[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86120a[OutputPrefixType.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86120a[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        Bytes bytesB = Util.b("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        f86115a = bytesB;
        f86116b = ParametersSerializer.a(new a(), AesGcmSivParameters.class, ProtoParametersSerialization.class);
        f86117c = ParametersParser.a(new b(), bytesB, ProtoParametersSerialization.class);
        f86118d = KeySerializer.a(new c(), AesGcmSivKey.class, ProtoKeySerialization.class);
        f86119e = KeyParser.a(new d(), bytesB, ProtoKeySerialization.class);
    }

    public static void a() {
        b(MutableSerializationRegistry.a());
    }

    public static void b(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.e(f86116b);
        mutableSerializationRegistry.d(f86117c);
        mutableSerializationRegistry.c(f86118d);
        mutableSerializationRegistry.b(f86119e);
    }
}
