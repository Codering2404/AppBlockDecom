package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;
import kotlin.Unit;

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
public final class ActivityResultLauncherHolder<I> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ActivityResultLauncher f430a;

    public final void a(Object obj, ActivityOptionsCompat activityOptionsCompat) {
        Unit unit;
        ActivityResultLauncher activityResultLauncher = this.f430a;
        if (activityResultLauncher != null) {
            activityResultLauncher.c(obj, activityOptionsCompat);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Launcher has not been initialized");
        }
    }

    public final void b(ActivityResultLauncher activityResultLauncher) {
        this.f430a = activityResultLauncher;
    }

    public final void c() {
        Unit unit;
        ActivityResultLauncher activityResultLauncher = this.f430a;
        if (activityResultLauncher != null) {
            activityResultLauncher.d();
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Launcher has not been initialized");
        }
    }
}
