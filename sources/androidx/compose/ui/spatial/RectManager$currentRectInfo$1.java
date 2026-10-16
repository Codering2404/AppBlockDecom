package androidx.compose.ui.spatial;

import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

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
final class RectManager$currentRectInfo$1 extends Lambda implements Function4<Integer, Integer, Integer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f28591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DelegatableNode f28592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RectManager f28593c;

    public final void c(int i3, int i4, int i5, int i6) {
        this.f28591a.f140144a = ThrottledCallbacksKt.a(this.f28592b, (((long) i3) << 32) | (((long) i4) & 4294967295L), (((long) i5) << 32) | (((long) i6) & 4294967295L), this.f28593c.f28582c.m(), this.f28593c.f28582c.k(), this.f28593c.f28582c.l());
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        c(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
        return Unit.f139807a;
    }
}
