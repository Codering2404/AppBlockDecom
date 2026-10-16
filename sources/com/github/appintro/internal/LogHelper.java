package com.github.appintro.internal;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
public final class LogHelper {
    public static final LogHelper INSTANCE = new LogHelper();

    private LogHelper() {
    }

    private final String cutTagLength(String str, int i3) {
        if (str.length() <= i3) {
            return str;
        }
        String strSubstring = str.substring(0, i3 - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @JvmStatic
    public static final int d(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        return Log.d(tag, message);
    }

    @JvmStatic
    public static final void e(String str, String str2) {
        e$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th = null;
        }
        e(str, str2, th);
    }

    @JvmStatic
    public static final int i(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        return Log.i(tag, message);
    }

    @JvmStatic
    public static final String makeLogTag(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        StringBuilder sb = new StringBuilder();
        sb.append("Log: ");
        LogHelper logHelper = INSTANCE;
        String simpleName = cls.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "cls.simpleName");
        sb.append(logHelper.cutTagLength(simpleName, 18));
        return sb.toString();
    }

    @JvmStatic
    public static final int v(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        return Log.v(tag, message);
    }

    @JvmStatic
    public static final void w(String str, String str2) {
        w$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th = null;
        }
        w(str, str2, th);
    }

    @JvmStatic
    public static final void wtf(String str, String str2) {
        wtf$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ void wtf$default(String str, String str2, Throwable th, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th = null;
        }
        wtf(str, str2, th);
    }

    @JvmStatic
    public static final void e(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.e(tag, message, th);
    }

    @JvmStatic
    public static final void w(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.w(tag, message, th);
    }

    @JvmStatic
    public static final void wtf(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.wtf(tag, message, th);
    }

    public final String makeLogTag(KClass<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        StringBuilder sb = new StringBuilder();
        sb.append("Log: ");
        String strM = cls.m();
        if (strM == null) {
            strM = "";
        }
        sb.append(cutTagLength(strM, 18));
        return sb.toString();
    }
}
