package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
final class PaddingKt$absolutePadding$1 extends Lambda implements Function1<InspectorInfo, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f7044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f7045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f7046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f7047d;

    public final void c(InspectorInfo inspectorInfo) {
        inspectorInfo.d("absolutePadding");
        inspectorInfo.b().c(ViewHierarchyConstants.DIMENSION_LEFT_KEY, Dp.d(this.f7044a));
        inspectorInfo.b().c(ViewHierarchyConstants.DIMENSION_TOP_KEY, Dp.d(this.f7045b));
        inspectorInfo.b().c("right", Dp.d(this.f7046c));
        inspectorInfo.b().c("bottom", Dp.d(this.f7047d));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((InspectorInfo) obj);
        return Unit.f139807a;
    }
}
