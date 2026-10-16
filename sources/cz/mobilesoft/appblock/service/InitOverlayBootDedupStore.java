package cz.mobilesoft.appblock.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InitOverlayBootDedupStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InitOverlayBootDedupStore f94149a = new InitOverlayBootDedupStore();

    private InitOverlayBootDedupStore() {
    }

    private final int b(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "boot_count");
        } catch (Exception unused) {
            return -1;
        }
    }

    private final Pair c(Context context) {
        try {
            Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            if (contextCreateDeviceProtectedStorageContext != null) {
                context = contextCreateDeviceProtectedStorageContext;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("init_overlay_boot_dedup", 0);
            return TuplesKt.a(Integer.valueOf(sharedPreferences.getInt("completed_boot_count", -1)), Long.valueOf(sharedPreferences.getLong("completed_elapsed_ms", 0L)));
        } catch (Exception unused) {
            return TuplesKt.a(-1, 0L);
        }
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            int iB = b(context);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            if (contextCreateDeviceProtectedStorageContext != null) {
                context = contextCreateDeviceProtectedStorageContext;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("init_overlay_boot_dedup", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("completed_boot_count", iB);
            editorEdit.putLong("completed_elapsed_ms", jElapsedRealtime);
            editorEdit.apply();
            Log.d("InitOverlayBootDedup", "marked overlay completed bootCount=" + iB + " elapsedMs=" + jElapsedRealtime);
        } catch (Exception unused) {
            Log.d("InitOverlayBootDedup", "failed to mark overlay completed");
        }
    }

    public final boolean d(Context context, String action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        int iB = b(context);
        Pair pairC = c(context);
        int iIntValue = ((Number) pairC.a()).intValue();
        long jLongValue = ((Number) pairC.b()).longValue();
        Log.d("InitOverlayBootDedup", "check action=" + action + " bootCount=" + iB + " completedBootCount=" + iIntValue);
        if (iB >= 0 && iIntValue == iB) {
            Log.d("InitOverlayBootDedup", "skip action=" + action + " overlay already completed for bootCount=" + iB);
            return false;
        }
        if (iB < 0 && jLongValue > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime > jLongValue && jElapsedRealtime - jLongValue < 30000) {
                Log.d("InitOverlayBootDedup", "skip action=" + action + " overlay completed recently (fallback)");
                return false;
            }
        }
        Log.d("InitOverlayBootDedup", "allow start action=" + action + " bootCount=" + iB);
        return true;
    }
}
