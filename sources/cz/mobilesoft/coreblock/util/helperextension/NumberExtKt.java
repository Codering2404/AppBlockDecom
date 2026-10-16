package cz.mobilesoft.coreblock.util.helperextension;

import android.content.Context;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NumberExtKt {
    public static final String a(int i3, Context context, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (z2) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str = String.format("#%08x", Arrays.copyOf(new Object[]{Integer.valueOf(ContextCompat.getColor(context, i3))}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f140150a;
        String str2 = String.format("#%06x", Arrays.copyOf(new Object[]{Integer.valueOf(ContextCompat.getColor(context, i3) & 16777215)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static /* synthetic */ String b(int i3, Context context, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z2 = false;
        }
        return a(i3, context, z2);
    }

    public static final boolean c(long j3) {
        return j3 % ((long) 4) == 0;
    }

    public static final boolean d(int i3, int i4) {
        return (i3 & i4) != 0;
    }
}
