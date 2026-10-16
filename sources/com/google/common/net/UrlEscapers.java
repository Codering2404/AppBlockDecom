package com.google.common.net;

import com.google.common.escape.Escaper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class UrlEscapers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Escaper f85432a = new PercentEscaper("-_.*", true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Escaper f85433b = new PercentEscaper("-._~!$'()*,;&=@:+", false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Escaper f85434c = new PercentEscaper("-._~!$'()*,;&=@:+/?", false);
}
