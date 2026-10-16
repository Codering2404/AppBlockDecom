package androidx.compose.ui;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Actual_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f25071a = new Handler(Looper.getMainLooper());

    public static final long b() {
        return System.currentTimeMillis();
    }

    public static final Object c(long j3, final Function0 function0) {
        Runnable runnable = new Runnable() { // from class: androidx.compose.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                Actual_androidKt.d(function0);
            }
        };
        f25071a.postDelayed(runnable, j3);
        return runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 function0) {
        function0.invoke();
    }

    public static final void e(Object obj) {
        if ((obj instanceof Runnable ? (Runnable) obj : null) == null) {
            return;
        }
        f25071a.removeCallbacks((Runnable) obj);
    }
}
