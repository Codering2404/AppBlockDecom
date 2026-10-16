package androidx.paging;

import androidx.paging.PageEvent;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
public final class CachedPageEventFlow<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FlattenedPageController f49587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableSharedFlow f49588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedFlow f49589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Job f49590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Flow f49591e;

    public CachedPageEventFlow(Flow src, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f49587a = new FlattenedPageController();
        MutableSharedFlow mutableSharedFlowA = SharedFlowKt.a(1, Api.BaseClientBuilder.API_PRIORITY_OTHER, BufferOverflow.f141062a);
        this.f49588b = mutableSharedFlowA;
        this.f49589c = FlowKt.X(mutableSharedFlowA, new CachedPageEventFlow$sharedForDownstream$1(this, null));
        Job jobD = BuildersKt__Builders_commonKt.d(scope, null, CoroutineStart.f140917b, new CachedPageEventFlow$job$1(src, this, null), 1, null);
        jobD.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.paging.CachedPageEventFlow$job$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                this.f49613a.f49588b.c(null);
            }
        });
        this.f49590d = jobD;
        this.f49591e = FlowKt.I(new CachedPageEventFlow$downstreamFlow$1(this, null));
    }

    public final void e() {
        Job.DefaultImpls.b(this.f49590d, null, 1, null);
    }

    public final PageEvent.Insert f() {
        return this.f49587a.a();
    }

    public final Flow g() {
        return this.f49591e;
    }
}
