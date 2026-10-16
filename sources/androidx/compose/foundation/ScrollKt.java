package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class ScrollKt {
    public static final Modifier a(Modifier modifier, ScrollState scrollState, boolean z2, FlingBehavior flingBehavior, boolean z3) {
        return e(modifier, scrollState, z3, flingBehavior, z2, false, true, null, 64, null);
    }

    public static /* synthetic */ Modifier b(Modifier modifier, ScrollState scrollState, boolean z2, FlingBehavior flingBehavior, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        if ((i3 & 4) != 0) {
            flingBehavior = null;
        }
        if ((i3 & 8) != 0) {
            z3 = false;
        }
        return a(modifier, scrollState, z2, flingBehavior, z3);
    }

    public static final ScrollState c(final int i3, Composer composer, int i4, int i5) {
        boolean z2 = true;
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1464256199, i4, -1, "androidx.compose.foundation.rememberScrollState (Scroll.kt:68)");
        }
        Object[] objArr = new Object[0];
        Saver saverA = ScrollState.f5135i.a();
        if ((((i4 & 14) ^ 6) <= 4 || !composer.e(i3)) && (i4 & 6) != 4) {
            z2 = false;
        }
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function0<ScrollState>() { // from class: androidx.compose.foundation.ScrollKt$rememberScrollState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ScrollState invoke() {
                    return new ScrollState(i3);
                }
            };
            composer.w(objG);
        }
        ScrollState scrollState = (ScrollState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return scrollState;
    }

    private static final Modifier d(Modifier modifier, ScrollState scrollState, boolean z2, FlingBehavior flingBehavior, boolean z3, boolean z4, boolean z5, OverscrollEffect overscrollEffect) {
        return ScrollingContainerKt.a(modifier, scrollState, z4 ? Orientation.f6031a : Orientation.f6032b, z3, z2, flingBehavior, scrollState.l(), z5, overscrollEffect, (Function.MAX_NARGS & Function.MAX_NARGS) != 0 ? null : null).then(new ScrollingLayoutElement(scrollState, z2, z4));
    }

    static /* synthetic */ Modifier e(Modifier modifier, ScrollState scrollState, boolean z2, FlingBehavior flingBehavior, boolean z3, boolean z4, boolean z5, OverscrollEffect overscrollEffect, int i3, Object obj) {
        return d(modifier, scrollState, z2, flingBehavior, z3, z4, z5, (i3 & 64) != 0 ? null : overscrollEffect);
    }

    public static final Modifier f(Modifier modifier, ScrollState scrollState, boolean z2, FlingBehavior flingBehavior, boolean z3) {
        return e(modifier, scrollState, z3, flingBehavior, z2, true, true, null, 64, null);
    }

    public static /* synthetic */ Modifier g(Modifier modifier, ScrollState scrollState, boolean z2, FlingBehavior flingBehavior, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        if ((i3 & 4) != 0) {
            flingBehavior = null;
        }
        if ((i3 & 8) != 0) {
            z3 = false;
        }
        return f(modifier, scrollState, z2, flingBehavior, z3);
    }
}
