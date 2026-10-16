package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;

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
public final class AndroidLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AndroidLog f144825a = new AndroidLog();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet f144826b = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f144827c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = OkHttpClient.class.getPackage();
        String name = r2 == null ? null : r2.getName();
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = Http2.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = TaskRunner.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f144827c = MapsKt.toMap(linkedHashMap);
    }

    private AndroidLog() {
    }

    private final void c(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (f144826b.add(logger)) {
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(AndroidLogHandler.f144828a);
        }
    }

    private final String d(String str) {
        String str2 = (String) f144827c.get(str);
        return str2 == null ? StringsKt.B1(str, 23) : str2;
    }

    public final void a(String loggerName, int i3, String message, Throwable th) {
        int iMin;
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(message, "message");
        String strD = d(loggerName);
        if (Log.isLoggable(strD, i3)) {
            if (th != null) {
                message = message + '\n' + ((Object) Log.getStackTraceString(th));
            }
            String str = message;
            int length = str.length();
            int i4 = 0;
            while (i4 < length) {
                int iM0 = StringsKt.m0(str, '\n', i4, false, 4, null);
                if (iM0 == -1) {
                    iM0 = length;
                }
                while (true) {
                    iMin = Math.min(iM0, i4 + 4000);
                    String strSubstring = str.substring(i4, iMin);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i3, strD, strSubstring);
                    if (iMin >= iM0) {
                        break;
                    } else {
                        i4 = iMin;
                    }
                }
                i4 = iMin + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry entry : f144827c.entrySet()) {
            c((String) entry.getKey(), (String) entry.getValue());
        }
    }
}
