package com.google.maps.android.compose;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
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
public final class TileOverlayKt {
    public static final void a(final TileProvider tileProvider, TileOverlayState tileOverlayState, boolean z2, float f3, boolean z3, float f4, Function1 function1, Composer composer, int i3, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(tileProvider, "tileProvider");
        Composer composerK = composer.k(-378552693);
        if ((i4 & 2) != 0) {
            tileOverlayState = c(composerK, 0);
        }
        final TileOverlayState tileOverlayState2 = tileOverlayState;
        final boolean z4 = (i4 & 4) != 0 ? true : z2;
        float f5 = (i4 & 8) != 0 ? 0.0f : f3;
        final boolean z5 = (i4 & 16) != 0 ? true : z3;
        float f6 = (i4 & 32) != 0 ? 0.0f : f4;
        final Function1 function12 = (i4 & 64) != 0 ? new Function1<TileOverlay, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$3
            public final void c(TileOverlay it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TileOverlay) obj);
                return Unit.f139807a;
            }
        } : function1;
        if (ComposerKt.M()) {
            i5 = i3;
            ComposerKt.U(-378552693, i5, -1, "com.google.maps.android.compose.TileOverlay (TileOverlay.kt:76)");
        } else {
            i5 = i3;
        }
        final MapApplier mapApplier = (MapApplier) composerK.m();
        final float f7 = f6;
        final float f8 = f5;
        final Function0<TileOverlayNode> function0 = new Function0<TileOverlayNode>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TileOverlayNode invoke() {
                GoogleMap googleMapI;
                MapApplier mapApplier2 = mapApplier;
                if (mapApplier2 != null && (googleMapI = mapApplier2.I()) != null) {
                    TileProvider tileProvider2 = tileProvider;
                    boolean z6 = z4;
                    float f9 = f8;
                    boolean z7 = z5;
                    float f10 = f7;
                    TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
                    tileOverlayOptions.w0(tileProvider2);
                    tileOverlayOptions.M(z6);
                    tileOverlayOptions.z0(f9);
                    tileOverlayOptions.h1(z7);
                    tileOverlayOptions.J2(f10);
                    TileOverlay tileOverlayF = googleMapI.f(tileOverlayOptions);
                    if (tileOverlayF != null) {
                        return new TileOverlayNode(tileOverlayF, tileOverlayState2, function12);
                    }
                }
                throw new IllegalStateException("Error adding tile overlay");
            }
        };
        final Function1 function13 = function12;
        composerK.F(1886828752);
        if (!(composerK.m() instanceof MapApplier)) {
            ComposablesKt.c();
        }
        composerK.o();
        if (composerK.i()) {
            composerK.P(new Function0<TileOverlayNode>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$$inlined$ComposeNode$1
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
        Updater.h(composerA, function13, new Function2<TileOverlayNode, Function1<? super TileOverlay, ? extends Unit>, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$5$1
            public final void c(TileOverlayNode update, Function1 it) {
                Intrinsics.checkNotNullParameter(update, "$this$update");
                Intrinsics.checkNotNullParameter(it, "it");
                update.e(it);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((TileOverlayNode) obj, (Function1) obj2);
                return Unit.f139807a;
            }
        });
        final boolean z6 = z5;
        final boolean z7 = z4;
        Updater.e(composerA, tileProvider, new Function2<TileOverlayNode, TileProvider, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$5$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void c(TileOverlayNode set, TileProvider it) {
                GoogleMap googleMapI;
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.d().a();
                MapApplier mapApplier2 = mapApplier;
                if (mapApplier2 != null && (googleMapI = mapApplier2.I()) != null) {
                    TileProvider tileProvider2 = tileProvider;
                    boolean z8 = z7;
                    float f9 = f8;
                    boolean z9 = z6;
                    float f10 = f7;
                    TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
                    tileOverlayOptions.w0(tileProvider2);
                    tileOverlayOptions.M(z8);
                    tileOverlayOptions.z0(f9);
                    tileOverlayOptions.h1(z9);
                    tileOverlayOptions.J2(f10);
                    Unit unit = Unit.f139807a;
                    TileOverlay tileOverlayF = googleMapI.f(tileOverlayOptions);
                    if (tileOverlayF != null) {
                        set.f(tileOverlayF);
                        return;
                    }
                }
                throw new IllegalStateException("Error adding tile overlay");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((TileOverlayNode) obj, (TileProvider) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z7), new Function2<TileOverlayNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$5$3
            public final void c(TileOverlayNode set, boolean z8) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().b(z8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((TileOverlayNode) obj, ((Boolean) obj2).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f8), new Function2<TileOverlayNode, Float, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$5$4
            public final void c(TileOverlayNode set, float f9) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().c(f9);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((TileOverlayNode) obj, ((Number) obj2).floatValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Boolean.valueOf(z6), new Function2<TileOverlayNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$5$5
            public final void c(TileOverlayNode set, boolean z8) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().d(z8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((TileOverlayNode) obj, ((Boolean) obj2).booleanValue());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Float.valueOf(f7), new Function2<TileOverlayNode, Float, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$5$6
            public final void c(TileOverlayNode set, float f9) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.d().e(f9);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((TileOverlayNode) obj, ((Number) obj2).floatValue());
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
        final int i6 = i5;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i7) {
                TileOverlayKt.a(tileProvider, tileOverlayState2, z7, f8, z6, f7, function13, composer2, i6 | 1, i4);
            }
        });
    }

    public static final /* synthetic */ void b(final TileProvider tileProvider, boolean z2, float f3, boolean z3, float f4, Function1 function1, Composer composer, final int i3, final int i4) {
        Intrinsics.checkNotNullParameter(tileProvider, "tileProvider");
        Composer composerK = composer.k(1712508128);
        boolean z4 = (i4 & 2) != 0 ? true : z2;
        float f5 = (i4 & 4) != 0 ? 0.0f : f3;
        boolean z5 = (i4 & 8) != 0 ? true : z3;
        float f6 = (i4 & 16) != 0 ? 0.0f : f4;
        Function1 function12 = (i4 & 32) != 0 ? new Function1<TileOverlay, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$1
            public final void c(TileOverlay it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TileOverlay) obj);
                return Unit.f139807a;
            }
        } : function1;
        if (ComposerKt.M()) {
            ComposerKt.U(1712508128, i3, -1, "com.google.maps.android.compose.TileOverlay (TileOverlay.kt:43)");
        }
        int i5 = i3 << 3;
        a(tileProvider, c(composerK, 0), z4, f5, z5, f6, function12, composerK, (i5 & 896) | 8 | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (i5 & 3670016), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        final boolean z6 = z4;
        final float f7 = f5;
        final boolean z7 = z5;
        final float f8 = f6;
        final Function1 function13 = function12;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.TileOverlayKt$TileOverlay$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i6) {
                TileOverlayKt.b(tileProvider, z6, f7, z7, f8, function13, composer2, i3 | 1, i4);
            }
        });
    }

    public static final TileOverlayState c(Composer composer, int i3) {
        composer.F(1570127269);
        if (ComposerKt.M()) {
            ComposerKt.U(1570127269, i3, -1, "com.google.maps.android.compose.rememberTileOverlayState (TileOverlay.kt:144)");
        }
        composer.F(-492369756);
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new TileOverlayState();
            composer.w(objG);
        }
        composer.Y();
        TileOverlayState tileOverlayState = (TileOverlayState) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return tileOverlayState;
    }
}
