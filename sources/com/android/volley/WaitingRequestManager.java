package com.android.volley;

import com.android.volley.Cache;
import com.android.volley.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class WaitingRequestManager implements Request.NetworkRequestCompleteListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ResponseDelivery f57734b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CacheDispatcher f57736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BlockingQueue f57737e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f57733a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RequestQueue f57735c = null;

    WaitingRequestManager(CacheDispatcher cacheDispatcher, BlockingQueue blockingQueue, ResponseDelivery responseDelivery) {
        this.f57734b = responseDelivery;
        this.f57736d = cacheDispatcher;
        this.f57737e = blockingQueue;
    }

    @Override // com.android.volley.Request.NetworkRequestCompleteListener
    public void a(Request request, Response response) {
        List list;
        Cache.Entry entry = response.f57719b;
        if (entry == null || entry.a()) {
            b(request);
            return;
        }
        String strM = request.m();
        synchronized (this) {
            list = (List) this.f57733a.remove(strM);
        }
        if (list != null) {
            if (VolleyLog.f57725b) {
                VolleyLog.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strM);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f57734b.a((Request) it.next(), response);
            }
        }
    }

    @Override // com.android.volley.Request.NetworkRequestCompleteListener
    public synchronized void b(Request request) {
        BlockingQueue blockingQueue;
        try {
            String strM = request.m();
            List list = (List) this.f57733a.remove(strM);
            if (list != null && !list.isEmpty()) {
                if (VolleyLog.f57725b) {
                    VolleyLog.e("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strM);
                }
                Request request2 = (Request) list.remove(0);
                this.f57733a.put(strM, list);
                request2.O(this);
                RequestQueue requestQueue = this.f57735c;
                if (requestQueue != null) {
                    requestQueue.h(request2);
                } else if (this.f57736d != null && (blockingQueue = this.f57737e) != null) {
                    try {
                        blockingQueue.put(request2);
                    } catch (InterruptedException e3) {
                        VolleyLog.c("Couldn't add request to queue. %s", e3.toString());
                        Thread.currentThread().interrupt();
                        this.f57736d.d();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized boolean c(Request request) {
        try {
            String strM = request.m();
            if (!this.f57733a.containsKey(strM)) {
                this.f57733a.put(strM, null);
                request.O(this);
                if (VolleyLog.f57725b) {
                    VolleyLog.b("new request, sending to network %s", strM);
                }
                return false;
            }
            List arrayList = (List) this.f57733a.get(strM);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            request.b("waiting-for-response");
            arrayList.add(request);
            this.f57733a.put(strM, arrayList);
            if (VolleyLog.f57725b) {
                VolleyLog.b("Request for cacheKey=%s is in flight, putting on hold.", strM);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
