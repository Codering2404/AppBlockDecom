package cz.mobilesoft.coreblock.scene.dashboard.card;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$startBlocking$1", f = "QuickBlockCardViewModel.kt", l = {342, 344}, m = "invokeSuspend", v = 1)
final class QuickBlockCardViewModel$startBlocking$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f100531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f100532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ QuickBlockCardViewModel f100533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Long f100534d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockCardViewModel$startBlocking$1(QuickBlockCardViewModel quickBlockCardViewModel, Long l3, Continuation continuation) {
        super(1, continuation);
        this.f100533c = quickBlockCardViewModel;
        this.f100534d = l3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new QuickBlockCardViewModel$startBlocking$1(this.f100533c, this.f100534d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r1.P0(r3, r5) == r0) goto L17;
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
            int r1 = r5.f100532b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L5c
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L40
        L1e:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r6 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
            r6.y1()
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r6 = r5.f100533c
            cz.mobilesoft.coreblock.repository.QuickBlockRepository r6 = cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.b1(r6)
            java.lang.Long r1 = r5.f100534d
            r6.M(r1)
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r6 = r5.f100533c
            cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper r6 = cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.V0(r6)
            r5.f100532b = r3
            java.lang.Object r6 = r6.f(r5)
            if (r6 != r0) goto L40
            goto L5b
        L40:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L5c
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel r1 = r5.f100533c
            cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewCommand$OpenEmailConsentActivity r3 = new cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockViewCommand$OpenEmailConsentActivity
            java.lang.String r4 = "quick_block"
            r3.<init>(r4)
            r5.f100531a = r6
            r5.f100532b = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel.f1(r1, r3, r5)
            if (r6 != r0) goto L5c
        L5b:
            return r0
        L5c:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$startBlocking$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((QuickBlockCardViewModel$startBlocking$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
