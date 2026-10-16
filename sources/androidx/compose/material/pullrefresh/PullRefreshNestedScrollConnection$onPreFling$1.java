package androidx.compose.material.pullrefresh;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection", f = "PullRefresh.kt", l = {107}, m = "onPreFling-QWom1Mo")
final class PullRefreshNestedScrollConnection$onPreFling$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f15286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f15287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PullRefreshNestedScrollConnection f15288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f15289d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PullRefreshNestedScrollConnection$onPreFling$1(PullRefreshNestedScrollConnection pullRefreshNestedScrollConnection, Continuation continuation) {
        super(continuation);
        this.f15288c = pullRefreshNestedScrollConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15287b = obj;
        this.f15289d |= Integer.MIN_VALUE;
        return this.f15288c.R1(0L, this);
    }
}
