package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class yl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f65231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f65232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f65233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f65234d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f65235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f65236g;

    public yl(String str, com.applovin.impl.sdk.j jVar) {
        this(str, jVar, false, null);
    }

    public com.applovin.impl.sdk.j b() {
        return this.f65231a;
    }

    public String c() {
        return this.f65232b;
    }

    public boolean d() {
        return this.f65236g;
    }

    public yl(String str, com.applovin.impl.sdk.j jVar, String str2) {
        this(str, jVar, false, str2);
    }

    public Context a() {
        return this.f65234d;
    }

    public ScheduledFuture b(final Thread thread, final long j3) {
        if (j3 <= 0) {
            return null;
        }
        return this.f65231a.i0().b(new jn(this.f65231a, "timeout:" + this.f65232b, new Runnable() { // from class: com.applovin.impl.y80
            @Override // java.lang.Runnable
            public final void run() {
                this.f65170a.a(thread, j3);
            }
        }), tm.b.TIMEOUT, j3);
    }

    public yl(String str, com.applovin.impl.sdk.j jVar, boolean z2) {
        this(str, jVar, z2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Thread thread, long j3) {
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("name", thread.getState().name());
        if (StringUtils.isValidString(this.f65235f)) {
            mapHashMap.put("details", this.f65235f);
        }
        this.f65231a.D().a(ka.f60946a0, this.f65232b, (Map) mapHashMap);
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.k(this.f65232b, "Task has been executing for over " + TimeUnit.MILLISECONDS.toSeconds(j3) + " seconds");
        }
    }

    public yl(String str, com.applovin.impl.sdk.j jVar, boolean z2, String str2) {
        this.f65232b = str;
        this.f65231a = jVar;
        this.f65233c = jVar.I();
        this.f65234d = com.applovin.impl.sdk.j.m();
        this.f65236g = z2;
        this.f65235f = str2;
    }

    public void a(String str) {
        this.f65235f = str;
    }

    public void a(boolean z2) {
        this.f65236g = z2;
    }

    public void a(Throwable th) {
        Map map = CollectionUtils.map("source", this.f65232b);
        map.put("top_main_method", th.toString());
        map.put("details", StringUtils.emptyIfNull(this.f65235f));
        this.f65231a.D().a(ka.Z, map);
    }
}
