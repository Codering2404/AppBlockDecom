package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.Offering;
import cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$invoke$1", f = "FetchRevenueCatOfferingUseCase.kt", l = {41, 43, 55, 58, 68, 98, 135, 138, 140, 156, 161, 165, 168, 172}, m = "invokeSuspend", v = 1)
final class FetchRevenueCatOfferingUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super DataState<? extends Offering>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f127060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f127061d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f127062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f127063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f127064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f127065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f127066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f127067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f127068l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private /* synthetic */ Object f127069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ FetchRevenueCatOfferingUseCase f127070n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ FetchRevenueCatOfferingUseCase.Params f127071o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchRevenueCatOfferingUseCase$invoke$1(FetchRevenueCatOfferingUseCase fetchRevenueCatOfferingUseCase, FetchRevenueCatOfferingUseCase.Params params, Continuation continuation) {
        super(2, continuation);
        this.f127070n = fetchRevenueCatOfferingUseCase;
        this.f127071o = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FetchRevenueCatOfferingUseCase$invoke$1 fetchRevenueCatOfferingUseCase$invoke$1 = new FetchRevenueCatOfferingUseCase$invoke$1(this.f127070n, this.f127071o, continuation);
        fetchRevenueCatOfferingUseCase$invoke$1.f127069m = obj;
        return fetchRevenueCatOfferingUseCase$invoke$1;
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x00dc: MOVE (r0 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]) (LINE:221), block:B:29:0x00db */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:199:0x05b9 -> B:211:0x0660). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed with stack overflow
        jadx.core.utils.exceptions.JadxOverflowException
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instruction units count: 1728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((FetchRevenueCatOfferingUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
