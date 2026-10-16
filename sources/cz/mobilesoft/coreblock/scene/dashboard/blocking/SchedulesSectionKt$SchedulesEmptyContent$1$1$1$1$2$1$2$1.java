package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.Dimension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class SchedulesSectionKt$SchedulesEmptyContent$1$1$1$1$2$1$2$1 implements Function1<ConstrainScope, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ConstraintLayoutBaseScope.HorizontalAnchor f99986a;

    SchedulesSectionKt$SchedulesEmptyContent$1$1$1$1$2$1$2$1(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor) {
        this.f99986a = horizontalAnchor;
    }

    public final void c(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        HorizontalAnchorable.a(constrainAs.h(), this.f99986a, 0.0f, 0.0f, 6, null);
        VerticalAnchorable.b(constrainAs.g(), constrainAs.f().d(), 0.0f, 0.0f, 6, null);
        VerticalAnchorable.b(constrainAs.e(), constrainAs.f().c(), 0.0f, 0.0f, 6, null);
        HorizontalAnchorable.a(constrainAs.c(), constrainAs.f().b(), 0.0f, 0.0f, 6, null);
        constrainAs.m(Dimension.f30535a.a());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((ConstrainScope) obj);
        return Unit.f139807a;
    }
}
