package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ContextMenuScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SnapshotStateList f5260a = SnapshotStateKt.f();

    public static /* synthetic */ void d(ContextMenuScope contextMenuScope, Function2 function2, Modifier modifier, boolean z2, Function3 function3, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            modifier = Modifier.b8;
        }
        Modifier modifier2 = modifier;
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i3 & 8) != 0) {
            function3 = null;
        }
        contextMenuScope.c(function2, modifier2, z3, function3, function0);
    }

    public final void a(final ContextMenuColors contextMenuColors, Composer composer, final int i3) {
        Composer composerK = composer.k(1320309496);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(contextMenuColors) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1320309496, i4, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.Content (ContextMenuUi.android.kt:240)");
            }
            SnapshotStateList snapshotStateList = this.f5260a;
            int size = snapshotStateList.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((Function3) snapshotStateList.get(i5)).invoke(contextMenuColors, composerK, Integer.valueOf(i4 & 14));
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuScope$Content$2
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
                    this.f5261a.a(contextMenuColors, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public final void b() {
        this.f5260a.clear();
    }

    public final void c(final Function2 function2, final Modifier modifier, final boolean z2, final Function3 function3, final Function0 function0) {
        this.f5260a.add(ComposableLambdaKt.c(262103052, true, new Function3<ContextMenuColors, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuScope$item$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final void c(ContextMenuColors contextMenuColors, Composer composer, int i3) {
                if ((i3 & 6) == 0) {
                    i3 |= composer.Z(contextMenuColors) ? 4 : 2;
                }
                if (!composer.r((i3 & 19) != 18, i3 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(262103052, i3, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.item.<anonymous> (ContextMenuUi.android.kt:282)");
                }
                String str = (String) function2.invoke(composer, 0);
                if (StringsKt.p0(str)) {
                    InlineClassHelperKt.c("Label must not be blank");
                }
                ContextMenuUi_androidKt.b(str, z2, contextMenuColors, modifier, function3, function0, composer, (i3 << 6) & 896, 0);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                c((ContextMenuColors) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.f139807a;
            }
        }));
    }
}
