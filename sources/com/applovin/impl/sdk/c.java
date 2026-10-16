package com.applovin.impl.sdk;

import android.os.SystemClock;
import android.text.TextUtils;
import com.applovin.impl.aq;
import com.applovin.impl.hh;
import com.applovin.impl.jn;
import com.applovin.impl.ka;
import com.applovin.impl.la;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.yl;
import com.applovin.sdk.AppLovinAdType;
import com.facebook.stetho.common.Utf8Charset;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final File f63243b = new File(j.m().getFilesDir(), "al/persisted-ads");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63244a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a implements hh {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f63245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AppLovinAdType f63246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f63247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f63248d;

        public a(String str, AppLovinAdType appLovinAdType, boolean z2, long j3) {
            this.f63245a = str;
            this.f63246b = appLovinAdType;
            this.f63247c = z2;
            this.f63248d = j3;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public long b() {
            return this.f63248d;
        }

        public String c() {
            return this.f63245a + "_" + this.f63246b;
        }

        public String d() {
            return this.f63245a;
        }

        public AppLovinAdType e() {
            return this.f63246b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String strD = d();
            String strD2 = aVar.d();
            if (strD != null ? !strD.equals(strD2) : strD2 != null) {
                return false;
            }
            AppLovinAdType appLovinAdTypeE = e();
            AppLovinAdType appLovinAdTypeE2 = aVar.e();
            return appLovinAdTypeE != null ? appLovinAdTypeE.equals(appLovinAdTypeE2) : appLovinAdTypeE2 == null;
        }

        public boolean f() {
            return this.f63247c;
        }

        public int hashCode() {
            String strD = d();
            int iHashCode = strD == null ? 43 : strD.hashCode();
            AppLovinAdType appLovinAdTypeE = e();
            return ((iHashCode + 59) * 59) + (appLovinAdTypeE != null ? appLovinAdTypeE.hashCode() : 43);
        }

        public String toString() {
            return "AdPersistenceFileService.PersistedAdFilePath(id=" + d() + ", type=" + e() + ", isAdServerAd=" + f() + ", expiryTimeMillis=" + b() + ")";
        }

        public static a a(com.applovin.impl.sdk.ad.b bVar) {
            return a(bVar, 0L);
        }

        public static a a(com.applovin.impl.sdk.ad.b bVar, long j3) {
            if (bVar == null) {
                return null;
            }
            return new a(StringUtils.isValidString(bVar.I()) ? bVar.I() : UUID.randomUUID().toString(), bVar.getType(), bVar instanceof com.applovin.impl.sdk.ad.a, SystemClock.elapsedRealtime() + j3);
        }

        public static a a(JSONObject jSONObject, j jVar) {
            String string = JsonUtils.getString(jSONObject, "id", "");
            String string2 = JsonUtils.getString(jSONObject, "type", "");
            Boolean bool = JsonUtils.getBoolean(jSONObject, "is_ad_server_ad", null);
            long j3 = JsonUtils.getLong(jSONObject, "expiry_time_millis", 0L);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || bool == null) {
                return null;
            }
            return new a(string, AppLovinAdType.fromString(string2), bool.booleanValue(), j3);
        }

        @Override // com.applovin.impl.hh
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putString(jSONObject, "id", this.f63245a);
            JsonUtils.putString(jSONObject, "type", this.f63246b.toString());
            JsonUtils.putBoolean(jSONObject, "is_ad_server_ad", this.f63247c);
            JsonUtils.putLong(jSONObject, "expiry_time_millis", this.f63248d);
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(a aVar);
    }

    /* JADX INFO: renamed from: com.applovin.impl.sdk.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InterfaceC0123c {
        void a(com.applovin.impl.sdk.ad.b bVar, String str);
    }

    public c(j jVar) {
        this.f63244a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, b bVar2) {
        a aVarA = a.a(bVar, ((Long) this.f63244a.a(sj.f63721a1)).longValue());
        File fileA = a(aVarA);
        if (fileA == null) {
            a("Could not persist incompatible ad", bVar, bVar2);
            return;
        }
        try {
            JSONObject jSONObjectA = bVar.a();
            if (jSONObjectA == null) {
                a("Could not serialize ad for persistence", bVar, bVar2);
                return;
            }
            if (this.f63244a.A().b((InputStream) new ByteArrayInputStream(jSONObjectA.toString().getBytes(Utf8Charset.NAME)), fileA, true)) {
                a(aVarA, bVar, bVar2);
            } else {
                a("Failed to write persisted ad to disk", bVar, bVar2);
            }
        } catch (Throwable th) {
            a("Ad could not be persisted", bVar, bVar2);
            this.f63244a.D().a("AdPersistenceFileService", th, CollectionUtils.map("error_message", "Ad could not be persisted"));
        }
    }

    public void b(final com.applovin.impl.sdk.ad.b bVar, final b bVar2) {
        if (b()) {
            this.f63244a.i0().a((yl) new jn(this.f63244a, "persistAd", new Runnable() { // from class: com.applovin.impl.sdk.b0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63237a.a(bVar, bVar2);
                }
            }), tm.b.CACHING);
        } else {
            a("Ad Persistence directory could not be created", bVar, bVar2);
        }
    }

    private boolean b() {
        File file = f63243b;
        if (file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    public void b(a aVar) {
        File fileA = a(aVar);
        if (fileA != null) {
            fileA.delete();
        }
    }

    public void a(final a aVar, final InterfaceC0123c interfaceC0123c) {
        final File fileA = a(aVar);
        if (fileA != null && fileA.exists()) {
            this.f63244a.i0().a((yl) new jn(this.f63244a, "retrievePersistedAd", new Runnable() { // from class: com.applovin.impl.sdk.c0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f63249a.a(fileA, interfaceC0123c, aVar);
                }
            }), tm.b.OTHER);
        } else {
            interfaceC0123c.a(null, "Persisted ad could not be retrieved: Retrieval failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(File file, InterfaceC0123c interfaceC0123c, a aVar) throws Throwable {
        com.applovin.impl.sdk.ad.b bVarA;
        String strE = this.f63244a.A().e(file);
        if (strE == null) {
            interfaceC0123c.a(null, "Persisted ad could not be retrieved: Read failed");
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(strE, new JSONObject());
            JsonUtils.putBoolean(JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "full_response", new JSONObject()), "is_persisted_ad", true);
            if (aVar.f()) {
                bVarA = com.applovin.impl.sdk.ad.a.a(jSONObjectJsonObjectFromJsonString, this.f63244a);
            } else {
                bVarA = aq.a(jSONObjectJsonObjectFromJsonString, this.f63244a);
            }
            if (bVarA == null) {
                interfaceC0123c.a(null, "Persisted ad could not be retrieved: Deserialization failed");
            } else {
                interfaceC0123c.a(bVarA, null);
            }
        } catch (Throwable th) {
            interfaceC0123c.a(null, "Persisted ad could not be retrieved: Deserialization failed");
            this.f63244a.D().a("AdPersistenceFileService", th, CollectionUtils.map("error_message", "Persisted ad could not be retrieved: Deserialization failed"));
        }
    }

    private File a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new File(f63243b.getAbsolutePath() + "/" + aVar.c());
    }

    private void a(a aVar, com.applovin.impl.sdk.ad.b bVar, b bVar2) {
        if (bVar2 == null) {
            return;
        }
        this.f63244a.I();
        if (n.a()) {
            this.f63244a.I().a("AdPersistenceFileService", "Ad was persisted successfully");
        }
        bVar2.a(aVar);
        this.f63244a.D().a(ka.f60964q, bVar);
    }

    private void a(String str, com.applovin.impl.sdk.ad.b bVar, b bVar2) {
        if (bVar2 == null) {
            return;
        }
        this.f63244a.I();
        if (n.a()) {
            this.f63244a.I().a("AdPersistenceFileService", str);
        }
        bVar2.a(null);
        Map mapA = la.a(bVar);
        CollectionUtils.putStringIfValid("error_message", str, mapA);
        this.f63244a.D().a(ka.f60965r, mapA);
    }

    public void a(List list) {
        File[] fileArrListFiles = f63243b.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        boolean z2 = false;
        for (File file : fileArrListFiles) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((a) it.next()).c().equals(file.getName())) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z2) {
                file.delete();
            }
        }
    }

    public void a() {
        File[] fileArrListFiles;
        File file = f63243b;
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
    }
}
