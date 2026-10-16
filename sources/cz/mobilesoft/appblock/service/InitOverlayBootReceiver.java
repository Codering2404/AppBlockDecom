package cz.mobilesoft.appblock.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import cz.mobilesoft.coreblock.storage.datastore.DirectBootDataStore;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InitOverlayBootReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f94150a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f94151b = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean a(Context context) {
        return DirectBootDataStore.f124280d.b(context);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        int iHashCode = action.hashCode();
        if (iHashCode != -1787487905) {
            if (iHashCode != -905063602) {
                if (iHashCode != 798292259 || !action.equals("android.intent.action.BOOT_COMPLETED")) {
                    return;
                }
            } else if (!action.equals("android.intent.action.LOCKED_BOOT_COMPLETED")) {
                return;
            }
        } else if (!action.equals("android.intent.action.QUICKBOOT_POWERON")) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime > 300000) {
            Log.d("InitOverlayBootReceiver", "Ignoring boot event received after " + jElapsedRealtime + " ms (phone has been running for a while)");
            return;
        }
        boolean zA = a(context);
        Log.d("InitOverlayBootReceiver", "Boot event received: " + action + ", isEnabled=" + zA);
        if (!zA) {
            Log.d("InitOverlayBootReceiver", "Init overlay is disabled in settings, skipping service start");
            return;
        }
        if (InitOverlayBootDedupStore.f94149a.d(context, action)) {
            try {
                Intent intent2 = new Intent(context, (Class<?>) InitOverlayForegroundService.class);
                intent2.putExtra("extra_is_boot", true);
                context.startForegroundService(intent2);
            } catch (Exception e3) {
                Log.e("InitOverlayBootReceiver", "Failed to start InitOverlayForegroundService", e3);
            }
        }
    }
}
