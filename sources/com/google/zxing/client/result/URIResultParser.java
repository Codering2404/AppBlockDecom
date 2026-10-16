package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class URIResultParser extends ResultParser {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f91758e = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f91759f = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");
}
