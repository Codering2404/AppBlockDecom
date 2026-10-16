package cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences;

import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$onEvent$2", f = "BlockingPreferencesViewModel.kt", l = {SensibleDefaults.X_OFFSET, 182}, m = "invokeSuspend", v = 1)
final class BlockingPreferencesViewModel$onEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f108132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BlockingPreferencesViewModel f108134c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingPreferencesViewModel$onEvent$2(BlockingPreferencesViewModel blockingPreferencesViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108134c = blockingPreferencesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingPreferencesViewModel$onEvent$2(this.f108134c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
    
        if (r1.P0(r2, r6) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0076, code lost:
    
        if (r1.y5(r3, r6) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
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
            int r1 = r6.f108133b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L17:
            java.lang.Object r0 = r6.f108132a
            cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewState r0 = (cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewState) r0
            kotlin.ResultKt.b(r7)
            goto L79
        L1f:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel r7 = r6.f108134c
            cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewState r7 = cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel.T0(r7)
            boolean r1 = r7.n()
            if (r1 == 0) goto L5f
            boolean r1 = r7.k()
            if (r1 != 0) goto L5f
            cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel r1 = r6.f108134c
            cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewCommand$ShowSnackBar r2 = new cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewCommand$ShowSnackBar
            cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel r4 = r6.f108134c
            android.content.Context r4 = r4.A0()
            cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives$Companion r5 = cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives.Companion
            int r5 = r5.a()
            java.lang.String r4 = r4.getString(r5)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r2.<init>(r4)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f108132a = r7
            r6.f108133b = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel.d1(r1, r2, r6)
            if (r7 != r0) goto L79
            goto L78
        L5f:
            cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel r1 = r6.f108134c
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r1 = cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel.U0(r1)
            boolean r4 = r7.k()
            r3 = r3 ^ r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f108132a = r7
            r6.f108133b = r2
            java.lang.Object r7 = r1.y5(r3, r6)
            if (r7 != r0) goto L79
        L78:
            return r0
        L79:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$onEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingPreferencesViewModel$onEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
