package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class HTTPTimeoutManager {
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_TIMEOUT_MS = 30000;
    public static final long REDUCED_TIMEOUT_MS = 2000;
    public static final long SUPPORTED_FALLBACK_TIMEOUT_MS = 5000;
    public static final long TEST_DIVIDER = 10;
    public static final long TIMEOUT_RESET_INTERVAL_MS = 600000;
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final AtomicLong lastTimeoutRequestTime;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum RequestResult {
        SUCCESS_ON_MAIN_BACKEND,
        TIMEOUT_ON_MAIN_BACKEND_FOR_FALLBACK_SUPPORTED_ENDPOINT,
        OTHER_RESULT
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestResult.values().length];
            try {
                iArr[RequestResult.SUCCESS_ON_MAIN_BACKEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestResult.TIMEOUT_ON_MAIN_BACKEND_FOR_FALLBACK_SUPPORTED_ENDPOINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestResult.OTHER_RESULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HTTPTimeoutManager(AppConfig appConfig, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.appConfig = appConfig;
        this.dateProvider = dateProvider;
        this.lastTimeoutRequestTime = new AtomicLong(0L);
    }

    private final void resetTimeout() {
        this.lastTimeoutRequestTime.set(0L);
    }

    private final boolean shouldResetTimeout() {
        long j3 = this.lastTimeoutRequestTime.get();
        return j3 != 0 && this.dateProvider.getNow().getTime() - j3 >= 600000;
    }

    public final long getTimeoutForRequest(boolean z2, boolean z3) {
        if (shouldResetTimeout()) {
            resetTimeout();
        }
        long j3 = (z2 || !z3) ? 30000L : this.lastTimeoutRequestTime.get() > 0 ? 2000L : 5000L;
        return this.appConfig.getRunningTests() ? j3 / 10 : j3;
    }

    public final void recordRequestResult(RequestResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int i3 = WhenMappings.$EnumSwitchMapping$0[result.ordinal()];
        if (i3 == 1) {
            resetTimeout();
        } else {
            if (i3 != 2) {
                return;
            }
            this.lastTimeoutRequestTime.set(this.dateProvider.getNow().getTime());
        }
    }

    public /* synthetic */ HTTPTimeoutManager(AppConfig appConfig, DateProvider dateProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(appConfig, (i3 & 2) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
