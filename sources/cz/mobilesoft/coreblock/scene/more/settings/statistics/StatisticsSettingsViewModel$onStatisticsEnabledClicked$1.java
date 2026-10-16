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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$onStatisticsEnabledClicked$1", f = "StatisticsSettingsViewModel.kt", l = {113, 114}, m = "invokeSuspend", v = 1)
final class StatisticsSettingsViewModel$onStatisticsEnabledClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f110226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StatisticsSettingsViewModel f110227b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsSettingsViewModel$onStatisticsEnabledClicked$1(StatisticsSettingsViewModel statisticsSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f110227b = statisticsSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatisticsSettingsViewModel$onStatisticsEnabledClicked$1(this.f110227b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r7.Q0(true, r6) == r0) goto L15;
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
            int r1 = r6.f110226a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L43
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.b(r7)
            goto L34
        L1e:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel r7 = r6.f110227b
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r7 = cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel.R0(r7)
            long r4 = java.lang.System.currentTimeMillis()
            r6.f110226a = r3
            java.lang.Object r7 = r7.L0(r4, r6)
            if (r7 != r0) goto L34
            goto L42
        L34:
            cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel r7 = r6.f110227b
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r7 = cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel.R0(r7)
            r6.f110226a = r2
            java.lang.Object r7 = r7.Q0(r3, r6)
            if (r7 != r0) goto L43
        L42:
            return r0
        L43:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsViewModel$onStatisticsEnabledClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatisticsSettingsViewModel$onStatisticsEnabledClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
