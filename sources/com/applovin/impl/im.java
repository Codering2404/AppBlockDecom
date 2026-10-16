package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.y0;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class im extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f60514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f60515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f60516j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(y0.b bVar, String str);

        void a(String str, String str2);
    }

    public im(com.applovin.impl.sdk.j jVar, String str, b bVar) {
        super("TaskFetchAppAdsContent", jVar);
        this.f60515i = str;
        this.f60514h = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList(Arrays.asList(Uri.parse(this.f60515i).getAuthority().split("\\.")));
        if (arrayList.size() > 0) {
            String str = (String) arrayList.get(0);
            if ("www".equals(str) || "m".equals(str)) {
                arrayList.remove(0);
            }
        }
        String strJoin = TextUtils.join(".", arrayList);
        Uri uriBuild = new Uri.Builder().scheme("https").authority(strJoin).appendPath("app-ads.txt").build();
        com.applovin.impl.sdk.network.a aVarA = com.applovin.impl.sdk.network.a.a(this.f65231a).c("GET").b(uriBuild.toString()).a(new Uri.Builder().scheme("http").authority(strJoin).appendPath("app-ads.txt").build().toString()).a((Object) "").a(false).a();
        this.f60516j = uriBuild.toString();
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Looking up app-ads.txt at " + this.f60516j);
        }
        this.f65231a.i0().a(new a(aVarA, this.f65231a));
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
                    this.f65233c.b(this.f65232b, "No app-ads.txt found");
                }
                im.this.f60514h.a(y0.b.APPADSTXT_NOT_FOUND, im.this.f60516j);
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.a(this.f65232b, "Found app-ads.txt");
                }
                im.this.f60514h.a(str2, im.this.f60516j);
            }
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i3, String str2, String str3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Unable to fetch app-ads.txt due to: " + str2 + ", and received error code: " + i3);
            }
            im.this.f60514h.a(y0.b.APPADSTXT_NOT_FOUND, im.this.f60516j);
        }
    }
}
