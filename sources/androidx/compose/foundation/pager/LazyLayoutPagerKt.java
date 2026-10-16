package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LazyLayoutPagerKt {
    /* JADX WARN: Removed duplicated region for block: B:107:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:268:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.ui.Modifier r30, final androidx.compose.foundation.pager.PagerState r31, final androidx.compose.foundation.layout.PaddingValues r32, final boolean r33, final androidx.compose.foundation.gestures.Orientation r34, final androidx.compose.foundation.gestures.TargetedFlingBehavior r35, final boolean r36, final androidx.compose.foundation.OverscrollEffect r37, int r38, float r39, final androidx.compose.foundation.pager.PageSize r40, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r41, final kotlin.jvm.functions.Function1 r42, final androidx.compose.ui.Alignment.Horizontal r43, final androidx.compose.ui.Alignment.Vertical r44, final androidx.compose.foundation.gestures.snapping.SnapPosition r45, final kotlin.jvm.functions.Function4 r46, androidx.compose.runtime.Composer r47, final int r48, final int r49, final int r50) {
        /*
            Method dump skipped, instruction units count: 1160
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.a(androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, androidx.compose.foundation.OverscrollEffect, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapPosition, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Modifier b(Modifier modifier, final PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.d(Modifier.b8, pagerState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1

            /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", f = "LazyLayoutPager.kt", l = {287}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f8632a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ PointerInputScope f8633b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ PagerState f8634c;

                /* JADX INFO: renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", f = "LazyLayoutPager.kt", l = {289, 293}, m = "invokeSuspend")
                static final class C00201 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    Object f8635a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    Object f8636b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    int f8637c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    private /* synthetic */ Object f8638d;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ PagerState f8639f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00201(PagerState pagerState, Continuation continuation) {
                        super(2, continuation);
                        this.f8639f = pagerState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        C00201 c00201 = new C00201(this.f8639f, continuation);
                        c00201.f8638d = obj;
                        return c00201;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                        return ((C00201) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
                    
                        if (r11 == r0) goto L17;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
                    
                        if (r11 == r0) goto L17;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
                    
                        return r0;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0065 -> B:18:0x0068). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
                        /*
                            r10 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r1 = r10.f8637c
                            r2 = 2
                            r3 = 0
                            r4 = 1
                            if (r1 == 0) goto L2f
                            if (r1 == r4) goto L27
                            if (r1 != r2) goto L1f
                            java.lang.Object r1 = r10.f8636b
                            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                            java.lang.Object r4 = r10.f8635a
                            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                            java.lang.Object r5 = r10.f8638d
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                            kotlin.ResultKt.b(r11)
                            goto L68
                        L1f:
                            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r11.<init>(r0)
                            throw r11
                        L27:
                            java.lang.Object r1 = r10.f8638d
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                            kotlin.ResultKt.b(r11)
                            goto L44
                        L2f:
                            kotlin.ResultKt.b(r11)
                            java.lang.Object r11 = r10.f8638d
                            r1 = r11
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.f26830a
                            r10.f8638d = r1
                            r10.f8637c = r4
                            java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.e(r1, r3, r11, r10)
                            if (r11 != r0) goto L44
                            goto L67
                        L44:
                            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                            androidx.compose.foundation.pager.PagerState r4 = r10.f8639f
                            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.f25596b
                            long r5 = r5.c()
                            r4.n0(r5)
                            r4 = 0
                            r5 = r1
                            r1 = r4
                            r4 = r11
                        L55:
                            if (r1 != 0) goto L94
                            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.f26830a
                            r10.f8638d = r5
                            r10.f8635a = r4
                            r10.f8636b = r1
                            r10.f8637c = r2
                            java.lang.Object r11 = r5.T0(r11, r10)
                            if (r11 != r0) goto L68
                        L67:
                            return r0
                        L68:
                            androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
                            java.util.List r6 = r11.c()
                            r7 = r6
                            java.util.Collection r7 = (java.util.Collection) r7
                            int r7 = r7.size()
                            r8 = r3
                        L76:
                            if (r8 >= r7) goto L88
                            java.lang.Object r9 = r6.get(r8)
                            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.c(r9)
                            if (r9 != 0) goto L85
                            goto L55
                        L85:
                            int r8 = r8 + 1
                            goto L76
                        L88:
                            java.util.List r11 = r11.c()
                            java.lang.Object r11 = r11.get(r3)
                            r1 = r11
                            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                            goto L55
                        L94:
                            androidx.compose.foundation.pager.PagerState r11 = r10.f8639f
                            long r0 = r1.h()
                            long r2 = r4.h()
                            long r0 = androidx.compose.ui.geometry.Offset.p(r0, r2)
                            r11.n0(r0)
                            kotlin.Unit r11 = kotlin.Unit.f139807a
                            return r11
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1.AnonymousClass1.C00201.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, PagerState pagerState, Continuation continuation) {
                    super(2, continuation);
                    this.f8633b = pointerInputScope;
                    this.f8634c = pagerState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.f8633b, this.f8634c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.f8632a;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        PointerInputScope pointerInputScope = this.f8633b;
                        C00201 c00201 = new C00201(this.f8634c, null);
                        this.f8632a = 1;
                        if (ForEachGestureKt.e(pointerInputScope, c00201, this) == objF) {
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

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                Object objF = CoroutineScopeKt.f(new AnonymousClass1(pointerInputScope, pagerState, null), continuation);
                return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
            }
        }));
    }

    private static final Function0 c(final PagerState pagerState, Function4 function4, Function1 function1, final Function0 function0, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1372505274, i3, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:259)");
        }
        final State stateP = SnapshotStateKt.p(function4, composer, (i3 >> 3) & 14);
        final State stateP2 = SnapshotStateKt.p(function1, composer, (i3 >> 6) & 14);
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer.Z(pagerState)) || (i3 & 6) == 4) | composer.Z(stateP) | composer.Z(stateP2) | ((((i3 & 7168) ^ 3072) > 2048 && composer.Z(function0)) || (i3 & 3072) == 2048);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            final State stateD = SnapshotStateKt.d(SnapshotStateKt.o(), new Function0<PagerLayoutIntervalContent>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final PagerLayoutIntervalContent invoke() {
                    return new PagerLayoutIntervalContent((Function4) stateP.getValue(), (Function1) stateP2.getValue(), ((Number) function0.invoke()).intValue());
                }
            });
            final State stateD2 = SnapshotStateKt.d(SnapshotStateKt.o(), new Function0<PagerLazyLayoutItemProvider>() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final PagerLazyLayoutItemProvider invoke() {
                    PagerLayoutIntervalContent pagerLayoutIntervalContent = (PagerLayoutIntervalContent) stateD.getValue();
                    return new PagerLazyLayoutItemProvider(pagerState, pagerLayoutIntervalContent, new NearestRangeKeyIndexMap(pagerState.G(), pagerLayoutIntervalContent));
                }
            });
            objG = new PropertyReference0Impl(stateD2) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.w(objG);
        }
        KProperty0 kProperty0 = (KProperty0) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return kProperty0;
    }
}
