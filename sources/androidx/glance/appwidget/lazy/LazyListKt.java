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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

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
public final class LazyListKt {
    public static final void a(GlanceModifier glanceModifier, int i3, final Function1 function1, Composer composer, final int i4, final int i5) {
        int i6;
        Composer composerK = composer.k(1060451148);
        int i7 = i5 & 1;
        if (i7 != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i6 = (composerK.Z(glanceModifier) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 112) == 0) {
            i6 |= ((i5 & 2) == 0 && composerK.e(i3)) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            i6 |= 384;
        } else if ((i4 & 896) == 0) {
            i6 |= composerK.Z(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i6 & 731) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            composerK.J();
            if ((i4 & 1) == 0 || composerK.S()) {
                if (i7 != 0) {
                    glanceModifier = GlanceModifier.f37605a;
                }
                if ((i5 & 2) != 0) {
                    i3 = Alignment.f39415c.f();
                }
            } else {
                composerK.Q();
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(1060451148, i4, -1, "androidx.glance.appwidget.lazy.LazyColumn (LazyList.kt:43)");
            }
            LazyListKt$LazyColumn$1 lazyListKt$LazyColumn$1 = LazyListKt$LazyColumn$1.f38587a;
            Function2 function2E = e(new Alignment(i3, Alignment.Vertical.f39439b.b(), null), function1);
            composerK.F(578571862);
            composerK.F(-548224868);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(lazyListKt$LazyColumn$1);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, glanceModifier, new Function2<EmittableLazyColumn, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$2$1
                public final void c(EmittableLazyColumn emittableLazyColumn, GlanceModifier glanceModifier2) {
                    emittableLazyColumn.b(glanceModifier2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLazyColumn) obj, (GlanceModifier) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, Alignment.Horizontal.d(i3), new Function2<EmittableLazyColumn, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$2$2
                public final void c(EmittableLazyColumn emittableLazyColumn, int i8) {
                    emittableLazyColumn.k(i8);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLazyColumn) obj, ((Alignment.Horizontal) obj2).j());
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
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$3
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
                LazyListKt.a(glanceModifier2, i8, function1, composer2, i4 | 1, i5);
            }
        });
    }

    public static final void b(final Bundle bundle, GlanceModifier glanceModifier, int i3, final Function1 function1, Composer composer, final int i4, final int i5) {
        Composer composerK = composer.k(828768758);
        if ((i5 & 2) != 0) {
            glanceModifier = GlanceModifier.f37605a;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if ((i5 & 4) != 0) {
            i3 = Alignment.f39415c.f();
        }
        final int i6 = i3;
        if (ComposerKt.M()) {
            ComposerKt.U(828768758, i4, -1, "androidx.glance.appwidget.lazy.LazyColumn (LazyList.kt:75)");
        }
        LazyListKt$LazyColumn$4 lazyListKt$LazyColumn$4 = LazyListKt$LazyColumn$4.f38595a;
        Function2 function2E = e(new Alignment(i6, Alignment.Vertical.f39439b.b(), null), function1);
        composerK.F(578571862);
        composerK.F(-548224868);
        if (!(composerK.m() instanceof Applier)) {
            ComposablesKt.c();
        }
        composerK.o();
        if (composerK.i()) {
            composerK.P(lazyListKt$LazyColumn$4);
        } else {
            composerK.v();
        }
        Composer composerA = Updater.a(composerK);
        Updater.e(composerA, glanceModifier2, new Function2<EmittableLazyColumn, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$5$1
            public final void c(EmittableLazyColumn emittableLazyColumn, GlanceModifier glanceModifier3) {
                emittableLazyColumn.b(glanceModifier3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableLazyColumn) obj, (GlanceModifier) obj2);
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, Alignment.Horizontal.d(i6), new Function2<EmittableLazyColumn, Alignment.Horizontal, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$5$2
            public final void c(EmittableLazyColumn emittableLazyColumn, int i7) {
                emittableLazyColumn.k(i7);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableLazyColumn) obj, ((Alignment.Horizontal) obj2).j());
                return Unit.f139807a;
            }
        });
        Updater.e(composerA, bundle, new Function2<EmittableLazyColumn, Bundle, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$5$3
            public final void c(EmittableLazyColumn emittableLazyColumn, Bundle bundle2) {
                emittableLazyColumn.j(bundle2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableLazyColumn) obj, (Bundle) obj2);
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
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyColumn$6
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
                LazyListKt.b(bundle, glanceModifier2, i6, function1, composer2, i4 | 1, i5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final long j3, final Alignment alignment, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-2015416678);
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
                ComposerKt.U(-2015416678, i4, -1, "androidx.glance.appwidget.lazy.LazyListItem (LazyList.kt:135)");
            }
            composerK.K(-1488189941, Long.valueOf(j3));
            LazyListKt$LazyListItem$1 lazyListKt$LazyListItem$1 = LazyListKt$LazyListItem$1.f38605a;
            composerK.F(578571862);
            int i5 = i4 & 896;
            composerK.F(-548224868);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(lazyListKt$LazyListItem$1);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, Long.valueOf(j3), new Function2<EmittableLazyListItem, Long, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyListItem$2$1
                public final void c(EmittableLazyListItem emittableLazyListItem, long j4) {
                    emittableLazyListItem.k(j4);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLazyListItem) obj, ((Number) obj2).longValue());
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, alignment, new Function2<EmittableLazyListItem, Alignment, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyListItem$2$2
                public final void c(EmittableLazyListItem emittableLazyListItem, Alignment alignment2) {
                    emittableLazyListItem.i(alignment2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLazyListItem) obj, (Alignment) obj2);
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
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$LazyListItem$3
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
                LazyListKt.c(j3, alignment, function2, composer2, i3 | 1);
            }
        });
    }

    private static final Function2 e(final Alignment alignment, Function1 function1) {
        final ArrayList arrayList = new ArrayList();
        function1.invoke(new LazyListScope() { // from class: androidx.glance.appwidget.lazy.LazyListKt$applyListScope$listScopeImpl$1
            @Override // androidx.glance.appwidget.lazy.LazyListScope
            public void a(int i3, Function1 function12, final Function4 function4) {
                for (final int i4 = 0; i4 < i3; i4++) {
                    c(((Number) function12.invoke(Integer.valueOf(i4))).longValue(), ComposableLambdaKt.c(19676320, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$applyListScope$listScopeImpl$1$items$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public final void c(LazyItemScope lazyItemScope, Composer composer, int i5) {
                            if ((i5 & 14) == 0) {
                                i5 |= composer.Z(lazyItemScope) ? 4 : 2;
                            }
                            if ((i5 & 91) == 18 && composer.l()) {
                                composer.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(19676320, i5, -1, "androidx.glance.appwidget.lazy.applyListScope.<no name provided>.items.<anonymous>.<anonymous> (LazyList.kt:117)");
                            }
                            function4.invoke(lazyItemScope, Integer.valueOf(i4), composer, Integer.valueOf(i5 & 14));
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            c((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.f139807a;
                        }
                    }));
                }
            }

            @Override // androidx.glance.appwidget.lazy.LazyListScope
            public void c(long j3, Function3 function3) {
                if (j3 != Long.MIN_VALUE && j3 <= -4611686018427387904L) {
                    throw new IllegalArgumentException("You may not specify item ids less than -4611686018427387904 in a Glance\nwidget. These are reserved.");
                }
                arrayList.add(TuplesKt.a(Long.valueOf(j3), function3));
            }
        });
        return ComposableLambdaKt.c(1748368075, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$applyListScope$1
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
                    ComposerKt.U(1748368075, i3, -1, "androidx.glance.appwidget.lazy.applyListScope.<anonymous> (LazyList.kt:122)");
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
                    LazyListKt.c(jLongValue, alignment2, ComposableLambdaKt.b(composer, -163738694, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.lazy.LazyListKt$applyListScope$1$1$2
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
                                ComposerKt.U(-163738694, i6, -1, "androidx.glance.appwidget.lazy.applyListScope.<anonymous>.<anonymous>.<anonymous> (LazyList.kt:127)");
                            }
                            function3.invoke(new LazyItemScope() { // from class: androidx.glance.appwidget.lazy.LazyListKt$applyListScope$1$1$2.1
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
