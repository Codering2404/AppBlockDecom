package com.applovin.impl;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum fq {
    UNSPECIFIED(-1),
    RESOURCE_REJECTED(1),
    API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED(2),
    FAILED_TO_LOAD_RESOURCE(3),
    XML_PARSING(100),
    GENERAL_WRAPPER_ERROR(300),
    TIMED_OUT(301),
    WRAPPER_LIMIT_REACHED(302),
    NO_WRAPPER_RESPONSE(303),
    GENERAL_LINEAR_ERROR(RCHTTPStatusCodes.BAD_REQUEST),
    NO_MEDIA_FILE_PROVIDED(RCHTTPStatusCodes.UNAUTHORIZED),
    MEDIA_FILE_TIMEOUT(402),
    MEDIA_FILE_ERROR(405),
    GENERAL_COMPANION_AD_ERROR(600),
    UNABLE_TO_FETCH_COMPANION_AD_RESOURCE(603),
    CAN_NOT_FIND_COMPANION_AD_RESOURCE(604);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f59801a;

    fq(int i3) {
        this.f59801a = i3;
    }

    public int b() {
        return this.f59801a;
    }
}
