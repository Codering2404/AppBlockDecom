package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
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
public final class PagerStateKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f8898a = Dp.g(56);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PagerMeasureResult f8899b = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.f6032b, 0, 0, false, 0, null, null, 0.0f, 0, false, SnapPosition.Start.f6488a, new MeasureResult() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f8902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f8903c = MapsKt.emptyMap();

        @Override // androidx.compose.ui.layout.MeasureResult
        public int getHeight() {
            return this.f8902b;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public int getWidth() {
            return this.f8901a;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public Map z() {
            return this.f8903c;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public void A() {
        }
    }, false, null, null, CoroutineScopeKt.a(EmptyCoroutineContext.f139889a), 393216, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final PagerStateKt$UnitDensity$1 f8900c = new Density() { // from class: androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f8904a = 1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f8905b = 1.0f;

        @Override // androidx.compose.ui.unit.FontScaling
        public float K1() {
            return this.f8905b;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.f8904a;
        }
    };

    public static final PagerState a(int i3, float f3, Function0 function0) {
        return new DefaultPagerState(i3, f3, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object e(final LazyLayoutScrollScope lazyLayoutScrollScope, int i3, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation) {
        function2.invoke(lazyLayoutScrollScope, Boxing.d(i3));
        boolean z2 = i3 > lazyLayoutScrollScope.h();
        int iB = (lazyLayoutScrollScope.b() - lazyLayoutScrollScope.h()) + 1;
        if (((z2 && i3 > lazyLayoutScrollScope.b()) || (!z2 && i3 < lazyLayoutScrollScope.h())) && Math.abs(i3 - lazyLayoutScrollScope.h()) >= 3) {
            lazyLayoutScrollScope.c(z2 ? RangesKt.f(i3 - iB, lazyLayoutScrollScope.h()) : RangesKt.k(iB + i3, lazyLayoutScrollScope.h()), 0);
        }
        float fE = LazyLayoutScrollScope.e(lazyLayoutScrollScope, i3, 0, 2, null) + f3;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        Object objE = SuspendAnimationKt.e(0.0f, fE, 0.0f, animationSpec, new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void c(float f4, float f5) {
                floatRef.f140141a += lazyLayoutScrollScope.d(f4 - floatRef.f140141a);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                return Unit.f139807a;
            }
        }, continuation, 4, null);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    public static final Object f(PagerState pagerState, Continuation continuation) throws Throwable {
        if (pagerState.v() + 1 >= pagerState.H()) {
            return Unit.f139807a;
        }
        Object objN = PagerState.n(pagerState, pagerState.v() + 1, 0.0f, null, continuation, 6, null);
        return objN == IntrinsicsKt.f() ? objN : Unit.f139807a;
    }

    public static final Object g(PagerState pagerState, Continuation continuation) throws Throwable {
        if (pagerState.v() - 1 < 0) {
            return Unit.f139807a;
        }
        Object objN = PagerState.n(pagerState, pagerState.v() - 1, 0.0f, null, continuation, 6, null);
        return objN == IntrinsicsKt.f() ? objN : Unit.f139807a;
    }

    public static final long h(PagerLayoutInfo pagerLayoutInfo, int i3) {
        long jC = (((((long) i3) * ((long) (pagerLayoutInfo.C() + pagerLayoutInfo.w()))) + ((long) pagerLayoutInfo.c())) + ((long) pagerLayoutInfo.b())) - ((long) pagerLayoutInfo.C());
        int iA = (int) (pagerLayoutInfo.getOrientation() == Orientation.f6032b ? pagerLayoutInfo.a() >> 32 : pagerLayoutInfo.a() & 4294967295L);
        return RangesKt.g(jC - ((long) (iA - RangesKt.p(pagerLayoutInfo.E().a(iA, pagerLayoutInfo.w(), pagerLayoutInfo.c(), pagerLayoutInfo.b(), i3 - 1, i3), 0, iA))), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(PagerMeasureResult pagerMeasureResult, int i3) {
        int iA = (int) (pagerMeasureResult.getOrientation() == Orientation.f6032b ? pagerMeasureResult.a() >> 32 : pagerMeasureResult.a() & 4294967295L);
        return RangesKt.p(pagerMeasureResult.E().a(iA, pagerMeasureResult.w(), pagerMeasureResult.c(), pagerMeasureResult.b(), 0, i3), 0, iA);
    }

    public static final float j() {
        return f8898a;
    }

    public static final PagerMeasureResult k() {
        return f8899b;
    }

    public static final PagerState l(final int i3, final float f3, final Function0 function0, Composer composer, int i4, int i5) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            f3 = 0.0f;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1210768637, i4, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:87)");
        }
        Object[] objArr = new Object[0];
        Saver saverA = DefaultPagerState.M.a();
        boolean z2 = ((((i4 & 14) ^ 6) > 4 && composer.e(i3)) || (i4 & 6) == 4) | ((((i4 & 112) ^ 48) > 32 && composer.c(f3)) || (i4 & 48) == 32) | ((((i4 & 896) ^ 384) > 256 && composer.Z(function0)) || (i4 & 384) == 256);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function0<DefaultPagerState>() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final DefaultPagerState invoke() {
                    return new DefaultPagerState(i3, f3, function0);
                }
            };
            composer.w(objG);
        }
        DefaultPagerState defaultPagerState = (DefaultPagerState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        defaultPagerState.s0().setValue(function0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultPagerState;
    }
}
