package com.singular.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class BatchManager {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final SingularLog f92490j = SingularLog.f(BatchManager.class.getSimpleName());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static BatchManager f92491k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f92494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f92495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private NetworkSender f92496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RegularFlowSender f92497f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BatchManagerPersistence f92500i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Semaphore f92492a = new Semaphore(1, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Semaphore f92493b = new Semaphore(1, true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f92498g = {"ad_platform", "ad_currency", "pcc"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map f92499h = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.singular.sdk.internal.BatchManager$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            BatchManager batchManager;
            try {
                try {
                    BatchManager.this.f92493b.acquire();
                    BatchManager.this.f92492a.acquire();
                } finally {
                    BatchManager.f92490j.c(Utils.l(th));
                }
                BatchManager batchManager2 = BatchManager.this;
                batchManager2.f92495d = batchManager2.f92500i.e();
                BatchManager.this.f92492a.release();
                BatchManager.f92490j.a("sendEvents: total events to send " + BatchManager.this.f92499h.size());
                final ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                String[] strArr = (String[]) BatchManager.this.f92499h.keySet().toArray(new String[0]);
                LinkedList linkedList = new LinkedList();
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    if (new JSONObject(strArr[i3]).getLong("send_id") < BatchManager.this.f92495d) {
                        linkedList.add(strArr[i3]);
                    }
                }
                String[] strArr2 = (String[]) linkedList.toArray(new String[0]);
                final Semaphore semaphore = new Semaphore(0, true);
                final AtomicInteger atomicInteger = new AtomicInteger(0);
                AtomicInteger atomicInteger2 = new AtomicInteger(0);
                for (final String str : strArr2) {
                    final BaseApi baseApi = (BaseApi) BatchManager.this.f92499h.get(str);
                    if (baseApi == null) {
                        BatchManager.f92490j.a("sendEvents: event not found for key: " + str + ", skipping");
                    } else {
                        atomicInteger2.incrementAndGet();
                        BatchManager batchManager3 = BatchManager.this;
                        long jQ = batchManager3.q(batchManager3.f92494c);
                        baseApi.put("tsls", String.valueOf(jQ > 0 ? Utils.y() - jQ : 0L));
                        BatchManager.f92490j.a("sendEvents: sending event with key: " + str + " and body: " + baseApi.toString());
                        try {
                            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.BatchManager.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (BatchManager.this.f92496e.a(baseApi)) {
                                        BatchManager.f92490j.a("sendEvents: sending event with key: " + str + " is successful");
                                        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.singular.sdk.internal.BatchManager.4.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    BatchManager.this.f92499h.remove(str);
                                                    BatchManager.this.f92500i.c(str);
                                                    atomicInteger.incrementAndGet();
                                                } finally {
                                                    try {
                                                    } finally {
                                                    }
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    BatchManager.f92490j.a("sendEvents: sending event with key: " + str + " has failed");
                                    semaphore.release();
                                }
                            });
                        } catch (Throwable th) {
                            BatchManager.f92490j.c(Utils.l(th));
                            semaphore.release();
                        }
                    }
                }
                try {
                    semaphore.tryAcquire(atomicInteger2.get(), 60L, TimeUnit.SECONDS);
                    BatchManager.this.z(atomicInteger2.get(), atomicInteger.get());
                    batchManager = BatchManager.this;
                } catch (Throwable th2) {
                    try {
                        batchManager = BatchManager.this;
                    } catch (Throwable th3) {
                        BatchManager.this.f92493b.release();
                        throw th3;
                    }
                }
                batchManager.f92493b.release();
            } catch (Throwable th22) {
                try {
                } catch (Throwable th4) {
                    BatchManager.this.f92492a.release();
                }
            }
            BatchManager.this.f92492a.release();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface AdmonConstants {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface NetworkSender {
        boolean a(BaseApi baseApi);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface RegularFlowSender {
        void a(BaseApi baseApi);
    }

    private BatchManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(BaseApi baseApi) {
        try {
            this.f92492a.acquire();
        } catch (InterruptedException e3) {
            f92490j.c(Utils.l(e3));
        }
        long jY = Utils.y();
        try {
            String strU = u(baseApi);
            SingularLog singularLog = f92490j;
            singularLog.a("batchEvent: " + baseApi.p());
            singularLog.a("batchEvent: key: " + strU);
            JSONObject jSONObject = new JSONObject(baseApi.get("e"));
            if (this.f92499h.containsKey(strU)) {
                BaseApi baseApi2 = (BaseApi) this.f92499h.get(strU);
                JSONObject jSONObject2 = new JSONObject(baseApi2.get("e"));
                double d3 = jSONObject2.getDouble("r") + jSONObject.getDouble("r");
                double d4 = jSONObject2.getDouble("ad_revenue") + jSONObject.getDouble("ad_revenue");
                int i3 = jSONObject2.getInt("admon_count") + 1;
                jSONObject2.put("r", d3);
                jSONObject2.put("ad_revenue", d4);
                jSONObject2.put("admon_count", i3);
                jSONObject2.put("last_update_timestamp", jY);
                baseApi2.put("e", jSONObject2.toString());
                singularLog.a("batchEvent: added to existing event: " + baseApi2.p());
                this.f92492a.release();
                this.f92500i.b(strU, baseApi2.p());
            } else {
                JSONObject jSONObject3 = new JSONObject(strU);
                jSONObject3.remove("send_id");
                double d5 = jSONObject.getDouble("r");
                double d6 = jSONObject.getDouble("ad_revenue");
                jSONObject3.put("r", d5);
                jSONObject3.put("ad_revenue", d6);
                jSONObject3.put("admon_count", 1);
                jSONObject3.put("is_admon_revenue", jSONObject.getBoolean("is_admon_revenue"));
                jSONObject3.put("is_revenue_event", jSONObject.getBoolean("is_revenue_event"));
                jSONObject3.put("first_update_timestamp", jY);
                jSONObject3.put("last_update_timestamp", jY);
                baseApi.put("e", jSONObject3.toString());
                baseApi.put("event_index", "a" + String.valueOf(p(this.f92494c)));
                if (ConfigManager.c().e()) {
                    baseApi.put("_de", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
                this.f92499h.put(strU, baseApi);
                this.f92492a.release();
                this.f92500i.f(strU, baseApi.p());
                singularLog.a("batchEvent: created 1st event: " + baseApi.p());
            }
        } catch (Throwable th) {
            this.f92492a.release();
            f92490j.c(Utils.l(th));
            throw th;
        }
    }

    private long p(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref-admon-event-index", 0);
        return s(sharedPreferences, sharedPreferences.getLong("admon-event-index", -1L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long q(Context context) {
        return context.getSharedPreferences("batch_send_id", 0).getLong("pref-admon-last-flush-timestmap", 0L);
    }

    public static BatchManager r() {
        if (f92491k == null) {
            f92491k = new BatchManager();
        }
        return f92491k;
    }

    private long s(SharedPreferences sharedPreferences, long j3) {
        long j4 = j3 + 1;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("admon-event-index", j4);
        editorEdit.commit();
        return j4;
    }

    private void t() {
        f92490j.a("loadFromPersistence");
        for (Map.Entry entry : this.f92500i.d()) {
            try {
                this.f92499h.put(entry.getKey(), BaseApi.h((String) entry.getValue()));
            } catch (Throwable th) {
                f92490j.c(Utils.l(th));
            }
        }
        f92490j.a("loadFromPersistence: loaded " + this.f92499h.size() + " entries");
    }

    private String u(BaseApi baseApi) throws JSONException {
        f92490j.a("prepareKey for API: " + baseApi.p());
        JSONObject jSONObject = new JSONObject(baseApi.get("e"));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("send_id", this.f92495d);
        for (String str : this.f92498g) {
            try {
                jSONObject2.put(str, jSONObject.getString(str));
            } catch (JSONException e3) {
                f92490j.c(Utils.l(e3));
            }
        }
        f92490j.a("prepareKey result: " + jSONObject2.toString());
        return jSONObject2.toString();
    }

    private void v(Context context, long j3) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("batch_send_id", 0).edit();
            editorEdit.putLong("pref-admon-last-flush-timestmap", j3);
            editorEdit.commit();
        } catch (Throwable th) {
            f92490j.c(Utils.l(th));
        }
    }

    private boolean y() {
        int iB = ConfigManager.c().b();
        if (iB == 0) {
            return true;
        }
        long jY = Utils.y();
        long jQ = q(this.f92494c);
        long j3 = ((long) iB) * 1000;
        if (jQ <= 0 || jY - jQ >= j3) {
            return true;
        }
        f92490j.a("sendEvents: not flushing events. not enough time passed");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i3, int i4) {
        if (i3 == 0) {
            f92490j.a("sendEvents: timestamp not updated - no events to send (empty batch)");
            return;
        }
        if (i4 != i3) {
            f92490j.a("sendEvents: timestamp not updated - " + i4 + " out of " + i3 + " events sent successfully");
            return;
        }
        try {
            v(this.f92494c, Utils.y());
            f92490j.a("sendEvents: timestamp updated - all " + i3 + " events sent successfully");
        } catch (Throwable th) {
            f92490j.c("sendEvents: failed to save flush timestamp: " + Utils.l(th));
        }
    }

    public void n(final BaseApi baseApi) {
        final boolean zF = ConfigManager.c().f();
        final boolean zE = ConfigManager.c().e();
        if (zF && zE && baseApi.m()) {
            try {
                this.f92497f.a(BaseApi.h(baseApi.p()));
            } catch (IOException e3) {
                f92490j.d("IOExceptionException", e3);
            } catch (Throwable th) {
                f92490j.d("Throwable", th);
            }
        }
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.BatchManager.3
                @Override // java.lang.Runnable
                public void run() {
                    BatchManager.f92490j.a("addToBatch api: " + baseApi.p());
                    if (!zF || !baseApi.m()) {
                        BatchManager.f92490j.a("addToBatch: no need to batch: batching enabled: " + zF + " is Admon event: " + baseApi.m());
                        BatchManager.this.f92497f.a(baseApi);
                        return;
                    }
                    BatchManager.f92490j.a("addToBatch: event needs to be batched");
                    try {
                        BatchManager.this.o(baseApi);
                    } catch (Throwable th2) {
                        BatchManager.f92490j.a("addToBatch: exception: " + th2.getMessage());
                        if (zE) {
                            return;
                        }
                        BatchManager.this.f92497f.a(baseApi);
                    }
                }
            });
        } catch (Throwable th2) {
            f92490j.c(Utils.l(th2));
        }
    }

    public void w() {
        try {
            if (!ConfigManager.c().f()) {
                f92490j.a("sendEvents: admon batching is disabled");
            } else if (y()) {
                Executors.newSingleThreadExecutor().execute(new AnonymousClass4());
            } else {
                f92490j.a("sendEvents: skipping flushing batched events.");
            }
        } catch (Throwable th) {
            f92490j.c(Utils.l(th));
        }
    }

    public void x(Context context) {
        this.f92500i = new BatchManagerPersistenceSqlite(context);
        this.f92496e = new NetworkSender() { // from class: com.singular.sdk.internal.BatchManager.1
            @Override // com.singular.sdk.internal.BatchManager.NetworkSender
            public boolean a(BaseApi baseApi) {
                try {
                    ApiManager.d(baseApi);
                    return baseApi.b(SingularInstance.u());
                } catch (IOException e3) {
                    BatchManager.f92490j.c(Utils.l(e3));
                    return false;
                } catch (Throwable th) {
                    BatchManager.f92490j.c(Utils.l(th));
                    return false;
                }
            }
        };
        this.f92497f = new RegularFlowSender() { // from class: com.singular.sdk.internal.BatchManager.2
            @Override // com.singular.sdk.internal.BatchManager.RegularFlowSender
            public void a(BaseApi baseApi) {
                SingularInstance.u().n().c(baseApi);
            }
        };
        this.f92495d = this.f92500i.a();
        this.f92494c = context;
        t();
    }
}
