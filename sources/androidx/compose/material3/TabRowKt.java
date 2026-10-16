package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

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
public final class TabRowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f20596a = Dp.g(90);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AnimationSpec f20597b = AnimationSpecKt.n(250, 0, EasingKt.d(), 2, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AnimationSpec f20598c = AnimationSpecKt.n(250, 0, EasingKt.d(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final int r21, androidx.compose.ui.Modifier r22, androidx.compose.foundation.ScrollState r23, long r24, long r26, float r28, kotlin.jvm.functions.Function3 r29, kotlin.jvm.functions.Function2 r30, final kotlin.jvm.functions.Function2 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.a(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3 r27, kotlin.jvm.functions.Function2 r28, final kotlin.jvm.functions.Function2 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.b(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final int r19, androidx.compose.ui.Modifier r20, long r21, long r23, float r25, kotlin.jvm.functions.Function3 r26, kotlin.jvm.functions.Function2 r27, final kotlin.jvm.functions.Function2 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.c(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final int i3, final Modifier modifier, final long j3, final long j4, final float f3, final ScrollState scrollState, final Function3 function3, final Function2 function2, final Function2 function22, Composer composer, final int i4) {
        int i5;
        float f4;
        ScrollState scrollState2;
        Function3 function32;
        Function2 function23;
        Composer composer2;
        Composer composerK = composer.k(-1594140035);
        if ((i4 & 6) == 0) {
            i5 = (composerK.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.f(j3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.f(j4) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            f4 = f3;
            i5 |= composerK.c(f4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            f4 = f3;
        }
        if ((196608 & i4) == 0) {
            scrollState2 = scrollState;
            i5 |= composerK.Z(scrollState2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            scrollState2 = scrollState;
        }
        if ((1572864 & i4) == 0) {
            function32 = function3;
            i5 |= composerK.I(function32) ? 1048576 : 524288;
        } else {
            function32 = function3;
        }
        if ((i4 & 12582912) == 0) {
            function23 = function2;
            i5 |= composerK.I(function23) ? 8388608 : 4194304;
        } else {
            function23 = function2;
        }
        if ((100663296 & i4) == 0) {
            i5 |= composerK.I(function22) ? 67108864 : 33554432;
        }
        if ((i5 & 38347923) == 38347922 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1594140035, i5, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:698)");
            }
            Modifier modifierB = ClipKt.b(SelectableGroupKt.a(ScrollKt.b(SizeKt.G(SizeKt.h(modifier, 0.0f, 1, null), Alignment.f25072a.h(), false, 2, null), scrollState2, false, null, false, 14, null)));
            final Function2 function24 = function23;
            final Function3 function33 = function32;
            final float f5 = f4;
            composer2 = composerK;
            SurfaceKt.a(modifierB, null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.e(1556158104, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    if ((i6 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1556158104, i6, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous> (TabRow.kt:710)");
                    }
                    Object objG = composer3.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composer3));
                        composer3.w(compositionScopedCoroutineScopeCanceller);
                        objG = compositionScopedCoroutineScopeCanceller;
                    }
                    CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG).a();
                    boolean Z = composer3.Z(scrollState) | composer3.Z(coroutineScopeA);
                    ScrollState scrollState3 = scrollState;
                    Object objG2 = composer3.G();
                    if (Z || objG2 == companion.a()) {
                        objG2 = new ScrollableTabData(scrollState3, coroutineScopeA);
                        composer3.w(objG2);
                    }
                    final ScrollableTabData scrollableTabData = (ScrollableTabData) objG2;
                    Object objG3 = composer3.G();
                    if (objG3 == companion.a()) {
                        objG3 = new TabRowKt$ScrollableTabRowImpl$1$scope$1$1();
                        composer3.w(objG3);
                    }
                    final TabRowKt$ScrollableTabRowImpl$1$scope$1$1 tabRowKt$ScrollableTabRowImpl$1$scope$1$1 = (TabRowKt$ScrollableTabRowImpl$1$scope$1$1) objG3;
                    Function2 function25 = function22;
                    Function2 function26 = function24;
                    final Function3 function34 = function33;
                    List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function25, function26, ComposableLambdaKt.e(-1530560661, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer4, int i7) {
                            if ((i7 & 3) == 2 && composer4.l()) {
                                composer4.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(-1530560661, i7, -1, "androidx.compose.material3.ScrollableTabRowImpl.<anonymous>.<anonymous> (TabRow.kt:756)");
                            }
                            function34.invoke(tabRowKt$ScrollableTabRowImpl$1$scope$1$1, composer4, 6);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer3, 54)});
                    boolean zC = composer3.c(f5) | composer3.e(i3) | composer3.I(scrollableTabData);
                    final float f6 = f5;
                    final int i7 = i3;
                    Object objG4 = composer3.G();
                    if (zC || objG4 == companion.a()) {
                        objG4 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1
                            @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo47measure3p2s80s(final MeasureScope measureScope, List list, long j5) {
                                MeasureScope measureScope2 = measureScope;
                                List list2 = (List) list.get(0);
                                List list3 = (List) list.get(1);
                                List list4 = (List) list.get(2);
                                final int iZ0 = measureScope2.z0(f6);
                                int size = list2.size();
                                int iZ02 = measureScope2.z0(TabRowKt.f20596a);
                                Integer numValueOf = 0;
                                int size2 = list2.size();
                                for (int i8 = 0; i8 < size2; i8++) {
                                    numValueOf = Integer.valueOf(Math.max(numValueOf.intValue(), ((Measurable) list2.get(i8)).I(Api.BaseClientBuilder.API_PRIORITY_OTHER)));
                                }
                                int iIntValue = numValueOf.intValue();
                                int iZ03 = iZ0 * 2;
                                long jD = Constraints.d(j5, iZ02, 0, iIntValue, iIntValue, 2, null);
                                final Ref.FloatRef floatRef = new Ref.FloatRef();
                                floatRef.f140141a = f6;
                                final ArrayList arrayList = new ArrayList(list2.size());
                                int size3 = list2.size();
                                for (int i9 = 0; i9 < size3; i9++) {
                                    arrayList.add(((Measurable) list2.get(i9)).n0(jD));
                                }
                                final ArrayList arrayList2 = new ArrayList(size);
                                for (int i10 = 0; i10 < size; i10++) {
                                    float fL = ((Dp) ComparisonsKt.k(Dp.d(TabRowKt.f20596a), Dp.d(measureScope2.F(((Placeable) arrayList.get(i10)).X0())))).l();
                                    iZ03 += measureScope2.z0(fL);
                                    TabPosition tabPosition = new TabPosition(floatRef.f140141a, fL, ((Dp) ComparisonsKt.k(Dp.d(Dp.g(fL - Dp.g(TabKt.o() * 2))), Dp.d(Dp.g(24)))).l(), null);
                                    floatRef.f140141a = Dp.g(floatRef.f140141a + fL);
                                    arrayList2.add(tabPosition);
                                }
                                tabRowKt$ScrollableTabRowImpl$1$scope$1$1.c(arrayList2);
                                final ArrayList arrayList3 = new ArrayList(list3.size());
                                int size4 = list3.size();
                                int i11 = 0;
                                while (i11 < size4) {
                                    int i12 = iZ03;
                                    arrayList3.add(((Measurable) list3.get(i11)).n0(Constraints.d(j5, i12, iZ03, 0, 0, 8, null)));
                                    i11++;
                                    size4 = size4;
                                    list3 = list3;
                                    iZ03 = i12;
                                }
                                int i13 = iZ03;
                                int i14 = i7;
                                final ArrayList arrayList4 = new ArrayList(list4.size());
                                int size5 = list4.size();
                                int i15 = 0;
                                while (i15 < size5) {
                                    int i16 = iIntValue;
                                    iIntValue = i16;
                                    arrayList4.add(((Measurable) list4.get(i15)).n0(Constraints.c(j5, 0, measureScope2.z0(((TabPosition) arrayList2.get(i14)).d()), 0, i16)));
                                    i15++;
                                    measureScope2 = measureScope;
                                    list4 = list4;
                                }
                                final float f7 = f6;
                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                final int i17 = i7;
                                final int i18 = iIntValue;
                                return MeasureScope.B0(measureScope, i13, iIntValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.f139807a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Ref.FloatRef floatRef2 = floatRef;
                                        floatRef2.f140141a = f7;
                                        List list5 = arrayList;
                                        MeasureScope measureScope3 = measureScope;
                                        List list6 = arrayList2;
                                        int size6 = list5.size();
                                        for (int i19 = 0; i19 < size6; i19++) {
                                            Placeable.PlacementScope.m(placementScope, (Placeable) list5.get(i19), measureScope3.z0(floatRef2.f140141a), 0, 0.0f, 4, null);
                                            floatRef2.f140141a = Dp.g(floatRef2.f140141a + ((TabPosition) list6.get(i19)).d());
                                        }
                                        List list7 = arrayList3;
                                        int i20 = i18;
                                        int size7 = list7.size();
                                        for (int i21 = 0; i21 < size7; i21++) {
                                            Placeable placeable = (Placeable) list7.get(i21);
                                            Placeable.PlacementScope.m(placementScope, placeable, 0, i20 - placeable.O0(), 0.0f, 4, null);
                                        }
                                        List list8 = arrayList4;
                                        MeasureScope measureScope4 = measureScope;
                                        List list9 = arrayList2;
                                        int i22 = i17;
                                        int i23 = i18;
                                        int size8 = list8.size();
                                        for (int i24 = 0; i24 < size8; i24++) {
                                            Placeable placeable2 = (Placeable) list8.get(i24);
                                            Placeable.PlacementScope.m(placementScope, placeable2, Math.max(0, (measureScope4.z0(((TabPosition) list9.get(i22)).d()) - placeable2.X0()) / 2), i23 - placeable2.O0(), 0.0f, 4, null);
                                        }
                                        scrollableTabData2.c(measureScope, iZ0, arrayList2, i17);
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.w(objG4);
                    }
                    MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objG4;
                    Modifier.Companion companion2 = Modifier.b8;
                    Function2 function2B = LayoutKt.b(listListOf);
                    boolean Z2 = composer3.Z(multiContentMeasurePolicy);
                    Object objG5 = composer3.G();
                    if (Z2 || objG5 == companion.a()) {
                        objG5 = MultiContentMeasurePolicyKt.a(multiContentMeasurePolicy);
                        composer3.w(objG5);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objG5;
                    int iA = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU = composer3.u();
                    Modifier modifierF = ComposedModifierKt.f(composer3, companion2);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                    Function0 function0A = companion3.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A);
                    } else {
                        composer3.v();
                    }
                    Composer composerA = Updater.a(composer3);
                    Updater.e(composerA, measurePolicy, companion3.e());
                    Updater.e(composerA, compositionLocalMapU, companion3.g());
                    Function2 function2B2 = companion3.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B2);
                    }
                    Updater.e(composerA, modifierF, companion3.f());
                    function2B.invoke(composer3, 0);
                    composer3.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composer2, (i5 & 896) | 12582912 | (i5 & 7168), 114);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    TabRowKt.d(i3, modifier, j3, j4, f3, scrollState, function3, function2, function22, composer3, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(final int r27, final kotlin.jvm.functions.Function3 r28, androidx.compose.ui.Modifier r29, long r30, long r32, float r34, kotlin.jvm.functions.Function2 r35, final kotlin.jvm.functions.Function2 r36, final androidx.compose.foundation.ScrollState r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.e(int, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.ScrollState, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(final int r21, androidx.compose.ui.Modifier r22, androidx.compose.foundation.ScrollState r23, long r24, long r26, float r28, kotlin.jvm.functions.Function3 r29, kotlin.jvm.functions.Function2 r30, final kotlin.jvm.functions.Function2 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.f(int, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3 r27, kotlin.jvm.functions.Function2 r28, final kotlin.jvm.functions.Function2 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.g(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final int r21, androidx.compose.ui.Modifier r22, long r23, long r25, kotlin.jvm.functions.Function3 r27, kotlin.jvm.functions.Function2 r28, final kotlin.jvm.functions.Function2 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.h(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Modifier modifier, final long j3, final long j4, final Function3 function3, final Function2 function2, final Function2 function22, Composer composer, final int i3) {
        Modifier modifier2;
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1757425411);
        if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.f(j4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function22) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1757425411, i4, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:570)");
            }
            int i5 = i4 << 3;
            composer2 = composerK;
            SurfaceKt.a(SelectableGroupKt.a(modifier2), null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.e(-65106680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    if ((i6 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-65106680, i6, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:576)");
                    }
                    Object objG = composer3.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        objG = new TabRowKt$TabRowImpl$1$scope$1$1();
                        composer3.w(objG);
                    }
                    final TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = (TabRowKt$TabRowImpl$1$scope$1$1) objG;
                    Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
                    Function2 function23 = function22;
                    Function2 function24 = function2;
                    final Function3 function32 = function3;
                    List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function23, function24, ComposableLambdaKt.e(1236693605, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer4, int i7) {
                            if ((i7 & 3) == 2 && composer4.l()) {
                                composer4.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(1236693605, i7, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:617)");
                            }
                            function32.invoke(tabRowKt$TabRowImpl$1$scope$1$1, composer4, 6);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer3, 54)});
                    Object objG2 = composer3.G();
                    if (objG2 == companion.a()) {
                        objG2 = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1
                            @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo47measure3p2s80s(MeasureScope measureScope, List list, long j5) {
                                MeasureScope measureScope2 = measureScope;
                                List list2 = (List) list.get(0);
                                List list3 = (List) list.get(1);
                                int i7 = 2;
                                List list4 = (List) list.get(2);
                                int iL = Constraints.l(j5);
                                int size = list2.size();
                                final Ref.IntRef intRef = new Ref.IntRef();
                                if (size > 0) {
                                    intRef.f140142a = iL / size;
                                }
                                Integer numValueOf = 0;
                                int size2 = list2.size();
                                for (int i8 = 0; i8 < size2; i8++) {
                                    numValueOf = Integer.valueOf(Math.max(((Measurable) list2.get(i8)).I(intRef.f140142a), numValueOf.intValue()));
                                }
                                final int iIntValue = numValueOf.intValue();
                                TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$12 = tabRowKt$TabRowImpl$1$scope$1$1;
                                ArrayList arrayList = new ArrayList(size);
                                int i9 = 0;
                                while (i9 < size) {
                                    arrayList.add(new TabPosition(Dp.g(measureScope2.F(intRef.f140142a) * i9), measureScope2.F(intRef.f140142a), ((Dp) ComparisonsKt.k(Dp.d(Dp.g(measureScope2.F(Math.min(((Measurable) list2.get(i9)).l0(iIntValue), intRef.f140142a)) - Dp.g(TabKt.o() * i7))), Dp.d(Dp.g(24)))).l(), null));
                                    i9++;
                                    measureScope2 = measureScope;
                                    i7 = 2;
                                }
                                tabRowKt$TabRowImpl$1$scope$1$12.c(arrayList);
                                final ArrayList arrayList2 = new ArrayList(list2.size());
                                int size3 = list2.size();
                                for (int i10 = 0; i10 < size3; i10++) {
                                    Measurable measurable = (Measurable) list2.get(i10);
                                    int i11 = intRef.f140142a;
                                    int i12 = iIntValue;
                                    long jC = Constraints.c(j5, i11, i11, i12, iIntValue);
                                    iIntValue = i12;
                                    arrayList2.add(measurable.n0(jC));
                                }
                                final ArrayList arrayList3 = new ArrayList(list3.size());
                                int size4 = list3.size();
                                for (int i13 = 0; i13 < size4; i13++) {
                                    arrayList3.add(((Measurable) list3.get(i13)).n0(Constraints.d(j5, 0, 0, 0, 0, 11, null)));
                                }
                                final ArrayList arrayList4 = new ArrayList(list4.size());
                                int size5 = list4.size();
                                for (int i14 = 0; i14 < size5; i14++) {
                                    Measurable measurable2 = (Measurable) list4.get(i14);
                                    int i15 = intRef.f140142a;
                                    int i16 = iIntValue;
                                    iIntValue = i16;
                                    arrayList4.add(measurable2.n0(Constraints.c(j5, i15, i15, 0, i16)));
                                }
                                return MeasureScope.B0(measureScope, iL, iIntValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.f139807a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        List list5 = arrayList2;
                                        Ref.IntRef intRef2 = intRef;
                                        int size6 = list5.size();
                                        for (int i17 = 0; i17 < size6; i17++) {
                                            Placeable.PlacementScope.m(placementScope, (Placeable) list5.get(i17), i17 * intRef2.f140142a, 0, 0.0f, 4, null);
                                        }
                                        List list6 = arrayList3;
                                        int i18 = iIntValue;
                                        int size7 = list6.size();
                                        for (int i19 = 0; i19 < size7; i19++) {
                                            Placeable placeable = (Placeable) list6.get(i19);
                                            Placeable.PlacementScope.m(placementScope, placeable, 0, i18 - placeable.O0(), 0.0f, 4, null);
                                        }
                                        List list7 = arrayList4;
                                        int i20 = iIntValue;
                                        int size8 = list7.size();
                                        for (int i21 = 0; i21 < size8; i21++) {
                                            Placeable placeable2 = (Placeable) list7.get(i21);
                                            Placeable.PlacementScope.m(placementScope, placeable2, 0, i20 - placeable2.O0(), 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.w(objG2);
                    }
                    MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objG2;
                    Function2 function2B = LayoutKt.b(listListOf);
                    Object objG3 = composer3.G();
                    if (objG3 == companion.a()) {
                        objG3 = MultiContentMeasurePolicyKt.a(multiContentMeasurePolicy);
                        composer3.w(objG3);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objG3;
                    int iA = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU = composer3.u();
                    Modifier modifierF = ComposedModifierKt.f(composer3, modifierH);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                    Function0 function0A = companion2.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A);
                    } else {
                        composer3.v();
                    }
                    Composer composerA = Updater.a(composer3);
                    Updater.e(composerA, measurePolicy, companion2.e());
                    Updater.e(composerA, compositionLocalMapU, companion2.g());
                    Function2 function2B2 = companion2.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B2);
                    }
                    Updater.e(composerA, modifierF, companion2.f());
                    function2B.invoke(composer3, 0);
                    composer3.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composer2, (i5 & 896) | 12582912 | (i5 & 7168), 114);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    TabRowKt.i(modifier3, j3, j4, function3, function2, function22, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Modifier modifier, final long j3, final long j4, final Function3 function3, final Function2 function2, final Function2 function22, Composer composer, final int i3) {
        Modifier modifier2;
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-160898917);
        if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.f(j4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function22) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-160898917, i4, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:942)");
            }
            int i5 = i4 << 3;
            composer2 = composerK;
            SurfaceKt.a(SelectableGroupKt.a(modifier2), null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.e(-1617702432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    if ((i6 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1617702432, i6, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:948)");
                    }
                    Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
                    boolean Z = composer3.Z(function22) | composer3.Z(function2) | composer3.Z(function3);
                    final Function2 function23 = function22;
                    final Function2 function24 = function2;
                    final Function3 function32 = function3;
                    Object objG = composer3.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m192invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).r());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m192invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j5) {
                                final int iL = Constraints.l(j5);
                                List listV = subcomposeMeasureScope.V(TabSlots.Tabs, function23);
                                int size = listV.size();
                                final Ref.IntRef intRef = new Ref.IntRef();
                                if (size > 0) {
                                    intRef.f140142a = iL / size;
                                }
                                Integer numValueOf = 0;
                                int size2 = listV.size();
                                for (int i7 = 0; i7 < size2; i7++) {
                                    numValueOf = Integer.valueOf(Math.max(((Measurable) listV.get(i7)).I(intRef.f140142a), numValueOf.intValue()));
                                }
                                final int iIntValue = numValueOf.intValue();
                                final ArrayList arrayList = new ArrayList(listV.size());
                                int size3 = listV.size();
                                for (int i8 = 0; i8 < size3; i8++) {
                                    Measurable measurable = (Measurable) listV.get(i8);
                                    int i9 = intRef.f140142a;
                                    arrayList.add(measurable.n0(Constraints.c(j5, i9, i9, iIntValue, iIntValue)));
                                }
                                final ArrayList arrayList2 = new ArrayList(size);
                                for (int i10 = 0; i10 < size; i10++) {
                                    arrayList2.add(new TabPosition(Dp.g(subcomposeMeasureScope.F(intRef.f140142a) * i10), subcomposeMeasureScope.F(intRef.f140142a), ((Dp) ComparisonsKt.k(Dp.d(Dp.g(subcomposeMeasureScope.F(Math.min(((Measurable) listV.get(i10)).l0(iIntValue), intRef.f140142a)) - Dp.g(TabKt.o() * 2))), Dp.d(Dp.g(24)))).l(), null));
                                }
                                final Function2 function25 = function24;
                                final Function3 function33 = function32;
                                return MeasureScope.B0(subcomposeMeasureScope, iL, iIntValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.f139807a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        List list = arrayList;
                                        Ref.IntRef intRef2 = intRef;
                                        int size4 = list.size();
                                        for (int i11 = 0; i11 < size4; i11++) {
                                            Placeable.PlacementScope.m(placementScope, (Placeable) list.get(i11), i11 * intRef2.f140142a, 0, 0.0f, 4, null);
                                        }
                                        List listV2 = subcomposeMeasureScope.V(TabSlots.Divider, function25);
                                        long j6 = j5;
                                        int i12 = iIntValue;
                                        int size5 = listV2.size();
                                        for (int i13 = 0; i13 < size5; i13++) {
                                            Placeable placeableN0 = ((Measurable) listV2.get(i13)).n0(Constraints.d(j6, 0, 0, 0, 0, 11, null));
                                            Placeable.PlacementScope.m(placementScope, placeableN0, 0, i12 - placeableN0.O0(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3 function34 = function33;
                                        final List list2 = arrayList2;
                                        List listV3 = subcomposeMeasureScope2.V(tabSlots, ComposableLambdaKt.c(1621992604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRowWithSubcomposeImpl.1.1.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.f139807a;
                                            }

                                            public final void invoke(Composer composer4, int i14) {
                                                if ((i14 & 3) == 2 && composer4.l()) {
                                                    composer4.Q();
                                                    return;
                                                }
                                                if (ComposerKt.M()) {
                                                    ComposerKt.U(1621992604, i14, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:994)");
                                                }
                                                function34.invoke(list2, composer4, 0);
                                                if (ComposerKt.M()) {
                                                    ComposerKt.T();
                                                }
                                            }
                                        }));
                                        int i14 = iL;
                                        int i15 = iIntValue;
                                        int size6 = listV3.size();
                                        for (int i16 = 0; i16 < size6; i16++) {
                                            Placeable.PlacementScope.m(placementScope, ((Measurable) listV3.get(i16)).n0(Constraints.f29963b.c(i14, i15)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        composer3.w(objG);
                    }
                    SubcomposeLayoutKt.a(modifierH, (Function2) objG, composer3, 6, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composer2, (i5 & 896) | 12582912 | (i5 & 7168), 114);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    TabRowKt.j(modifier3, j3, j4, function3, function2, function22, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
