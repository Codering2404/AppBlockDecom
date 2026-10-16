package com.applovin.mediation.adapter.parameters;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MaxAdapterParameters {
    String getAdUnitId();

    String getConsentString();

    Bundle getCustomParameters();

    Map<String, Object> getLocalExtraParameters();

    Bundle getServerParameters();

    Boolean hasUserConsent();

    @Deprecated
    Boolean isAgeRestrictedUser();

    Boolean isDoNotSell();

    boolean isTesting();
}
