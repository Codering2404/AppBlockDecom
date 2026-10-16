package androidx.constraintlayout.compose;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ConstraintLayoutTagKt {
    public static final Object a(Measurable measurable) {
        Object objP = measurable.p();
        ConstraintLayoutTagParentData constraintLayoutTagParentData = objP instanceof ConstraintLayoutTagParentData ? (ConstraintLayoutTagParentData) objP : null;
        if (constraintLayoutTagParentData != null) {
            return constraintLayoutTagParentData.a();
        }
        return null;
    }

    public static final Object b(Measurable measurable) {
        Object objP = measurable.p();
        ConstraintLayoutTagParentData constraintLayoutTagParentData = objP instanceof ConstraintLayoutTagParentData ? (ConstraintLayoutTagParentData) objP : null;
        if (constraintLayoutTagParentData != null) {
            return constraintLayoutTagParentData.b();
        }
        return null;
    }

    public static final Modifier c(Modifier modifier, final String str, String str2) {
        if (str2 == null) {
            return LayoutIdKt.b(modifier, str);
        }
        return modifier.then(new ConstraintLayoutTag(str2, str, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutTagKt$layoutId$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("constraintLayoutId");
                inspectorInfo.e(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a()));
    }

    public static /* synthetic */ Modifier d(Modifier modifier, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return c(modifier, str, str2);
    }
}
