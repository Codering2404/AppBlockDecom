package com.google.zxing.client.result;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class URIParsedResult extends ParsedResult {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f91755c = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f91756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f91757b;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        ParsedResult.b(this.f91757b, sb);
        ParsedResult.b(this.f91756a, sb);
        return sb.toString();
    }
}
