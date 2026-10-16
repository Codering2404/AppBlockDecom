package com.google.android.gms.ads.admanager;

import com.google.android.gms.ads.AbstractAdRequestBuilder;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AdManagerAdRequest extends AdRequest {
    /* synthetic */ AdManagerAdRequest(Builder builder, byte[] bArr) {
        super(builder);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder extends AbstractAdRequestBuilder<Builder> {
        public Builder m(String str) {
            this.f69625a.r(str);
            return this;
        }

        public AdManagerAdRequest n() {
            return new AdManagerAdRequest(this, null);
        }

        public Builder o(String str) {
            this.f69625a.n(str);
            return this;
        }

        @Override // com.google.android.gms.ads.AbstractAdRequestBuilder
        public final /* bridge */ /* synthetic */ AbstractAdRequestBuilder d() {
            return this;
        }
    }
}
