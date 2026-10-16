package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class w4 extends dc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.applovin.impl.sdk.j f64566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f64567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f64568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f64569i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        RECENT_ADS,
        COUNT
    }

    public w4(Context context) {
        super(context);
        this.f64568h = new AtomicBoolean();
        this.f64569i = new ArrayList();
    }

    private List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new u6((v6) it.next(), this.f59200a));
        }
        return arrayList;
    }

    @Override // com.applovin.impl.dc
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.dc
    protected List c(int i3) {
        return this.f64569i;
    }

    public List d() {
        return this.f64567g;
    }

    public com.applovin.impl.sdk.j e() {
        return this.f64566f;
    }

    public boolean f() {
        return this.f64569i.size() == 0;
    }

    public void g() {
        this.f64568h.compareAndSet(true, false);
    }

    public String toString() {
        return "CreativeDebuggerListAdapter{isInitialized=" + this.f64568h.get() + "}";
    }

    @Override // com.applovin.impl.dc
    protected int d(int i3) {
        return this.f64569i.size();
    }

    @Override // com.applovin.impl.dc
    protected cc e(int i3) {
        return new fj("RECENT ADS");
    }

    public void a(List list, com.applovin.impl.sdk.j jVar) {
        Activity activityM0;
        this.f64566f = jVar;
        this.f64567g = list;
        if (!(this.f59200a instanceof Activity) && (activityM0 = jVar.m0()) != null) {
            this.f59200a = activityM0;
        }
        if (list != null && this.f64568h.compareAndSet(false, true)) {
            this.f64569i = a(this.f64567g);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.c70
            @Override // java.lang.Runnable
            public final void run() {
                this.f58853a.notifyDataSetChanged();
            }
        });
    }
}
