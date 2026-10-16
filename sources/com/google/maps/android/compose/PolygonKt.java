package com.google.maps.android.compose;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class PolygonKt {
    public static final void a(final List points, boolean z2, long j3, boolean z3, List list, long j4, int i3, List list2, float f3, Object obj, boolean z4, float f4, Function1 function1, Composer composer, final int i4, final int i5, final int i6) {
        Function1 function12;
        final float f5;
        Composer composer2;
        Intrinsics.checkNotNullParameter(points, "points");
        Composer composerK = composer.k(-52967640);
        boolean z5 = (i6 & 2) != 0 ? false : z2;
        final long jA = (i6 & 4) != 0 ? Color.f25715b.a() : j3;
        final boolean z6 = (i6 & 8) != 0 ? false : z3;
        final List listEmptyList = (i6 & 16) != 0 ? CollectionsKt.emptyList() : list;
        final long jA2 = (i6 & 32) != 0 ? Color.f25715b.a() : j4;
        final int i7 = (i6 & 64) != 0 ? 0 : i3;
        List list3 = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : list2;
        final float f6 = (i6 & Function.MAX_NARGS) != 0 ? 10.0f : f3;
        Object obj2 = (i6 & 512) == 0 ? obj : null;
        final boolean z7 = (i6 & 1024) != 0 ? true : z4;
        float f7 = (i6 & 2048) != 0 ? 0.0f : f4;
        Function1 function13 = (i6 & 4096) != 0 ? new Function1<Polygon, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$1
            public final void c(Polygon it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                c((Polygon) obj3);
                return Unit.f139807a;
            }
        } : function1;
        if (ComposerKt.M()) {
            function12 = function13;
            f5 = f7;
            composer2 = composerK;
            ComposerKt.U(-52967640, i4, i5, "com.google.maps.android.compose.Polygon (Polygon.kt:55)");
        } else {
            function12 = function13;
            f5 = f7;
            composer2 = composerK;
        }
        final MapApplier mapApplier = (MapApplier) composer2.m();
        final Function1 function14 = function12;
        Composer composer3 = composer2;
        final Object obj3 = obj2;
        final List list4 = list3;
        final boolean z8 = z5;
        final Function0<PolygonNode> function0 = new Function0<PolygonNode>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final PolygonNode invoke() {
                GoogleMap googleMapI;
                MapApplier mapApplier2 = mapApplier;
                if (mapApplier2 != null && (googleMapI = mapApplier2.I()) != null) {
                    List list5 = points;
                    boolean z9 = z8;
                    long j5 = jA;
                    boolean z10 = z6;
                    List list6 = listEmptyList;
                    long j6 = jA2;
                    int i8 = i7;
                    List list7 = list4;
                    float f8 = f6;
                    boolean z11 = z7;
                    float f9 = f5;
                    PolygonOptions polygonOptions = new PolygonOptions();
                    polygonOptions.M(list5);
                    polygonOptions.O(z9);
                    polygonOptions.g0(ColorKt.k(j5));
                    polygonOptions.j0(z10);
                    Iterator it = list6.iterator();
                    while (it.hasNext()) {
                        polygonOptions.N((List) it.next());
                    }
                    polygonOptions.Q2(ColorKt.k(j6));
                    polygonOptions.R2(i8);
                    polygonOptions.S2(list7);
                    polygonOptions.T2(f8);
                    polygonOptions.U2(z11);
                    polygonOptions.V2(f9);
                    Polygon polygonD = googleMapI.d(polygonOptions);
                    Intrinsics.checkNotNullExpressionValue(polygonD, "this.addPolygon(\n       …ons(optionsActions)\n    )");
                    if (polygonD != null) {
                        polygonD.k(obj3);
                        return new PolygonNode(polygonD, function14);
                    }
                }
                throw new IllegalStateException("Error adding polygon");
            }
        };
        final long j5 = jA2;
        final long j6 = jA;
        final List list5 = listEmptyList;
        final int i8 = i7;
        final boolean z9 = z6;
        composer3.F(1886828752);
        if (!(composer3.m() instanceof MapApplier)) {
            ComposablesKt.c();
        }
        composer3.o();
        if (composer3.i()) {
            composer3.P(new Function0<PolygonNode>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon-qT8xWJw$$inlined$ComposeNode$1
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
        Updater.h(composerA, function14, new Function2<PolygonNode, Function1<? super Polygon, ? extends Unit>, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$1
            public final void c(PolygonNode update, Function1 it) {
                Intrinsics.checkNotNullParameter(update, "$this$update");
                Intrinsics.checkNotNullParameter(it, "it");
                update.f(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, (Function1) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, points, new Function2<PolygonNode, List<? extends LatLng>, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$2
            public final void c(PolygonNode set, List it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.e().f(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, (List) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z8), new Function2<PolygonNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$3
            public final void c(PolygonNode set, boolean z10) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().b(z10);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Color.n(j6), new Function2<PolygonNode, Color, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$4
            public final void c(PolygonNode set, long j7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().c(ColorKt.k(j7));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, ((Color) obj5).B());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z9), new Function2<PolygonNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$5
            public final void c(PolygonNode set, boolean z10) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().d(z10);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, list5, new Function2<PolygonNode, List<? extends List<? extends LatLng>>, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$6
            public final void c(PolygonNode set, List it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.e().e(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, (List) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Color.n(j5), new Function2<PolygonNode, Color, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$7
            public final void c(PolygonNode set, long j7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().g(ColorKt.k(j7));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, ((Color) obj5).B());
                return Unit.f139807a;
            }
        });
        PolygonKt$Polygon$3$8 polygonKt$Polygon$3$8 = new Function2<PolygonNode, Integer, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$8
            public final void c(PolygonNode set, int i9) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().h(i9);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, ((Number) obj5).intValue());
                return Unit.f139807a;
            }
        };
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(i8))) {
            composerA.w(Integer.valueOf(i8));
            composerA.p(Integer.valueOf(i8), polygonKt$Polygon$3$8);
        }
        Updater.e(composerA, list4, new Function2<PolygonNode, List<? extends PatternItem>, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$9
            public final void c(PolygonNode set, List list6) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().i(list6);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, (List) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f6), new Function2<PolygonNode, Float, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$10
            public final void c(PolygonNode set, float f8) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().j(f8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, ((Number) obj5).floatValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, obj3, new Function2<PolygonNode, Object, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$11
            public final void c(PolygonNode set, Object obj4) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().k(obj4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z7), new Function2<PolygonNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$12
            public final void c(PolygonNode set, boolean z10) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().l(z10);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f5), new Function2<PolygonNode, Float, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$3$13
            public final void c(PolygonNode set, float f8) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().m(f8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolygonNode) obj4, ((Number) obj5).floatValue());
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
        final float f8 = f6;
        final boolean z10 = z7;
        final float f9 = f5;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.PolygonKt$Polygon$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                invoke((Composer) obj4, ((Number) obj5).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer4, int i9) {
                PolygonKt.a(points, z8, j6, z9, list5, j5, i8, list4, f8, obj3, z10, f9, function14, composer4, i4 | 1, i5, i6);
            }
        });
    }
}
