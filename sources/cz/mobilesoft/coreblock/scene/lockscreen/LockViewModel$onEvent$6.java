package cz.mobilesoft.coreblock.scene.lockscreen;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$onEvent$6", f = "LockViewModel.kt", l = {271, 274, 275}, m = "invokeSuspend", v = 1)
final class LockViewModel$onEvent$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockViewModel f105523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockViewEvent f105524c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockViewModel$onEvent$6(LockViewModel lockViewModel, LockViewEvent lockViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f105523b = lockViewModel;
        this.f105524c = lockViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockViewModel$onEvent$6(this.f105523b, this.f105524c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (r11.P0(r1, r10) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
    
        if (r11.P0(r3, r10) != r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f105522a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L27
            if (r1 == r4) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.b(r11)
            goto L96
        L16:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1e:
            kotlin.ResultKt.b(r11)
            goto L7f
        L22:
            kotlin.ResultKt.b(r11)
            goto La1
        L27:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel r11 = r10.f105523b
            cz.mobilesoft.coreblock.repository.StrictModeRepository r11 = cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel.T0(r11)
            boolean r11 = r11.n()
            if (r11 == 0) goto L5b
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel r11 = r10.f105523b
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewCommand$ShowSnackBar r1 = new cz.mobilesoft.coreblock.scene.lockscreen.LockViewCommand$ShowSnackBar
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel r2 = r10.f105523b
            android.content.Context r2 = r2.A0()
            cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives$Companion r3 = cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives.Companion
            int r3 = r3.a()
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.<init>(r2)
            r10.f105522a = r4
            java.lang.Object r11 = cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel.U0(r11, r1, r10)
            if (r11 != r0) goto La1
            goto L95
        L5b:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r11 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent r1 = r10.f105524c
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent$LockScreenExcludeBrowserClickEvent r1 = (cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent.LockScreenExcludeBrowserClickEvent) r1
            java.lang.String r1 = r1.a()
            r11.K1(r1)
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel r11 = r10.f105523b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r11 = r11.Y0()
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent r1 = r10.f105524c
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent$LockScreenExcludeBrowserClickEvent r1 = (cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent.LockScreenExcludeBrowserClickEvent) r1
            java.lang.String r1 = r1.a()
            r10.f105522a = r3
            java.lang.Object r11 = r11.Q(r1, r10)
            if (r11 != r0) goto L7f
            goto L95
        L7f:
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel r11 = r10.f105523b
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewCommand$CloseCommand r3 = new cz.mobilesoft.coreblock.scene.lockscreen.LockViewCommand$CloseCommand
            r8 = 15
            r9 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r10.f105522a = r2
            java.lang.Object r11 = cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel.U0(r11, r3, r10)
            if (r11 != r0) goto L96
        L95:
            return r0
        L96:
            cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel r11 = r10.f105523b
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r11 = r11.Z0()
            if (r11 == 0) goto La1
            r11.U()
        La1:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel$onEvent$6.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockViewModel$onEvent$6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
