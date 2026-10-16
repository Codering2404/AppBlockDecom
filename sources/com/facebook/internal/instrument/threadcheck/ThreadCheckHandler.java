package com.facebook.internal.instrument.threadcheck;

import android.os.Looper;
import android.util.Log;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ThreadCheckHandler {
    public static final ThreadCheckHandler INSTANCE = new ThreadCheckHandler();
    private static final String TAG = ThreadCheckHandler.class.getCanonicalName();
    private static boolean enabled;

    private ThreadCheckHandler() {
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
    }

    private final void log(String str, Class<?> cls, String str2, String str3) {
        if (enabled) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str4 = String.format(Locale.US, "%s annotation violation detected in %s.%s%s. Current looper is %s and main looper is %s.", Arrays.copyOf(new Object[]{str, cls.getName(), str2, str3, Looper.myLooper(), Looper.getMainLooper()}, 6));
            Intrinsics.checkNotNullExpressionValue(str4, "format(locale, format, *args)");
            Exception exc = new Exception();
            Log.e(TAG, str4, exc);
            InstrumentData.Builder.build(exc, InstrumentData.Type.ThreadCheck).save();
        }
    }

    @JvmStatic
    public static final void uiThreadViolationDetected(Class<?> clazz, String methodName, String methodDesc) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(methodDesc, "methodDesc");
        INSTANCE.log("@UiThread", clazz, methodName, methodDesc);
    }

    @JvmStatic
    public static final void workerThreadViolationDetected(Class<?> clazz, String methodName, String methodDesc) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(methodDesc, "methodDesc");
        INSTANCE.log("@WorkerThread", clazz, methodName, methodDesc);
    }
}
