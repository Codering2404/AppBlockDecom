package com.facebook.internal.instrument.crashshield;

import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CrashShieldHandler {
    public static final CrashShieldHandler INSTANCE = new CrashShieldHandler();
    private static final Set<Object> crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    private static boolean enabled;

    private CrashShieldHandler() {
    }

    @JvmStatic
    public static final void disable() {
        enabled = false;
    }

    @JvmStatic
    public static final void enable() {
        enabled = true;
    }

    @JvmStatic
    public static final void handleThrowable(Throwable th, Object o3) {
        Intrinsics.checkNotNullParameter(o3, "o");
        if (enabled) {
            crashingObjects.add(o3);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer.execute(th);
                InstrumentData.Builder.build(th, InstrumentData.Type.CrashShield).save();
            }
            scheduleCrashInDebug(th);
        }
    }

    @JvmStatic
    public static final boolean isDebug() {
        return false;
    }

    @JvmStatic
    public static final boolean isObjectCrashing(Object o3) {
        Intrinsics.checkNotNullParameter(o3, "o");
        return crashingObjects.contains(o3);
    }

    @JvmStatic
    public static final void reset() {
        resetCrashingObjects();
    }

    @JvmStatic
    public static final void resetCrashingObjects() {
        crashingObjects.clear();
    }

    @JvmStatic
    public static final void scheduleCrashInDebug(final Throwable th) {
        if (isDebug()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.internal.instrument.crashshield.CrashShieldHandler.scheduleCrashInDebug.1
                @Override // java.lang.Runnable
                public void run() {
                    throw new RuntimeException(th);
                }
            });
        }
    }

    @JvmStatic
    public static final void methodFinished(Object obj) {
    }
}
