package com.google.zxing.client.result;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ExpandedProductParsedResult extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f91711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f91712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f91713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f91714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f91715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f91716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f91717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f91718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f91719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f91720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f91721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f91722l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f91723m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Map f91724n;

    private static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        return String.valueOf(this.f91711a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedProductParsedResult)) {
            return false;
        }
        ExpandedProductParsedResult expandedProductParsedResult = (ExpandedProductParsedResult) obj;
        return d(this.f91712b, expandedProductParsedResult.f91712b) && d(this.f91713c, expandedProductParsedResult.f91713c) && d(this.f91714d, expandedProductParsedResult.f91714d) && d(this.f91715e, expandedProductParsedResult.f91715e) && d(this.f91716f, expandedProductParsedResult.f91716f) && d(this.f91717g, expandedProductParsedResult.f91717g) && d(this.f91718h, expandedProductParsedResult.f91718h) && d(this.f91719i, expandedProductParsedResult.f91719i) && d(this.f91720j, expandedProductParsedResult.f91720j) && d(this.f91721k, expandedProductParsedResult.f91721k) && d(this.f91722l, expandedProductParsedResult.f91722l) && d(this.f91723m, expandedProductParsedResult.f91723m) && d(this.f91724n, expandedProductParsedResult.f91724n);
    }

    public int hashCode() {
        return (((((((((((e(this.f91712b) ^ e(this.f91713c)) ^ e(this.f91714d)) ^ e(this.f91715e)) ^ e(this.f91716f)) ^ e(this.f91717g)) ^ e(this.f91718h)) ^ e(this.f91719i)) ^ e(this.f91720j)) ^ e(this.f91721k)) ^ e(this.f91722l)) ^ e(this.f91723m)) ^ e(this.f91724n);
    }
}
