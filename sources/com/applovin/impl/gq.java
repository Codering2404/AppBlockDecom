package com.applovin.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class gq implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f60042a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f60043b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f60044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f60045d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f60046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f60047g;

    public static gq a(es esVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        es esVarC = esVar.c("StaticResource");
        if (esVarC == null || !URLUtil.isValidUrl(esVarC.d())) {
            jVar.I();
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            jVar.I().b("VastIndustryIcon", "Unable to create industry icon.  No valid image URL found.");
            return null;
        }
        gq gqVar = new gq();
        gqVar.f60044c = Uri.parse(esVarC.d());
        es esVarB = esVar.b("IconClickThrough");
        if (esVarB != null && URLUtil.isValidUrl(esVarB.d())) {
            gqVar.f60045d = Uri.parse(esVarB.d());
        }
        String str = (String) esVar.a().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        int i3 = 0;
        int i4 = (str == null || Integer.parseInt(str) <= 0) ? 0 : Integer.parseInt(str);
        String str2 = (String) esVar.a().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        if (str2 != null && Integer.parseInt(str2) > 0) {
            i3 = Integer.parseInt(str2);
        }
        int iIntValue = ((Integer) jVar.a(sj.M4)).intValue();
        if (i4 <= 0 || i3 <= 0) {
            gqVar.f60047g = iIntValue;
            gqVar.f60046f = iIntValue;
            return gqVar;
        }
        double d3 = i4 / i3;
        int iMin = Math.min(Math.max(i4, i3), iIntValue);
        if (i4 >= i3) {
            gqVar.f60046f = iMin;
            gqVar.f60047g = (int) (((double) iMin) / d3);
            return gqVar;
        }
        gqVar.f60047g = iMin;
        gqVar.f60046f = (int) (((double) iMin) * d3);
        return gqVar;
    }

    public Set b() {
        return this.f60042a;
    }

    public Uri c() {
        return this.f60045d;
    }

    public int d() {
        return this.f60047g;
    }

    public Uri e() {
        return this.f60044c;
    }

    public Set f() {
        return this.f60043b;
    }

    public int g() {
        return this.f60046f;
    }

    public String toString() {
        return "VastIndustryIcon{imageUri='" + e() + "', clickUri='" + c() + "', width=" + g() + ", height=" + d() + "}";
    }

    public static gq a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        kq kqVarA;
        kq kqVarA2;
        if (jSONObject == null) {
            return null;
        }
        gq gqVar = new gq();
        String string = JsonUtils.getString(jSONObject, "image_uri", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        gqVar.f60044c = Uri.parse(string);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            if (jSONObject2 != null && (kqVarA2 = kq.a(jSONObject2, jVar)) != null) {
                gqVar.f60042a.add(kqVarA2);
            }
        }
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "view_trackers", new JSONArray());
        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i4, (JSONObject) null);
            if (jSONObject3 != null && (kqVarA = kq.a(jSONObject3, jVar)) != null) {
                gqVar.f60043b.add(kqVarA);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "click_uri", null);
        gqVar.f60045d = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        gqVar.f60046f = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0);
        gqVar.f60047g = JsonUtils.getInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0);
        return gqVar;
    }

    @Override // com.applovin.impl.hh
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f60042a.iterator();
        while (it.hasNext()) {
            jSONArray.put(((kq) it.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.f60043b.iterator();
        while (it2.hasNext()) {
            jSONArray.put(((kq) it2.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "view_trackers", jSONArray2);
        Uri uri = this.f60044c;
        JsonUtils.putString(jSONObject, "image_uri", uri == null ? null : uri.toString());
        Uri uri2 = this.f60045d;
        JsonUtils.putString(jSONObject, "click_uri", uri2 != null ? uri2.toString() : null);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f60046f);
        JsonUtils.putInt(jSONObject, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f60047g);
        return jSONObject;
    }

    public static ImageView a(Uri uri, Context context, com.applovin.impl.sdk.j jVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setVisibility(8);
        ImageViewUtils.setImageUri(imageView, uri, jVar);
        return imageView;
    }
}
