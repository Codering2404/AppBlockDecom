package com.google.crypto.tink.prf;

import com.google.crypto.tink.proto.AesCmacPrfKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HkdfPrfKeyFormat;
import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class PrfKeyTemplates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KeyTemplate f86415a = b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final KeyTemplate f86416b = c(32, HashType.SHA256);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KeyTemplate f86417c = c(64, HashType.SHA512);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final KeyTemplate f86418d = a();

    private static KeyTemplate a() {
        return (KeyTemplate) KeyTemplate.X().K(new AesCmacPrfKeyManager().c()).L(((AesCmacPrfKeyFormat) AesCmacPrfKeyFormat.S().J(32).build()).b()).J(OutputPrefixType.RAW).build();
    }

    private static KeyTemplate b() {
        return (KeyTemplate) KeyTemplate.X().L(((HkdfPrfKeyFormat) HkdfPrfKeyFormat.T().J(32).K(HkdfPrfParams.S().J(HashType.SHA256)).build()).b()).K(HkdfPrfKeyManager.g()).J(OutputPrefixType.RAW).build();
    }

    private static KeyTemplate c(int i3, HashType hashType) {
        return (KeyTemplate) KeyTemplate.X().K(new HmacPrfKeyManager().c()).L(((HmacPrfKeyFormat) HmacPrfKeyFormat.T().K((HmacPrfParams) HmacPrfParams.S().J(hashType).build()).J(i3).build()).b()).J(OutputPrefixType.RAW).build();
    }
}
