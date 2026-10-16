package androidx.glance.appwidget;

import android.widget.RemoteViews;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AndroidRemoteViewsKt {
    public static final void a(final RemoteViews remoteViews, final int i3, GlanceModifier glanceModifier, final Function2 function2, Composer composer, final int i4, final int i5) {
        Composer composerK = composer.k(-1388408952);
        if ((i5 & 4) != 0) {
            glanceModifier = GlanceModifier.f37605a;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.M()) {
            ComposerKt.U(-1388408952, i4, -1, "androidx.glance.appwidget.AndroidRemoteViews (AndroidRemoteViews.kt:53)");
        }
        AndroidRemoteViewsKt$AndroidRemoteViews$2 androidRemoteViewsKt$AndroidRemoteViews$2 = AndroidRemoteViewsKt$AndroidRemoteViews$2.f37682a;
        composerK.F(578571862);
        int i6 = (i4 >> 3) & 896;
        composerK.F(-548224868);
        if (!(composerK.m() instanceof Applier)) {
            ComposablesKt.c();
        }
        composerK.o();
        if (composerK.i()) {
            composerK.P(androidRemoteViewsKt$AndroidRemoteViews$2);
        } else {
            composerK.v();
        }
        Composer composerA = Updater.a(composerK);
        Updater.e(composerA, remoteViews, new Function2<EmittableAndroidRemoteViews, RemoteViews, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt$AndroidRemoteViews$3$1
            public final void c(EmittableAndroidRemoteViews emittableAndroidRemoteViews, RemoteViews remoteViews2) {
                emittableAndroidRemoteViews.k(remoteViews2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableAndroidRemoteViews) obj, (RemoteViews) obj2);
                return Unit.f139807a;
            }
        });
        AndroidRemoteViewsKt$AndroidRemoteViews$3$2 androidRemoteViewsKt$AndroidRemoteViews$3$2 = new Function2<EmittableAndroidRemoteViews, Integer, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt$AndroidRemoteViews$3$2
            public final void c(EmittableAndroidRemoteViews emittableAndroidRemoteViews, int i7) {
                emittableAndroidRemoteViews.j(i7);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableAndroidRemoteViews) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }
        };
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(i3))) {
            composerA.w(Integer.valueOf(i3));
            composerA.p(Integer.valueOf(i3), androidRemoteViewsKt$AndroidRemoteViews$3$2);
        }
        Updater.e(composerA, glanceModifier2, new Function2<EmittableAndroidRemoteViews, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt$AndroidRemoteViews$3$3
            public final void c(EmittableAndroidRemoteViews emittableAndroidRemoteViews, GlanceModifier glanceModifier3) {
                emittableAndroidRemoteViews.b(glanceModifier3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((EmittableAndroidRemoteViews) obj, (GlanceModifier) obj2);
                return Unit.f139807a;
            }
        });
        function2.invoke(composerK, Integer.valueOf((i6 >> 6) & 14));
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
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt$AndroidRemoteViews$4
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
                AndroidRemoteViewsKt.a(remoteViews, i3, glanceModifier2, function2, composer2, i4 | 1, i5);
            }
        });
    }

    public static final void b(final RemoteViews remoteViews, GlanceModifier glanceModifier, Composer composer, final int i3, final int i4) {
        Composer composerK = composer.k(-647353345);
        if ((i4 & 2) != 0) {
            glanceModifier = GlanceModifier.f37605a;
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        if (ComposerKt.M()) {
            ComposerKt.U(-647353345, i3, -1, "androidx.glance.appwidget.AndroidRemoteViews (AndroidRemoteViews.kt:34)");
        }
        a(remoteViews, -1, glanceModifier2, ComposableSingletons$AndroidRemoteViewsKt.f37866a.a(), composerK, ((i3 << 3) & 896) | 3080, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.AndroidRemoteViewsKt$AndroidRemoteViews$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i5) {
                AndroidRemoteViewsKt.b(remoteViews, glanceModifier2, composer2, i3 | 1, i4);
            }
        });
    }
}
