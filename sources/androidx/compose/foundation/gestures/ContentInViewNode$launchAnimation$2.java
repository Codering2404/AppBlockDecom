package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", f = "ContentInViewNode.kt", l = {215}, m = "invokeSuspend")
final class ContentInViewNode$launchAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ContentInViewNode f5571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ UpdatableAnimationState f5572d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BringIntoViewSpec f5573f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContentInViewNode$launchAnimation$2(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, BringIntoViewSpec bringIntoViewSpec, Continuation continuation) {
        super(2, continuation);
        this.f5571c = contentInViewNode;
        this.f5572d = updatableAnimationState;
        this.f5573f = bringIntoViewSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ContentInViewNode$launchAnimation$2 contentInViewNode$launchAnimation$2 = new ContentInViewNode$launchAnimation$2(this.f5571c, this.f5572d, this.f5573f, continuation);
        contentInViewNode$launchAnimation$2.f5570b = obj;
        return contentInViewNode$launchAnimation$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f5569a;
        try {
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Job jobM = JobKt.m(((CoroutineScope) this.f5570b).getCoroutineContext());
                    this.f5571c.f5565l = true;
                    ScrollingLogic scrollingLogic = this.f5571c.f5556b;
                    MutatePriority mutatePriority = MutatePriority.f5071a;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f5572d, this.f5571c, this.f5573f, jobM, null);
                    this.f5569a = 1;
                    if (scrollingLogic.z(mutatePriority, anonymousClass1, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                this.f5571c.f5560g.d();
                this.f5571c.f5565l = false;
                this.f5571c.f5560g.b(null);
                this.f5571c.f5562i = false;
                return Unit.f139807a;
            } catch (CancellationException e3) {
                throw e3;
            }
        } catch (Throwable th) {
            this.f5571c.f5565l = false;
            this.f5571c.f5560g.b(null);
            this.f5571c.f5562i = false;
            throw th;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", f = "ContentInViewNode.kt", l = {221}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f5575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ UpdatableAnimationState f5576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ContentInViewNode f5577d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BringIntoViewSpec f5578f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Job f5579g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, BringIntoViewSpec bringIntoViewSpec, Job job, Continuation continuation) {
            super(2, continuation);
            this.f5576c = updatableAnimationState;
            this.f5577d = contentInViewNode;
            this.f5578f = bringIntoViewSpec;
            this.f5579g = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f5576c, this.f5577d, this.f5578f, this.f5579g, continuation);
            anonymousClass1.f5575b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(NestedScrollScope nestedScrollScope, Continuation continuation) {
            return ((AnonymousClass1) create(nestedScrollScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f5574a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException(MrGIhy.RUmLGqFBThh);
                }
            } else {
                ResultKt.b(obj);
                final NestedScrollScope nestedScrollScope = (NestedScrollScope) this.f5575b;
                this.f5576c.j(this.f5577d.w2(this.f5578f));
                final UpdatableAnimationState updatableAnimationState = this.f5576c;
                final ContentInViewNode contentInViewNode = this.f5577d;
                final Job job = this.f5579g;
                Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(float f3) {
                        float f4 = contentInViewNode.f5557c ? 1.0f : -1.0f;
                        ScrollingLogic scrollingLogic = contentInViewNode.f5556b;
                        float F = f4 * scrollingLogic.F(scrollingLogic.y(nestedScrollScope.b(scrollingLogic.y(scrollingLogic.G(f4 * f3)), NestedScrollSource.f26772b.b())));
                        if (Math.abs(F) < Math.abs(f3)) {
                            JobKt__JobKt.f(job, "Scroll animation cancelled because scroll was not consumed (" + F + " < " + f3 + ')', null, 2, null);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        c(((Number) obj2).floatValue());
                        return Unit.f139807a;
                    }
                };
                final ContentInViewNode contentInViewNode2 = this.f5577d;
                final UpdatableAnimationState updatableAnimationState2 = this.f5576c;
                final BringIntoViewSpec bringIntoViewSpec = this.f5578f;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m34invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m34invoke() {
                        BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = contentInViewNode2.f5560g;
                        ContentInViewNode contentInViewNode3 = contentInViewNode2;
                        while (true) {
                            if (bringIntoViewRequestPriorityQueue.f5543a.o() != 0) {
                                Rect rect = (Rect) ((ContentInViewNode.Request) bringIntoViewRequestPriorityQueue.f5543a.q()).b().invoke();
                                if (!(rect == null ? true : ContentInViewNode.E2(contentInViewNode3, rect, 0L, 1, null))) {
                                    break;
                                } else {
                                    ((ContentInViewNode.Request) bringIntoViewRequestPriorityQueue.f5543a.u(bringIntoViewRequestPriorityQueue.f5543a.o() - 1)).a().resumeWith(Result.b(Unit.f139807a));
                                }
                            } else {
                                break;
                            }
                        }
                        if (contentInViewNode2.f5562i) {
                            Rect rectB2 = contentInViewNode2.B2();
                            if (rectB2 != null && ContentInViewNode.E2(contentInViewNode2, rectB2, 0L, 1, null)) {
                                contentInViewNode2.f5562i = false;
                            }
                        }
                        updatableAnimationState2.j(contentInViewNode2.w2(bringIntoViewSpec));
                    }
                };
                this.f5574a = 1;
                if (updatableAnimationState.h(function1, function0, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ContentInViewNode$launchAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
