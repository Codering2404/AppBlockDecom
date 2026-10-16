package androidx.glance.appwidget.lazy;

import android.os.Bundle;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class LazyVerticalGridKt {
    public static final void a(final GridCells gridCells, GlanceModifier glanceModifier, int i3, final Function1 function1, Composer composer, final int i4, final int i5) {
        int i6;
        Composer composerK = composer.k(-2047392247);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i6 = (composerK.Z(gridCells) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i7 = i5 & 2;
        if (i7 != 0) {
            i6 |= 48;
        } else if ((i4 & 112) == 0) {
            i6 |= composerK.Z(glanceModifier) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i6 |= ((i5 & 4) == 0 && composerK.e(i3)) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 8) != 0) {
            i6 |= 3072;
        } else if ((i4 & 7168) == 0) {
            i6 |= composerK.Z(function1) ? 2048 : 1024;
        }
        if ((i6 & 5851) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            composerK.J();
            if ((i4 & 1) == 0 || composerK.S()) {
                if (i7 != 0) {
                    glanceModifier = GlanceModifier.f37605a;
                }
                if ((i5 & 4) != 0) {
                    i3 = Alignment.f39415c.f();
                }
            } else {
                composerK.Q();
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(-2047392247, i4, -1, "androidx.glance.appwidget.lazy.LazyVerticalGrid (LazyVerticalGrid.kt:44)");
            }
            LazyVerticalGridKt$LazyVerticalGrid$1 lazyVerticalGridKt$LazyVerticalGrid$1 = LazyVerticalGridKt$LazyVerticalGrid$1.f38641a;
            Function2 function2E = e(new Alignment(i3, Alignment.Vertical.f39439b.b(), null), function1);
            composerK.F(578571862);
            composerK.F(-548224868);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(lazyVerticalGridKt$LazyVerticalGrid$1);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, gridCells, new Function2<EmittableLazyVerticalGrid, GridCells, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$2$1
                public final void c(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GridCells gridCells2) {
                    emittableLazyVerticalGrid.l(gridCells2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLazyVerticalGrid) obj, (GridCells) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, glanceModifier, new Function2<EmittableLazyVerticalGrid, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$2$2
                public final void c(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GlanceModifier glanceModifier2) {
                    emittableLazyVerticalGrid.b(glanceModifier2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLazyVerticalGrid) obj, (GlanceModifier) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, Alignment.Horizontal.d(i3), new Function2<EmittableLazyVerticalGrid, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$2$3
                public final void c(EmittableLazyVerticalGrid emittableLazyVerticalGrid, int i8) {
                    emittableLazyVerticalGrid.m(i8);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLazyVerticalGrid) obj, ((Alignment.Horizontal) obj2).j());
                    return Unit.f139807a;
                }
            });
            function2E.invoke(composerK, 0);
            composerK.y();
            composerK.Y();
            composerK.Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final int i8 = i3;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i9) {
                LazyVerticalGridKt.a(gridCells, glanceModifier2, i8, function1, composer2, i4 | 1, i5);
            }
        });
    }

    public static final void b(final GridCells gridCells, final Bundle bundle, GlanceModifier glanceModifier, int i3, final Function1 function1, Composer composer, int i4, final int i5) {
        final int i6;
        Composer composerK = composer.k(2103725789);
        if ((i5 & 4) != 0) {
            glanceModifier = GlanceModifier.f37605a;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if ((i5 & 8) != 0) {
            i3 = Alignment.f39415c.f();
        }
        final int i7 = i3;
        if (ComposerKt.M()) {
            i6 = i4;
            ComposerKt.U(2103725789, i6, -1, "androidx.glance.appwidget.lazy.LazyVerticalGrid (LazyVerticalGrid.kt:79)");
        } else {
            i6 = i4;
        }
        LazyVerticalGridKt$LazyVerticalGrid$4 lazyVerticalGridKt$LazyVerticalGrid$4 = LazyVerticalGridKt$LazyVerticalGrid$4.f38651a;
        Function2 function2E = e(new Alignment(i7, Alignment.Vertical.f39439b.b(), null), function1);
        composerK.F(578571862);
        composerK.F(-548224868);
        if (!(composerK.m() instanceof Applier)) {
            ComposablesKt.c();
        }
        composerK.o();
        if (composerK.i()) {
            composerK.P(lazyVerticalGridKt$LazyVerticalGrid$4);
        } else {
            composerK.v();
        }
        Composer composerA = Updater.a(composerK);
        Updater.e(composerA, gridCells, new Function2<EmittableLazyVerticalGrid, GridCells, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$5$1
            public final void c(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GridCells gridCells2) {
                emittableLazyVerticalGrid.l(gridCells2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableLazyVerticalGrid) obj, (GridCells) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, glanceModifier2, new Function2<EmittableLazyVerticalGrid, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$5$2
            public final void c(EmittableLazyVerticalGrid emittableLazyVerticalGrid, GlanceModifier glanceModifier3) {
                emittableLazyVerticalGrid.b(glanceModifier3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableLazyVerticalGrid) obj, (GlanceModifier) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Alignment.Horizontal.d(i7), new Function2<EmittableLazyVerticalGrid, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$5$3
            public final void c(EmittableLazyVerticalGrid emittableLazyVerticalGrid, int i8) {
                emittableLazyVerticalGrid.m(i8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableLazyVerticalGrid) obj, ((Alignment.Horizontal) obj2).j());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, bundle, new Function2<EmittableLazyVerticalGrid, Bundle, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$5$4
            public final void c(EmittableLazyVerticalGrid emittableLazyVerticalGrid, Bundle bundle2) {
                emittableLazyVerticalGrid.k(bundle2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableLazyVerticalGrid) obj, (Bundle) obj2);
                return Unit.f139807a;
            }
        });
        function2E.invoke(composerK, 0);
        composerK.y();
        composerK.Y();
        composerK.Y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGrid$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i8) {
                LazyVerticalGridKt.b(gridCells, bundle, glanceModifier2, i7, function1, composer2, i6 | 1, i5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final long j3, final Alignment alignment, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(982284890);
        if ((i3 & 14) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 112) == 0) {
            i4 |= composerK.Z(alignment) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i4 |= composerK.Z(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 731) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(982284890, i4, -1, "androidx.glance.appwidget.lazy.LazyVerticalGridItem (LazyVerticalGrid.kt:144)");
            }
            composerK.K(-250207478, Long.valueOf(j3));
            LazyVerticalGridKt$LazyVerticalGridItem$1 lazyVerticalGridKt$LazyVerticalGridItem$1 = LazyVerticalGridKt$LazyVerticalGridItem$1.f38663a;
            composerK.F(578571862);
            int i5 = i4 & 896;
            composerK.F(-548224868);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(lazyVerticalGridKt$LazyVerticalGridItem$1);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, Long.valueOf(j3), new Function2<EmittableLazyVerticalGridListItem, Long, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGridItem$2$1
                public final void c(EmittableLazyVerticalGridListItem emittableLazyVerticalGridListItem, long j4) {
                    emittableLazyVerticalGridListItem.k(j4);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLazyVerticalGridListItem) obj, ((Number) obj2).longValue());
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, alignment, new Function2<EmittableLazyVerticalGridListItem, Alignment, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGridItem$2$2
                public final void c(EmittableLazyVerticalGridListItem emittableLazyVerticalGridListItem, Alignment alignment2) {
                    emittableLazyVerticalGridListItem.i(alignment2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLazyVerticalGridListItem) obj, (Alignment) obj2);
                    return Unit.f139807a;
                }
            });
            function2.invoke(composerK, Integer.valueOf((i5 >> 6) & 14));
            composerK.y();
            composerK.Y();
            composerK.Y();
            composerK.X();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$LazyVerticalGridItem$3
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
                LazyVerticalGridKt.c(j3, alignment, function2, composer2, i3 | 1);
            }
        });
    }

    public static final Function2 e(final Alignment alignment, Function1 function1) {
        final ArrayList arrayList = new ArrayList();
        function1.invoke(new LazyVerticalGridScope() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$applyVerticalGridScope$listScopeImpl$1
        });
        return ComposableLambdaKt.c(-628089649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$applyVerticalGridScope$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i3) {
                if ((i3 & 11) == 2 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-628089649, i3, -1, "androidx.glance.appwidget.lazy.applyVerticalGridScope.<anonymous> (LazyVerticalGrid.kt:129)");
                }
                List list = arrayList;
                Alignment alignment2 = alignment;
                int i4 = 0;
                for (Object obj : list) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Pair pair = (Pair) obj;
                    Long l3 = (Long) pair.a();
                    final Function3 function3 = (Function3) pair.b();
                    if (l3 != null && l3.longValue() == Long.MIN_VALUE) {
                        l3 = null;
                    }
                    long jLongValue = l3 != null ? l3.longValue() : (-4611686018427387904L) - ((long) i4);
                    if (jLongValue == Long.MIN_VALUE) {
                        throw new IllegalStateException("Implicit list item ids exhausted.");
                    }
                    LazyVerticalGridKt.c(jLongValue, alignment2, ComposableLambdaKt.b(composer, -1015790400, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$applyVerticalGridScope$1$1$2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((Composer) obj2, ((Number) obj3).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            if ((i6 & 11) == 2 && composer2.l()) {
                                composer2.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(-1015790400, i6, -1, "androidx.glance.appwidget.lazy.applyVerticalGridScope.<anonymous>.<anonymous>.<anonymous> (LazyVerticalGrid.kt:136)");
                            }
                            function3.invoke(new LazyItemScope() { // from class: androidx.glance.appwidget.lazy.LazyVerticalGridKt$applyVerticalGridScope$1$1$2.1
                            }, composer2, 0);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }), composer, (Alignment.f39416d << 3) | 384);
                    i4 = i5;
                }
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        });
    }
}
