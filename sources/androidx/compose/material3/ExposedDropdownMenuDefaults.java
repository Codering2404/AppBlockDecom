package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.MenuAnchorType;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ExposedDropdownMenuDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExposedDropdownMenuDefaults f17608a = new ExposedDropdownMenuDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PaddingValues f17609b = PaddingKt.b(ExposedDropdownMenu_androidKt.f17632a, Dp.g(0));

    private ExposedDropdownMenuDefaults() {
    }

    private static final boolean d(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    public final /* synthetic */ void a(boolean z2, Composer composer, final int i3) {
        int i4;
        final boolean z3;
        Composer composerK = composer.k(-473088613);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(this) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            z3 = z2;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-473088613, i4, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:886)");
            }
            z3 = z2;
            b(z3, Modifier.b8, composerK, (i4 & 14) | 48 | ((i4 << 3) & 896), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuDefaults$TrailingIcon$2
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
                    this.f17615a.a(z3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public final void b(final boolean z2, Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-1987096744);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        if ((i5 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1987096744, i5, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.android.kt:519)");
            }
            IconKt.d(ArrowDropDownKt.a(Icons.Filled.f15154a), null, RotateKt.a(modifier, z2 ? 180.0f : 0.0f), 0L, composerK, 48, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenuDefaults$TrailingIcon$1
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
                    this.f17610a.b(z2, modifier2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    public final PopupProperties c(String str, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1724259382, i3, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.popupProperties (ExposedDropdownMenu.android.kt:860)");
        }
        State stateC = AccessibilityServiceStateProvider_androidKt.c(false, false, composer, 0, 3);
        int i4 = !d(stateC) ? 393248 : 393216;
        MenuAnchorType.Companion companion = MenuAnchorType.f18132b;
        if (MenuAnchorType.g(str, companion.a()) || (MenuAnchorType.g(str, companion.c()) && !d(stateC))) {
            i4 |= 8;
        }
        PopupProperties popupProperties = new PopupProperties(i4, false, false, false, false, false, 62, (DefaultConstructorMarker) null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return popupProperties;
    }
}
