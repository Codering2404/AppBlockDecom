package okhttp3.internal;

import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.common.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f144274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Headers f144275b = Headers.f144082b.g(new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ResponseBody f144276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RequestBody f144277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Options f144278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TimeZone f144279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Regex f144280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f144281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f144282i;

    static {
        byte[] bArr = new byte[0];
        f144274a = bArr;
        f144276c = ResponseBody.Companion.d(ResponseBody.f144254b, bArr, null, 1, null);
        f144277d = RequestBody.Companion.i(RequestBody.f144218a, bArr, null, 0, 0, 7, null);
        Options.Companion companion = Options.f145068c;
        ByteString.Companion companion2 = ByteString.f144997d;
        f144278e = companion.d(companion2.b("efbbbf"), companion2.b("feff"), companion2.b("fffe"), companion2.b("0000ffff"), companion2.b("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        f144279f = timeZone;
        f144280g = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f144281h = false;
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        f144282i = StringsKt.L0(StringsKt.K0(name, "okhttp3."), "Client");
    }

    public static /* synthetic */ int A(String str, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = str.length();
        }
        return z(str, i3, i4);
    }

    public static final int B(String str, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i5 = i4 - 1;
        if (i3 <= i5) {
            while (true) {
                int i6 = i5 - 1;
                char cCharAt = str.charAt(i5);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i5 + 1;
                }
                if (i5 == i3) {
                    break;
                }
                i5 = i6;
            }
        }
        return i3;
    }

    public static /* synthetic */ int C(String str, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = str.length();
        }
        return B(str, i3, i4);
    }

    public static final int D(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (i3 < length) {
            int i4 = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i3;
            }
            i3 = i4;
        }
        return str.length();
    }

    public static final String[] E(String[] strArr, String[] other, Comparator comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i3 = 0;
        while (i3 < length) {
            String str = strArr[i3];
            i3++;
            int length2 = other.length;
            int i4 = 0;
            while (true) {
                if (i4 < length2) {
                    String str2 = other[i4];
                    i4++;
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean F(FileSystem fileSystem, File file) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        Sink sinkF = fileSystem.f(file);
        try {
            try {
                fileSystem.h(file);
                CloseableKt.a(sinkF, null);
                return true;
            } catch (IOException unused) {
                Unit unit = Unit.f139807a;
                CloseableKt.a(sinkF, null);
                fileSystem.h(file);
                return false;
            }
        } finally {
        }
    }

    public static final boolean G(Socket socket, BufferedSource source) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !source.G1();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean H(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.F(name, "Authorization", true) || StringsKt.F(name, "Cookie", true) || StringsKt.F(name, "Proxy-Authorization", true) || StringsKt.F(name, "Set-Cookie", true);
    }

    public static final int I(char c3) {
        if ('0' <= c3 && c3 < ':') {
            return c3 - '0';
        }
        if ('a' <= c3 && c3 < 'g') {
            return c3 - 'W';
        }
        if ('A' > c3 || c3 >= 'G') {
            return -1;
        }
        return c3 - '7';
    }

    public static final Charset J(BufferedSource bufferedSource, Charset charset) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        int iI2 = bufferedSource.I2(f144278e);
        if (iI2 == -1) {
            return charset;
        }
        if (iI2 == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (iI2 == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            Intrinsics.checkNotNullExpressionValue(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (iI2 == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (iI2 == 3) {
            return Charsets.f140509a.a();
        }
        if (iI2 == 4) {
            return Charsets.f140509a.b();
        }
        throw new AssertionError();
    }

    public static final int K(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        return d(bufferedSource.readByte(), 255) | (d(bufferedSource.readByte(), 255) << 16) | (d(bufferedSource.readByte(), 255) << 8);
    }

    public static final int L(Buffer buffer, byte b3) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i3 = 0;
        while (!buffer.G1() && buffer.r(0L) == b3) {
            i3++;
            buffer.readByte();
        }
        return i3;
    }

    public static final boolean M(Source source, int i3, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jD = source.v().f() ? source.v().d() - jNanoTime : Long.MAX_VALUE;
        source.v().e(Math.min(jD, timeUnit.toNanos(i3)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.t2(buffer, 8192L) != -1) {
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

    public static final ThreadFactory N(final String name, final boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ThreadFactory() { // from class: q2.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return Util.O(name, z2, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread O(String name, boolean z2, Runnable runnable) {
        Intrinsics.checkNotNullParameter(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(z2);
        return thread;
    }

    public static final List P(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        IntRange intRangeB = RangesKt.B(0, headers.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB, 10));
        Iterator<Integer> it = intRangeB.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            arrayList.add(new Header(headers.d(iNextInt), headers.h(iNextInt)));
        }
        return arrayList;
    }

    public static final Headers Q(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            builder.d(header.a().I(), header.b().I());
        }
        return builder.f();
    }

    public static final String R(int i3) {
        String hexString = Integer.toHexString(i3);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String S(long j3) {
        String hexString = Long.toHexString(j3);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String T(HttpUrl httpUrl, boolean z2) {
        String strI;
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        if (StringsKt.a0(httpUrl.i(), Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, null)) {
            strI = '[' + httpUrl.i() + ']';
        } else {
            strI = httpUrl.i();
        }
        if (!z2 && httpUrl.n() == HttpUrl.f144085k.c(httpUrl.r())) {
            return strI;
        }
        return strI + ':' + httpUrl.n();
    }

    public static /* synthetic */ String U(HttpUrl httpUrl, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return T(httpUrl, z2);
    }

    public static final List V(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final Map W(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final long X(String str, long j3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j3;
        }
    }

    public static final int Y(String str, int i3) {
        Long lValueOf;
        if (str == null) {
            lValueOf = null;
        } else {
            try {
                lValueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
            }
        }
        if (lValueOf == null) {
            return i3;
        }
        long jLongValue = lValueOf.longValue();
        if (jLongValue > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }

    public static final String Z(String str, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int iZ = z(str, i3, i4);
        String strSubstring = str.substring(iZ, B(str, iZ, i4));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String a0(String str, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = str.length();
        }
        return Z(str, i3, i4);
    }

    public static final Throwable b0(Exception exc, List suppressed) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator it = suppressed.iterator();
        while (it.hasNext()) {
            ExceptionsKt.a(exc, (Exception) it.next());
        }
        return exc;
    }

    public static final void c(List list, Object obj) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.contains(obj)) {
            return;
        }
        list.add(obj);
    }

    public static final void c0(BufferedSink bufferedSink, int i3) {
        Intrinsics.checkNotNullParameter(bufferedSink, "<this>");
        bufferedSink.writeByte((i3 >>> 16) & 255);
        bufferedSink.writeByte((i3 >>> 8) & 255);
        bufferedSink.writeByte(i3 & 255);
    }

    public static final int d(byte b3, int i3) {
        return b3 & i3;
    }

    public static final int e(short s2, int i3) {
        return s2 & i3;
    }

    public static final long f(int i3, long j3) {
        return ((long) i3) & j3;
    }

    public static final EventListener.Factory g(final EventListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "<this>");
        return new EventListener.Factory() { // from class: q2.a
            @Override // okhttp3.EventListener.Factory
            public final EventListener a(Call call) {
                return Util.h(eventListener, call);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener h(EventListener this_asFactory, Call it) {
        Intrinsics.checkNotNullParameter(this_asFactory, "$this_asFactory");
        Intrinsics.checkNotNullParameter(it, "it");
        return this_asFactory;
    }

    public static final boolean i(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return f144280g.k(str);
    }

    public static final boolean j(HttpUrl httpUrl, HttpUrl other) {
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(httpUrl.i(), other.i()) && httpUrl.n() == other.n() && Intrinsics.areEqual(httpUrl.r(), other.r());
    }

    public static final int k(String name, long j3, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (j3 < 0) {
            throw new IllegalStateException(Intrinsics.stringPlus(name, " < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j3);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(name, " too large.").toString());
        }
        if (millis != 0 || j3 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus(name, " too small.").toString());
    }

    public static final void l(long j3, long j4, long j5) {
        if ((j4 | j5) < 0 || j4 > j3 || j3 - j4 < j5) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void m(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static final void n(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e3) {
            throw e3;
        } catch (RuntimeException e4) {
            if (!Intrinsics.areEqual(e4.getMessage(), "bio == null")) {
                throw e4;
            }
        } catch (Exception unused) {
        }
    }

    public static final String[] o(String[] strArr, String value) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[ArraysKt.getLastIndex(strArr2)] = value;
        return strArr2;
    }

    public static final int p(String str, char c3, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i3 < i4) {
            int i5 = i3 + 1;
            if (str.charAt(i3) == c3) {
                return i3;
            }
            i3 = i5;
        }
        return i4;
    }

    public static final int q(String str, String delimiters, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        while (i3 < i4) {
            int i5 = i3 + 1;
            if (StringsKt.Z(delimiters, str.charAt(i3), false, 2, null)) {
                return i3;
            }
            i3 = i5;
        }
        return i4;
    }

    public static /* synthetic */ int r(String str, char c3, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = str.length();
        }
        return p(str, c3, i3, i4);
    }

    public static final boolean s(Source source, int i3, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return M(source, i3, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String t(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }

    public static final boolean u(String[] strArr, String[] strArr2, Comparator comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            int length = strArr.length;
            int i3 = 0;
            while (i3 < length) {
                String str = strArr[i3];
                i3++;
                Iterator itA = ArrayIteratorKt.a(strArr2);
                while (itA.hasNext()) {
                    if (comparator.compare(str, (String) itA.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long v(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        String strA = response.r().a(HttpHeaders.CONTENT_LENGTH);
        if (strA == null) {
            return -1L;
        }
        return X(strA, -1L);
    }

    public static final List w(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int x(String[] strArr, String value, Comparator comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (comparator.compare(strArr[i3], value) == 0) {
                return i3;
            }
        }
        return -1;
    }

    public static final int y(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (Intrinsics.compare((int) cCharAt, 31) <= 0 || Intrinsics.compare((int) cCharAt, 127) >= 0) {
                return i3;
            }
            i3 = i4;
        }
        return -1;
    }

    public static final int z(String str, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i3 < i4) {
            int i5 = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3;
            }
            i3 = i5;
        }
        return i4;
    }
}
