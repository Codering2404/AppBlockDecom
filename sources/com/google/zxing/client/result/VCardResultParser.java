package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class VCardResultParser extends ResultParser {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f91760e = Pattern.compile("BEGIN:VCARD", 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f91761f = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f91762g = Pattern.compile("\r\n[ \t]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f91763h = Pattern.compile("\\\\[nN]");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f91764i = Pattern.compile("\\\\([,;\\\\])");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f91765j = Pattern.compile("=");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f91766k = Pattern.compile(";");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f91767l = Pattern.compile("(?<!\\\\);+");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f91768m = Pattern.compile(",");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Pattern f91769n = Pattern.compile("[;,]");
}
