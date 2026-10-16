package com.applovin.impl.mediation;

import android.os.Bundle;
import com.applovin.impl.fe;
import com.applovin.impl.oe;
import com.applovin.impl.zj;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxAdapterParametersImpl implements MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters, MaxAdapterInitializationParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f61422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f61423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f61424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f61425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f61426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Boolean f61427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f61428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f61429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f61430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f61431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f61432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MaxAdFormat f61433l;

    private MaxAdapterParametersImpl() {
    }

    static MaxAdapterParametersImpl a(fe feVar) {
        MaxAdapterParametersImpl maxAdapterParametersImplA = a((oe) feVar);
        maxAdapterParametersImplA.f61430i = feVar.T();
        maxAdapterParametersImplA.f61431j = feVar.D();
        maxAdapterParametersImplA.f61432k = feVar.C();
        return maxAdapterParametersImplA;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters
    public MaxAdFormat getAdFormat() {
        return this.f61433l;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public String getAdUnitId() {
        return this.f61422a;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public long getBidExpirationMillis() {
        return this.f61432k;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getBidResponse() {
        return this.f61431j;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public String getConsentString() {
        return this.f61428g;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Bundle getCustomParameters() {
        return this.f61425d;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Map<String, Object> getLocalExtraParameters() {
        return this.f61423b;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Bundle getServerParameters() {
        return this.f61424c;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getThirdPartyAdPlacementId() {
        return this.f61430i;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean hasUserConsent() {
        return this.f61426e;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean isAgeRestrictedUser() {
        return null;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean isDoNotSell() {
        return this.f61427f;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public boolean isTesting() {
        return this.f61429h;
    }

    static MaxAdapterParametersImpl a(zj zjVar, String str, MaxAdFormat maxAdFormat) {
        MaxAdapterParametersImpl maxAdapterParametersImplA = a(zjVar);
        maxAdapterParametersImplA.f61422a = str;
        maxAdapterParametersImplA.f61433l = maxAdFormat;
        return maxAdapterParametersImplA;
    }

    static MaxAdapterParametersImpl a(oe oeVar) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f61422a = oeVar.getAdUnitId();
        maxAdapterParametersImpl.f61426e = oeVar.n();
        maxAdapterParametersImpl.f61427f = oeVar.o();
        maxAdapterParametersImpl.f61428g = oeVar.d();
        maxAdapterParametersImpl.f61423b = oeVar.i();
        maxAdapterParametersImpl.f61424c = oeVar.l();
        maxAdapterParametersImpl.f61425d = oeVar.f();
        maxAdapterParametersImpl.f61429h = oeVar.p();
        return maxAdapterParametersImpl;
    }
}
