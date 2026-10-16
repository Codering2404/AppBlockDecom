package com.facebook.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface Ad {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface LoadAdConfig {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface LoadConfigBuilder {
        LoadAdConfig build();

        LoadConfigBuilder withBid(String str);
    }

    void destroy();

    String getPlacementId();

    boolean isAdInvalidated();

    void loadAd();

    @Deprecated
    void setExtraHints(ExtraHints extraHints);
}
