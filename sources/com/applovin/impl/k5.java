package com.applovin.impl;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class k5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f60912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f60913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f60914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f60915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f60916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f60917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f60918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f60919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f60920i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f60921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f60922k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f60923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f60924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f60925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f60926d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map f60927e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f60928f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f60929g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f60930h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f60931i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Object f60932j;

        public b() {
            this.f60925c = 1;
            this.f60927e = Collections.EMPTY_MAP;
            this.f60929g = -1L;
        }

        public k5 a() {
            b1.a(this.f60923a, "The uri must be set.");
            return new k5(this.f60923a, this.f60924b, this.f60925c, this.f60926d, this.f60927e, this.f60928f, this.f60929g, this.f60930h, this.f60931i, this.f60932j);
        }

        public b b(int i3) {
            this.f60925c = i3;
            return this;
        }

        public b b(String str) {
            this.f60923a = Uri.parse(str);
            return this;
        }

        public b a(int i3) {
            this.f60931i = i3;
            return this;
        }

        public b a(byte[] bArr) {
            this.f60926d = bArr;
            return this;
        }

        private b(k5 k5Var) {
            this.f60923a = k5Var.f60912a;
            this.f60924b = k5Var.f60913b;
            this.f60925c = k5Var.f60914c;
            this.f60926d = k5Var.f60915d;
            this.f60927e = k5Var.f60916e;
            this.f60928f = k5Var.f60918g;
            this.f60929g = k5Var.f60919h;
            this.f60930h = k5Var.f60920i;
            this.f60931i = k5Var.f60921j;
            this.f60932j = k5Var.f60922k;
        }

        public b a(Map map) {
            this.f60927e = map;
            return this;
        }

        public b a(String str) {
            this.f60930h = str;
            return this;
        }

        public b a(long j3) {
            this.f60928f = j3;
            return this;
        }

        public b a(Uri uri) {
            this.f60923a = uri;
            return this;
        }
    }

    private k5(Uri uri, long j3, int i3, byte[] bArr, Map map, long j4, long j5, String str, int i4, Object obj) {
        byte[] bArr2 = bArr;
        long j6 = j3 + j4;
        b1.a(j6 >= 0);
        b1.a(j4 >= 0);
        b1.a(j5 > 0 || j5 == -1);
        this.f60912a = uri;
        this.f60913b = j3;
        this.f60914c = i3;
        this.f60915d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f60916e = Collections.unmodifiableMap(new HashMap(map));
        this.f60918g = j4;
        this.f60917f = j6;
        this.f60919h = j5;
        this.f60920i = str;
        this.f60921j = i4;
        this.f60922k = obj;
    }

    public static String a(int i3) {
        if (i3 == 1) {
            return "GET";
        }
        if (i3 == 2) {
            return "POST";
        }
        if (i3 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public final String b() {
        return a(this.f60914c);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f60912a + ", " + this.f60918g + ", " + this.f60919h + ", " + this.f60920i + ", " + this.f60921j + "]";
    }

    public boolean b(int i3) {
        return (this.f60921j & i3) == i3;
    }

    public b a() {
        return new b();
    }
}
