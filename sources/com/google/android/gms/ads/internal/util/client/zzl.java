package com.google.android.gms.ads.internal.util.client;

import android.util.JsonWriter;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f70178c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f70179d = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f70182g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f70183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f70177b = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Clock f70180e = DefaultClock.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set f70181f = new HashSet(Arrays.asList(new String[0]));

    public zzl(String str) {
        this.f70183a = !j() ? new ArrayList() : Arrays.asList("network_request_".concat(String.valueOf(UUID.randomUUID().toString())));
    }

    public static void g() {
        synchronized (f70177b) {
            f70178c = false;
            f70179d = false;
            zzo.f("Ad debug logging enablement is out of date.");
        }
    }

    public static void h(boolean z2) {
        synchronized (f70177b) {
            f70178c = true;
            f70179d = z2;
        }
    }

    public static boolean i() {
        boolean z2;
        synchronized (f70177b) {
            z2 = f70178c;
        }
        return z2;
    }

    public static boolean j() {
        boolean z2;
        synchronized (f70177b) {
            try {
                z2 = false;
                if (f70178c && f70179d) {
                    z2 = true;
                }
            } finally {
            }
        }
        return z2;
    }

    static /* synthetic */ void k(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(ShareConstants.MEDIA_URI).value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        p(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.c(bArr));
        }
        jsonWriter.endObject();
    }

    static /* synthetic */ void l(int i3, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i3);
        jsonWriter.endObject();
        p(jsonWriter, map);
        jsonWriter.endObject();
    }

    private final void m(final String str, final String str2, final Map map, final byte[] bArr) {
        q("onNetworkRequest", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzj
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void a(JsonWriter jsonWriter) throws IOException {
                zzl.k(str, str2, map, bArr, jsonWriter);
            }
        });
    }

    private final void n(final Map map, final int i3) {
        q("onNetworkResponse", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzg
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void a(JsonWriter jsonWriter) throws IOException {
                zzl.l(i3, map, jsonWriter);
            }
        });
    }

    private final void o(final String str) {
        q("onNetworkRequestError", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzi
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void a(JsonWriter jsonWriter) throws IOException {
                int i3 = zzl.f70182g;
                jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
                String str2 = str;
                if (str2 != null) {
                    jsonWriter.name(SbbqvQlxi.qjMbARDijO).value(str2);
                }
                jsonWriter.endObject();
            }
        });
    }

    private static void p(JsonWriter jsonWriter, Map map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if (!f70181f.contains(str)) {
                if (!(entry.getValue() instanceof List)) {
                    if (!(entry.getValue() instanceof String)) {
                        zzo.c("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                        break;
                    }
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(str);
                    jsonWriter.name("value").value((String) entry.getValue());
                    jsonWriter.endObject();
                } else {
                    for (String str2 : (List) entry.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value(str2);
                        jsonWriter.endObject();
                    }
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void q(String str, zzk zzkVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(f70180e.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            Iterator it = this.f70183a.iterator();
            while (it.hasNext()) {
                jsonWriter.value((String) it.next());
            }
            jsonWriter.endArray();
            zzkVar.a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e3) {
            zzo.d("unable to log", e3);
        }
        r(stringWriter.toString());
    }

    private static synchronized void r(String str) {
        try {
            zzo.e("GMA Debug BEGIN");
            int i3 = 0;
            while (i3 < str.length()) {
                int i4 = i3 + 4000;
                zzo.e("GMA Debug CONTENT ".concat(String.valueOf(str.substring(i3, Math.min(i4, str.length())))));
                i3 = i4;
            }
            zzo.e("GMA Debug FINISH");
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (j()) {
            m(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void b(String str, String str2, Map map, byte[] bArr) {
        if (j()) {
            m(str, "GET", map, bArr);
        }
    }

    public final void c(HttpURLConnection httpURLConnection, int i3) {
        if (j()) {
            String responseMessage = null;
            n(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i3);
            if (i3 < 200 || i3 >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e3) {
                    zzo.f("Can not get error message from error HttpURLConnection\n".concat(String.valueOf(e3.getMessage())));
                }
                o(responseMessage);
            }
        }
    }

    public final void d(Map map, int i3) {
        if (j()) {
            n(map, i3);
            if (i3 < 200 || i3 >= 300) {
                o(null);
            }
        }
    }

    public final void e(String str) {
        if (j() && str != null) {
            f(str.getBytes());
        }
    }

    public final void f(final byte[] bArr) {
        q("onNetworkResponseBody", new zzk() { // from class: com.google.android.gms.ads.internal.util.client.zzh
            @Override // com.google.android.gms.ads.internal.util.client.zzk
            public final /* synthetic */ void a(JsonWriter jsonWriter) throws IOException {
                int i3 = zzl.f70182g;
                jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
                byte[] bArr2 = bArr;
                int length = bArr2.length;
                String strC = Base64Utils.c(bArr2);
                if (length < 10000) {
                    jsonWriter.name("body").value(strC);
                } else {
                    String strR = zzf.r(strC);
                    if (strR != null) {
                        jsonWriter.name("bodydigest").value(strR);
                    }
                }
                jsonWriter.name("bodylength").value(length);
                jsonWriter.endObject();
            }
        });
    }
}
