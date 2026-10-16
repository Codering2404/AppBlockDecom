package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class LayoutUtilsKt {
    public static final long a(long j3, boolean z2, int i3, float f3) {
        return Constraints.f29963b.b(0, c(j3, z2, i3, f3), 0, Constraints.k(j3));
    }

    public static final int b(boolean z2, int i3, int i4) {
        if (z2 || !d(i3)) {
            return RangesKt.f(i4, 1);
        }
        return 1;
    }

    public static final int c(long j3, boolean z2, int i3, float f3) {
        int iL = ((z2 || d(i3)) && Constraints.h(j3)) ? Constraints.l(j3) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        return Constraints.n(j3) == iL ? iL : RangesKt.p(TextDelegateKt.a(f3), Constraints.n(j3), iL);
    }

    public static final boolean d(int i3) {
        TextOverflow.Companion companion = TextOverflow.f29661b;
        return TextOverflow.h(i3, companion.b()) || TextOverflow.h(i3, companion.d()) || TextOverflow.h(i3, companion.c());
    }
}
