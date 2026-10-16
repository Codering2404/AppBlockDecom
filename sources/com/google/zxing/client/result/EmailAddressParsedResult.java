package com.google.zxing.client.result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class EmailAddressParsedResult extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f91704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f91705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f91706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f91707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f91708e;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        ParsedResult.c(this.f91704a, sb);
        ParsedResult.c(this.f91705b, sb);
        ParsedResult.c(this.f91706c, sb);
        ParsedResult.b(this.f91707d, sb);
        ParsedResult.b(this.f91708e, sb);
        return sb.toString();
    }
}
