package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
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
public final class AndroidOverscroll_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f4612a = ColorKt.d(4284900966L);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PaddingValues f4613b = PaddingKt.c(0.0f, 0.0f, 3, null);

    public static final OverscrollFactory b(CompositionLocalAccessorScope compositionLocalAccessorScope) {
        Context context = (Context) compositionLocalAccessorScope.z(AndroidCompositionLocals_androidKt.g());
        Density density = (Density) compositionLocalAccessorScope.z(CompositionLocalsKt.f());
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) compositionLocalAccessorScope.z(OverscrollConfiguration_androidKt.a());
        if (overscrollConfiguration == null) {
            return null;
        }
        return new AndroidEdgeEffectOverscrollFactory(context, density, overscrollConfiguration.b(), overscrollConfiguration.a(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float c(int i3) {
        return NestedScrollSource.e(i3, NestedScrollSource.f26772b.a()) ? 4.0f : 1.0f;
    }
}
