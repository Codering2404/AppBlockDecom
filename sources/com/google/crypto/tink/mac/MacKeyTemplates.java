package com.google.crypto.tink.mac;

import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MacKeyTemplates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KeyTemplate f86372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KeyTemplate f86373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KeyTemplate f86374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KeyTemplate f86375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final KeyTemplate f86376e;

    static {
        HashType hashType = HashType.SHA256;
        f86372a = a(32, 16, hashType);
        f86373b = a(32, 32, hashType);
        HashType hashType2 = HashType.SHA512;
        f86374c = a(64, 32, hashType2);
        f86375d = a(64, 64, hashType2);
        f86376e = (KeyTemplate) KeyTemplate.X().L(((AesCmacKeyFormat) AesCmacKeyFormat.T().J(32).K((AesCmacParams) AesCmacParams.S().J(16).build()).build()).b()).K(new AesCmacKeyManager().c()).J(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate a(int i3, int i4, HashType hashType) {
        return (KeyTemplate) KeyTemplate.X().L(((HmacKeyFormat) HmacKeyFormat.T().K((HmacParams) HmacParams.T().J(hashType).K(i4).build()).J(i3).build()).b()).K(new HmacKeyManager().c()).J(OutputPrefixType.TINK).build();
    }
}
