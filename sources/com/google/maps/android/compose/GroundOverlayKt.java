package com.google.maps.android.compose;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class GroundOverlayKt {
    public static final void a(final GroundOverlayPosition position, final BitmapDescriptor image, long j3, float f3, boolean z2, Object obj, float f4, boolean z3, float f5, Function1 function1, Composer composer, int i3, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(image, "image");
        Composer composerK = composer.k(199851106);
        long jA = (i4 & 4) != 0 ? OffsetKt.a(0.5f, 0.5f) : j3;
        final float f6 = (i4 & 8) != 0 ? 0.0f : f3;
        final boolean z4 = (i4 & 16) != 0 ? false : z2;
        Object obj2 = (i4 & 32) != 0 ? null : obj;
        final float f7 = (i4 & 64) != 0 ? 0.0f : f4;
        final boolean z5 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? true : z3;
        final float f8 = (i4 & Function.MAX_NARGS) != 0 ? 0.0f : f5;
        Function1 function12 = (i4 & 512) != 0 ? new Function1<GroundOverlay, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$1
            public final void c(GroundOverlay it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                c((GroundOverlay) obj3);
                return Unit.f139807a;
            }
        } : function1;
        if (ComposerKt.M()) {
            i5 = i3;
            ComposerKt.U(199851106, i5, -1, "com.google.maps.android.compose.GroundOverlay (GroundOverlay.kt:79)");
        } else {
            i5 = i3;
        }
        Applier applierM = composerK.m();
        final Object obj3 = obj2;
        final MapApplier mapApplier = applierM instanceof MapApplier ? (MapApplier) applierM : null;
        final long j4 = jA;
        final Function1 function13 = function12;
        final Function0<GroundOverlayNode> function0 = new Function0<GroundOverlayNode>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final GroundOverlayNode invoke() {
                GoogleMap googleMapI;
                MapApplier mapApplier2 = mapApplier;
                if (mapApplier2 != null && (googleMapI = mapApplier2.I()) != null) {
                    long j5 = j4;
                    float f9 = f6;
                    boolean z6 = z4;
                    BitmapDescriptor bitmapDescriptor = image;
                    GroundOverlayPosition groundOverlayPosition = position;
                    float f10 = f7;
                    boolean z7 = z5;
                    float f11 = f8;
                    GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
                    groundOverlayOptions.M(Offset.m(j5), Offset.n(j5));
                    groundOverlayOptions.N(f9);
                    groundOverlayOptions.O(z6);
                    groundOverlayOptions.N2(bitmapDescriptor);
                    GroundOverlayKt.d(groundOverlayOptions, groundOverlayPosition);
                    groundOverlayOptions.T2(f10);
                    groundOverlayOptions.U2(z7);
                    groundOverlayOptions.V2(f11);
                    GroundOverlay groundOverlayB = googleMapI.b(groundOverlayOptions);
                    if (groundOverlayB != null) {
                        groundOverlayB.i(obj3);
                        return new GroundOverlayNode(groundOverlayB, function13);
                    }
                }
                throw new IllegalStateException("Error adding ground overlay");
            }
        };
        final float f9 = f6;
        final boolean z6 = z4;
        final float f10 = f7;
        final float f11 = f8;
        composerK.F(1886828752);
        if (!(composerK.m() instanceof MapApplier)) {
            ComposablesKt.c();
        }
        composerK.o();
        if (composerK.i()) {
            composerK.P(new Function0<GroundOverlayNode>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay-bPm4XcI$$inlined$ComposeNode$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return function0.invoke();
                }
            });
        } else {
            composerK.v();
        }
        Composer composerA = Updater.a(composerK);
        Updater.h(composerA, function13, new Function2<GroundOverlayNode, Function1<? super GroundOverlay, ? extends Unit>, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$3$1
            public final void c(GroundOverlayNode update, Function1 it) {
                Intrinsics.checkNotNullParameter(update, "$this$update");
                Intrinsics.checkNotNullParameter(it, "it");
                update.f(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((GroundOverlayNode) obj4, (Function1) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f9), new Function2<GroundOverlayNode, Float, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$3$2
            public final void c(GroundOverlayNode set, float f12) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().b(f12);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((GroundOverlayNode) obj4, ((Number) obj5).floatValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z6), new Function2<GroundOverlayNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$3$3
            public final void c(GroundOverlayNode set, boolean z7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().c(z7);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((GroundOverlayNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, image, new Function2<GroundOverlayNode, BitmapDescriptor, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$3$4
            public final void c(GroundOverlayNode set, BitmapDescriptor it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.d().f(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((GroundOverlayNode) obj4, (BitmapDescriptor) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, position, new Function2<GroundOverlayNode, GroundOverlayPosition, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$3$5
            public final void c(GroundOverlayNode set, GroundOverlayPosition it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                GroundOverlayKt.e(set.d(), it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((GroundOverlayNode) obj4, (GroundOverlayPosition) obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, obj3, new Function2<GroundOverlayNode, Object, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$3$6
            public final void c(GroundOverlayNode set, Object obj4) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().i(obj4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((GroundOverlayNode) obj4, obj5);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f10), new Function2<GroundOverlayNode, Float, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$3$7
            public final void c(GroundOverlayNode set, float f12) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().j(f12);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((GroundOverlayNode) obj4, ((Number) obj5).floatValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z5), new Function2<GroundOverlayNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$3$8
            public final void c(GroundOverlayNode set, boolean z7) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().k(z7);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((GroundOverlayNode) obj4, ((Boolean) obj5).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f11), new Function2<GroundOverlayNode, Float, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$3$9
            public final void c(GroundOverlayNode set, float f12) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().l(f12);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                c((GroundOverlayNode) obj4, ((Number) obj5).floatValue());
                return Unit.f139807a;
            }
        });
        composerK.y();
        composerK.Y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        final boolean z7 = z5;
        final int i6 = i5;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.GroundOverlayKt$GroundOverlay$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5) {
                invoke((Composer) obj4, ((Number) obj5).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i7) {
                GroundOverlayKt.a(position, image, j4, f9, z6, obj3, f10, z7, f11, function13, composer2, i6 | 1, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroundOverlayOptions d(GroundOverlayOptions groundOverlayOptions, GroundOverlayPosition groundOverlayPosition) {
        if (groundOverlayPosition.b() != null) {
            GroundOverlayOptions groundOverlayOptionsS2 = groundOverlayOptions.S2(groundOverlayPosition.b());
            Intrinsics.checkNotNullExpressionValue(groundOverlayOptionsS2, "positionFromBounds(position.latLngBounds)");
            return groundOverlayOptionsS2;
        }
        if (groundOverlayPosition.c() == null || groundOverlayPosition.d() == null) {
            throw new IllegalStateException("Invalid position " + groundOverlayPosition);
        }
        if (groundOverlayPosition.a() == null) {
            GroundOverlayOptions groundOverlayOptionsQ2 = groundOverlayOptions.Q2(groundOverlayPosition.c(), groundOverlayPosition.d().floatValue());
            Intrinsics.checkNotNullExpressionValue(groundOverlayOptionsQ2, "position(position.location, position.width)");
            return groundOverlayOptionsQ2;
        }
        GroundOverlayOptions groundOverlayOptionsR2 = groundOverlayOptions.R2(groundOverlayPosition.c(), groundOverlayPosition.d().floatValue(), groundOverlayPosition.a().floatValue());
        Intrinsics.checkNotNullExpressionValue(groundOverlayOptionsR2, "position(position.locati…n.width, position.height)");
        return groundOverlayOptionsR2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GroundOverlay groundOverlay, GroundOverlayPosition groundOverlayPosition) {
        if (groundOverlayPosition.b() != null) {
            groundOverlay.h(groundOverlayPosition.b());
            return;
        }
        if (groundOverlayPosition.c() != null) {
            groundOverlay.g(groundOverlayPosition.c());
        }
        if (groundOverlayPosition.d() != null && groundOverlayPosition.a() == null) {
            groundOverlay.d(groundOverlayPosition.d().floatValue());
        } else {
            if (groundOverlayPosition.d() == null || groundOverlayPosition.a() == null) {
                return;
            }
            groundOverlay.e(groundOverlayPosition.d().floatValue(), groundOverlayPosition.a().floatValue());
        }
    }
}
