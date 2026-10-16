package cz.mobilesoft.coreblock.scene.insights;

import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$updateSchedules$3", f = "BaseInsightsViewModel.kt", l = {209, 219, 226}, m = "invokeSuspend", v = 1)
final class BaseInsightsViewModel$updateSchedules$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f102551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f102552d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f102553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f102554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f102555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f102556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f102557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ List f102558k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ BaseInsightsViewModel f102559l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ String f102560m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseInsightsViewModel$updateSchedules$3(List list, BaseInsightsViewModel baseInsightsViewModel, String str, Continuation continuation) {
        super(1, continuation);
        this.f102558k = list;
        this.f102559l = baseInsightsViewModel;
        this.f102560m = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseInsightsViewModel$updateSchedules$3(this.f102558k, this.f102559l, this.f102560m, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0157, code lost:
    
        if (r2.P0(r3, r24) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0132, code lost:
    
        r4 = 2;
        r12 = r7;
        r7 = r2;
        r2 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x012d -> B:33:0x012e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$updateSchedules$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseInsightsViewModel$updateSchedules$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
