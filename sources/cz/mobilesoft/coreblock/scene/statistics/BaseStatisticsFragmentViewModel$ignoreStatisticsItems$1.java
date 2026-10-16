package cz.mobilesoft.coreblock.scene.statistics;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$ignoreStatisticsItems$1", f = "BaseStatisticsFragmentViewModel.kt", l = {129, 134}, m = "invokeSuspend", v = 1)
final class BaseStatisticsFragmentViewModel$ignoreStatisticsItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f119650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f119651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f119652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f119653d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f119654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f119655g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f119656h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f119657i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f119658j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f119659k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f119660l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f119661m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f119662n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    long f119663o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f119664p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ Collection f119665q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final /* synthetic */ BaseStatisticsFragmentViewModel f119666r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseStatisticsFragmentViewModel$ignoreStatisticsItems$1(Collection collection, BaseStatisticsFragmentViewModel baseStatisticsFragmentViewModel, Continuation continuation) {
        super(2, continuation);
        this.f119665q = collection;
        this.f119666r = baseStatisticsFragmentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseStatisticsFragmentViewModel$ignoreStatisticsItems$1(this.f119665q, this.f119666r, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x012e, code lost:
    
        if (r23.f119666r.W0().j0(r9, r23) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0103  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00dd -> B:10:0x0053). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel$ignoreStatisticsItems$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseStatisticsFragmentViewModel$ignoreStatisticsItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
