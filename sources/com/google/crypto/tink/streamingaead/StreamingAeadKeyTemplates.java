package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class StreamingAeadKeyTemplates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KeyTemplate f87325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KeyTemplate f87326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KeyTemplate f87327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KeyTemplate f87328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final KeyTemplate f87329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final KeyTemplate f87330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final KeyTemplate f87331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final KeyTemplate f87332h;

    static {
        HashType hashType = HashType.SHA256;
        f87325a = a(16, hashType, 16, hashType, 32, 4096);
        f87326b = a(16, hashType, 16, hashType, 32, 1048576);
        f87327c = a(32, hashType, 32, hashType, 32, 4096);
        f87328d = a(32, hashType, 32, hashType, 32, 1048576);
        f87329e = b(16, hashType, 16, 4096);
        f87330f = b(16, hashType, 16, 1048576);
        f87331g = b(32, hashType, 32, 4096);
        f87332h = b(32, hashType, 32, 1048576);
    }

    public static KeyTemplate a(int i3, HashType hashType, int i4, HashType hashType2, int i5, int i6) {
        return (KeyTemplate) KeyTemplate.X().L(((AesCtrHmacStreamingKeyFormat) AesCtrHmacStreamingKeyFormat.T().K((AesCtrHmacStreamingParams) AesCtrHmacStreamingParams.V().J(i6).K(i4).L(hashType).M((HmacParams) HmacParams.T().J(hashType2).K(i5).build()).build()).J(i3).build()).b()).K(new AesCtrHmacStreamingKeyManager().c()).J(OutputPrefixType.RAW).build();
    }

    public static KeyTemplate b(int i3, HashType hashType, int i4, int i5) {
        return (KeyTemplate) KeyTemplate.X().L(((AesGcmHkdfStreamingKeyFormat) AesGcmHkdfStreamingKeyFormat.T().J(i3).K((AesGcmHkdfStreamingParams) AesGcmHkdfStreamingParams.U().J(i5).K(i4).L(hashType).build()).build()).b()).K(new AesGcmHkdfStreamingKeyManager().c()).J(OutputPrefixType.RAW).build();
    }
}
