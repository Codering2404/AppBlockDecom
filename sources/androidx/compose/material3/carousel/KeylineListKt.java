package androidx.compose.material3.carousel;

import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import kotlin.Metadata;
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
public final class KeylineListKt {
    public static final KeylineList a() {
        return KeylineList.f21718h.a();
    }

    public static final KeylineList b(float f3, float f4, int i3, float f5, Function1 function1) {
        KeylineListScopeImpl keylineListScopeImpl = new KeylineListScopeImpl();
        function1.invoke(keylineListScopeImpl);
        return keylineListScopeImpl.e(f3, f4, i3, f5);
    }

    public static final KeylineList c(float f3, float f4, int i3, Function1 function1) {
        KeylineListScopeImpl keylineListScopeImpl = new KeylineListScopeImpl();
        function1.invoke(keylineListScopeImpl);
        return keylineListScopeImpl.d(f3, f4, i3);
    }

    public static final Keyline d(Keyline keyline, Keyline keyline2, float f3) {
        return new Keyline(MathHelpersKt.b(keyline.e(), keyline2.e(), f3), MathHelpersKt.b(keyline.d(), keyline2.d(), f3), MathHelpersKt.b(keyline.f(), keyline2.f(), f3), f3 < 0.5f ? keyline.h() : keyline2.h(), f3 < 0.5f ? keyline.g() : keyline2.g(), f3 < 0.5f ? keyline.i() : keyline2.i(), MathHelpersKt.b(keyline.c(), keyline2.c(), f3));
    }

    public static final KeylineList e(KeylineList keylineList, KeylineList keylineList2, float f3) {
        ArrayList arrayList = new ArrayList(keylineList.size());
        int size = keylineList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(d(keylineList.get(i3), keylineList2.get(i3), f3));
        }
        return new KeylineList(arrayList);
    }
}
