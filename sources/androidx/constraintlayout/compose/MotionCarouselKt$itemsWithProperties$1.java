package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.compose.MotionLayoutScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MotionCarouselKt$itemsWithProperties$1 extends Lambda implements Function4<Integer, androidx.compose.runtime.State<? extends MotionLayoutScope.MotionProperties>, Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function4 f30707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f30708b;

    public final void c(int i3, androidx.compose.runtime.State state, Composer composer, int i4) {
        int i5;
        if ((i4 & 6) == 0) {
            i5 = (composer.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composer.Z(state) ? 32 : 16;
        }
        if ((i5 & 147) == 146 && composer.l()) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1304172608, i5, -1, "androidx.constraintlayout.compose.itemsWithProperties.<anonymous> (MotionCarousel.kt:302)");
        }
        this.f30707a.invoke(this.f30708b.get(i3), state, composer, Integer.valueOf(i5 & 112));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        c(((Number) obj).intValue(), (androidx.compose.runtime.State) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.f139807a;
    }
}
