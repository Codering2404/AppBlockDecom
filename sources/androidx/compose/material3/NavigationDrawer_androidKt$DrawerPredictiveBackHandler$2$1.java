package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

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
@DebugMetadata(c = "androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1", f = "NavigationDrawer.android.kt", l = {60, 86, 86, 86}, m = "invokeSuspend")
final class NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 extends SuspendLambda implements Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f18683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f18684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DrawerPredictiveBackState f18685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f18686d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DrawerState f18687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f18688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f18689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f18690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f18691j;

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2", f = "NavigationDrawer.android.kt", l = {77}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DrawerPredictiveBackState f18698b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DrawerPredictiveBackState drawerPredictiveBackState, Continuation continuation) {
            super(2, continuation);
            this.f18698b = drawerPredictiveBackState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f18698b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnonymousClass2 anonymousClass2;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f18697a;
            if (i3 == 0) {
                ResultKt.b(obj);
                float fB = this.f18698b.b();
                final DrawerPredictiveBackState drawerPredictiveBackState = this.f18698b;
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.material3.NavigationDrawer_androidKt.DrawerPredictiveBackHandler.2.1.2.1
                    {
                        super(2);
                    }

                    public final void c(float f3, float f4) {
                        drawerPredictiveBackState.e(f3);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                        return Unit.f139807a;
                    }
                };
                this.f18697a = 1;
                anonymousClass2 = this;
                if (SuspendAnimationKt.e(fB, 0.0f, 0.0f, null, function2, anonymousClass2, 12, null) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                anonymousClass2 = this;
            }
            anonymousClass2.f18698b.a();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(DrawerPredictiveBackState drawerPredictiveBackState, CoroutineScope coroutineScope, DrawerState drawerState, boolean z2, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.FloatRef floatRef3, Continuation continuation) {
        super(2, continuation);
        this.f18685c = drawerPredictiveBackState;
        this.f18686d = coroutineScope;
        this.f18687f = drawerState;
        this.f18688g = z2;
        this.f18689h = floatRef;
        this.f18690i = floatRef2;
        this.f18691j = floatRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(this.f18685c, this.f18686d, this.f18687f, this.f18688g, this.f18689h, this.f18690i, this.f18691j, continuation);
        navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.f18684b = obj;
        return navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Flow flow, Continuation continuation) {
        return ((NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1) create(flow, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
    
        if (r14.d(r13) == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0099, code lost:
    
        if (r14.d(r13) != r1) goto L33;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r13.f18683a
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r0 == 0) goto L32
            if (r0 == r5) goto L2b
            if (r0 == r4) goto L26
            if (r0 == r3) goto L26
            if (r0 == r2) goto L1d
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L1d:
            java.lang.Object r0 = r13.f18684b
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.b(r14)
            goto Lc4
        L26:
            kotlin.ResultKt.b(r14)
            goto L9c
        L2b:
            kotlin.ResultKt.b(r14)     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            goto L51
        L2f:
            r0 = move-exception
            r14 = r0
            goto L9f
        L32:
            kotlin.ResultKt.b(r14)
            java.lang.Object r14 = r13.f18684b
            kotlinx.coroutines.flow.Flow r14 = (kotlinx.coroutines.flow.Flow) r14
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$1 r7 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$1     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            androidx.compose.material3.DrawerPredictiveBackState r8 = r13.f18685c     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            boolean r9 = r13.f18688g     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            kotlin.jvm.internal.Ref$FloatRef r10 = r13.f18689h     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            kotlin.jvm.internal.Ref$FloatRef r11 = r13.f18690i     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            kotlin.jvm.internal.Ref$FloatRef r12 = r13.f18691j     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            r7.<init>()     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            r13.f18683a = r5     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            java.lang.Object r14 = r14.collect(r7, r13)     // Catch: java.lang.Throwable -> L2f java.util.concurrent.CancellationException -> L74
            if (r14 != r1) goto L51
            goto Lc3
        L51:
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.f18685c
            boolean r14 = r14.d()
            if (r14 == 0) goto L69
            kotlinx.coroutines.CoroutineScope r7 = r13.f18686d
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 r10 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.f18685c
            r10.<init>(r14, r6)
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.BuildersKt.d(r7, r8, r9, r10, r11, r12)
        L69:
            androidx.compose.material3.DrawerState r14 = r13.f18687f
            r13.f18683a = r4
            java.lang.Object r14 = r14.d(r13)
            if (r14 != r1) goto L9c
            goto Lc3
        L74:
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.f18685c     // Catch: java.lang.Throwable -> L2f
            r14.a()     // Catch: java.lang.Throwable -> L2f
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.f18685c
            boolean r14 = r14.d()
            if (r14 == 0) goto L91
            kotlinx.coroutines.CoroutineScope r7 = r13.f18686d
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 r10 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.f18685c
            r10.<init>(r14, r6)
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.BuildersKt.d(r7, r8, r9, r10, r11, r12)
        L91:
            androidx.compose.material3.DrawerState r14 = r13.f18687f
            r13.f18683a = r3
            java.lang.Object r14 = r14.d(r13)
            if (r14 != r1) goto L9c
            goto Lc3
        L9c:
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        L9f:
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.f18685c
            boolean r14 = r14.d()
            if (r14 == 0) goto Lb7
            kotlinx.coroutines.CoroutineScope r7 = r13.f18686d
            androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2 r10 = new androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1$2
            androidx.compose.material3.DrawerPredictiveBackState r14 = r13.f18685c
            r10.<init>(r14, r6)
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.BuildersKt.d(r7, r8, r9, r10, r11, r12)
        Lb7:
            androidx.compose.material3.DrawerState r14 = r13.f18687f
            r13.f18684b = r0
            r13.f18683a = r2
            java.lang.Object r14 = r14.d(r13)
            if (r14 != r1) goto Lc4
        Lc3:
            return r1
        Lc4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
