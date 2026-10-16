package com.google.crypto.tink.aead;

import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AeadKeyTemplates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KeyTemplate f86066a = c(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KeyTemplate f86067b = c(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KeyTemplate f86068c = b(16, 16);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KeyTemplate f86069d = b(32, 16);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final KeyTemplate f86070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final KeyTemplate f86071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final KeyTemplate f86072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final KeyTemplate f86073h;

    static {
        HashType hashType = HashType.SHA256;
        f86070e = a(16, 16, 32, 16, hashType);
        f86071f = a(32, 16, 32, 32, hashType);
        KeyTemplate.Builder builderK = KeyTemplate.X().K(new ChaCha20Poly1305KeyManager().c());
        OutputPrefixType outputPrefixType = OutputPrefixType.TINK;
        f86072g = (KeyTemplate) builderK.J(outputPrefixType).build();
        f86073h = (KeyTemplate) KeyTemplate.X().K(new XChaCha20Poly1305KeyManager().c()).J(outputPrefixType).build();
    }

    public static KeyTemplate a(int i3, int i4, int i5, int i6, HashType hashType) {
        AesCtrKeyFormat aesCtrKeyFormat = (AesCtrKeyFormat) AesCtrKeyFormat.T().K((AesCtrParams) AesCtrParams.S().J(i4).build()).J(i3).build();
        return (KeyTemplate) KeyTemplate.X().L(((AesCtrHmacAeadKeyFormat) AesCtrHmacAeadKeyFormat.T().J(aesCtrKeyFormat).K((HmacKeyFormat) HmacKeyFormat.T().K((HmacParams) HmacParams.T().J(hashType).K(i6).build()).J(i5).build()).build()).b()).K(new AesCtrHmacAeadKeyManager().c()).J(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate b(int i3, int i4) {
        return (KeyTemplate) KeyTemplate.X().L(((AesEaxKeyFormat) AesEaxKeyFormat.T().J(i3).K((AesEaxParams) AesEaxParams.S().J(i4).build()).build()).b()).K(new AesEaxKeyManager().c()).J(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate c(int i3) {
        return (KeyTemplate) KeyTemplate.X().L(((AesGcmKeyFormat) AesGcmKeyFormat.S().J(i3).build()).b()).K(new AesGcmKeyManager().c()).J(OutputPrefixType.TINK).build();
    }
}
