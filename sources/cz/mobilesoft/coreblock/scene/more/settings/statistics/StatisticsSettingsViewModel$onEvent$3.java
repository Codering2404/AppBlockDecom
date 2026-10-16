package cz.mobilesoft.coreblock.scene.more.settings.statistics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$onEvent$3", f = "StatisticsSettingsViewModel.kt", l = {92, 95}, m = "invokeSuspend", v = 1)
final class StatisticsSettingsViewModel$onEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StatisticsSettingsViewEvent f110222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StatisticsSettingsViewModel f110223c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsSettingsViewModel$onEvent$3(StatisticsSettingsViewEvent statisticsSettingsViewEvent, StatisticsSettingsViewModel statisticsSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110222b = statisticsSettingsViewEvent;
        this.f110223c = statisticsSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatisticsSettingsViewModel$onEvent$3(this.f110222b, this.f110223c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (r6.R0(true, r5) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        if (r6.R0(false, r5) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f110221a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L56
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L63
        L1e:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewEvent r6 = r5.f110222b
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewEvent$OnWebStatisticsClick r6 = (cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewEvent.OnWebStatisticsClick) r6
            boolean r6 = r6.a()
            java.lang.String r1 = "WEBS"
            r4 = 0
            if (r6 == 0) goto L42
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r6 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r6.S6(r4, r1)
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel r6 = r5.f110223c
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel.R0(r6)
            r5.f110221a = r3
            java.lang.Object r6 = r6.R0(r3, r5)
            if (r6 != r0) goto L63
            goto L55
        L42:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r6 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r6.S6(r3, r1)
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel r6 = r5.f110223c
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel.R0(r6)
            r5.f110221a = r2
            java.lang.Object r6 = r6.R0(r4, r5)
            if (r6 != r0) goto L56
        L55:
            return r0
        L56:
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r6 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.WEBSITE
            int r6 = r6.getTypeId()
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.d(r6)
            cz.mobilesoft.statistics.api.Statistics.c(r6)
        L63:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$onEvent$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatisticsSettingsViewModel$onEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
