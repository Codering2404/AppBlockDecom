package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MotionLayoutKt$MotionLayout$contentDelegate$1 extends Lambda implements Function3<MotionLayoutScope, Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MutableState f30764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InvalidationStrategy f30765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref f30766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f30767d;

    public final void c(MotionLayoutScope motionLayoutScope, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(284503157, i3, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:152)");
        }
        this.f30764a.setValue(Unit.f139807a);
        if (this.f30765b.d() == null && this.f30766c.a() == CompositionSource.Unknown) {
            this.f30766c.b(CompositionSource.Content);
        }
        this.f30767d.invoke(motionLayoutScope, composer, Integer.valueOf(i3 & 14));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        c((MotionLayoutScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.f139807a;
    }
}
