package com.google.maps.android.compose;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class CircleKt {
    public static final void a(final LatLng center, boolean z2, long j3, double d3, long j4, List list, float f3, Object obj, boolean z3, float f4, Function1 function1, Composer composer, final int i3, final int i4, final int i5) {
        Function1 function12;
        Composer composer2;
        Intrinsics.checkNotNullParameter(center, "center");
        Composer composerK = composer.k(139485030);
        final boolean z4 = (i5 & 2) != 0 ? false : z2;
        final long j5 = (i5 & 4) != 0 ? Color.f25715b.j() : j3;
        final double d4 = (i5 & 8) != 0 ? 0.0d : d3;
        final long jA = (i5 & 16) != 0 ? Color.f25715b.a() : j4;
        List list2 = (i5 & 32) != 0 ? null : list;
        final float f5 = (i5 & 64) != 0 ? 10.0f : f3;
        Object obj2 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : obj;
        boolean z5 = (i5 & Function.MAX_NARGS) != 0 ? true : z3;
        float f6 = (i5 & 512) != 0 ? 0.0f : f4;
        Function1 function13 = (i5 & 1024) != 0 ? new Function1<Circle, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$1
            public final void c(Circle it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                c((Circle) obj3);
                return Unit.f139807a;
            }
        } : function1;
        if (ComposerKt.M()) {
            function12 = function13;
            composer2 = composerK;
            ComposerKt.U(139485030, i3, i4, "com.google.maps.android.compose.Circle (Circle.kt:53)");
        } else {
            function12 = function13;
            composer2 = composerK;
        }
        Applier applierM = composer2.m();
        Composer composer3 = composer2;
        final MapApplier mapApplier = applierM instanceof MapApplier ? (MapApplier) applierM : null;
        final Object obj3 = obj2;
        final boolean z6 = z5;
        final Function1 function14 = function12;
        final float f7 = f6;
        final List list3 = list2;
        final Function0<CircleNode> function0 = new Function0<CircleNode>() { // from class: com.google.maps.android.compose.CircleKt$Circle$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CircleNode invoke() {
                GoogleMap googleMapI;
                MapApplier mapApplier2 = mapApplier;
                if (mapApplier2 != null && (googleMapI = mapApplier2.I()) != null) {
                    LatLng latLng = center;
                    boolean z7 = z4;
                    long j6 = j5;
                    double d5 = d4;
                    long j7 = jA;
                    List list4 = list3;
                    float f8 = f5;
                    boolean z8 = z6;
                    float f9 = f7;
                    CircleOptions circleOptions = new CircleOptions();
                    circleOptions.M(latLng);
                    circleOptions.N(z7);
                    circleOptions.O(ColorKt.k(j6));
                    circleOptions.N2(d5);
                    circleOptions.O2(ColorKt.k(j7));
                    circleOptions.P2(list4);
                    circleOptions.Q2(f8);
                    circleOptions.R2(z8);
                    circleOptions.S2(f9);
                    Circle circleA = googleMapI.a(circleOptions);
                    Intrinsics.checkNotNullExpressionValue(circleA, "this.addCircle(\n        …ons(optionsActions)\n    )");
                    if (circleA != null) {
                        circleA.i(obj3);
                        return new CircleNode(circleA, function14);
                    }
                }
                throw new IllegalStateException("Error adding circle");
            }
        };
        final long j6 = j5;
        final long j7 = jA;
        final boolean z7 = z4;
        final double d5 = d4;
        final float f8 = f5;
        composer3.F(1886828752);
        if (!(composer3.m() instanceof MapApplier)) {
            ComposablesKt.c();
        }
        composer3.o();
        if (composer3.i()) {
            composer3.P(new Function0<CircleNode>() { // from class: com.google.maps.android.compose.CircleKt$Circle-rQ_Q3OA$$inlined$ComposeNode$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return function0.invoke();
                }
            });
        } else {
            composer3.v();
        }
        Composer composerA = Updater.a(composer3);
        Updater.h(composerA, function14, new Function2<CircleNode, Function1<? super Circle, ? extends Unit>, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$1
            public final void c(CircleNode update, Function1 it) {
                Intrinsics.checkNotNullParameter(update, "$this$update");
                Intrinsics.checkNotNullParameter(it, "it");
                update.f(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, (Function1) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, center, new Function2<CircleNode, LatLng, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$2
            public final void c(CircleNode set, LatLng it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.d().b(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, (LatLng) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z7), new Function2<CircleNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$3
            public final void c(CircleNode set, boolean z8) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().c(z8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Color.n(j6), new Function2<CircleNode, Color, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$4
            public final void c(CircleNode set, long j8) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().d(ColorKt.k(j8));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, ((Color) obj5).B());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Double.valueOf(d5), new Function2<CircleNode, Double, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$5
            public final void c(CircleNode set, double d6) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().e(d6);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, ((Number) obj5).doubleValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Color.n(j7), new Function2<CircleNode, Color, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$6
            public final void c(CircleNode set, long j8) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().f(ColorKt.k(j8));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, ((Color) obj5).B());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, list3, new Function2<CircleNode, List<? extends PatternItem>, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$7
            public final void c(CircleNode set, List list4) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().g(list4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, (List) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f8), new Function2<CircleNode, Float, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$8
            public final void c(CircleNode set, float f9) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().h(f9);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, ((Number) obj5).floatValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, obj3, new Function2<CircleNode, Object, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$9
            public final void c(CircleNode set, Object obj4) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().i(obj4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z6), new Function2<CircleNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$10
            public final void c(CircleNode set, boolean z8) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().j(z8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f7), new Function2<CircleNode, Float, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$3$11
            public final void c(CircleNode set, float f9) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().k(f9);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((CircleNode) obj4, ((Number) obj5).floatValue());
                return Unit.f139807a;
            }
        });
        composer3.y();
        composer3.Y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer3.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.CircleKt$Circle$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                invoke((Composer) obj4, ((Number) obj5).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer4, int i6) {
                CircleKt.a(center, z7, j6, d5, j7, list3, f8, obj3, z6, f7, function14, composer4, i3 | 1, i4, i5);
            }
        });
    }
}
