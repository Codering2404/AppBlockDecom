package com.google.zxing.client.result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class WifiParsedResult extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f91779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f91780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f91781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f91782d;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(80);
        ParsedResult.b(this.f91779a, sb);
        ParsedResult.b(this.f91780b, sb);
        ParsedResult.b(this.f91781c, sb);
        ParsedResult.b(Boolean.toString(this.f91782d), sb);
        return sb.toString();
    }
}
