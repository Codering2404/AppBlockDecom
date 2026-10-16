package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.activity.ViewTreeFullyDrawnReporterOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
public final class LocalFullyDrawnReporterOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalFullyDrawnReporterOwner f455a = new LocalFullyDrawnReporterOwner();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal f456b = CompositionLocalKt.e(null, new Function0<FullyDrawnReporterOwner>() { // from class: androidx.activity.compose.LocalFullyDrawnReporterOwner$LocalFullyDrawnReporterOwner$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final FullyDrawnReporterOwner invoke() {
            return null;
        }
    }, 1, null);

    private LocalFullyDrawnReporterOwner() {
    }

    public final FullyDrawnReporterOwner a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(540186968, i3, -1, "androidx.activity.compose.LocalFullyDrawnReporterOwner.<get-current> (ReportDrawn.kt:95)");
        }
        FullyDrawnReporterOwner fullyDrawnReporterOwnerA = (FullyDrawnReporterOwner) composer.q(f456b);
        if (fullyDrawnReporterOwnerA == null) {
            composer.a0(-1738308180);
            fullyDrawnReporterOwnerA = ViewTreeFullyDrawnReporterOwner.a((View) composer.q(AndroidCompositionLocals_androidKt.j()));
            composer.U();
        } else {
            composer.a0(-1738310474);
            composer.U();
        }
        if (fullyDrawnReporterOwnerA == null) {
            composer.a0(-1738306337);
            Object baseContext = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof FullyDrawnReporterOwner) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            fullyDrawnReporterOwnerA = (FullyDrawnReporterOwner) baseContext;
            composer.U();
        } else {
            composer.a0(-1738310398);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fullyDrawnReporterOwnerA;
    }
}
