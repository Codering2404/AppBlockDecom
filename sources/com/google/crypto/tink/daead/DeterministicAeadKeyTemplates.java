package com.google.crypto.tink.daead;

import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DeterministicAeadKeyTemplates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KeyTemplate f86165a = a(64);

    public static KeyTemplate a(int i3) {
        return (KeyTemplate) KeyTemplate.X().L(((AesSivKeyFormat) AesSivKeyFormat.S().J(i3).build()).b()).K(new AesSivKeyManager().c()).J(OutputPrefixType.TINK).build();
    }
}
