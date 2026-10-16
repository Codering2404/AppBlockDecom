package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

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
public final class LazyLayoutScrollScopeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f8181a = Dp.g(2500);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f8182b = Dp.g(1500);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f8183c = Dp.g(50);

    /* JADX WARN: Can't wrap try/catch for region: R(18:(1:(2:39|40))|(1:(16:51|53|(1:55)(1:56)|57|(1:59)(1:61)|60|108|62|63|122|64|65|112|66|(8:69|18|118|70|71|114|35|(4:37|39|40|(0)(4:42|116|43|(1:46))))|99)(1:52))(0)|45|53|(0)(0)|57|(0)(0)|60|108|62|63|122|64|65|112|66|(0)|99) */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e4, code lost:
    
        r21 = r5;
        r2 = r17;
        r14 = r18;
        r9 = r26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea A[Catch: ItemFoundInScroll -> 0x01ed, TryCatch #5 {ItemFoundInScroll -> 0x01ed, blocks: (B:35:0x00e6, B:37:0x00ea, B:39:0x00f0, B:53:0x0121, B:57:0x015d), top: B:114:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0250  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01b6 -> B:18:0x0072). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope r37, int r38, int r39, int r40, androidx.compose.ui.unit.Density r41, kotlin.coroutines.Continuation r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt.b(androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope, int, int, int, androidx.compose.ui.unit.Density, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(boolean z2, LazyLayoutScrollScope lazyLayoutScrollScope, int i3, int i4) {
        if (z2) {
            if (lazyLayoutScrollScope.h() > i3) {
                return true;
            }
            return lazyLayoutScrollScope.h() == i3 && lazyLayoutScrollScope.g() > i4;
        }
        if (lazyLayoutScrollScope.h() < i3) {
            return true;
        }
        return lazyLayoutScrollScope.h() == i3 && lazyLayoutScrollScope.g() < i4;
    }

    public static final boolean d(LazyLayoutScrollScope lazyLayoutScrollScope, int i3) {
        return i3 <= lazyLayoutScrollScope.b() && lazyLayoutScrollScope.h() <= i3;
    }
}
