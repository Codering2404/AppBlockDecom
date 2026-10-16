package cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport;

import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class OnboardingBlockingTestScreenKt$PhoneAppGrid$lambda$2$0$$inlined$items$default$3 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function2 f111097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f111098b;

    public final long c(LazyGridItemSpanScope lazyGridItemSpanScope, int i3) {
        return ((GridItemSpan) this.f111097a.invoke(lazyGridItemSpanScope, this.f111098b.get(i3))).g();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return GridItemSpan.a(c((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
    }
}
