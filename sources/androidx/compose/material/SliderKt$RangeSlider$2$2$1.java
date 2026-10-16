package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;

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
/* synthetic */ class SliderKt$RangeSlider$2$2$1 extends FunctionReferenceImpl implements Function1<Float, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ClosedFloatingPointRange f13800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f13801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f13802c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$2$1(ClosedFloatingPointRange closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
        super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
        this.f13800a = closedFloatingPointRange;
        this.f13801b = floatRef;
        this.f13802c = floatRef2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return q(((Number) obj).floatValue());
    }

    public final Float q(float f3) {
        return Float.valueOf(SliderKt$RangeSlider$2.e(this.f13800a, this.f13801b, this.f13802c, f3));
    }
}
