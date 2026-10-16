package com.google.crypto.tink;

import com.facebook.stetho.common.Utf8Charset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f86054a = Charset.forName(Utf8Charset.NAME);

    public static KeysetInfo.KeyInfo a(Keyset.Key key) {
        return (KeysetInfo.KeyInfo) KeysetInfo.KeyInfo.V().M(key.R().S()).L(key.U()).K(key.T()).J(key.S()).build();
    }

    public static KeysetInfo b(Keyset keyset) {
        KeysetInfo.Builder builderK = KeysetInfo.V().K(keyset.S());
        Iterator it = keyset.R().iterator();
        while (it.hasNext()) {
            builderK.J(a((Keyset.Key) it.next()));
        }
        return (KeysetInfo) builderK.build();
    }
}
