package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxErrorImpl implements MaxError {
    private String adLoadFailureInfo;
    private final int errorCode;
    private final String errorMessage;
    private String loadTag;
    private final int mediatedNetworkErrorCode;
    private final String mediatedNetworkErrorMessage;
    private long requestLatencyMillis;
    private MaxAdWaterfallInfo waterfall;

    public MaxErrorImpl(int i3) {
        this(i3, "");
    }

    @Override // com.applovin.mediation.MaxError
    public String getAdLoadFailureInfo() {
        return this.adLoadFailureInfo;
    }

    @Override // com.applovin.mediation.MaxError
    public int getCode() {
        return this.errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getLoadTag() {
        return this.loadTag;
    }

    @Override // com.applovin.mediation.MaxError
    public int getMediatedNetworkErrorCode() {
        return this.mediatedNetworkErrorCode;
    }

    @Override // com.applovin.mediation.MaxError
    public String getMediatedNetworkErrorMessage() {
        return this.mediatedNetworkErrorMessage;
    }

    @Override // com.applovin.mediation.MaxError
    public String getMessage() {
        return this.errorMessage;
    }

    @Override // com.applovin.mediation.MaxError
    public long getRequestLatencyMillis() {
        return this.requestLatencyMillis;
    }

    @Override // com.applovin.mediation.MaxError
    public MaxAdWaterfallInfo getWaterfall() {
        return this.waterfall;
    }

    public void setAdLoadFailureInfo(String str) {
        this.adLoadFailureInfo = str;
    }

    public void setLoadTag(String str) {
        this.loadTag = str;
    }

    public void setRequestLatencyMillis(long j3) {
        this.requestLatencyMillis = j3;
    }

    public void setWaterfall(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.waterfall = maxAdWaterfallInfo;
    }

    public String toString() {
        return "MaxError{code=" + getCode() + ", message=\"" + getMessage() + "\", mediatedNetworkErrorCode=" + getMediatedNetworkErrorCode() + ", mediatedNetworkErrorMessage=\"" + getMediatedNetworkErrorMessage() + "\"}";
    }

    public MaxErrorImpl(String str) {
        this(-1, str);
    }

    public MaxErrorImpl(int i3, String str) {
        this(i3, str, -1, "");
    }

    public MaxErrorImpl(int i3, String str, int i4, String str2) {
        this.errorCode = i3;
        this.errorMessage = StringUtils.emptyIfNull(str);
        this.mediatedNetworkErrorCode = i4;
        this.mediatedNetworkErrorMessage = StringUtils.emptyIfNull(str2);
    }
}
