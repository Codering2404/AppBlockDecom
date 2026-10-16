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
final class ChaCha20Poly1305ProtoSerialization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bytes f86127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ParametersSerializer f86128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ParametersParser f86129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final KeySerializer f86130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final KeyParser f86131e;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.ChaCha20Poly1305ProtoSerialization$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86132a;

        static {
            int[] iArr = new int[OutputPrefixType.values().length];
            f86132a = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86132a[OutputPrefixType.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86132a[OutputPrefixType.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86132a[OutputPrefixType.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        Bytes bytesB = Util.b("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        f86127a = bytesB;
        f86128b = ParametersSerializer.a(new a(), ChaCha20Poly1305Parameters.class, ProtoParametersSerialization.class);
        f86129c = ParametersParser.a(new b(), bytesB, ProtoParametersSerialization.class);
        f86130d = KeySerializer.a(new c(), ChaCha20Poly1305Key.class, ProtoKeySerialization.class);
        f86131e = KeyParser.a(new d(), bytesB, ProtoKeySerialization.class);
    }

    public static void a() {
        b(MutableSerializationRegistry.a());
    }

    public static void b(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.e(f86128b);
        mutableSerializationRegistry.d(f86129c);
        mutableSerializationRegistry.c(f86130d);
        mutableSerializationRegistry.b(f86131e);
    }
}
