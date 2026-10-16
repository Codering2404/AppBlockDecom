package com.google.zxing.client.result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class GeoParsedResult extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f91725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f91726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f91727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f91728d;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f91725a);
        sb.append(", ");
        sb.append(this.f91726b);
        if (this.f91727c > 0.0d) {
            sb.append(", ");
            sb.append(this.f91727c);
            sb.append('m');
        }
        if (this.f91728d != null) {
            sb.append(" (");
            sb.append(this.f91728d);
            sb.append(')');
        }
        return sb.toString();
    }
}
