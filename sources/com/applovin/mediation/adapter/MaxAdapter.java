package com.applovin.mediation.adapter;

import android.app.Activity;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MaxAdapter {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum InitializationStatus {
        NOT_INITIALIZED(-4),
        DOES_NOT_APPLY(-3),
        INITIALIZING(-2),
        INITIALIZED_UNKNOWN(-1),
        INITIALIZED_FAILURE(0),
        INITIALIZED_SUCCESS(1);

        private final int code;

        InitializationStatus(int i3) {
            this.code = i3;
        }

        public int getCode() {
            return this.code;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCompletionListener {
        void onCompletion(InitializationStatus initializationStatus, String str);
    }

    String getAdapterVersion();

    String getSdkVersion();

    void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, OnCompletionListener onCompletionListener);

    boolean isBeta();

    void onDestroy();

    Boolean shouldCollectSignalsOnUiThread();

    Boolean shouldInitializeOnUiThread();

    Boolean shouldLoadAdsOnUiThread(MaxAdFormat maxAdFormat);

    Boolean shouldShowAdsOnUiThread(MaxAdFormat maxAdFormat);
}
