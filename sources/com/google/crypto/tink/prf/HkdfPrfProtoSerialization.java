package com.google.crypto.tink.prf;

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
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.util.Bytes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class HkdfPrfProtoSerialization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bytes f86406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ParametersSerializer f86407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ParametersParser f86408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final KeySerializer f86409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final KeyParser f86410e;

    /* JADX INFO: renamed from: com.google.crypto.tink.prf.HkdfPrfProtoSerialization$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86411a;

        static {
            int[] iArr = new int[HashType.values().length];
            f86411a = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86411a[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86411a[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86411a[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f86411a[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        Bytes bytesB = Util.b("type.googleapis.com/google.crypto.tink.HkdfPrfKey");
        f86406a = bytesB;
        f86407b = ParametersSerializer.a(new a(), HkdfPrfParameters.class, ProtoParametersSerialization.class);
        f86408c = ParametersParser.a(new b(), bytesB, ProtoParametersSerialization.class);
        f86409d = KeySerializer.a(new c(), HkdfPrfKey.class, ProtoKeySerialization.class);
        f86410e = KeyParser.a(new d(), bytesB, ProtoKeySerialization.class);
    }

    public static void a() {
        b(MutableSerializationRegistry.a());
    }

    public static void b(MutableSerializationRegistry mutableSerializationRegistry) {
        mutableSerializationRegistry.e(f86407b);
        mutableSerializationRegistry.d(f86408c);
        mutableSerializationRegistry.c(f86409d);
        mutableSerializationRegistry.b(f86410e);
    }
}
