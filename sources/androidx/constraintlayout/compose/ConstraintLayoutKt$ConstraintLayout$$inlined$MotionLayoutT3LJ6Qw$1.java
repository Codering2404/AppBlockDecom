package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayout-T3LJ6Qw$1, reason: invalid class name */
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
public final class ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayoutT3LJ6Qw$1 extends Lambda implements Function3<MotionLayoutScope, Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MutableState f30438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InvalidationStrategy f30439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref f30440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f30441d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f30442f;

    public final void c(MotionLayoutScope motionLayoutScope, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(284503157, i3, -1, "androidx.constraintlayout.compose.MotionLayout.<anonymous> (MotionLayout.kt:152)");
        }
        this.f30438a.setValue(Unit.f139807a);
        if (this.f30439b.d() == null && this.f30440c.a() == CompositionSource.Unknown) {
            this.f30440c.b(CompositionSource.Content);
        }
        composer.a0(-2076156842);
        this.f30441d.invoke(composer, Integer.valueOf((this.f30442f >> 15) & 14));
        composer.U();
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
