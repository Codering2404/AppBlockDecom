package androidx.glance.appwidget;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.Emittable;
import androidx.glance.EmittableWithChildren;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public final class IgnoreResultKt {
    public static final void a(Composer composer, final int i3) {
        Composer composerK = composer.k(1257244356);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1257244356, i3, -1, "androidx.glance.appwidget.IgnoreResult (IgnoreResult.kt:34)");
            }
            final IgnoreResultKt$IgnoreResult$1 ignoreResultKt$IgnoreResult$1 = IgnoreResultKt$IgnoreResult$1.f38085a;
            composerK.F(-1115894518);
            composerK.F(1886828752);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(new Function0<EmittableIgnoreResult>() { // from class: androidx.glance.appwidget.IgnoreResultKt$IgnoreResult$$inlined$GlanceNode$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ignoreResultKt$IgnoreResult$1.invoke();
                    }
                });
            } else {
                composerK.v();
            }
            Updater.a(composerK);
            composerK.y();
            composerK.Y();
            composerK.Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.IgnoreResultKt$IgnoreResult$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i4) {
                IgnoreResultKt.a(composer2, i3 | 1);
            }
        });
    }

    public static final boolean b(Emittable emittable) {
        if (emittable instanceof EmittableIgnoreResult) {
            return true;
        }
        if (!(emittable instanceof EmittableWithChildren)) {
            return false;
        }
        List listD = ((EmittableWithChildren) emittable).d();
        if ((listD instanceof Collection) && listD.isEmpty()) {
            return false;
        }
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            if (b((Emittable) it.next())) {
                return true;
            }
        }
        return false;
    }
}
