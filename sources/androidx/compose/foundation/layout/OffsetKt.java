package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
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
public final class OffsetKt {
    public static final Modifier a(Modifier modifier, final float f3, final float f4) {
        return modifier.then(new OffsetElement(f3, f4, false, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.OffsetKt$absoluteOffset$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("absoluteOffset");
                inspectorInfo.b().c("x", Dp.d(f3));
                inspectorInfo.b().c("y", Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        }, null));
    }

    public static final Modifier b(Modifier modifier, final Function1 function1) {
        return modifier.then(new OffsetPxElement(function1, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.OffsetKt$offset$2
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("offset");
                inspectorInfo.b().c("offset", function1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        }));
    }

    public static final Modifier c(Modifier modifier, final float f3, final float f4) {
        return modifier.then(new OffsetElement(f3, f4, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.OffsetKt$offset$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("offset");
                inspectorInfo.b().c("x", Dp.d(f3));
                inspectorInfo.b().c("y", Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        }, null));
    }

    public static /* synthetic */ Modifier d(Modifier modifier, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.g(0);
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.g(0);
        }
        return c(modifier, f3, f4);
    }
}
