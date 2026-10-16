package androidx.compose.material3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.WeakHashMap;
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
public final class CalendarLocale_jvmKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final WeakHashMap f16173a = new WeakHashMap();

    private static final NumberFormat a(int i3, int i4, boolean z2) {
        String str = i3 + '.' + i4 + '.' + z2 + '.' + Locale.getDefault().toLanguageTag();
        WeakHashMap weakHashMap = f16173a;
        Object obj = weakHashMap.get(str);
        Object obj2 = obj;
        if (obj == null) {
            NumberFormat integerInstance = NumberFormat.getIntegerInstance();
            integerInstance.setGroupingUsed(z2);
            integerInstance.setMinimumIntegerDigits(i3);
            integerInstance.setMaximumIntegerDigits(i4);
            weakHashMap.put(str, integerInstance);
            obj2 = integerInstance;
        }
        return (NumberFormat) obj2;
    }

    public static final String b(int i3, int i4, int i5, boolean z2) {
        return a(i4, i5, z2).format(Integer.valueOf(i3));
    }

    public static /* synthetic */ String c(int i3, int i4, int i5, boolean z2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 1;
        }
        if ((i6 & 2) != 0) {
            i5 = 40;
        }
        if ((i6 & 4) != 0) {
            z2 = false;
        }
        return b(i3, i4, i5, z2);
    }
}
