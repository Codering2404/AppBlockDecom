package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$3$1 implements Function1<ConstrainScope, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$3$1 f105341a = new ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$3$1();

    ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$3$1() {
    }

    public final void c(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        VerticalAnchorable.b(constrainAs.g(), constrainAs.f().d(), 0.0f, 0.0f, 6, null);
        VerticalAnchorable.b(constrainAs.e(), constrainAs.f().c(), 0.0f, 0.0f, 6, null);
        HorizontalAnchorable.a(constrainAs.h(), constrainAs.f().e(), 0.0f, 0.0f, 6, null);
        HorizontalAnchorable.a(constrainAs.c(), constrainAs.f().b(), 0.0f, 0.0f, 6, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((ConstrainScope) obj);
        return Unit.f139807a;
    }
}
