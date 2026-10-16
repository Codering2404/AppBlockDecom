package com.applovin.impl.sdk;

import android.adservices.measurement.MeasurementManager;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.text.TextUtils;
import android.view.InputEvent;
import com.applovin.impl.jn;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.wh;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f63577b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MeasurementManager f63580e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TopicsManager f63583h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f63578c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f63579d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference f63581f = new AtomicReference(new JSONArray());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f63582g = new d(this, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements OutcomeReceiver {
        a() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            q.this.f63576a.I();
            if (n.a()) {
                q.this.f63576a.I().a("PrivacySandboxService", "Failed to register impression", exc);
            }
        }

        public void onResult(Object obj) {
            q.this.f63576a.I();
            if (n.a()) {
                q.this.f63576a.I().a("PrivacySandboxService", "Successfully registered impression");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements OutcomeReceiver {
        b() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            q.this.f63576a.I();
            if (n.a()) {
                q.this.f63576a.I().a("PrivacySandboxService", "Failed to register click", exc);
            }
        }

        public void onResult(Object obj) {
            q.this.f63576a.I();
            if (n.a()) {
                q.this.f63576a.I().a("PrivacySandboxService", "Successfully registered click");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements OutcomeReceiver {
        c() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            q.this.f63576a.I();
            if (n.a()) {
                q.this.f63576a.I().a("PrivacySandboxService", "Failed to register conversion", exc);
            }
        }

        public void onResult(Object obj) {
            q.this.f63576a.I();
            if (n.a()) {
                q.this.f63576a.I().a("PrivacySandboxService", "Successfully registered conversion");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class d implements OutcomeReceiver {
        private d() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(GetTopicsResponse getTopicsResponse) {
            List<Topic> listA = getTopicsResponse.a();
            int size = listA.size();
            q.this.f63576a.I();
            if (n.a()) {
                q.this.f63576a.I().d("PrivacySandboxService", size + " topic(s) received");
            }
            JSONArray jSONArray = new JSONArray();
            for (Topic topic : listA) {
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putInt(jSONObject, "id", topic.c());
                JsonUtils.putLong(jSONObject, DeviceRequestsHelper.DEVICE_INFO_MODEL, topic.a());
                JsonUtils.putLong(jSONObject, "taxonomy", topic.b());
                jSONArray.put(jSONObject);
            }
            q.this.f63581f.set(jSONArray);
            q.this.b(((Boolean) q.this.f63576a.a(sj.y6)).booleanValue(), ((Long) q.this.f63576a.a(sj.w6)).longValue());
        }

        /* synthetic */ d(q qVar, a aVar) {
            this();
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            String str;
            Long l3 = (Long) q.this.f63576a.a(sj.x6);
            boolean z2 = l3.longValue() == -1;
            q.this.f63576a.I();
            if (n.a()) {
                n nVarI = q.this.f63576a.I();
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to retrieve topics");
                if (z2) {
                    str = "";
                } else {
                    str = ", retrying in " + l3 + " ms";
                }
                sb.append(str);
                nVarI.a("PrivacySandboxService", sb.toString(), exc);
            }
            if (z2) {
                return;
            }
            q.this.b(((Boolean) q.this.f63576a.a(sj.z6)).booleanValue(), l3.longValue());
        }
    }

    protected q(j jVar) {
        this.f63576a = jVar;
        this.f63577b = jVar.i0().a();
        Context contextM = j.m();
        this.f63580e = androidx.privacysandbox.ads.adservices.measurement.k.a(contextM.getSystemService(androidx.privacysandbox.ads.adservices.measurement.j.a()));
        this.f63583h = (TopicsManager) contextM.getSystemService(TopicsManager.class);
        if (((Boolean) jVar.a(sj.v6)).booleanValue()) {
            b(((Boolean) jVar.a(sj.y6)).booleanValue(), 0L);
        }
    }

    private boolean c(String str) {
        synchronized (this.f63579d) {
            try {
                if (this.f63578c.contains(str)) {
                    return false;
                }
                this.f63578c.add(str);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(final List list) {
        a("register impression", new Runnable() { // from class: com.applovin.impl.sdk.f1
            @Override // java.lang.Runnable
            public final void run() {
                this.f63282a.a(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        if (list == null || list.isEmpty() || this.f63580e == null || !wh.e(j.f63330v0)) {
            return;
        }
        this.f63576a.I();
        if (n.a()) {
            this.f63576a.I().a("PrivacySandboxService", "Registering impression...");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f63580e.registerSource(Uri.parse((String) it.next()), null, this.f63577b, new a());
        }
    }

    public void b(final List list, final InputEvent inputEvent) {
        a("register click", new Runnable() { // from class: com.applovin.impl.sdk.h1
            @Override // java.lang.Runnable
            public final void run() {
                this.f63320a.a(list, inputEvent);
            }
        });
    }

    public void b(final String str) {
        a("register conversion trigger event", new Runnable() { // from class: com.applovin.impl.sdk.g1
            @Override // java.lang.Runnable
            public final void run() {
                this.f63309a.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z2, final long j3) {
        a("retrieve topics", new Runnable() { // from class: com.applovin.impl.sdk.j1
            @Override // java.lang.Runnable
            public final void run() {
                this.f63388a.a(z2, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, InputEvent inputEvent) {
        if (list == null || list.isEmpty() || this.f63580e == null || !wh.e(j.f63330v0)) {
            return;
        }
        this.f63576a.I();
        if (n.a()) {
            this.f63576a.I().a("PrivacySandboxService", "Registering click...");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f63580e.registerSource(Uri.parse((String) it.next()), inputEvent, this.f63577b, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (TextUtils.isEmpty(str) || this.f63580e == null || !wh.e(j.f63330v0)) {
            return;
        }
        this.f63576a.I();
        if (n.a()) {
            this.f63576a.I().a("PrivacySandboxService", "Registering conversion: " + str);
        }
        this.f63580e.registerTrigger(Uri.parse(str), this.f63577b, new c());
    }

    public JSONArray a() {
        return (JSONArray) this.f63581f.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2, long j3) {
        if (this.f63583h == null) {
            return;
        }
        final GetTopicsRequest getTopicsRequestA = new GetTopicsRequest.Builder().c(z2).b("AppLovin").a();
        if (j3 > 0) {
            this.f63576a.i0().a(new jn(this.f63576a, true, "getTopics", new Runnable() { // from class: com.applovin.impl.sdk.i1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63327a.a(getTopicsRequestA);
                }
            }), tm.b.OTHER, j3);
        } else {
            this.f63583h.b(getTopicsRequestA, this.f63577b, this.f63582g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(GetTopicsRequest getTopicsRequest) {
        this.f63583h.b(getTopicsRequest, this.f63577b, this.f63582g);
    }

    private void a(String str, Runnable runnable) {
        try {
            this.f63576a.I();
            if (n.a()) {
                this.f63576a.I().a("PrivacySandboxService", "Running operation: " + str);
            }
            runnable.run();
        } catch (Throwable th) {
            this.f63576a.I();
            if (n.a()) {
                this.f63576a.I().a("PrivacySandboxService", "Failed to run operation: " + str, th);
            }
            if (c(str)) {
                this.f63576a.D().a("PrivacySandboxService", str, th);
            }
        }
    }
}
