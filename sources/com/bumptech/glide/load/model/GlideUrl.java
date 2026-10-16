package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GlideUrl implements Key {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Headers f66701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final URL f66702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f66703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f66704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private URL f66705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile byte[] f66706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f66707h;

    public GlideUrl(URL url) {
        this(url, Headers.f66709b);
    }

    private byte[] d() {
        if (this.f66706g == null) {
            this.f66706g = c().getBytes(Key.f66253a);
        }
        return this.f66706g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f66704e)) {
            String string = this.f66703d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) Preconditions.e(this.f66702c)).toString();
            }
            this.f66704e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$[]");
        }
        return this.f66704e;
    }

    private URL g() {
        if (this.f66705f == null) {
            this.f66705f = new URL(f());
        }
        return this.f66705f;
    }

    @Override // com.bumptech.glide.load.Key
    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f66703d;
        return str != null ? str : ((URL) Preconditions.e(this.f66702c)).toString();
    }

    public Map e() {
        return this.f66701b.a();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GlideUrl) {
            GlideUrl glideUrl = (GlideUrl) obj;
            if (c().equals(glideUrl.c()) && this.f66701b.equals(glideUrl.f66701b)) {
                return true;
            }
        }
        return false;
    }

    public URL h() {
        return g();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.f66707h == 0) {
            int iHashCode = c().hashCode();
            this.f66707h = iHashCode;
            this.f66707h = (iHashCode * 31) + this.f66701b.hashCode();
        }
        return this.f66707h;
    }

    public String toString() {
        return c();
    }

    public GlideUrl(String str) {
        this(str, Headers.f66709b);
    }

    public GlideUrl(URL url, Headers headers) {
        this.f66702c = (URL) Preconditions.e(url);
        this.f66703d = null;
        this.f66701b = (Headers) Preconditions.e(headers);
    }

    public GlideUrl(String str, Headers headers) {
        this.f66702c = null;
        this.f66703d = Preconditions.c(str);
        this.f66701b = (Headers) Preconditions.e(headers);
    }
}
