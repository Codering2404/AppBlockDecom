package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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
public final class WindowInsetsKt {
    public static final WindowInsets a(int i3, int i4, int i5, int i6) {
        return new FixedIntInsets(i3, i4, i5, i6);
    }

    public static final WindowInsets b(float f3, float f4, float f5, float f6) {
        return new FixedDpInsets(f3, f4, f5, f6, null);
    }

    public static /* synthetic */ WindowInsets c(float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.g(0);
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.g(0);
        }
        if ((i3 & 4) != 0) {
            f5 = Dp.g(0);
        }
        if ((i3 & 8) != 0) {
            f6 = Dp.g(0);
        }
        return b(f3, f4, f5, f6);
    }

    public static final WindowInsets d(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new AddedInsets(windowInsets, windowInsets2);
    }

    public static final WindowInsets e(PaddingValues paddingValues) {
        return new PaddingValuesInsets(paddingValues);
    }

    public static final PaddingValues f(WindowInsets windowInsets, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1485016250, i3, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:220)");
        }
        InsetsPaddingValues insetsPaddingValues = new InsetsPaddingValues(windowInsets, (Density) composer.q(CompositionLocalsKt.f()));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return insetsPaddingValues;
    }

    public static final PaddingValues g(WindowInsets windowInsets, Density density) {
        return new InsetsPaddingValues(windowInsets, density);
    }

    public static final WindowInsets h(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new ExcludeInsets(windowInsets, windowInsets2);
    }

    public static final WindowInsets i(WindowInsets windowInsets, int i3) {
        return new LimitInsets(windowInsets, i3, null);
    }

    public static final WindowInsets j(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new UnionInsets(windowInsets, windowInsets2);
    }
}
