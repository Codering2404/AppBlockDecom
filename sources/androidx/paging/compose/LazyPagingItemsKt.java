package androidx.paging.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.paging.LoadState;
import androidx.paging.LoadStates;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

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
public final class LazyPagingItemsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LoadState.NotLoading f50767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LoadStates f50768b;

    static {
        LoadState.NotLoading notLoading = new LoadState.NotLoading(false);
        f50767a = notLoading;
        f50768b = new LoadStates(LoadState.Loading.f49892b, notLoading, notLoading);
    }

    public static final LazyPagingItems b(Flow flow, CoroutineContext coroutineContext, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        composer.F(388053246);
        if ((i4 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(388053246, i3, -1, "androidx.paging.compose.collectAsLazyPagingItems (LazyPagingItems.kt:203)");
        }
        composer.F(1046463091);
        boolean Z = composer.Z(flow);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new LazyPagingItems(flow);
            composer.w(objG);
        }
        LazyPagingItems lazyPagingItems = (LazyPagingItems) objG;
        composer.Y();
        composer.F(1046463169);
        boolean zI = composer.I(coroutineContext) | composer.I(lazyPagingItems);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new LazyPagingItemsKt$collectAsLazyPagingItems$1$1(coroutineContext, lazyPagingItems, null);
            composer.w(objG2);
        }
        composer.Y();
        EffectsKt.g(lazyPagingItems, (Function2) objG2, composer, 0);
        composer.F(1046463438);
        boolean zI2 = composer.I(coroutineContext) | composer.I(lazyPagingItems);
        Object objG3 = composer.G();
        if (zI2 || objG3 == Composer.f23746a.a()) {
            objG3 = new LazyPagingItemsKt$collectAsLazyPagingItems$2$1(coroutineContext, lazyPagingItems, null);
            composer.w(objG3);
        }
        composer.Y();
        EffectsKt.g(lazyPagingItems, (Function2) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return lazyPagingItems;
    }
}
