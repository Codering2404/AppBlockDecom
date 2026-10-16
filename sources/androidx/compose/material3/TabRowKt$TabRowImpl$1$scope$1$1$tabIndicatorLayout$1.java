package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class TabRowKt$TabRowImpl$1$scope$1$1$tabIndicatorLayout$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function4 f20748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TabRowKt$TabRowImpl$1$scope$1$1 f20749b;

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m191invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
    }

    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
    public final MeasureResult m191invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        return (MeasureResult) this.f20748a.invoke(measureScope, measurable, Constraints.a(j3), this.f20749b.b().getValue());
    }
}
