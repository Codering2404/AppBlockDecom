package com.applovin.impl;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.y0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class km extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f61044h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(y0.b bVar);

        void a(String str);
    }

    public km(com.applovin.impl.sdk.j jVar, b bVar) {
        super("TaskFetchDeveloperUri", jVar);
        this.f61044h = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strValueOf = String.valueOf(this.f65231a.x().B().get("package_name"));
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Looking up developer URI for package name: " + strValueOf);
        }
        this.f65231a.i0().a(new a(com.applovin.impl.sdk.network.a.a(this.f65231a).c("GET").b("https://play.google.com/store/apps/details?id=" + strValueOf).a((Object) "").a(false).a(), this.f65231a));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends dn {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, String str2, int i3) {
            if (TextUtils.isEmpty(str2)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "No developer URI found - response from the Play Store is empty");
                }
                km.this.f61044h.a(y0.b.APP_DETAILS_NOT_FOUND);
                return;
            }
            Matcher matcher = Pattern.compile("(?<=\"appstore:developer_url\" content=\").*?(?=\">)").matcher(str2);
            if (!matcher.find()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "No developer URI found - unable to find the developer_url meta tag from the Play Store listing");
                }
                km.this.f61044h.a(y0.b.INVALID_DEVELOPER_URI);
                return;
            }
            String strGroup = matcher.group();
            if (!URLUtil.isValidUrl(strGroup)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "Developer URI (" + strGroup + ") is not valid");
                }
                km.this.f61044h.a(y0.b.INVALID_DEVELOPER_URI);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Found developer URI: " + strGroup);
            }
            km.this.f61044h.a(strGroup);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, String str3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Unable to fetch app details due to: " + str2 + ", and received error code: " + i3);
            }
            km.this.f61044h.a(y0.b.APP_DETAILS_NOT_FOUND);
        }
    }
}
