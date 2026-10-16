package cz.mobilesoft.coreblock.scene.more.settings.developer;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$mockWeeklyStatisticsDialog$1", f = "DeveloperSettingsViewModel.kt", l = {1393, 1396, 1399}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$mockWeeklyStatisticsDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108654b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$mockWeeklyStatisticsDialog$1(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108654b = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$mockWeeklyStatisticsDialog$1(this.f108654b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0071, code lost:
    
        if (r12.P0(r1, r11) != r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f108653a
            r2 = 7
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L27
            if (r1 == r6) goto L23
            if (r1 == r5) goto L1f
            if (r1 != r4) goto L17
            kotlin.ResultKt.b(r12)
            goto L74
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            kotlin.ResultKt.b(r12)
            goto L62
        L23:
            kotlin.ResultKt.b(r12)
            goto L46
        L27:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r12 = r11.f108654b
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r12 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.I1(r12)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r7 = r1.n()
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.DAYS
            long r9 = r1.toMillis(r2)
            long r7 = r7 - r9
            r11.f108653a = r6
            java.lang.Object r12 = r12.P0(r7, r11)
            if (r12 != r0) goto L46
            goto L73
        L46:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r12 = r11.f108654b
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r12 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.I1(r12)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r6 = r1.n()
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.DAYS
            long r1 = r1.toMillis(r2)
            long r6 = r6 - r1
            r11.f108653a = r5
            java.lang.Object r12 = r12.M0(r6, r11)
            if (r12 != r0) goto L62
            goto L73
        L62:
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r12 = r11.f108654b
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowSnackbar r1 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowSnackbar
            int r2 = cz.mobilesoft.coreblock.R.string.Vj
            r1.<init>(r2)
            r11.f108653a = r4
            java.lang.Object r12 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r12, r1, r11)
            if (r12 != r0) goto L74
        L73:
            return r0
        L74:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$mockWeeklyStatisticsDialog$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$mockWeeklyStatisticsDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
