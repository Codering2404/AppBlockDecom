package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class OverscrollKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f5103a = CompositionLocalKt.f(new Function1<CompositionLocalAccessorScope, OverscrollFactory>() { // from class: androidx.compose.foundation.OverscrollKt$LocalOverscrollFactory$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final OverscrollFactory invoke(CompositionLocalAccessorScope compositionLocalAccessorScope) {
            return AndroidOverscroll_androidKt.b(compositionLocalAccessorScope);
        }
    });

    public static final ProvidableCompositionLocal a() {
        return f5103a;
    }

    public static final OverscrollEffect b(Composer composer, int i3) {
        composer.a0(282942128);
        if (ComposerKt.M()) {
            ComposerKt.U(282942128, i3, -1, "androidx.compose.foundation.rememberOverscrollEffect (Overscroll.kt:344)");
        }
        OverscrollFactory overscrollFactory = (OverscrollFactory) composer.q(f5103a);
        if (overscrollFactory == null) {
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return null;
        }
        boolean Z = composer.Z(overscrollFactory);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = overscrollFactory.a();
            composer.w(objG);
        }
        OverscrollEffect overscrollEffect = (OverscrollEffect) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return overscrollEffect;
    }
}
