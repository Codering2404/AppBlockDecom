package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.e1;
import com.applovin.impl.f1;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.ye;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class bm extends yl implements ye.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final com.applovin.impl.sdk.ad.b f58720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final u2 f58721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AppLovinAdLoadListener f58722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.applovin.impl.sdk.l f58723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Collection f58724l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f58725m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected ExecutorService f58726n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected ExecutorService f58727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected List f58728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected String f58729q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements f1.a {
        a() {
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            bm.this.f58720h.b(uri);
            com.applovin.impl.sdk.n nVar = bm.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                bm bmVar = bm.this;
                bmVar.f65233c.a(bmVar.f65232b, "Ad updated with muteImageUri = " + uri);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements f1.a {
        b() {
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            bm.this.f58720h.c(uri);
            com.applovin.impl.sdk.n nVar = bm.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                bm bmVar = bm.this;
                bmVar.f65233c.a(bmVar.f65232b, "Ad updated with unmuteImageUri = " + uri);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f1.a f58732a;

        c(f1.a aVar) {
            this.f58732a = aVar;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                com.applovin.impl.sdk.n nVar = bm.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    bm bmVar = bm.this;
                    bmVar.f65233c.a(bmVar.f65232b, "Finish caching video for ad #" + bm.this.f58720h.getAdIdNumber() + ". Updating ad with cachedVideoURL = " + uri);
                }
                this.f58732a.a(uri);
                return;
            }
            com.applovin.impl.sdk.n nVar2 = bm.this.f65233c;
            if (com.applovin.impl.sdk.n.a()) {
                bm bmVar2 = bm.this;
                bmVar2.f65233c.b(bmVar2.f65232b, "Failed to cache video");
            }
            bm.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            Bundle bundle = new Bundle();
            bundle.putLong("ad_id", bm.this.f58720h.getAdIdNumber());
            bundle.putInt("load_response_code", bm.this.f58721i.b());
            Throwable thA = bm.this.f58721i.a();
            if (thA != null) {
                bundle.putString("load_exception_message", thA.getMessage());
            }
            bm.this.f65231a.q().a(bundle, "video_caching_failed");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class d implements e1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f58734a;

        d(e eVar) {
            this.f58734a = eVar;
        }

        @Override // com.applovin.impl.e1.c
        public void a(String str, boolean z2) {
            if (z2) {
                bm.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                return;
            }
            e eVar = this.f58734a;
            if (eVar != null) {
                eVar.a(str);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface e {
        void a(String str);
    }

    bm(String str, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, jVar);
        if (bVar == null) {
            throw new IllegalArgumentException("No ad specified.");
        }
        this.f58720h = bVar;
        this.f58722j = appLovinAdLoadListener;
        this.f58723k = jVar.A();
        this.f58724l = h();
        this.f58721i = new u2();
        if (((Boolean) jVar.a(sj.I0)).booleanValue()) {
            this.f58729q = StringUtils.isValidString(bVar.I()) ? bVar.I() : UUID.randomUUID().toString();
            this.f58726n = jVar.i0().a("com.applovin.sdk.caching." + this.f58729q, ((Integer) jVar.a(sj.J0)).intValue());
            this.f58727o = jVar.i0().a("com.applovin.sdk.caching.html." + this.f58729q, ((Integer) jVar.a(sj.K0)).intValue());
        }
    }

    private Collection h() {
        HashSet hashSet = new HashSet();
        for (char c3 : ((String) this.f65231a.a(sj.D0)).toCharArray()) {
            hashSet.add(Character.valueOf(c3));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f58722j;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.f58720h);
            this.f58722j = null;
        }
    }

    protected List a(List list) {
        this.f58728p = list;
        return this.f65231a.i0().a(list, this.f58726n);
    }

    protected Uri b(String str) {
        return a(str, this.f58720h.Y(), true);
    }

    Uri c(String str) {
        return c(str, this.f58720h.Y(), true);
    }

    protected String d(String str, List list, boolean z2) {
        if (!((Boolean) this.f65231a.a(sj.f63809z)).booleanValue()) {
            InputStream inputStreamA = this.f58723k.a(str, list, z2, this.f58721i);
            if (inputStreamA == null) {
                return null;
            }
            try {
                String strA = this.f58723k.a(inputStreamA);
                yp.a(inputStreamA, this.f65231a);
                return strA;
            } catch (Throwable th) {
                try {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f65233c.a(this.f65232b, "Unknown failure to read input stream.", th);
                    }
                    this.f65231a.D().a(this.f65232b, "readInputStreamAsString", th);
                    yp.a(inputStreamA, this.f65231a);
                    return null;
                } catch (Throwable th2) {
                    yp.a(inputStreamA, this.f65231a);
                    throw th2;
                }
            }
        }
        try {
            InputStream inputStreamA2 = this.f58723k.a(str, list, z2, this.f58721i);
            if (inputStreamA2 == null) {
                if (inputStreamA2 == null) {
                    return null;
                }
                inputStreamA2.close();
                return null;
            }
            try {
                String strA2 = this.f58723k.a(inputStreamA2);
                inputStreamA2.close();
                return strA2;
            } finally {
            }
        } catch (Throwable th3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Unknown failure to read input stream.", th3);
            }
            this.f65233c.a(this.f65232b, th3);
            this.f65231a.D().a(this.f65232b, "readInputStreamAsString", th3);
            return null;
        }
    }

    void f() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Rendered new ad:" + this.f58720h);
        }
        MaxAdFormat maxAdFormatD = this.f58720h.getAdZone().d();
        if (((Boolean) this.f65231a.a(sj.Y0)).booleanValue() && maxAdFormatD != null && maxAdFormatD.isFullscreenAd()) {
            this.f65231a.g().b(this.f58720h);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.au
            @Override // java.lang.Runnable
            public final void run() {
                this.f58514a.i();
            }
        });
    }

    protected void g() {
        this.f58725m = true;
        List list = this.f58728p;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.f58728p.iterator();
            while (it.hasNext()) {
                ((d1) it.next()).a(true);
            }
        }
        ExecutorService executorService = this.f58726n;
        if (executorService != null) {
            executorService.shutdown();
            this.f58726n = null;
        }
        ExecutorService executorService2 = this.f58727o;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.f58727o = null;
        }
    }

    void j() {
        if (z3.f()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Caching mute images...");
        }
        Uri uriA = a(this.f58720h.M(), "mute");
        if (uriA != null) {
            this.f58720h.b(uriA);
        }
        Uri uriA2 = a(this.f58720h.g0(), "unmute");
        if (uriA2 != null) {
            this.f58720h.c(uriA2);
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Ad updated with muteImageFilename = " + this.f58720h.M() + ", unmuteImageFilename = " + this.f58720h.g0());
        }
    }

    protected void k() {
        this.f65231a.R().b(this);
        ExecutorService executorService = this.f58726n;
        if (executorService != null) {
            executorService.shutdown();
            this.f58726n = null;
        }
        ExecutorService executorService2 = this.f58727o;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.f58727o = null;
        }
    }

    protected boolean l() {
        return this.f58725m;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f58720h.g1()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Subscribing to timeout events...");
            }
            this.f65231a.R().a(this);
        }
    }

    String b(String str, List list, boolean z2) {
        InputStream inputStreamA;
        if (StringUtils.isValidString(str)) {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.a(this.f65232b, "Nothing to cache, skipping...");
                }
                return null;
            }
            try {
                File fileA = this.f58723k.a(yp.a(uri, this.f58720h.getCachePrefix(), this.f65231a), a());
                if (!this.f58723k.a(fileA)) {
                    if (((Boolean) this.f65231a.a(sj.f63809z)).booleanValue()) {
                        try {
                            InputStream inputStreamA2 = this.f58723k.a(str, list, z2, this.f58721i);
                            try {
                                if (inputStreamA2 != null) {
                                    this.f58723k.a(inputStreamA2, fileA);
                                } else {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.f65233c.b(this.f65232b, "Failed to load resource: " + str);
                                    }
                                    this.f65231a.D().a(ka.Q, "cacheStringResource", (Map) CollectionUtils.hashMap("url", str));
                                }
                                if (inputStreamA2 != null) {
                                    inputStreamA2.close();
                                }
                            } finally {
                            }
                        } catch (Throwable th) {
                            this.f65233c.a(this.f65232b, th);
                            this.f65231a.D().a(this.f65232b, "cacheStringResource", th);
                        }
                    } else {
                        try {
                            inputStreamA = this.f58723k.a(str, list, z2, this.f58721i);
                            try {
                                if (inputStreamA != null) {
                                    this.f58723k.a(inputStreamA, fileA);
                                } else {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.f65233c.b(this.f65232b, "Failed to load resource: " + str);
                                    }
                                    this.f65231a.D().a(ka.Q, "cacheStringResource", (Map) CollectionUtils.hashMap("url", str));
                                }
                                yp.a(inputStreamA, this.f65231a);
                            } catch (Throwable th2) {
                                th = th2;
                                yp.a(inputStreamA, this.f65231a);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStreamA = null;
                        }
                    }
                }
                return this.f58723k.e(fileA);
            } catch (Throwable th4) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.a(this.f65232b, "Resource at " + str + " failed to load.", th4);
                }
            }
        }
        return null;
    }

    Uri c(String str, List list, boolean z2) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Caching video " + str + "...");
        }
        String strA = this.f58723k.a(a(), str, this.f58720h.getCachePrefix(), list, z2, this.f58721i, this.f65231a.A().a(str, this.f58720h));
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Failed to cache video: " + str);
            }
            this.f65231a.D().a(ka.Q, "cacheVideo", (Map) CollectionUtils.hashMap("url", str));
            a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            return null;
        }
        File fileA = this.f58723k.a(strA, a());
        if (fileA == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Unable to retrieve File from cached video filename = " + strA);
            }
            this.f65231a.D().a(ka.Q, "retrieveVideoFile", (Map) CollectionUtils.hashMap("url", strA));
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        if (uriFromFile != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Finish caching video for ad #" + this.f58720h.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + strA);
            }
            return uriFromFile;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "Unable to create URI from cached video file = " + fileA);
        }
        this.f65231a.D().a(ka.Q, "extractUriFromVideoFile", (Map) CollectionUtils.hashMap("url", strA));
        return null;
    }

    protected List e() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Caching mute images...");
        }
        ArrayList arrayList = new ArrayList();
        if (this.f58720h.M() != null) {
            arrayList.add(a(this.f58720h.M().toString(), new a()));
        }
        if (this.f58720h.g0() != null) {
            arrayList.add(a(this.f58720h.g0().toString(), new b()));
        }
        return arrayList;
    }

    private Uri a(String str, String str2) {
        File fileA = this.f58723k.a(yp.a(Uri.parse(str2), this.f58720h.getCachePrefix(), this.f65231a), com.applovin.impl.sdk.j.m());
        if (fileA == null) {
            return null;
        }
        if (this.f58723k.a(fileA)) {
            this.f58721i.a(fileA.length());
            return Uri.parse("file://" + fileA.getAbsolutePath());
        }
        String str3 = str + str2;
        if (!this.f58723k.a(fileA, str3, Arrays.asList(str), this.f58721i, this.f65231a.A().a(str3, this.f58720h))) {
            return null;
        }
        return Uri.parse("file://" + fileA.getAbsolutePath());
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0039, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String a(java.lang.String r12, java.util.List r13, com.applovin.impl.sdk.ad.b r14) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.bm.a(java.lang.String, java.util.List, com.applovin.impl.sdk.ad.b):java.lang.String");
    }

    protected f1 b(String str, f1.a aVar) {
        return a(str, this.f58720h.Y(), true, aVar);
    }

    Uri a(String str, List list, boolean z2) {
        String str2;
        try {
            str2 = str;
        } catch (Throwable th) {
            th = th;
            str2 = str;
        }
        try {
            String strA = this.f58723k.a(a(), str2, this.f58720h.getCachePrefix(), list, z2, this.f58721i, this.f65231a.A().a(str, this.f58720h));
            if (StringUtils.isValidString(strA)) {
                File fileA = this.f58723k.a(strA, a());
                if (fileA != null) {
                    Uri uriFromFile = Uri.fromFile(fileA);
                    if (uriFromFile != null) {
                        return uriFromFile;
                    }
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f65233c.b(this.f65232b, "Unable to extract Uri from image file");
                    }
                    this.f65231a.D().a(ka.Q, "extractUriFromImageFile", (Map) CollectionUtils.hashMap("url", strA));
                    return null;
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "Unable to retrieve File from cached image filename = " + strA);
                }
                this.f65231a.D().a(ka.Q, "retrieveImageFile", (Map) CollectionUtils.hashMap("url", strA));
                return null;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Failed to cache image: " + str2);
            }
            this.f65231a.D().a(ka.Q, "cacheImageResource", (Map) CollectionUtils.hashMap("url", str2));
            return null;
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Failed to cache image at url = " + str2, th3);
            }
            this.f65231a.D().a(this.f65232b, "cacheImageResource", th3, CollectionUtils.hashMap("url", str2));
            return null;
        }
    }

    protected Uri a(Uri uri, String str) {
        if (uri == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "No " + str + " image to cache");
            }
            return null;
        }
        String string = uri.toString();
        if (TextUtils.isEmpty(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Failed to cache " + str + " image");
            }
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Caching " + str + " image...");
        }
        return b(string);
    }

    void a(com.applovin.impl.sdk.ad.b bVar) {
        String strA = a(bVar.i0(), bVar.j0(), bVar.R0(), bVar.Y(), bVar.d1());
        if (bVar.Q0() && StringUtils.isValidString(strA)) {
            String strA2 = a(strA, bVar.Y(), bVar);
            bVar.a(strA2);
            this.f65233c.f(this.f65232b, "Ad updated with video button HTML assets cached = " + strA2);
        }
    }

    protected f1 a(String str, List list, boolean z2, f1.a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (!com.applovin.impl.sdk.n.a()) {
                return null;
            }
            this.f65233c.a(this.f65232b, "No video to cache, skipping...");
            return null;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.a(this.f65232b, "Caching video " + str + "...");
        }
        return new f1(str, this.f58720h, list, z2, this.f58721i, this.f65231a, new c(aVar));
    }

    void a(int i3) {
        if (this.f58722j != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Calling back ad load failed with error code: " + i3);
            }
            this.f58722j.failedToReceiveAd(i3);
            this.f58722j = null;
        }
        g();
    }

    @Override // com.applovin.impl.ye.a
    public void a(fe feVar) {
        if (feVar.R().equalsIgnoreCase(this.f58720h.I())) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.b(this.f65232b, "Updating flag for timeout...");
            }
            g();
        }
        this.f65231a.R().b(this);
    }

    String a(String str, String str2, boolean z2, List list, boolean z3) {
        if (StringUtils.isValidString(str2)) {
            String strA = a(str2, z2, list, z3);
            if (StringUtils.isValidString(strA)) {
                return strA;
            }
            if (TextUtils.isEmpty(str)) {
                a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                if (com.applovin.impl.sdk.n.a()) {
                    this.f65233c.b(this.f65232b, "Could not retrieve HTML from: " + str2 + " and HTML source is invalid.");
                }
                this.f65231a.D().a(ka.Q, "retrieveHtmlString", (Map) CollectionUtils.hashMap("url", str2));
            }
        }
        return str;
    }

    private String a(String str, boolean z2, List list, boolean z3) {
        if (z2) {
            return b(str, list, z3);
        }
        return d(str, list, z3);
    }

    protected f1 a(String str, f1.a aVar) {
        return new f1(str, this.f58720h, this.f58721i, this.f65231a, aVar);
    }

    protected e1 a(String str, List list, e eVar) {
        return new e1(str, this.f58720h, list, this.f58721i, this.f58727o, this.f65231a, new d(eVar));
    }
}
