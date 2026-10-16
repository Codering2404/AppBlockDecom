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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$onEvent$1", f = "StatisticsSettingsViewModel.kt", l = {63, 65, 68}, m = "invokeSuspend", v = 1)
final class StatisticsSettingsViewModel$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StatisticsSettingsViewEvent f110216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StatisticsSettingsViewModel f110217c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsSettingsViewModel$onEvent$1(StatisticsSettingsViewEvent statisticsSettingsViewEvent, StatisticsSettingsViewModel statisticsSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110216b = statisticsSettingsViewEvent;
        this.f110217c = statisticsSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatisticsSettingsViewModel$onEvent$1(this.f110216b, this.f110217c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r7.L0(r1, r6) != r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        if (r7.C0(false, r6) == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f110215a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r7)
            goto L70
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1d:
            kotlin.ResultKt.b(r7)
            goto L7d
        L21:
            kotlin.ResultKt.b(r7)
            goto L49
        L25:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewEvent r7 = r6.f110216b
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewEvent$OnAppStatisticsClick r7 = (cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewEvent.OnAppStatisticsClick) r7
            boolean r7 = r7.a()
            java.lang.String r1 = "APPS"
            r5 = 0
            if (r7 == 0) goto L5c
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r7 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r7.S6(r5, r1)
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel r7 = r6.f110217c
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r7 = cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel.R0(r7)
            r6.f110215a = r4
            java.lang.Object r7 = r7.C0(r4, r6)
            if (r7 != r0) goto L49
            goto L6f
        L49:
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel r7 = r6.f110217c
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r7 = cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel.R0(r7)
            long r1 = java.lang.System.currentTimeMillis()
            r6.f110215a = r3
            java.lang.Object r7 = r7.L0(r1, r6)
            if (r7 != r0) goto L7d
            goto L6f
        L5c:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r7 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r7.S6(r4, r1)
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel r7 = r6.f110217c
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r7 = cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel.R0(r7)
            r6.f110215a = r2
            java.lang.Object r7 = r7.C0(r5, r6)
            if (r7 != r0) goto L70
        L6f:
            return r0
        L70:
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r7 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            int r7 = r7.getTypeId()
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.d(r7)
            cz.mobilesoft.statistics.api.Statistics.c(r7)
        L7d:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$onEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatisticsSettingsViewModel$onEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
