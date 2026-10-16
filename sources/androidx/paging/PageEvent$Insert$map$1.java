package androidx.paging;

import androidx.paging.PageEvent;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "androidx.paging.PageEvent$Insert", f = "PageEvent.kt", l = {ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD}, m = "map")
final class PageEvent$Insert$map$1<R> extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f49987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f49988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f49989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f49990d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f49991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f49992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f49993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f49994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f49995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f49996k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f49997l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    /* synthetic */ Object f49998m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ PageEvent.Insert f49999n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f50000o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageEvent$Insert$map$1(PageEvent.Insert insert, Continuation continuation) {
        super(continuation);
        this.f49999n = insert;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49998m = obj;
        this.f50000o |= Integer.MIN_VALUE;
        return this.f49999n.e(null, this);
    }
}
