package com.google.zxing.client.result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SMSParsedResult extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f91749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f91750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f91751c;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.c(this.f91749a, sb);
        ParsedResult.b(this.f91750b, sb);
        ParsedResult.b(this.f91751c, sb);
        return sb.toString();
    }
}
