package com.applovin.impl.sdk.network;

import android.text.TextUtils;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sj;
import com.applovin.impl.yl;
import com.facebook.stetho.common.Utf8Charset;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class c extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f63523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final n f63524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AtomicBoolean f63525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f63526k;

    c(b bVar, j jVar) {
        super("PersistentPostbackQueueSaveTask", jVar);
        this.f63525j = new AtomicBoolean();
        this.f63526k = false;
        this.f63523h = bVar;
        this.f63524i = jVar.I();
    }

    public List a(int i3) throws Throwable {
        ArrayList arrayList = new ArrayList();
        l lVarA = this.f65231a.A();
        if (!lVarA.b("persistent_postback_cache.json", j.m())) {
            n.h("PersistentPostbackQueueSaveTask", "Postbacks queue file does not exist.");
            return arrayList;
        }
        File fileA = lVarA.a("persistent_postback_cache.json", j.m());
        String strE = lVarA.e(fileA);
        if (TextUtils.isEmpty(strE)) {
            n.h("PersistentPostbackQueueSaveTask", "Postbacks queue file has no content.");
            return arrayList;
        }
        boolean z2 = false;
        try {
            JSONArray jSONArray = new JSONObject(strE).getJSONArray("pb");
            if (n.a()) {
                this.f63524i.a("PersistentPostbackQueueSaveTask", "Deserializing " + jSONArray.length() + " postback(s)...");
            }
            arrayList.ensureCapacity(Math.max(1, jSONArray.length()));
            Integer num = (Integer) this.f65231a.a(sj.L2);
            for (int i4 = 0; i4 < jSONArray.length() && arrayList.size() < i3; i4++) {
                try {
                    d dVar = new d(jSONArray.getJSONObject(i4), this.f65231a);
                    if (dVar.c() < num.intValue()) {
                        arrayList.add(dVar);
                    } else {
                        n.h("PersistentPostbackQueueSaveTask", "Skipping deserialization because maximum attempt count exceeded for postback: " + dVar);
                    }
                } catch (Throwable th) {
                    n.c("PersistentPostbackQueueSaveTask", "Unable to deserialize postback from json", th);
                    this.f65231a.D().a("PersistentPostbackQueueSaveTask", "deserializePostback", th);
                }
            }
            if (n.a()) {
                this.f63524i.a("PersistentPostbackQueueSaveTask", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            }
        } catch (Throwable th2) {
            try {
                n.c("PersistentPostbackQueueSaveTask", "Failed to load postback queue", th2);
                try {
                    this.f65231a.D().a("PersistentPostbackQueueSaveTask", "deserializePostbackQueue", th2);
                    if (((Boolean) this.f65231a.a(sj.M0)).booleanValue()) {
                        lVarA.a(fileA, "removeAfterDeserializationFail");
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z2 = true;
                    if (z2 && ((Boolean) this.f65231a.a(sj.M0)).booleanValue()) {
                        lVarA.a(fileA, "removeAfterDeserializationFail");
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        this.f63526k = arrayList.isEmpty();
        return arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        a(this.f63523h.d());
    }

    private void a(List list) {
        if (!(this.f63526k && list.isEmpty()) && this.f63525j.compareAndSet(false, true)) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                try {
                    jSONArray.put(dVar.q());
                } catch (Throwable th) {
                    n.c("PersistentPostbackQueueSaveTask", "Unable to serialize postback to JSON: " + dVar, th);
                    this.f65231a.D().a("PersistentPostbackQueueSaveTask", "serializePostback", th);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pb", jSONArray);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.toString().getBytes(Utf8Charset.NAME));
                l lVarA = this.f65231a.A();
                if (lVarA.b((InputStream) byteArrayInputStream, lVarA.a("persistent_postback_cache.json", j.m()), true)) {
                    if (n.a()) {
                        this.f63524i.a("PersistentPostbackQueueSaveTask", "Exported postback queue to disk.");
                    }
                } else if (n.a()) {
                    this.f63524i.b("PersistentPostbackQueueSaveTask", "Unable to export postback queue to disk.");
                }
            } catch (Throwable th2) {
                n.c("PersistentPostbackQueueSaveTask", "Unable to export postbacks to disk: " + jSONArray, th2);
                this.f65231a.D().a("PersistentPostbackQueueSaveTask", "serializePostbackQueue", th2);
            }
            this.f63525j.set(false);
        }
    }
}
