package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

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
public final class CarouselKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.material3.carousel.CarouselState r32, final androidx.compose.foundation.gestures.Orientation r33, final kotlin.jvm.functions.Function2 r34, final androidx.compose.foundation.layout.PaddingValues r35, final int r36, androidx.compose.ui.Modifier r37, float r38, androidx.compose.foundation.gestures.TargetedFlingBehavior r39, final kotlin.jvm.functions.Function4 r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 708
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.a(androidx.compose.material3.carousel.CarouselState, androidx.compose.foundation.gestures.Orientation, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, int, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final androidx.compose.material3.carousel.CarouselState r24, final float r25, androidx.compose.ui.Modifier r26, float r27, androidx.compose.foundation.gestures.TargetedFlingBehavior r28, float r29, float r30, androidx.compose.foundation.layout.PaddingValues r31, final kotlin.jvm.functions.Function4 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.b(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, float, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final androidx.compose.material3.carousel.CarouselState r21, final float r22, androidx.compose.ui.Modifier r23, float r24, androidx.compose.foundation.gestures.TargetedFlingBehavior r25, androidx.compose.foundation.layout.PaddingValues r26, final kotlin.jvm.functions.Function4 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.CarouselKt.c(androidx.compose.material3.carousel.CarouselState, float, androidx.compose.ui.Modifier, float, androidx.compose.foundation.gestures.TargetedFlingBehavior, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float e(PaddingValues paddingValues, Orientation orientation, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1018496720, i3, -1, "androidx.compose.material3.carousel.calculateAfterContentPadding (Carousel.kt:353)");
        }
        composer.a0(-587616383);
        float fA = orientation == Orientation.f6031a ? paddingValues.a() : PaddingKt.f(paddingValues, (LayoutDirection) composer.q(CompositionLocalsKt.m()));
        composer.U();
        float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(fA);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fM1;
    }

    private static final float f(PaddingValues paddingValues, Orientation orientation, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1896839347, i3, -1, "androidx.compose.material3.carousel.calculateBeforeContentPadding (Carousel.kt:341)");
        }
        composer.a0(295830617);
        float fD = orientation == Orientation.f6031a ? paddingValues.d() : PaddingKt.g(paddingValues, (LayoutDirection) composer.q(CompositionLocalsKt.m()));
        composer.U();
        float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(fD);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return fM1;
    }

    public static final float g(CarouselState carouselState, Strategy strategy) {
        float fE = strategy.e() + strategy.f();
        return ((carouselState.h().v() * fE) + (carouselState.h().w() * fE)) - KeylineSnapPositionKt.b(strategy, carouselState.h().v(), carouselState.h().H());
    }

    public static final float h(CarouselState carouselState, Strategy strategy) {
        float fH = carouselState.h().H();
        return RangesKt.e(((strategy.e() * fH) + (strategy.f() * (fH - 1))) - strategy.b(), 0.0f);
    }

    public static final Modifier i(Modifier modifier, final int i3, final CarouselState carouselState, final Function0 function0, final CarouselItemInfoImpl carouselItemInfoImpl, final Shape shape) {
        return LayoutModifierKt.a(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.carousel.CarouselKt$carouselItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m197invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m197invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
                final Strategy strategy = (Strategy) function0.invoke();
                if (!strategy.j()) {
                    return MeasureScope.B0(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$carouselItem$1.1
                        public final void invoke(Placeable.PlacementScope placementScope) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.f139807a;
                        }
                    }, 4, null);
                }
                final boolean z2 = carouselState.h().C().getOrientation() == Orientation.f6031a;
                final boolean z3 = measureScope.getLayoutDirection() == LayoutDirection.f30002b;
                float fE = strategy.e();
                final Placeable placeableN0 = measurable.n0(z2 ? Constraints.c(j3, Constraints.n(j3), Constraints.l(j3), MathKt.d(fE), MathKt.d(fE)) : Constraints.c(j3, MathKt.d(fE), MathKt.d(fE), Constraints.m(j3), Constraints.k(j3)));
                int iX0 = placeableN0.X0();
                int iO0 = placeableN0.O0();
                final CarouselState carouselState2 = carouselState;
                final int i4 = i3;
                final CarouselItemInfoImpl carouselItemInfoImpl2 = carouselItemInfoImpl;
                final Shape shape2 = shape;
                return MeasureScope.B0(measureScope, iX0, iO0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt$carouselItem$1.2
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
                        Placeable placeable = placeableN0;
                        final CarouselState carouselState3 = carouselState2;
                        final Strategy strategy2 = strategy;
                        final int i5 = i4;
                        final boolean z4 = z2;
                        final CarouselItemInfoImpl carouselItemInfoImpl3 = carouselItemInfoImpl2;
                        final Shape shape3 = shape2;
                        final boolean z5 = z3;
                        Placeable.PlacementScope.w(placementScope, placeable, 0, 0, 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.carousel.CarouselKt.carouselItem.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GraphicsLayerScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                float fG = CarouselKt.g(carouselState3, strategy2);
                                float fH = CarouselKt.h(carouselState3, strategy2);
                                KeylineList keylineListH = Strategy.h(strategy2, fG, fH, false, 4, null);
                                KeylineList keylineListG = strategy2.g(fG, fH, true);
                                float fE2 = ((i5 * (strategy2.e() + strategy2.f())) + (strategy2.e() / 2.0f)) - fG;
                                Keyline keylineO = keylineListH.o(fE2);
                                Keyline keylineN = keylineListH.n(fE2);
                                Keyline keylineD = KeylineListKt.d(keylineO, keylineN, CarouselKt.j(keylineO, keylineN, fE2));
                                boolean zAreEqual = Intrinsics.areEqual(keylineO, keylineN);
                                float fG2 = (z4 ? Size.g(graphicsLayerScope.b()) : strategy2.e()) / 2.0f;
                                float fE3 = (z4 ? strategy2.e() : Size.g(graphicsLayerScope.b())) / 2.0f;
                                float fI = (z4 ? Size.i(graphicsLayerScope.b()) : keylineD.e()) / 2.0f;
                                float fE4 = (z4 ? keylineD.e() : Size.g(graphicsLayerScope.b())) / 2.0f;
                                Rect rect = new Rect(fG2 - fI, fE3 - fE4, fG2 + fI, fE3 + fE4);
                                carouselItemInfoImpl3.f(keylineD.e());
                                CarouselItemInfoImpl carouselItemInfoImpl4 = carouselItemInfoImpl3;
                                Iterator<Keyline> it = keylineListG.iterator();
                                if (!it.hasNext()) {
                                    throw new NoSuchElementException();
                                }
                                Keyline next = it.next();
                                if (it.hasNext()) {
                                    float fE5 = next.e();
                                    do {
                                        Keyline next2 = it.next();
                                        float fE6 = next2.e();
                                        if (Float.compare(fE5, fE6) > 0) {
                                            next = next2;
                                            fE5 = fE6;
                                        }
                                    } while (it.hasNext());
                                }
                                carouselItemInfoImpl4.e(next.e());
                                carouselItemInfoImpl3.d(keylineListG.f().e());
                                carouselItemInfoImpl3.c(rect);
                                graphicsLayerScope.B(!Intrinsics.areEqual(rect, new Rect(0.0f, 0.0f, Size.i(graphicsLayerScope.b()), Size.g(graphicsLayerScope.b()))));
                                graphicsLayerScope.I1(shape3);
                                float fD = keylineD.d() - fE2;
                                if (zAreEqual) {
                                    fD += (fE2 - keylineD.f()) / keylineD.e();
                                }
                                if (z4) {
                                    graphicsLayerScope.d(fD);
                                    return;
                                }
                                if (z5) {
                                    fD = -fD;
                                }
                                graphicsLayerScope.l(fD);
                            }
                        }, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float j(Keyline keyline, Keyline keyline2, float f3) {
        if (Intrinsics.areEqual(keyline, keyline2)) {
            return 1.0f;
        }
        return (f3 - keyline.f()) / (keyline2.f() - keyline.f());
    }
}
