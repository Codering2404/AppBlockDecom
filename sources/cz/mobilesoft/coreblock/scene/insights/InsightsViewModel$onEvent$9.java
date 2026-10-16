package cz.mobilesoft.coreblock.scene.insights;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$onEvent$9", f = "InsightsViewModel.kt", l = {497, 503, 513}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$onEvent$9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f102794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f102795d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f102796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f102797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f102798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ InsightsViewEvent f102800j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$onEvent$9(InsightsViewModel insightsViewModel, InsightsViewEvent insightsViewEvent, Continuation continuation) {
        super(1, continuation);
        this.f102799i = insightsViewModel;
        this.f102800j = insightsViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$onEvent$9(this.f102799i, this.f102800j, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0104, code lost:
    
        if (r9.P0(r10, r16) == r6) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$onEvent$9.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$onEvent$9) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
