package com.squareup.okhttp.internal;

import com.facebook.stetho.common.Utf8Charset;
import com.revenuecat.purchases.common.Constants;
import com.squareup.okhttp.HttpUrl;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f93119a = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f93120b = new String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f93121c = Charset.forName(Utf8Charset.NAME);

    public static void a(long j3, long j4, long j5) {
        if ((j4 | j5) < 0 || j4 > j3 || j3 - j4 < j5) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void b(Closeable closeable, Closeable closeable2) throws IOException {
        try {
            closeable.close();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th == null) {
            return;
        }
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (!(th instanceof Error)) {
            throw new AssertionError(th);
        }
        throw ((Error) th);
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static void d(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e3) {
                if (!o(e3)) {
                    throw e3;
                }
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] e(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    public static boolean f(String[] strArr, String str) {
        return Arrays.asList(strArr).contains(str);
    }

    public static boolean g(Source source, int i3, TimeUnit timeUnit) {
        try {
            return r(source, i3, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean h(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String i(HttpUrl httpUrl) {
        if (httpUrl.A() == HttpUrl.i(httpUrl.E())) {
            return httpUrl.q();
        }
        return httpUrl.q() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + httpUrl.A();
    }

    public static List j(List list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static List k(Object... objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static Map l(Map map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    private static List m(Object[] objArr, Object[] objArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            int length = objArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    Object obj2 = objArr2[i3];
                    if (obj.equals(obj2)) {
                        arrayList.add(obj2);
                        break;
                    }
                    i3++;
                }
            }
        }
        return arrayList;
    }

    public static Object[] n(Class cls, Object[] objArr, Object[] objArr2) {
        List listM = m(objArr, objArr2);
        return listM.toArray((Object[]) Array.newInstance((Class<?>) cls, listM.size()));
    }

    public static boolean o(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static String p(String str) {
        try {
            return ByteString.v(MessageDigest.getInstance("MD5").digest(str.getBytes(Utf8Charset.NAME))).l();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        }
    }

    public static ByteString q(ByteString byteString) {
        try {
            return ByteString.v(MessageDigest.getInstance("SHA-1").digest(byteString.H()));
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        }
    }

    public static boolean r(Source source, int i3, TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        long jD = source.v().f() ? source.v().d() - jNanoTime : Long.MAX_VALUE;
        source.v().e(Math.min(jD, timeUnit.toNanos(i3)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.t2(buffer, 2048L) != -1) {
                buffer.a();
            }
            if (jD == Long.MAX_VALUE) {
                source.v().b();
                return true;
            }
            source.v().e(jNanoTime + jD);
            return true;
        } catch (InterruptedIOException unused) {
            if (jD == Long.MAX_VALUE) {
                source.v().b();
                return false;
            }
            source.v().e(jNanoTime + jD);
            return false;
        } catch (Throwable th) {
            if (jD == Long.MAX_VALUE) {
                source.v().b();
            } else {
                source.v().e(jNanoTime + jD);
            }
            throw th;
        }
    }

    public static ThreadFactory s(final String str, final boolean z2) {
        return new ThreadFactory() { // from class: com.squareup.okhttp.internal.Util.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z2);
                return thread;
            }
        };
    }
}
