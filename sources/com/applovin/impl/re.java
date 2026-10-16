package com.applovin.impl;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class re extends Activity implements AppLovinCommunicatorSubscriber {
    protected List<String> communicatorTopics = new ArrayList();

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return getClass().getSimpleName();
    }

    protected abstract com.applovin.impl.sdk.j getSdk();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSdk() != null && !yp.c(getSdk())) {
            setTheme(R.style.com_applovin_mediation_MaxDebuggerActivity_Theme_Live);
        }
        List<String> list = this.communicatorTopics;
        if (list == null || list.size() <= 0) {
            return;
        }
        AppLovinCommunicator.getInstance(this).subscribe(this, this.communicatorTopics);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        List<String> list = this.communicatorTopics;
        if (list == null || list.size() <= 0) {
            return;
        }
        AppLovinCommunicator.getInstance(this).unsubscribe(this, this.communicatorTopics);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
    }
}
