package com.applovin.impl.mediation;

import com.applovin.impl.fe;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxAdWaterfallInfoImpl implements MaxAdWaterfallInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final fe f61415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f61416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f61417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f61418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f61419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f61420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f61421g;

    public MaxAdWaterfallInfoImpl(fe feVar, long j3, List<MaxNetworkResponseInfo> list, String str) {
        this(feVar, feVar.V(), feVar.W(), j3, list, feVar.U(), str);
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public long getLatencyMillis() {
        return this.f61419e;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public MaxAd getLoadedAd() {
        return this.f61415a;
    }

    public String getMCode() {
        return this.f61421g;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getName() {
        return this.f61416b;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public List<MaxNetworkResponseInfo> getNetworkResponses() {
        return this.f61418d;
    }

    public List<String> getPostbackUrls() {
        return this.f61420f;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getTestName() {
        return this.f61417c;
    }

    public String toString() {
        return "MaxAdWaterfallInfo{name=" + this.f61416b + ", testName=" + this.f61417c + ", networkResponses=" + this.f61418d + ", latencyMillis=" + this.f61419e + '}';
    }

    public MaxAdWaterfallInfoImpl(fe feVar, String str, String str2, long j3, List<MaxNetworkResponseInfo> list, List<String> list2, String str3) {
        this.f61415a = feVar;
        this.f61416b = str;
        this.f61417c = str2;
        this.f61418d = list;
        this.f61419e = j3;
        this.f61420f = list2;
        this.f61421g = str3;
    }
}
