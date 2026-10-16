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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$82", f = "DeveloperSettingsViewModel.kt", l = {931, 933}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$82 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108862b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$82(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108862b = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$82(this.f108862b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (r6.P0(r1, r5) == r0) goto L15;
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
            int r1 = r5.f108861a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L4f
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L32
        L1e:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108862b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.B1(r6)
            r5.f108861a = r3
            r3 = 0
            java.lang.Object r6 = r6.d5(r3, r5)
            if (r6 != r0) goto L32
            goto L4e
        L32:
            cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager r6 = cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager.f101460a
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r1 = r5.f108862b
            android.content.Context r1 = r1.A0()
            r6.h(r1)
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel r6 = r5.f108862b
            cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowSnackbar r1 = new cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewCommand$ShowSnackbar
            int r3 = cz.mobilesoft.coreblock.R.string.bb
            r1.<init>(r3)
            r5.f108861a = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.X1(r6, r1, r5)
            if (r6 != r0) goto L4f
        L4e:
            return r0
        L4f:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$82.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$82) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
