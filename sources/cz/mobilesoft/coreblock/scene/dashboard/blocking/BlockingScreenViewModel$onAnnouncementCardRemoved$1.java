package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.dto.QuestionnaireConfig;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$onAnnouncementCardRemoved$1", f = "BlockingScreenViewModel.kt", l = {1063, 1071}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$onAnnouncementCardRemoved$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f99717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f99718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f99719d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ QuestionnaireConfig f99720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99721g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$onAnnouncementCardRemoved$1(QuestionnaireConfig questionnaireConfig, BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f99720f = questionnaireConfig;
        this.f99721g = blockingScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BlockingScreenViewModel$onAnnouncementCardRemoved$1 blockingScreenViewModel$onAnnouncementCardRemoved$1 = new BlockingScreenViewModel$onAnnouncementCardRemoved$1(this.f99720f, this.f99721g, continuation);
        blockingScreenViewModel$onAnnouncementCardRemoved$1.f99719d = obj;
        return blockingScreenViewModel$onAnnouncementCardRemoved$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        if (r3.emit(null, r7) == r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
    
        if (r8.emit(r4, r7) == r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0084, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f99719d
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r7.f99718c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L27
            if (r2 == r4) goto L1f
            if (r2 != r3) goto L17
            java.lang.Object r0 = r7.f99716a
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            goto L23
        L17:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1f:
            java.lang.Object r0 = r7.f99716a
            cz.mobilesoft.coreblock.dto.QuestionnaireConfig r0 = (cz.mobilesoft.coreblock.dto.QuestionnaireConfig) r0
        L23:
            kotlin.ResultKt.b(r8)
            goto L85
        L27:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.dto.QuestionnaireConfig r8 = r7.f99720f
            r2 = 0
            if (r8 == 0) goto L52
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r3 = r7.f99721g
            cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r5 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
            int r6 = r8.b()
            r5.l2(r6)
            kotlinx.coroutines.flow.MutableStateFlow r3 = cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel.o1(r3)
            r7.f99719d = r0
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r7.f99716a = r8
            r7.f99717b = r2
            r7.f99718c = r4
            r8 = 0
            java.lang.Object r8 = r3.emit(r8, r7)
            if (r8 != r1) goto L85
            goto L84
        L52:
            cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel r8 = r7.f99721g
            cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r5 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
            r5.S2(r4)
            cz.mobilesoft.coreblock.repository.AppVersionRepository r4 = cz.mobilesoft.coreblock.repository.AppVersionRepository.f97355a
            r4.G()
            java.lang.Boolean r4 = cz.mobilesoft.coreblock.BuildConfig.f95357b
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L85
            kotlinx.coroutines.flow.MutableStateFlow r8 = r8.o2()
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r7.f99719d = r5
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r7.f99716a = r0
            r7.f99717b = r2
            r7.f99718c = r3
            java.lang.Object r8 = r8.emit(r4, r7)
            if (r8 != r1) goto L85
        L84:
            return r1
        L85:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$onAnnouncementCardRemoved$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$onAnnouncementCardRemoved$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
