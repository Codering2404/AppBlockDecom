package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

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
final class TabRowDefaults$tabIndicatorOffset$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TabPosition f20594a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TabRowDefaults$tabIndicatorOffset$2(TabPosition tabPosition) {
        super(3);
        this.f20594a = tabPosition;
    }

    private static final float e(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(State state) {
        return ((Dp) state.getValue()).l();
    }

    public final Modifier d(Modifier modifier, Composer composer, int i3) {
        composer.a0(-1541271084);
        if (ComposerKt.M()) {
            ComposerKt.U(-1541271084, i3, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:1265)");
        }
        State stateC = AnimateAsStateKt.c(this.f20594a.d(), TabRowKt.f20598c, null, null, composer, 0, 12);
        final State stateC2 = AnimateAsStateKt.c(this.f20594a.b(), TabRowKt.f20598c, null, null, composer, 0, 12);
        Modifier modifierG = SizeKt.G(SizeKt.h(modifier, 0.0f, 1, null), Alignment.f25072a.d(), false, 2, null);
        boolean Z = composer.Z(stateC2);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$2$1$1
                {
                    super(1);
                }

                public final long c(Density density) {
                    return IntOffsetKt.a(density.z0(TabRowDefaults$tabIndicatorOffset$2.h(stateC2)), 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return IntOffset.c(c((Density) obj));
                }
            };
            composer.w(objG);
        }
        Modifier modifierA = SizeKt.A(OffsetKt.b(modifierG, (Function1) objG), e(stateC));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierA;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return d((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
