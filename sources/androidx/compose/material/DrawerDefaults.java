package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import com.sun.jna.Function;
import kotlin.Metadata;

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
public final class DrawerDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DrawerDefaults f12711a = new DrawerDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TweenSpec f12712b = new TweenSpec(Function.MAX_NARGS, 0, null, 6, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f12713c = Dp.g(16);

    private DrawerDefaults() {
    }

    public final TweenSpec a() {
        return f12712b;
    }

    public final long b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-788676020, i3, -1, "androidx.compose.material.DrawerDefaults.<get-backgroundColor> (Drawer.kt:758)");
        }
        long jN = MaterialTheme.f13091a.a(composer, 6).n();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jN;
    }

    public final float c() {
        return f12713c;
    }

    public final long d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(617225966, i3, -1, "androidx.compose.material.DrawerDefaults.<get-scrimColor> (Drawer.kt:777)");
        }
        long jR = Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jR;
    }

    public final Shape e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2041803618, i3, -1, "androidx.compose.material.DrawerDefaults.<get-shape> (Drawer.kt:770)");
        }
        CornerBasedShape cornerBasedShapeC = MaterialTheme.f13091a.b(composer, 6).c();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return cornerBasedShapeC;
    }
}
