package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ShareKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

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
public final class ComposableSingletons$InsightsScreenToolbarsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$InsightsScreenToolbarsKt f102584a = new ComposableSingletons$InsightsScreenToolbarsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f102585b = ComposableLambdaKt.c(-1318648864, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.b0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenToolbarsKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f102586c = ComposableLambdaKt.c(767080741, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.c0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenToolbarsKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f102587d = ComposableLambdaKt.c(-1169603005, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.d0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InsightsScreenToolbarsKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(767080741, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenToolbarsKt.lambda$767080741.<anonymous> (InsightsScreenToolbars.kt:136)");
            }
            IconKt.b(ShareKt.a(Icons.f15145a.a()), null, SizeKt.v(Modifier.b8, Dp.g(24)), 0L, composer, 432, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1169603005, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenToolbarsKt.lambda$-1169603005.<anonymous> (InsightsScreenToolbars.kt:182)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G0, composer, 6), null, SizeKt.v(Modifier.b8, Dp.g(24)), 0L, composer, 432, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1318648864, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenToolbarsKt.lambda$-1318648864.<anonymous> (InsightsScreenToolbars.kt:108)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.h5, composer, 6), null, SizeKt.v(Modifier.b8, Dp.g(24)), 0L, composer, 432, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 d() {
        return f102587d;
    }

    public final Function2 e() {
        return f102585b;
    }

    public final Function2 f() {
        return f102586c;
    }
}
