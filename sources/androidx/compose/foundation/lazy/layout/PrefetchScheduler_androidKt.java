package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PrefetchScheduler_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PrefetchScheduler_androidKt$RobolectricImpl$1 f8287a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        f8287a = Intrinsics.areEqual(lowerCase, "robolectric") ? new PrefetchScheduler() { // from class: androidx.compose.foundation.lazy.layout.PrefetchScheduler_androidKt$RobolectricImpl$1
            @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
            public void a(PrefetchRequest prefetchRequest) {
            }
        } : 0;
    }

    public static final PrefetchScheduler a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1141871251, i3, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:32)");
        }
        PrefetchScheduler prefetchScheduler = f8287a;
        if (prefetchScheduler != null) {
            composer.a0(1213893039);
            composer.U();
        } else {
            composer.a0(1213931944);
            View view = (View) composer.q(AndroidCompositionLocals_androidKt.j());
            boolean Z = composer.Z(view);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new AndroidPrefetchScheduler(view);
                composer.w(objG);
            }
            prefetchScheduler = (AndroidPrefetchScheduler) objG;
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return prefetchScheduler;
    }
}
