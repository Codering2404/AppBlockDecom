package androidx.room.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ViewInfoKt {
    public static final boolean a(ViewInfo viewInfo, Object obj) {
        Intrinsics.checkNotNullParameter(viewInfo, "<this>");
        if (viewInfo == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo2 = (ViewInfo) obj;
        if (Intrinsics.areEqual(viewInfo.f52990a, viewInfo2.f52990a)) {
            String str = viewInfo.f52991b;
            if (str != null ? Intrinsics.areEqual(str, viewInfo2.f52991b) : viewInfo2.f52991b == null) {
                return true;
            }
        }
        return false;
    }

    public static final int b(ViewInfo viewInfo) {
        Intrinsics.checkNotNullParameter(viewInfo, "<this>");
        int iHashCode = viewInfo.f52990a.hashCode() * 31;
        String str = viewInfo.f52991b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public static final String c(ViewInfo viewInfo) {
        Intrinsics.checkNotNullParameter(viewInfo, "<this>");
        return StringsKt.p("\n            |ViewInfo {\n            |   name = '" + viewInfo.f52990a + "',\n            |   sql = '" + viewInfo.f52991b + "'\n            |}\n        ", null, 1, null);
    }
}
