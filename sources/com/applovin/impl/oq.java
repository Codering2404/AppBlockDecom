package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class oq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f62368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f62369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f62370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f62371d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f62372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f62373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f62374h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum a {
        Progressive,
        Streaming
    }

    private oq() {
    }

    public static oq a(es esVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            String strD = esVar.d();
            if (!URLUtil.isValidUrl(strD)) {
                jVar.I();
                if (!com.applovin.impl.sdk.n.a()) {
                    return null;
                }
                jVar.I().b("VastVideoFile", "Unable to create video file. Could not find URL.");
                return null;
            }
            Uri uri = Uri.parse(strD);
            oq oqVar = new oq();
            oqVar.f62368a = uri;
            oqVar.f62369b = uri;
            oqVar.f62374h = a(esVar);
            oqVar.f62370c = a((String) esVar.a().get("delivery"));
            oqVar.f62373g = StringUtils.parseInt((String) esVar.a().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
            oqVar.f62372f = StringUtils.parseInt((String) esVar.a().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
            oqVar.f62371d = ((String) esVar.a().get("type")).toLowerCase(Locale.ENGLISH);
            return oqVar;
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("VastVideoFile", "Error occurred while initializing", th);
            }
            jVar.D().a("VastVideoFile", th);
            return null;
        }
    }

    public long b() {
        return this.f62374h;
    }

    public String c() {
        return this.f62371d;
    }

    public Uri d() {
        return this.f62368a;
    }

    public Uri e() {
        return this.f62369b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oq)) {
            return false;
        }
        oq oqVar = (oq) obj;
        if (this.f62372f != oqVar.f62372f || this.f62373g != oqVar.f62373g || this.f62374h != oqVar.f62374h) {
            return false;
        }
        Uri uri = this.f62368a;
        if (uri == null ? oqVar.f62368a != null : !uri.equals(oqVar.f62368a)) {
            return false;
        }
        Uri uri2 = this.f62369b;
        if (uri2 == null ? oqVar.f62369b != null : !uri2.equals(oqVar.f62369b)) {
            return false;
        }
        if (this.f62370c != oqVar.f62370c) {
            return false;
        }
        String str = this.f62371d;
        String str2 = oqVar.f62371d;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Uri uri = this.f62368a;
        int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.f62369b;
        int iHashCode2 = (iHashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        a aVar = this.f62370c;
        int iHashCode3 = (iHashCode2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f62371d;
        return ((((((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.f62372f) * 31) + this.f62373g) * 31) + Long.valueOf(this.f62374h).hashCode();
    }

    public String toString() {
        return "VastVideoFile{sourceVideoUri=" + this.f62368a + ", videoUri=" + this.f62369b + ", deliveryType=" + this.f62370c + ", fileType='" + this.f62371d + "', width=" + this.f62372f + ", height=" + this.f62373g + ", bitrate=" + this.f62374h + '}';
    }

    public static oq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject, "source_video_uri", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        Uri uri = Uri.parse(string);
        if (TextUtils.isEmpty(JsonUtils.getString(jSONObject, "video_uri", null))) {
            return null;
        }
        Uri uri2 = Uri.parse(string);
        String string2 = JsonUtils.getString(jSONObject, "file_type", null);
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        a aVarValueOf = a.valueOf(JsonUtils.getString(jSONObject, "delivery_type", a.Progressive.toString()));
        int i3 = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0);
        int i4 = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0);
        int i5 = JsonUtils.getInt(jSONObject, "bitrate", 0);
        oq oqVar = new oq();
        oqVar.f62368a = uri;
        oqVar.f62369b = uri2;
        oqVar.f62370c = aVarValueOf;
        oqVar.f62371d = string2;
        oqVar.f62372f = i3;
        oqVar.f62373g = i4;
        oqVar.f62374h = i5;
        return oqVar;
    }

    private static long a(es esVar) {
        Map mapA = esVar.a();
        long j3 = StringUtils.parseLong((String) mapA.get("bitrate"), 0L);
        return j3 != 0 ? j3 : (StringUtils.parseLong((String) mapA.get("minBitrate"), 0L) + StringUtils.parseLong((String) mapA.get(cJfnYMIyomoWf.EnM), 0L)) / 2;
    }

    private static a a(String str) {
        if (StringUtils.isValidString(str)) {
            if ("progressive".equalsIgnoreCase(str)) {
                return a.Progressive;
            }
            if ("streaming".equalsIgnoreCase(str)) {
                return a.Streaming;
            }
        }
        return a.Progressive;
    }

    public void a(Uri uri) {
        this.f62369b = uri;
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        Uri uri = this.f62368a;
        if (uri != null) {
            JsonUtils.putString(jSONObject, "source_video_uri", uri.toString());
        }
        Uri uri2 = this.f62369b;
        if (uri2 != null) {
            JsonUtils.putString(jSONObject, "video_uri", uri2.toString());
        }
        a aVar = this.f62370c;
        JsonUtils.putString(jSONObject, "delivery_type", aVar == null ? null : aVar.toString());
        JsonUtils.putString(jSONObject, "file_type", this.f62371d);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f62372f);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f62373g);
        JsonUtils.putLong(jSONObject, "bitrate", this.f62374h);
        return jSONObject;
    }
}
