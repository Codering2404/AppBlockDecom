package com.applovin.impl;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.dc;
import com.applovin.impl.je;
import com.applovin.impl.le;
import com.applovin.impl.r;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ke extends re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private le f61027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ListView f61028b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements dc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ je f61029a;

        /* JADX INFO: renamed from: com.applovin.impl.ke$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0106a implements r.b {
            C0106a() {
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                maxDebuggerMultiAdActivity.initialize(a.this.f61029a);
            }
        }

        a(je jeVar) {
            this.f61029a = jeVar;
        }

        @Override // com.applovin.impl.dc.a
        public void a(kb kbVar, cc ccVar) {
            if (kbVar.b() != le.a.TEST_ADS.ordinal()) {
                yp.a(ccVar.c(), ccVar.b(), ke.this);
                return;
            }
            com.applovin.impl.sdk.j jVarO = this.f61029a.o();
            je.b bVarY = this.f61029a.y();
            if (!ke.this.f61027a.a(kbVar)) {
                yp.a(ccVar.c(), ccVar.b(), ke.this);
                return;
            }
            if (je.b.READY == bVarY) {
                r.a(ke.this, MaxDebuggerMultiAdActivity.class, jVarO.e(), new C0106a());
            } else if (je.b.DISABLED != bVarY) {
                yp.a(ccVar.c(), ccVar.b(), ke.this);
            } else {
                jVarO.k0().a();
                yp.a(ccVar.c(), ccVar.b(), ke.this);
            }
        }
    }

    public ke() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    @Override // com.applovin.impl.re
    protected com.applovin.impl.sdk.j getSdk() {
        le leVar = this.f61027a;
        if (leVar != null) {
            return leVar.h().o();
        }
        return null;
    }

    public void initialize(je jeVar) {
        setTitle(jeVar.g());
        le leVar = new le(jeVar, this);
        this.f61027a = leVar;
        leVar.a(new a(jeVar));
    }

    @Override // com.applovin.impl.re, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        this.f61028b = listView;
        listView.setAdapter((ListAdapter) this.f61027a);
    }

    @Override // com.applovin.impl.re, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f61027a.h().b().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f61027a.k();
            this.f61027a.c();
        }
    }
}
