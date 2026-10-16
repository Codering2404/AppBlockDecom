package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

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
final class PointerInteropFilter_androidKt$pointerInteropFilter$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1 f26918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RequestDisallowInterceptTouchEvent f26919b;

    public final Modifier c(Modifier modifier, Composer composer, int i3) {
        composer.a0(374375707);
        if (ComposerKt.M()) {
            ComposerKt.U(374375707, i3, -1, "androidx.compose.ui.input.pointer.pointerInteropFilter.<anonymous> (PointerInteropFilter.android.kt:77)");
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new PointerInteropFilter();
            composer.w(objG);
        }
        PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) objG;
        pointerInteropFilter.d(this.f26918a);
        pointerInteropFilter.e(this.f26919b);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return pointerInteropFilter;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
