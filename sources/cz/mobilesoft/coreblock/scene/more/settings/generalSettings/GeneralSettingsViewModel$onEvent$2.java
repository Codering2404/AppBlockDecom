package cz.mobilesoft.coreblock.scene.more.settings.generalSettings;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$onEvent$2", f = "GeneralSettingsViewModel.kt", l = {185, 187}, m = "invokeSuspend", v = 1)
final class GeneralSettingsViewModel$onEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f109768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f109769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GeneralSettingsViewModel f109770c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeneralSettingsViewModel$onEvent$2(GeneralSettingsViewModel generalSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f109770c = generalSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GeneralSettingsViewModel$onEvent$2(this.f109770c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (r1.P0(r3, r6) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
    
        if (r1.H(r2, r6) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
    
        return r0;
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
            int r1 = r6.f109769b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto Le
            if (r1 != r2) goto L16
        Le:
            java.lang.Object r0 = r6.f109768a
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState r0 = (cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState) r0
            kotlin.ResultKt.b(r7)
            goto L75
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r7 = r6.f109770c
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState r7 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.S0(r7)
            boolean r1 = r7.j()
            if (r1 == 0) goto L5b
            boolean r1 = r7.k()
            if (r1 == 0) goto L34
            goto L5b
        L34:
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r1 = r6.f109770c
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewCommand$ShowSnackBar r3 = new cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewCommand$ShowSnackBar
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r4 = r6.f109770c
            android.content.Context r4 = r4.A0()
            int r5 = cz.mobilesoft.coreblock.R.string.er
            java.lang.String r4 = r4.getString(r5)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r3.<init>(r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f109768a = r7
            r6.f109769b = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.d1(r1, r3, r6)
            if (r7 != r0) goto L75
            goto L74
        L5b:
            cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel r1 = r6.f109770c
            cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore r1 = cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel.Y0(r1)
            boolean r2 = r7.j()
            r2 = r2 ^ r3
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f109768a = r7
            r6.f109769b = r3
            java.lang.Object r7 = r1.H(r2, r6)
            if (r7 != r0) goto L75
        L74:
            return r0
        L75:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$onEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GeneralSettingsViewModel$onEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
