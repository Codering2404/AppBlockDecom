package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzeh;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final zzeh f69644a;

    protected AdRequest(AbstractAdRequestBuilder abstractAdRequestBuilder) {
        this.f69644a = new zzeh(abstractAdRequestBuilder.f69625a);
    }

    public final zzeh a() {
        return this.f69644a;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder extends AbstractAdRequestBuilder<Builder> {
        public AdRequest m() {
            return new AdRequest(this);
        }

        @Override // com.google.android.gms.ads.AbstractAdRequestBuilder
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Builder d() {
            return this;
        }
    }
}
