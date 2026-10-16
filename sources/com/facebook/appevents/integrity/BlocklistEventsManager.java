package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashSet;
import java.util.Set;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class BlocklistEventsManager {
    public static final BlocklistEventsManager INSTANCE = new BlocklistEventsManager();
    private static Set<String> blocklist = new HashSet();
    private static boolean enabled;

    private BlocklistEventsManager() {
    }

    @JvmStatic
    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(BlocklistEventsManager.class)) {
            return;
        }
        try {
            enabled = false;
            blocklist = new HashSet();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BlocklistEventsManager.class);
        }
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(BlocklistEventsManager.class)) {
            return;
        }
        try {
            INSTANCE.loadBlocklistEvents();
            Set<String> set = blocklist;
            if (set != null && !set.isEmpty()) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BlocklistEventsManager.class);
        }
    }

    @JvmStatic
    public static final boolean isInBlocklist(String eventName) {
        if (CrashShieldHandler.isObjectCrashing(BlocklistEventsManager.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (enabled) {
                return blocklist.contains(eventName);
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BlocklistEventsManager.class);
            return false;
        }
    }

    private final void loadBlocklistEvents() {
        HashSet<String> hashSetConvertJSONArrayToHashSet;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null || (hashSetConvertJSONArrayToHashSet = Utility.convertJSONArrayToHashSet(fetchedAppSettingsQueryAppSettings.getBlocklistEvents())) == null) {
                return;
            }
            blocklist = hashSetConvertJSONArrayToHashSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
