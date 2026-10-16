package com.google.maps.android.compose;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.ButtCap;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
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
public final class PolylineKt {
    public static final void a(final List points, boolean z2, long j3, Cap cap, boolean z3, int i3, List list, Cap cap2, Object obj, boolean z4, float f3, float f4, Function1 function1, Composer composer, final int i4, final int i5, final int i6) {
        Function1 function12;
        Composer composer2;
        Intrinsics.checkNotNullParameter(points, "points");
        Composer composerK = composer.k(-2113937603);
        boolean z5 = (i6 & 2) != 0 ? false : z2;
        final long jA = (i6 & 4) != 0 ? Color.f25715b.a() : j3;
        final Cap buttCap = (i6 & 8) != 0 ? new ButtCap() : cap;
        final boolean z6 = (i6 & 16) != 0 ? false : z3;
        final int i7 = (i6 & 32) != 0 ? 0 : i3;
        List list2 = (i6 & 64) != 0 ? null : list;
        final Cap buttCap2 = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new ButtCap() : cap2;
        Object obj2 = (i6 & Function.MAX_NARGS) == 0 ? obj : null;
        final boolean z7 = (i6 & 512) != 0 ? true : z4;
        final float f5 = (i6 & 1024) != 0 ? 10.0f : f3;
        final float f6 = (i6 & 2048) != 0 ? 0.0f : f4;
        Function1 function13 = (i6 & 4096) != 0 ? new Function1<Polyline, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$1
            public final void c(Polyline it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                c((Polyline) obj3);
                return Unit.f139807a;
            }
        } : function1;
        if (ComposerKt.M()) {
            function12 = function13;
            composer2 = composerK;
            ComposerKt.U(-2113937603, i4, i5, "com.google.maps.android.compose.Polyline (Polyline.kt:57)");
        } else {
            function12 = function13;
            composer2 = composerK;
        }
        final MapApplier mapApplier = (MapApplier) composer2.m();
        final Function1 function14 = function12;
        Composer composer3 = composer2;
        final Object obj3 = obj2;
        final List list3 = list2;
        final boolean z8 = z5;
        final Function0<PolylineNode> function0 = new Function0<PolylineNode>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final PolylineNode invoke() {
                GoogleMap googleMapI;
                MapApplier mapApplier2 = mapApplier;
                if (mapApplier2 != null && (googleMapI = mapApplier2.I()) != null) {
                    List list4 = points;
                    boolean z9 = z8;
                    long j4 = jA;
                    Cap cap3 = buttCap;
                    boolean z10 = z6;
                    int i8 = i7;
                    List list5 = list3;
                    Cap cap4 = buttCap2;
                    boolean z11 = z7;
                    float f7 = f5;
                    float f8 = f6;
                    PolylineOptions polylineOptions = new PolylineOptions();
                    polylineOptions.M(list4);
                    polylineOptions.N(z9);
                    polylineOptions.O(ColorKt.k(j4));
                    polylineOptions.g0(cap3);
                    polylineOptions.j0(z10);
                    polylineOptions.R2(i8);
                    polylineOptions.S2(list5);
                    polylineOptions.T2(cap4);
                    polylineOptions.U2(z11);
                    polylineOptions.V2(f7);
                    polylineOptions.W2(f8);
                    Polyline polylineE = googleMapI.e(polylineOptions);
                    Intrinsics.checkNotNullExpressionValue(polylineE, "this.addPolyline(\n      …ons(optionsActions)\n    )");
                    if (polylineE != null) {
                        polylineE.j(obj3);
                        return new PolylineNode(polylineE, function14);
                    }
                }
                throw new IllegalStateException("Error adding Polyline");
            }
        };
        final Cap cap3 = buttCap2;
        final long j4 = jA;
        final boolean z9 = z6;
        final int i8 = i7;
        final Cap cap4 = buttCap;
        final boolean z10 = z7;
        composer3.F(1886828752);
        if (!(composer3.m() instanceof MapApplier)) {
            ComposablesKt.c();
        }
        composer3.o();
        if (composer3.i()) {
            composer3.P(new Function0<PolylineNode>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline-Ut8lOTo$$inlined$ComposeNode$1
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
        Updater.h(composerA, function14, new Function2<PolylineNode, Function1<? super Polyline, ? extends Unit>, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$1
            public final void c(PolylineNode update, Function1 it) {
                Intrinsics.checkNotNullParameter(update, "$this$update");
                Intrinsics.checkNotNullParameter(it, "it");
                update.f(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, (Function1) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, points, new Function2<PolylineNode, List<? extends LatLng>, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$2
            public final void c(PolylineNode set, List it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.e().h(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, (List) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z8), new Function2<PolylineNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$3
            public final void c(PolylineNode set, boolean z11) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().b(z11);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Color.n(j4), new Function2<PolylineNode, Color, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$4
            public final void c(PolylineNode set, long j5) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().c(ColorKt.k(j5));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, ((Color) obj5).B());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, cap4, new Function2<PolylineNode, Cap, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$5
            public final void c(PolylineNode set, Cap it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.e().d(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, (Cap) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z9), new Function2<PolylineNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$6
            public final void c(PolylineNode set, boolean z11) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().e(z11);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        PolylineKt$Polyline$3$7 polylineKt$Polyline$3$7 = new Function2<PolylineNode, Integer, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$7
            public final void c(PolylineNode set, int i9) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().f(i9);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, ((Number) obj5).intValue());
                return Unit.f139807a;
            }
        };
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(i8))) {
            composerA.w(Integer.valueOf(i8));
            composerA.p(Integer.valueOf(i8), polylineKt$Polyline$3$7);
        }
        Updater.e(composerA, list3, new Function2<PolylineNode, List<? extends PatternItem>, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$8
            public final void c(PolylineNode set, List list4) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().g(list4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, (List) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, cap3, new Function2<PolylineNode, Cap, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$9
            public final void c(PolylineNode set, Cap it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.e().i(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, (Cap) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, obj3, new Function2<PolylineNode, Object, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$10
            public final void c(PolylineNode set, Object obj4) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().j(obj4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z10), new Function2<PolylineNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$11
            public final void c(PolylineNode set, boolean z11) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().k(z11);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f5), new Function2<PolylineNode, Float, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$12
            public final void c(PolylineNode set, float f7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().l(f7);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, ((Number) obj5).floatValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f6), new Function2<PolylineNode, Float, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$3$13
            public final void c(PolylineNode set, float f7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.e().m(f7);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((PolylineNode) obj4, ((Number) obj5).floatValue());
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
        final float f7 = f5;
        final float f8 = f6;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.PolylineKt$Polyline$4
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
                PolylineKt.a(points, z8, j4, cap4, z9, i8, list3, cap3, obj3, z10, f7, f8, function14, composer4, i4 | 1, i5, i6);
            }
        });
    }
}
