package com.superwall.sdk.logger;

import com.superwall.sdk.logger.Loggable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class Logger implements Loggable {
    public static final Logger INSTANCE = new Logger();

    private Logger() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void debug$default(Logger logger, LogLevel logLevel, LogScope logScope, String str, Map map, Throwable th, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "";
        }
        logger.debug(logLevel, logScope, str, (Map<String, ? extends Object>) ((i3 & 8) != 0 ? null : map), (i3 & 16) != 0 ? null : th);
    }

    public final void debug(LogLevel logLevel, LogScope scope, String message, Map<String, ? extends Object> map, Throwable th) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(message, "message");
        Loggable.Companion.debug(logLevel, scope, message, map, th);
    }

    public final boolean shouldPrint(LogLevel logLevel, LogScope scope) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return Loggable.Companion.shouldPrint(logLevel, scope);
    }

    public final void debug(LogLevel logLevel, LogScope scope, Throwable th, Function0<? extends Map<String, ? extends Object>> info, Function0<String> message) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(message, "message");
        Loggable.Companion companion = Loggable.Companion;
        if (companion.willLog(logLevel, scope)) {
            companion.emit(logLevel, scope, (String) message.invoke(), (Map) info.invoke(), th);
        }
    }

    public static /* synthetic */ void debug$default(Logger logger, LogLevel logLevel, LogScope scope, Throwable th, Function0 info, Function0 message, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th = null;
        }
        Throwable th2 = th;
        if ((i3 & 8) != 0) {
            info = new Function0() { // from class: com.superwall.sdk.logger.Logger.debug.1
                @Override // kotlin.jvm.functions.Function0
                public final Void invoke() {
                    return null;
                }
            };
        }
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(message, "message");
        Loggable.Companion companion = Loggable.Companion;
        if (companion.willLog(logLevel, scope)) {
            companion.emit(logLevel, scope, (String) message.invoke(), (Map) info.invoke(), th2);
        }
    }
}
