package cz.mobilesoft.coreblock.scene.dashboard.card;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$onEvent$2", f = "QuickBlockCardViewModel.kt", l = {210, 213, 216}, m = "invokeSuspend", v = 1)
final class QuickBlockCardViewModel$onEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f100489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ QuickBlockCardViewModel f100490b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockCardViewModel$onEvent$2(QuickBlockCardViewModel quickBlockCardViewModel, Continuation continuation) {
        super(2, continuation);
        this.f100490b = quickBlockCardViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new QuickBlockCardViewModel$onEvent$2(this.f100490b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7.P0(r1, r6) == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
    
        if (r7.n1(r6) != r0) goto L27;
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
            int r1 = r6.f100489a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L22
            if (r1 == r4) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L1e
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.b(r7)
            goto L79
        L1e:
            kotlin.ResultKt.b(r7)
            goto L89
        L22:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r7 = r6.f100490b
            cz.mobilesoft.coreblock.repository.StrictModeRepository r7 = cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.d1(r7)
            boolean r7 = r7.n()
            if (r7 == 0) goto L56
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r7 = r6.f100490b
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewCommand$ShowSnackBar r1 = new cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewCommand$ShowSnackBar
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r2 = r6.f100490b
            android.content.Context r2 = r2.A0()
            cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives$Companion r3 = cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives.Companion
            int r3 = r3.a()
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.<init>(r2)
            r6.f100489a = r4
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.f1(r7, r1, r6)
            if (r7 != r0) goto L89
            goto L88
        L56:
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r7 = r6.f100490b
            kotlinx.coroutines.Job r7 = cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.W0(r7)
            if (r7 == 0) goto L79
            boolean r7 = r7.isActive()
            if (r7 != r4) goto L79
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r7 = r6.f100490b
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r7 = cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.Y0(r7)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r4 = r1.f()
            r6.f100489a = r3
            java.lang.Object r7 = r7.j2(r4, r6)
            if (r7 != r0) goto L79
            goto L88
        L79:
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r7 = r6.f100490b
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.h1(r7)
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r7 = r6.f100490b
            r6.f100489a = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.T0(r7, r6)
            if (r7 != r0) goto L89
        L88:
            return r0
        L89:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$onEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((QuickBlockCardViewModel$onEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
