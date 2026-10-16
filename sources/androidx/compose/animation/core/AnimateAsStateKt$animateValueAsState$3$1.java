package androidx.compose.animation.core;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1", f = "AnimateAsState.kt", l = {418}, m = "invokeSuspend")
final class AnimateAsStateKt$animateValueAsState$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f3817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f3819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Channel f3820d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Animatable f3821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ State f3822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ State f3823h;

    /* JADX INFO: renamed from: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1", f = "AnimateAsState.kt", l = {427}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f3825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Animatable f3826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ State f3827d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ State f3828f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, Animatable animatable, State state, State state2, Continuation continuation) {
            super(2, continuation);
            this.f3825b = obj;
            this.f3826c = animatable;
            this.f3827d = state;
            this.f3828f = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f3825b, this.f3826c, this.f3827d, this.f3828f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass1 anonymousClass1;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f3824a;
            if (i3 == 0) {
                ResultKt.b(obj);
                if (Intrinsics.areEqual(this.f3825b, this.f3826c.l())) {
                    return Unit.f139807a;
                }
                Animatable animatable = this.f3826c;
                Object obj2 = this.f3825b;
                AnimationSpec animationSpecG = AnimateAsStateKt.g(this.f3827d);
                this.f3824a = 1;
                anonymousClass1 = this;
                if (Animatable.f(animatable, obj2, animationSpecG, null, null, anonymousClass1, 12, null) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                anonymousClass1 = this;
            }
            Function1 function1F = AnimateAsStateKt.f(anonymousClass1.f3828f);
            if (function1F != null) {
                function1F.invoke(anonymousClass1.f3826c.n());
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimateAsStateKt$animateValueAsState$3$1(Channel channel, Animatable animatable, State state, State state2, Continuation continuation) {
        super(2, continuation);
        this.f3820d = channel;
        this.f3821f = animatable;
        this.f3822g = state;
        this.f3823h = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AnimateAsStateKt$animateValueAsState$3$1 animateAsStateKt$animateValueAsState$3$1 = new AnimateAsStateKt$animateValueAsState$3$1(this.f3820d, this.f3821f, this.f3822g, this.f3823h, continuation);
        animateAsStateKt$animateValueAsState$3$1.f3819c = obj;
        return animateAsStateKt$animateValueAsState$3$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0037 -> B:12:0x003a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f3818b
            r2 = 1
            if (r1 == 0) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r1 = r11.f3817a
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r11.f3819c
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.b(r12)
            goto L3a
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = r11.f3819c
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            kotlinx.coroutines.channels.Channel r1 = r11.f3820d
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r3 = r12
        L2d:
            r11.f3819c = r3
            r11.f3817a = r1
            r11.f3818b = r2
            java.lang.Object r12 = r1.a(r11)
            if (r12 != r0) goto L3a
            return r0
        L3a:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L6a
            java.lang.Object r12 = r1.next()
            kotlinx.coroutines.channels.Channel r4 = r11.f3820d
            java.lang.Object r4 = r4.s()
            java.lang.Object r4 = kotlinx.coroutines.channels.ChannelResult.f(r4)
            if (r4 != 0) goto L54
            r6 = r12
            goto L55
        L54:
            r6 = r4
        L55:
            androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1 r5 = new androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1$1
            androidx.compose.animation.core.Animatable r7 = r11.f3821f
            androidx.compose.runtime.State r8 = r11.f3822g
            androidx.compose.runtime.State r9 = r11.f3823h
            r10 = 0
            r5.<init>(r6, r7, r8, r9, r10)
            r7 = 3
            r8 = 0
            r4 = 0
            r6 = r5
            r5 = 0
            kotlinx.coroutines.BuildersKt.d(r3, r4, r5, r6, r7, r8)
            goto L2d
        L6a:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AnimateAsStateKt$animateValueAsState$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
