package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Logger {
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    private final LoggingBehavior behavior;
    private StringBuilder contents;
    private int priority;
    private final String tag;
    public static final Companion Companion = new Companion(null);
    private static final HashMap<String, String> stringsToReplace = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized String replaceStrings(String str) {
            String strO;
            strO = str;
            for (Map.Entry entry : Logger.stringsToReplace.entrySet()) {
                strO = StringsKt.O(strO, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
            }
            return strO;
        }

        @JvmStatic
        public final void log(LoggingBehavior behavior, String tag, String string) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(string, "string");
            log(behavior, 3, tag, string);
        }

        @JvmStatic
        public final synchronized void registerAccessToken(String accessToken) {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(accessToken, "ACCESS_TOKEN_REMOVED");
            }
        }

        @JvmStatic
        public final synchronized void registerStringToReplace(String original, String replace) {
            Intrinsics.checkNotNullParameter(original, "original");
            Intrinsics.checkNotNullParameter(replace, "replace");
            Logger.stringsToReplace.put(original, replace);
        }

        private Companion() {
        }

        @JvmStatic
        public final void log(LoggingBehavior behavior, String tag, String format, Object... args) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
                String str = String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                log(behavior, 3, tag, str);
            }
        }

        @JvmStatic
        public final void log(LoggingBehavior behavior, int i3, String tag, String format, Object... args) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
                String str = String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                log(behavior, i3, tag, str);
            }
        }

        @JvmStatic
        public final void log(LoggingBehavior behavior, int i3, String tag, String string) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(string, "string");
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                String strReplaceStrings = replaceStrings(string);
                if (!StringsKt.U(tag, Logger.LOG_TAG_BASE, false, 2, null)) {
                    tag = Logger.LOG_TAG_BASE + tag;
                }
                Log.println(i3, tag, strReplaceStrings);
                if (behavior == LoggingBehavior.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }
    }

    public Logger(LoggingBehavior behavior, String tag) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.priority = 3;
        this.behavior = behavior;
        this.tag = LOG_TAG_BASE + Validate.notNullOrEmpty(tag, "tag");
        this.contents = new StringBuilder();
    }

    @JvmStatic
    public static final void log(LoggingBehavior loggingBehavior, int i3, String str, String str2) {
        Companion.log(loggingBehavior, i3, str, str2);
    }

    @JvmStatic
    public static final synchronized void registerAccessToken(String str) {
        Companion.registerAccessToken(str);
    }

    @JvmStatic
    public static final synchronized void registerStringToReplace(String str, String str2) {
        Companion.registerStringToReplace(str, str2);
    }

    private final boolean shouldLog() {
        return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
    }

    public final void append(StringBuilder stringBuilder) {
        Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
        if (shouldLog()) {
            this.contents.append((CharSequence) stringBuilder);
        }
    }

    public final void appendKeyValue(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        append("  %s:\t%s\n", key, value);
    }

    public final String getContents() {
        Companion companion = Companion;
        String string = this.contents.toString();
        Intrinsics.checkNotNullExpressionValue(string, "contents.toString()");
        return companion.replaceStrings(string);
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void logString(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        Companion.log(this.behavior, this.priority, this.tag, string);
    }

    public final void setPriority(int i3) {
        Validate.oneOf(Integer.valueOf(i3), "value", 7, 3, 6, 4, 2, 5);
        setPriority(i3);
    }

    @JvmStatic
    public static final void log(LoggingBehavior loggingBehavior, int i3, String str, String str2, Object... objArr) {
        Companion.log(loggingBehavior, i3, str, str2, objArr);
    }

    @JvmStatic
    public static final void log(LoggingBehavior loggingBehavior, String str, String str2) {
        Companion.log(loggingBehavior, str, str2);
    }

    public final void append(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (shouldLog()) {
            this.contents.append(string);
        }
    }

    @JvmStatic
    public static final void log(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        Companion.log(loggingBehavior, str, str2, objArr);
    }

    public final void append(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        if (shouldLog()) {
            StringBuilder sb = this.contents;
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
            String str = String.format(format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            sb.append(str);
        }
    }

    public final void log() {
        String string = this.contents.toString();
        Intrinsics.checkNotNullExpressionValue(string, "contents.toString()");
        logString(string);
        this.contents = new StringBuilder();
    }
}
