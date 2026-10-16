package com.facebook.appevents.gps;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
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
public final class GpsDebugLogger {
    public static final Companion Companion = new Companion(null);
    private static final String GPS_PREFIX = "gps";
    private static final double LOGGING_SAMPLING_RATE = 1.0E-4d;
    private static final boolean shouldLog;
    private final InternalAppEventsLogger internalAppEventsLogger;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        shouldLog = Random.f140182a.f() <= LOGGING_SAMPLING_RATE;
    }

    public GpsDebugLogger(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.internalAppEventsLogger = new InternalAppEventsLogger(context);
    }

    private final boolean isGPSDebugEvent(String str) {
        if (str != null) {
            return StringsKt.a0(str, GPS_PREFIX, false, 2, null);
        }
        return false;
    }

    public final void log(String str, Bundle bundle) {
        if (shouldLog && isGPSDebugEvent(str)) {
            this.internalAppEventsLogger.logEventImplicitly(str, bundle);
        }
    }
}
