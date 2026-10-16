package cz.mobilesoft.coreblock.scene.intro.strictmode;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewCommand;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$onAccessMethodConfirmed$1", f = "StrictModeIntroViewModel.kt", l = {92, 93, 94}, m = "invokeSuspend", v = 1)
final class StrictModeIntroViewModel$onAccessMethodConfirmed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f105052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictModeIntroViewModel f105053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrictModeAccessMethod f105054d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ List f105055f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$onAccessMethodConfirmed$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$onAccessMethodConfirmed$1$1", f = "StrictModeIntroViewModel.kt", l = {97}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f105056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StrictModeIntroViewModel f105057b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StrictModeIntroViewModel strictModeIntroViewModel, Continuation continuation) {
            super(2, continuation);
            this.f105057b = strictModeIntroViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f105057b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f105056a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StrictModeIntroViewModel strictModeIntroViewModel = this.f105057b;
                StrictModeIntroViewCommand.Finish finish = StrictModeIntroViewCommand.Finish.f105028a;
                this.f105056a = 1;
                if (strictModeIntroViewModel.P0(finish, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeIntroViewModel$onAccessMethodConfirmed$1(StrictModeIntroViewModel strictModeIntroViewModel, StrictModeAccessMethod strictModeAccessMethod, List list, Continuation continuation) {
        super(2, continuation);
        this.f105053c = strictModeIntroViewModel;
        this.f105054d = strictModeAccessMethod;
        this.f105055f = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictModeIntroViewModel$onAccessMethodConfirmed$1 strictModeIntroViewModel$onAccessMethodConfirmed$1 = new StrictModeIntroViewModel$onAccessMethodConfirmed$1(this.f105053c, this.f105054d, this.f105055f, continuation);
        strictModeIntroViewModel$onAccessMethodConfirmed$1.f105052b = obj;
        return strictModeIntroViewModel$onAccessMethodConfirmed$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        if (r9.s(r2, r8) != r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f105052b
            r1 = r0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r8.f105051a
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L2a
            if (r2 == r5) goto L26
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            kotlin.ResultKt.b(r9)
            goto L6a
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            kotlin.ResultKt.b(r9)
            goto L57
        L26:
            kotlin.ResultKt.b(r9)
            goto L44
        L2a:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel r9 = r8.f105053c
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r9 = cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel.T0(r9)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r2 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r6 = r2.f()
            r8.f105052b = r1
            r8.f105051a = r5
            java.lang.Object r9 = r9.e1(r6, r8)
            if (r9 != r0) goto L44
            goto L69
        L44:
            cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel r9 = r8.f105053c
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r9 = cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel.T0(r9)
            cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r2 = r8.f105054d
            r8.f105052b = r1
            r8.f105051a = r4
            java.lang.Object r9 = r9.M0(r2, r8)
            if (r9 != r0) goto L57
            goto L69
        L57:
            cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel r9 = r8.f105053c
            cz.mobilesoft.coreblock.repository.StrictModeRepository r9 = cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel.U0(r9)
            java.util.List r2 = r8.f105055f
            r8.f105052b = r1
            r8.f105051a = r3
            java.lang.Object r9 = r9.s(r2, r8)
            if (r9 != r0) goto L6a
        L69:
            return r0
        L6a:
            cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$onAccessMethodConfirmed$1$1 r4 = new cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$onAccessMethodConfirmed$1$1
            cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel r9 = r8.f105053c
            r0 = 0
            r4.<init>(r9, r0)
            r5 = 3
            r6 = 0
            r2 = 0
            r3 = 0
            kotlinx.coroutines.BuildersKt.d(r1, r2, r3, r4, r5, r6)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$onAccessMethodConfirmed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictModeIntroViewModel$onAccessMethodConfirmed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
