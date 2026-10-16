package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class PaddingKt {
    public static final PaddingValues a(float f3) {
        return new PaddingValuesImpl(f3, f3, f3, f3, null);
    }

    public static final PaddingValues b(float f3, float f4) {
        return new PaddingValuesImpl(f3, f4, f3, f4, null);
    }

    public static /* synthetic */ PaddingValues c(float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.g(0);
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.g(0);
        }
        return b(f3, f4);
    }

    public static final PaddingValues d(float f3, float f4, float f5, float f6) {
        return new PaddingValuesImpl(f3, f4, f5, f6, null);
    }

    public static /* synthetic */ PaddingValues e(float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.g(0);
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.g(0);
        }
        if ((i3 & 4) != 0) {
            f5 = Dp.g(0);
        }
        if ((i3 & 8) != 0) {
            f6 = Dp.g(0);
        }
        return d(f3, f4, f5, f6);
    }

    public static final float f(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.f30001a ? paddingValues.c(layoutDirection) : paddingValues.b(layoutDirection);
    }

    public static final float g(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.f30001a ? paddingValues.b(layoutDirection) : paddingValues.c(layoutDirection);
    }

    public static final Modifier h(Modifier modifier, final PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$4
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("padding");
                inspectorInfo.b().c("paddingValues", paddingValues);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        }));
    }

    public static final Modifier i(Modifier modifier, final float f3) {
        return modifier.then(new PaddingElement(f3, f3, f3, f3, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("padding");
                inspectorInfo.e(Dp.d(f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        }, null));
    }

    public static final Modifier j(Modifier modifier, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f3, f4, f3, f4, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("padding");
                inspectorInfo.b().c("horizontal", Dp.d(f3));
                inspectorInfo.b().c("vertical", Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        }, null));
    }

    public static /* synthetic */ Modifier k(Modifier modifier, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.g(0);
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.g(0);
        }
        return j(modifier, f3, f4);
    }

    public static final Modifier l(Modifier modifier, final float f3, final float f4, final float f5, final float f6) {
        return modifier.then(new PaddingElement(f3, f4, f5, f6, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("padding");
                inspectorInfo.b().c("start", Dp.d(f3));
                inspectorInfo.b().c(ViewHierarchyConstants.DIMENSION_TOP_KEY, Dp.d(f4));
                inspectorInfo.b().c("end", Dp.d(f5));
                inspectorInfo.b().c("bottom", Dp.d(f6));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        }, null));
    }

    public static /* synthetic */ Modifier m(Modifier modifier, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.g(0);
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.g(0);
        }
        if ((i3 & 4) != 0) {
            f5 = Dp.g(0);
        }
        if ((i3 & 8) != 0) {
            f6 = Dp.g(0);
        }
        return l(modifier, f3, f4, f5, f6);
    }
}
