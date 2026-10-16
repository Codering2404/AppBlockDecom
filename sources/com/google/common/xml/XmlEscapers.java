package com.google.common.xml;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class XmlEscapers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Escaper f85993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Escaper f85994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Escaper f85995c;

    static {
        Escapers.Builder builderA = Escapers.a();
        builderA.d((char) 0, (char) 65533);
        builderA.e("�");
        for (char c3 = 0; c3 <= 31; c3 = (char) (c3 + 1)) {
            if (c3 != '\t' && c3 != '\n' && c3 != '\r') {
                builderA.b(c3, "�");
            }
        }
        builderA.b('&', "&amp;");
        builderA.b('<', "&lt;");
        builderA.b('>', "&gt;");
        f85994b = builderA.c();
        builderA.b('\'', "&apos;");
        builderA.b('\"', "&quot;");
        f85993a = builderA.c();
        builderA.b('\t', "&#x9;");
        builderA.b('\n', "&#xA;");
        builderA.b('\r', "&#xD;");
        f85995c = builderA.c();
    }
}
