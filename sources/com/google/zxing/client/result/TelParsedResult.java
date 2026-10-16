package com.google.zxing.client.result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class TelParsedResult extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f91752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f91753b;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        ParsedResult.b(this.f91752a, sb);
        ParsedResult.b(this.f91753b, sb);
        return sb.toString();
    }
}
