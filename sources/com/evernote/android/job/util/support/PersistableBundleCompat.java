package com.evernote.android.job.util.support;

import com.evernote.android.job.util.JobCat;
import com.facebook.stetho.common.Utf8Charset;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PersistableBundleCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JobCat f67981b = new JobCat("PersistableBundleCompat");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f67982a;

    public PersistableBundleCompat() {
        this(new HashMap());
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.evernote.android.job.util.support.PersistableBundleCompat b(java.lang.String r3) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L24 java.lang.VerifyError -> L26 java.io.IOException -> L28 org.xmlpull.v1.XmlPullParserException -> L2a
            java.lang.String r2 = "UTF-8"
            byte[] r3 = r3.getBytes(r2)     // Catch: java.lang.Throwable -> L24 java.lang.VerifyError -> L26 java.io.IOException -> L28 org.xmlpull.v1.XmlPullParserException -> L2a
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L24 java.lang.VerifyError -> L26 java.io.IOException -> L28 org.xmlpull.v1.XmlPullParserException -> L2a
            java.util.HashMap r3 = com.evernote.android.job.util.support.XmlUtils.a(r1)     // Catch: java.lang.Throwable -> L19 java.lang.VerifyError -> L1c java.io.IOException -> L1f org.xmlpull.v1.XmlPullParserException -> L22
            com.evernote.android.job.util.support.PersistableBundleCompat r0 = new com.evernote.android.job.util.support.PersistableBundleCompat     // Catch: java.lang.Throwable -> L19 java.lang.VerifyError -> L1c java.io.IOException -> L1f org.xmlpull.v1.XmlPullParserException -> L22
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L19 java.lang.VerifyError -> L1c java.io.IOException -> L1f org.xmlpull.v1.XmlPullParserException -> L22
            r1.close()     // Catch: java.io.IOException -> L18
        L18:
            return r0
        L19:
            r3 = move-exception
            r0 = r1
            goto L4c
        L1c:
            r3 = move-exception
            r0 = r1
            goto L2c
        L1f:
            r3 = move-exception
        L20:
            r0 = r1
            goto L3c
        L22:
            r3 = move-exception
            goto L20
        L24:
            r3 = move-exception
            goto L4c
        L26:
            r3 = move-exception
            goto L2c
        L28:
            r3 = move-exception
            goto L3c
        L2a:
            r3 = move-exception
            goto L3c
        L2c:
            com.evernote.android.job.util.JobCat r1 = com.evernote.android.job.util.support.PersistableBundleCompat.f67981b     // Catch: java.lang.Throwable -> L24
            r1.f(r3)     // Catch: java.lang.Throwable -> L24
            com.evernote.android.job.util.support.PersistableBundleCompat r3 = new com.evernote.android.job.util.support.PersistableBundleCompat     // Catch: java.lang.Throwable -> L24
            r3.<init>()     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L3b
            r0.close()     // Catch: java.io.IOException -> L3b
        L3b:
            return r3
        L3c:
            com.evernote.android.job.util.JobCat r1 = com.evernote.android.job.util.support.PersistableBundleCompat.f67981b     // Catch: java.lang.Throwable -> L24
            r1.f(r3)     // Catch: java.lang.Throwable -> L24
            com.evernote.android.job.util.support.PersistableBundleCompat r3 = new com.evernote.android.job.util.support.PersistableBundleCompat     // Catch: java.lang.Throwable -> L24
            r3.<init>()     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L4b
            r0.close()     // Catch: java.io.IOException -> L4b
        L4b:
            return r3
        L4c:
            if (r0 == 0) goto L51
            r0.close()     // Catch: java.io.IOException -> L51
        L51:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.evernote.android.job.util.support.PersistableBundleCompat.b(java.lang.String):com.evernote.android.job.util.support.PersistableBundleCompat");
    }

    public boolean a(String str) {
        return this.f67982a.containsKey(str);
    }

    public boolean c(String str, boolean z2) {
        Object obj = this.f67982a.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z2;
    }

    public int d(String str, int i3) {
        Object obj = this.f67982a.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i3;
    }

    public long e(String str, long j3) {
        Object obj = this.f67982a.get(str);
        return obj instanceof Long ? ((Long) obj).longValue() : j3;
    }

    public String f(String str, String str2) {
        Object obj = this.f67982a.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public void g(PersistableBundleCompat persistableBundleCompat) {
        this.f67982a.putAll(persistableBundleCompat.f67982a);
    }

    public void h(String str, boolean z2) {
        this.f67982a.put(str, Boolean.valueOf(z2));
    }

    public void i(String str, int i3) {
        this.f67982a.put(str, Integer.valueOf(i3));
    }

    public void j(String str, long j3) {
        this.f67982a.put(str, Long.valueOf(j3));
    }

    public void k(String str, String str2) {
        this.f67982a.put(str, str2);
    }

    public String l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                XmlUtils.t(this.f67982a, byteArrayOutputStream);
                return byteArrayOutputStream.toString(Utf8Charset.NAME);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
        } catch (IOException e3) {
            e = e3;
            f67981b.f(e);
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
            }
            return "";
        } catch (Error e4) {
            f67981b.f(e4);
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused3) {
            }
            return "";
        } catch (XmlPullParserException e5) {
            e = e5;
            f67981b.f(e);
            byteArrayOutputStream.close();
            return "";
        }
    }

    public PersistableBundleCompat(PersistableBundleCompat persistableBundleCompat) {
        this(new HashMap(persistableBundleCompat.f67982a));
    }

    private PersistableBundleCompat(Map map) {
        this.f67982a = map;
    }
}
