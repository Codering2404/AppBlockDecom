package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.h5;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface pa extends h5 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a extends c {
        public a(IOException iOException, k5 k5Var) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, k5Var, 2007, 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b extends h5.a {
        @Override // com.applovin.impl.h5.a
        pa a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class c extends i5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k5 f62422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f62423c;

        public c(k5 k5Var, int i3, int i4) {
            super(a(i3, i4));
            this.f62422b = k5Var;
            this.f62423c = i4;
        }

        private static int a(int i3, int i4) {
            return (i3 == 2000 && i4 == 1) ? AdError.INTERNAL_ERROR_CODE : i3;
        }

        public static c a(IOException iOException, k5 k5Var, int i3) {
            String message = iOException.getMessage();
            int i4 = iOException instanceof SocketTimeoutException ? AdError.CACHE_ERROR_CODE : iOException instanceof InterruptedIOException ? 1004 : (message == null || !Ascii.toLowerCase(message).matches("cleartext.*not permitted.*")) ? AdError.INTERNAL_ERROR_CODE : 2007;
            return i4 == 2007 ? new a(iOException, k5Var) : new c(iOException, k5Var, i4, i3);
        }

        public c(IOException iOException, k5 k5Var, int i3, int i4) {
            super(iOException, a(i3, i4));
            this.f62422b = k5Var;
            this.f62423c = i4;
        }

        public c(String str, k5 k5Var, int i3, int i4) {
            super(str, a(i3, i4));
            this.f62422b = k5Var;
            this.f62423c = i4;
        }

        public c(String str, IOException iOException, k5 k5Var, int i3, int i4) {
            super(str, iOException, a(i3, i4));
            this.f62422b = k5Var;
            this.f62423c = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class d extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f62424d;

        public d(String str, k5 k5Var) {
            super("Invalid content type: " + str, k5Var, AdError.INTERNAL_ERROR_2003, 1);
            this.f62424d = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class e extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f62425d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f62426f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map f62427g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f62428h;

        public e(int i3, String str, IOException iOException, Map map, k5 k5Var, byte[] bArr) {
            super("Response code: " + i3, iOException, k5Var, AdError.INTERNAL_ERROR_2004, 1);
            this.f62425d = i3;
            this.f62426f = str;
            this.f62427g = map;
            this.f62428h = bArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f62429a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f62430b;

        public synchronized Map a() {
            try {
                if (this.f62430b == null) {
                    this.f62430b = Collections.unmodifiableMap(new HashMap(this.f62429a));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f62430b;
        }
    }
}
