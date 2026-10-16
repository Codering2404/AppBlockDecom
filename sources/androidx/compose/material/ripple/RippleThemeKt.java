package androidx.compose.material.ripple;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
public final class RippleThemeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f15423a = CompositionLocalKt.g(new Function0<RippleTheme>() { // from class: androidx.compose.material.ripple.RippleThemeKt$LocalRippleTheme$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final RippleTheme invoke() {
            return DebugRippleTheme.f15341b;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RippleAlpha f15424b = new RippleAlpha(0.16f, 0.24f, 0.08f, 0.24f);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final RippleAlpha f15425c = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.12f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final RippleAlpha f15426d = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.1f);

    public static final ProvidableCompositionLocal d() {
        return f15423a;
    }
}
