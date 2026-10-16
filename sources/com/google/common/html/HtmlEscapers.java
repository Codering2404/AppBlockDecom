package com.google.common.html;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class HtmlEscapers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Escaper f85179a = Escapers.a().b('\"', "&quot;").b('\'', "&#39;").b('&', "&amp;").b('<', "&lt;").b('>', "&gt;").c();
}
