package com.singular.sdk;

import android.net.Uri;
import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.Utils;
import com.singular.sdk.internal.utils.UriUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SingularLinkParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f92447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f92448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f92449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f92450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap f92451e;

    public SingularLinkParams(String str, String str2, boolean z2, Uri uri) {
        this.f92447a = a(str, uri);
        this.f92448b = str2;
        this.f92449c = z2;
        this.f92450d = uri;
    }

    private String a(String str, Uri uri) {
        if (Utils.U(str) || Utils.U(uri.toString())) {
            return str;
        }
        Uri uri2 = Uri.parse(str);
        Uri.Builder builderBuildUpon = uri2.buildUpon();
        String queryParameter = uri.getQueryParameter("_forward_params");
        if (Utils.U(queryParameter) || !queryParameter.equals("2")) {
            return str;
        }
        HashSet hashSet = new HashSet(uri2.getQueryParameterNames());
        for (String str2 : uri.getQueryParameterNames()) {
            if (!Constants.f92525d.contains(str2) && !hashSet.contains(str2)) {
                builderBuildUpon.appendQueryParameter(str2, uri.getQueryParameter(str2));
            }
        }
        return builderBuildUpon.build().toString();
    }

    public String b() {
        return this.f92447a;
    }

    public String c() {
        return this.f92448b;
    }

    public HashMap d() {
        if (this.f92451e == null && UriUtils.a(this.f92450d)) {
            Set<String> queryParameterNames = this.f92450d.getQueryParameterNames();
            this.f92451e = new HashMap(queryParameterNames.size());
            for (String str : queryParameterNames) {
                this.f92451e.put(str, this.f92450d.getQueryParameter(str));
            }
        }
        HashMap map = this.f92451e;
        return map != null ? map : new HashMap();
    }
}
