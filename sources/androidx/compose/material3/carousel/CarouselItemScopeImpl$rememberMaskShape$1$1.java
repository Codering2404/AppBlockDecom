package androidx.compose.material3.carousel;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class CarouselItemScopeImpl$rememberMaskShape$1$1 extends Lambda implements Function3<Path, Size, LayoutDirection, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CarouselItemScopeImpl f21625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Shape f21626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Density f21627c;

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m196invoke12SF9DM((Path) obj, ((Size) obj2).m(), (LayoutDirection) obj3);
        return Unit.f139807a;
    }

    /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
    public final void m196invoke12SF9DM(Path path, long j3, LayoutDirection layoutDirection) {
        Rect rectX = this.f21625a.a().a().x(SizeKt.c(j3));
        OutlineKt.a(path, this.f21626b.mo29createOutlinePq9zytI(rectX.q(), layoutDirection, this.f21627c));
        path.p(OffsetKt.a(rectX.o(), rectX.r()));
    }
}
