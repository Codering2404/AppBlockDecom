package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LazyStaggeredGridMeasurePolicyKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8464a;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.f6031a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.f6032b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f8464a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(PaddingValues paddingValues, Orientation orientation, boolean z2, LayoutDirection layoutDirection) {
        int i3 = WhenMappings.f8464a[orientation.ordinal()];
        if (i3 == 1) {
            return z2 ? paddingValues.d() : paddingValues.a();
        }
        if (i3 == 2) {
            return z2 ? PaddingKt.g(paddingValues, layoutDirection) : PaddingKt.f(paddingValues, layoutDirection);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float e(PaddingValues paddingValues, Orientation orientation, boolean z2, LayoutDirection layoutDirection) {
        int i3 = WhenMappings.f8464a[orientation.ordinal()];
        if (i3 == 1) {
            return z2 ? paddingValues.a() : paddingValues.d();
        }
        if (i3 == 2) {
            return z2 ? PaddingKt.f(paddingValues, layoutDirection) : PaddingKt.g(paddingValues, layoutDirection);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00d9 A[PHI: r3
      0x00d9: PHI (r3v40 androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider) = 
      (r3v38 androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider)
      (r3v41 androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider)
     binds: [B:68:0x00d7, B:64:0x00d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.jvm.functions.Function2 f(final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r16, final kotlin.jvm.functions.Function0 r17, final androidx.compose.foundation.layout.PaddingValues r18, final boolean r19, final androidx.compose.foundation.gestures.Orientation r20, final float r21, float r22, final kotlinx.coroutines.CoroutineScope r23, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider r24, final androidx.compose.ui.graphics.GraphicsContext r25, androidx.compose.runtime.Composer r26, int r27) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt.f(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, kotlin.jvm.functions.Function0, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, float, float, kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider, androidx.compose.ui.graphics.GraphicsContext, androidx.compose.runtime.Composer, int):kotlin.jvm.functions.Function2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(PaddingValues paddingValues, Orientation orientation, LayoutDirection layoutDirection) {
        int i3 = WhenMappings.f8464a[orientation.ordinal()];
        if (i3 == 1) {
            return PaddingKt.g(paddingValues, layoutDirection);
        }
        if (i3 == 2) {
            return paddingValues.d();
        }
        throw new NoWhenBranchMatchedException();
    }
}
