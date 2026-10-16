package com.superwall.sdk.logger;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.delegate.SuperwallDelegateAdapter;
import com.superwall.sdk.logger.Loggable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
public interface Loggable {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void debug$default(Companion companion, LogLevel logLevel, LogScope logScope, String str, Map map, Throwable th, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = "";
            }
            String str2 = str;
            if ((i3 & 8) != 0) {
                map = MapsKt.emptyMap();
            }
            Map map2 = map;
            if ((i3 & 16) != 0) {
                th = null;
            }
            companion.debug(logLevel, logScope, str2, (Map<String, ? extends Object>) map2, th);
        }

        private final void deliver(LogLevel logLevel, LogScope logScope, String str, Map<String, ? extends Object> map, Throwable th) {
            String str2;
            Map<String, ? extends Object> map2;
            Throwable th2;
            Superwall.Companion companion = Superwall.Companion;
            if (companion.getInitialized()) {
                str2 = str;
                map2 = map;
                th2 = th;
                companion.getInstance().getDependencyContainer$superwall_release().getDelegateAdapter().handleLog(logLevel.toString(), logScope.toString(), str2, map2, th2);
            } else {
                str2 = str;
                map2 = map;
                th2 = th;
            }
            if (shouldPrint(logLevel, logScope)) {
                System.out.println((Object) ("\n" + logLevel.getDescriptionEmoji() + " [!!Superwall] [" + logScope + "] " + logLevel + ": " + str2 + "\n"));
                if (map2 != null) {
                    Map<String, ? extends Object> map3 = !map2.isEmpty() ? map2 : null;
                    if (map3 != null) {
                        System.out.println((Object) ("info: " + map3));
                    }
                }
                if (th2 != null) {
                    System.out.println((Object) ("error: " + th2));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit emit$lambda$0(LogLevel logLevel, LogScope logScope, String str, Map map, Throwable th) {
            $$INSTANCE.deliver(logLevel, logScope, str, map, th);
            return Unit.f139807a;
        }

        public final void debug(LogLevel logLevel, LogScope scope, String message, Map<String, ? extends Object> map, Throwable th) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(message, "message");
            emit(logLevel, scope, message, map, th);
        }

        public final void emit(final LogLevel logLevel, final LogScope scope, final String message, final Map<String, ? extends Object> map, final Throwable th) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(message, "message");
            LogQueue.INSTANCE.post(new Function0() { // from class: com.superwall.sdk.logger.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Loggable.Companion.emit$lambda$0(logLevel, scope, message, map, th);
                }
            });
        }

        public final boolean shouldPrint(LogLevel logLevel, LogScope scope) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            SuperwallOptions.Logging logging = new SuperwallOptions.Logging();
            Superwall.Companion companion = Superwall.Companion;
            if (companion.getInitialized()) {
                logging = companion.getInstance().getOptions().getLogging();
            }
            if (logging.getLevel() == LogLevel.none) {
                return false;
            }
            return (logLevel.getLevel() >= logging.getLevel().getLevel()) && (logging.getScopes().contains(scope) || logging.getScopes().contains(LogScope.all));
        }

        public final boolean willLog(LogLevel logLevel, LogScope scope) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return SuperwallDelegateAdapter.Companion.getHasAnyDelegate$superwall_release() || shouldPrint(logLevel, scope);
        }

        public final void debug(LogLevel logLevel, LogScope scope, Throwable th, Function0<? extends Map<String, ? extends Object>> info, Function0<String> message) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(message, "message");
            if (willLog(logLevel, scope)) {
                emit(logLevel, scope, (String) message.invoke(), (Map) info.invoke(), th);
            }
        }

        public static /* synthetic */ void debug$default(Companion companion, LogLevel logLevel, LogScope scope, Throwable th, Function0 info, Function0 message, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                th = null;
            }
            Throwable th2 = th;
            if ((i3 & 8) != 0) {
                info = new Function0<Map<String, ? extends Object>>() { // from class: com.superwall.sdk.logger.Loggable$Companion$debug$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Map<String, Object> invoke() {
                        return MapsKt.emptyMap();
                    }
                };
            }
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(message, "message");
            if (companion.willLog(logLevel, scope)) {
                companion.emit(logLevel, scope, (String) message.invoke(), (Map) info.invoke(), th2);
            }
        }
    }
}
