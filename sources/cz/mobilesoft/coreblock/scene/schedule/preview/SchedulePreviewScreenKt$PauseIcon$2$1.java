package cz.mobilesoft.coreblock.scene.schedule.preview;

import androidx.compose.animation.core.Animatable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt$PauseIcon$2$1", f = "SchedulePreviewScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class SchedulePreviewScreenKt$PauseIcon$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f117375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f117376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Animatable f117377c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt$PauseIcon$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt$PauseIcon$2$1$1", f = "SchedulePreviewScreen.kt", l = {767, 771}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Animatable f117379b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Animatable animatable, Continuation continuation) {
            super(2, continuation);
            this.f117379b = animatable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f117379b, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
        
            if (androidx.compose.animation.core.Animatable.f(r0, r1, r2, null, null, r14, 12, null) == r8) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                r14 = this;
                java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r0 = r14.f117378a
                r9 = 6
                r10 = 0
                r11 = 1500(0x5dc, float:2.102E-42)
                r12 = 2
                r1 = 1
                r13 = 0
                if (r0 == 0) goto L23
                if (r0 == r1) goto L1f
                if (r0 != r12) goto L17
                kotlin.ResultKt.b(r15)
                goto L5d
            L17:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1f:
                kotlin.ResultKt.b(r15)
                goto L43
            L23:
                kotlin.ResultKt.b(r15)
                androidx.compose.animation.core.Animatable r0 = r14.f117379b
                r2 = 1065353216(0x3f800000, float:1.0)
                java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.c(r2)
                r3 = r2
                androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.n(r11, r10, r13, r9, r13)
                r14.f117378a = r1
                r1 = r3
                r3 = 0
                r4 = 0
                r6 = 12
                r7 = 0
                r5 = r14
                java.lang.Object r0 = androidx.compose.animation.core.Animatable.f(r0, r1, r2, r3, r4, r5, r6, r7)
                if (r0 != r8) goto L43
                goto L5c
            L43:
                androidx.compose.animation.core.Animatable r0 = r14.f117379b
                r1 = 0
                java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.c(r1)
                androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.n(r11, r10, r13, r9, r13)
                r14.f117378a = r12
                r3 = 0
                r4 = 0
                r6 = 12
                r7 = 0
                r5 = r14
                java.lang.Object r0 = androidx.compose.animation.core.Animatable.f(r0, r1, r2, r3, r4, r5, r6, r7)
                if (r0 != r8) goto L5d
            L5c:
                return r8
            L5d:
                kotlin.Unit r0 = kotlin.Unit.f139807a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt$PauseIcon$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewScreenKt$PauseIcon$2$1(CoroutineScope coroutineScope, Animatable animatable, Continuation continuation) {
        super(2, continuation);
        this.f117376b = coroutineScope;
        this.f117377c = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SchedulePreviewScreenKt$PauseIcon$2$1(this.f117376b, this.f117377c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f117375a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        BuildersKt__Builders_commonKt.d(this.f117376b, null, null, new AnonymousClass1(this.f117377c, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SchedulePreviewScreenKt$PauseIcon$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
