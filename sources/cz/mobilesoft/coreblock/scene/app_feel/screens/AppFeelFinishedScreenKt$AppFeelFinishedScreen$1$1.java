package cz.mobilesoft.coreblock.scene.app_feel.screens;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1", f = "AppFeelFinishedScreen.kt", l = {59}, m = "invokeSuspend", v = 1)
final class AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f98662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Animatable f98663c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1$1", f = "AppFeelFinishedScreen.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f98664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f98665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Animatable f98666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Animatable f98667d;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1$1$1", f = "AppFeelFinishedScreen.kt", l = {61}, m = "invokeSuspend", v = 1)
        static final class C02661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f98668a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Animatable f98669b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02661(Animatable animatable, Continuation continuation) {
                super(2, continuation);
                this.f98669b = animatable;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C02661(this.f98669b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f98668a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Animatable animatable = this.f98669b;
                    Float fC = Boxing.c(1.0f);
                    TweenSpec tweenSpecN = AnimationSpecKt.n(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, 0, null, 6, null);
                    this.f98668a = 1;
                    if (Animatable.f(animatable, fC, tweenSpecN, null, null, this, 12, null) == objF) {
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
                return ((C02661) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1$1$2", f = "AppFeelFinishedScreen.kt", l = {67, 68}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f98670a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Animatable f98671b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Animatable animatable, Continuation continuation) {
                super(2, continuation);
                this.f98671b = animatable;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.f98671b, continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
            
                if (androidx.compose.animation.core.Animatable.f(r3, r4, r5, null, null, r11, 12, null) == r0) goto L15;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r1 = r11.f98670a
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    kotlin.ResultKt.b(r12)
                    goto L4b
                L12:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L1a:
                    kotlin.ResultKt.b(r12)
                    goto L2c
                L1e:
                    kotlin.ResultKt.b(r12)
                    r11.f98670a = r3
                    r3 = 500(0x1f4, double:2.47E-321)
                    java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r3, r11)
                    if (r12 != r0) goto L2c
                    goto L4a
                L2c:
                    androidx.compose.animation.core.Animatable r3 = r11.f98671b
                    r12 = 1065353216(0x3f800000, float:1.0)
                    java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.c(r12)
                    r12 = 0
                    r1 = 6
                    r5 = 500(0x1f4, float:7.0E-43)
                    r6 = 0
                    androidx.compose.animation.core.TweenSpec r5 = androidx.compose.animation.core.AnimationSpecKt.n(r5, r12, r6, r1, r6)
                    r11.f98670a = r2
                    r7 = 0
                    r9 = 12
                    r10 = 0
                    r8 = r11
                    java.lang.Object r12 = androidx.compose.animation.core.Animatable.f(r3, r4, r5, r6, r7, r8, r9, r10)
                    if (r12 != r0) goto L4b
                L4a:
                    return r0
                L4b:
                    kotlin.Unit r12 = kotlin.Unit.f139807a
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Animatable animatable, Animatable animatable2, Continuation continuation) {
            super(2, continuation);
            this.f98666c = animatable;
            this.f98667d = animatable2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f98666c, this.f98667d, continuation);
            anonymousClass1.f98665b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope = (CoroutineScope) this.f98665b;
            IntrinsicsKt.f();
            if (this.f98664a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new C02661(this.f98666c, null), 3, null);
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass2(this.f98667d, null), 3, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1(Animatable animatable, Animatable animatable2, Continuation continuation) {
        super(2, continuation);
        this.f98662b = animatable;
        this.f98663c = animatable2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1(this.f98662b, this.f98663c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98661a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f98662b, this.f98663c, null);
            this.f98661a = 1;
            if (CoroutineScopeKt.f(anonymousClass1, this) == objF) {
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
        return ((AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
