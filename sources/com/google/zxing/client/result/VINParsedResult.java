package com.google.zxing.client.result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class VINParsedResult extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f91770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f91771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f91772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f91773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f91774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final char f91775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f91776g;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.f91770a);
        sb.append(' ');
        sb.append(this.f91771b);
        sb.append(' ');
        sb.append(this.f91772c);
        sb.append('\n');
        String str = this.f91773d;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f91774e);
        sb.append(' ');
        sb.append(this.f91775f);
        sb.append(' ');
        sb.append(this.f91776g);
        sb.append('\n');
        return sb.toString();
    }
}
