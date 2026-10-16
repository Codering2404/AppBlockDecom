package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", l = {97}, m = "invokeSuspend")
final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f53109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FoldingFeatureObserver f53110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f53111c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FoldingFeatureObserver$registerLayoutStateChangeCallback$1(FoldingFeatureObserver foldingFeatureObserver, Activity activity, Continuation continuation) {
        super(2, continuation);
        this.f53110b = foldingFeatureObserver;
        this.f53111c = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this.f53110b, this.f53111c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f53109a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final Flow flowB = this.f53110b.f53105a.b(this.f53111c);
            final FoldingFeatureObserver foldingFeatureObserver = this.f53110b;
            Flow flowU = FlowKt.u(new Flow<FoldingFeature>() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1

                /* JADX INFO: renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class AnonymousClass2 implements FlowCollector<WindowLayoutInfo> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f53115a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ FoldingFeatureObserver f53116b;

                    /* JADX INFO: renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                    @Metadata
                    @DebugMetadata(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "FoldingFeatureObserver.kt", l = {138}, m = "emit")
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f53117a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f53118b;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f53117a = obj;
                            this.f53118b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, FoldingFeatureObserver foldingFeatureObserver) {
                        this.f53115a = flowCollector;
                        this.f53116b = foldingFeatureObserver;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f53118b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f53118b = r1
                            goto L18
                        L13:
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.f53117a
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r2 = r0.f53118b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.b(r6)
                            goto L4a
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.b(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.f53115a
                            androidx.window.layout.WindowLayoutInfo r5 = (androidx.window.layout.WindowLayoutInfo) r5
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver r2 = r4.f53116b
                            androidx.window.layout.FoldingFeature r5 = androidx.slidingpanelayout.widget.FoldingFeatureObserver.a(r2, r5)
                            if (r5 != 0) goto L41
                            goto L4a
                        L41:
                            r0.f53118b = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L4a
                            return r1
                        L4a:
                            kotlin.Unit r5 = kotlin.Unit.f139807a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector flowCollector, Continuation continuation) {
                    Object objCollect = flowB.collect(new AnonymousClass2(flowCollector, foldingFeatureObserver), continuation);
                    return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                }
            });
            final FoldingFeatureObserver foldingFeatureObserver2 = this.f53110b;
            FlowCollector<FoldingFeature> flowCollector = new FlowCollector<FoldingFeature>() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(Object obj2, Continuation continuation) {
                    Unit unit;
                    FoldingFeature foldingFeature = (FoldingFeature) obj2;
                    FoldingFeatureObserver.OnFoldingFeatureChangeListener onFoldingFeatureChangeListener = foldingFeatureObserver2.f53108d;
                    if (onFoldingFeatureChangeListener == null) {
                        unit = null;
                    } else {
                        onFoldingFeatureChangeListener.a(foldingFeature);
                        unit = Unit.f139807a;
                    }
                    return unit == IntrinsicsKt.f() ? unit : Unit.f139807a;
                }
            };
            this.f53109a = 1;
            if (flowU.collect(flowCollector, this) == objF) {
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
        return ((FoldingFeatureObserver$registerLayoutStateChangeCallback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
