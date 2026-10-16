package androidx.glance.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ColumnKt {
    public static final void a(GlanceModifier glanceModifier, int i3, int i4, final Function3 function3, Composer composer, final int i5, final int i6) {
        int i7;
        Composer composerK = composer.k(-1883910253);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 14) == 0) {
            i7 = (composerK.Z(glanceModifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i9 = i6 & 2;
        if (i9 != 0) {
            i7 |= 48;
        } else if ((i5 & 112) == 0) {
            i7 |= composerK.e(i3) ? 32 : 16;
        }
        int i10 = i6 & 4;
        if (i10 != 0) {
            i7 |= 384;
        } else if ((i5 & 896) == 0) {
            i7 |= composerK.e(i4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 7168) == 0) {
            i7 |= composerK.Z(function3) ? 2048 : 1024;
        }
        if ((i7 & 5851) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (i8 != 0) {
                glanceModifier = GlanceModifier.f37605a;
            }
            if (i9 != 0) {
                i3 = Alignment.f39415c.g();
            }
            if (i10 != 0) {
                i4 = Alignment.f39415c.f();
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1883910253, i7, -1, "androidx.glance.layout.Column (Column.kt:83)");
            }
            ColumnKt$Column$1 columnKt$Column$1 = ColumnKt$Column$1.f39452a;
            composerK.F(578571862);
            composerK.F(-548224868);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(columnKt$Column$1);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, glanceModifier, new Function2<EmittableColumn, GlanceModifier, Unit>() { // from class: androidx.glance.layout.ColumnKt$Column$2$1
                public final void c(EmittableColumn emittableColumn, GlanceModifier glanceModifier2) {
                    emittableColumn.b(glanceModifier2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableColumn) obj, (GlanceModifier) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, Alignment.Horizontal.d(i4), new Function2<EmittableColumn, Alignment.Horizontal, Unit>() { // from class: androidx.glance.layout.ColumnKt$Column$2$2
                public final void c(EmittableColumn emittableColumn, int i11) {
                    emittableColumn.j(i11);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableColumn) obj, ((Alignment.Horizontal) obj2).j());
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, Alignment.Vertical.d(i3), new Function2<EmittableColumn, Alignment.Vertical, Unit>() { // from class: androidx.glance.layout.ColumnKt$Column$2$3
                public final void c(EmittableColumn emittableColumn, int i11) {
                    emittableColumn.k(i11);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableColumn) obj, ((Alignment.Vertical) obj2).j());
                    return Unit.f139807a;
                }
            });
            function3.invoke(ColumnScopeImplInstance.f39462a, composerK, Integer.valueOf(((i7 >> 6) & 112) | 6));
            composerK.y();
            composerK.Y();
            composerK.Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final int i11 = i3;
        final int i12 = i4;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.layout.ColumnKt$Column$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i13) {
                ColumnKt.a(glanceModifier2, i11, i12, function3, composer2, i5 | 1, i6);
            }
        });
    }
}
