package com.applovin.impl.mediation;

import android.os.Bundle;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxNetworkResponseInfoImpl implements MaxNetworkResponseInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxNetworkResponseInfo.AdLoadState f61435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaxMediatedNetworkInfo f61436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f61437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f61438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f61439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f61440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MaxError f61441g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f61442a;

        static {
            int[] iArr = new int[MaxNetworkResponseInfo.AdLoadState.values().length];
            f61442a = iArr;
            try {
                iArr[MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61442a[MaxNetworkResponseInfo.AdLoadState.AD_LOADED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MaxNetworkResponseInfoImpl(MaxNetworkResponseInfo.AdLoadState adLoadState, MaxMediatedNetworkInfo maxMediatedNetworkInfo, Bundle bundle, boolean z2, long j3, String str, MaxError maxError) {
        this.f61435a = adLoadState;
        this.f61436b = maxMediatedNetworkInfo;
        this.f61437c = bundle;
        this.f61438d = z2;
        this.f61439e = j3;
        this.f61440f = str;
        this.f61441g = maxError;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof MaxNetworkResponseInfoImpl;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MaxNetworkResponseInfoImpl)) {
            return false;
        }
        MaxNetworkResponseInfoImpl maxNetworkResponseInfoImpl = (MaxNetworkResponseInfoImpl) obj;
        if (!maxNetworkResponseInfoImpl.canEqual(this) || isBidding() != maxNetworkResponseInfoImpl.isBidding() || getLatencyMillis() != maxNetworkResponseInfoImpl.getLatencyMillis()) {
            return false;
        }
        MaxNetworkResponseInfo.AdLoadState adLoadState = getAdLoadState();
        MaxNetworkResponseInfo.AdLoadState adLoadState2 = maxNetworkResponseInfoImpl.getAdLoadState();
        if (adLoadState != null ? !adLoadState.equals(adLoadState2) : adLoadState2 != null) {
            return false;
        }
        MaxMediatedNetworkInfo mediatedNetwork = getMediatedNetwork();
        MaxMediatedNetworkInfo mediatedNetwork2 = maxNetworkResponseInfoImpl.getMediatedNetwork();
        if (mediatedNetwork != null ? !mediatedNetwork.equals(mediatedNetwork2) : mediatedNetwork2 != null) {
            return false;
        }
        Bundle credentials = getCredentials();
        Bundle credentials2 = maxNetworkResponseInfoImpl.getCredentials();
        if (credentials != null ? !credentials.equals(credentials2) : credentials2 != null) {
            return false;
        }
        String bCode = getBCode();
        String bCode2 = maxNetworkResponseInfoImpl.getBCode();
        if (bCode != null ? !bCode.equals(bCode2) : bCode2 != null) {
            return false;
        }
        MaxError error = getError();
        MaxError error2 = maxNetworkResponseInfoImpl.getError();
        return error != null ? error.equals(error2) : error2 == null;
    }

    @Override // com.applovin.mediation.MaxNetworkResponseInfo
    public MaxNetworkResponseInfo.AdLoadState getAdLoadState() {
        return this.f61435a;
    }

    public String getBCode() {
        return this.f61440f;
    }

    @Override // com.applovin.mediation.MaxNetworkResponseInfo
    public Bundle getCredentials() {
        return this.f61437c;
    }

    @Override // com.applovin.mediation.MaxNetworkResponseInfo
    public MaxError getError() {
        return this.f61441g;
    }

    @Override // com.applovin.mediation.MaxNetworkResponseInfo
    public long getLatencyMillis() {
        return this.f61439e;
    }

    @Override // com.applovin.mediation.MaxNetworkResponseInfo
    public MaxMediatedNetworkInfo getMediatedNetwork() {
        return this.f61436b;
    }

    public int hashCode() {
        int i3 = isBidding() ? 79 : 97;
        long latencyMillis = getLatencyMillis();
        int i4 = ((i3 + 59) * 59) + ((int) (latencyMillis ^ (latencyMillis >>> 32)));
        MaxNetworkResponseInfo.AdLoadState adLoadState = getAdLoadState();
        int iHashCode = (i4 * 59) + (adLoadState == null ? 43 : adLoadState.hashCode());
        MaxMediatedNetworkInfo mediatedNetwork = getMediatedNetwork();
        int iHashCode2 = (iHashCode * 59) + (mediatedNetwork == null ? 43 : mediatedNetwork.hashCode());
        Bundle credentials = getCredentials();
        int iHashCode3 = (iHashCode2 * 59) + (credentials == null ? 43 : credentials.hashCode());
        String bCode = getBCode();
        int iHashCode4 = (iHashCode3 * 59) + (bCode == null ? 43 : bCode.hashCode());
        MaxError error = getError();
        return (iHashCode4 * 59) + (error != null ? error.hashCode() : 43);
    }

    @Override // com.applovin.mediation.MaxNetworkResponseInfo
    public boolean isBidding() {
        return this.f61438d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MaxResponseInfo{adLoadState=" + this.f61435a + ", mediatedNetwork=" + this.f61436b + ", credentials=" + this.f61437c + ", isBidding=" + this.f61438d);
        int i3 = a.f61442a[this.f61435a.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
            }
            sb.append("}");
            return sb.toString();
        }
        sb.append(", error=");
        sb.append(this.f61441g);
        sb.append(", latencyMillis=");
        sb.append(this.f61439e);
        sb.append("}");
        return sb.toString();
    }
}
