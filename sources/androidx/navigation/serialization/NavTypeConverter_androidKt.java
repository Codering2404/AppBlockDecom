package androidx.navigation.serialization;

import androidx.navigation.NavType;
import androidx.navigation.serialization.InternalAndroidNavType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

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
public final class NavTypeConverter_androidKt {
    private static final Class a(SerialDescriptor serialDescriptor) {
        String strO = StringsKt.O(serialDescriptor.i(), "?", "", false, 4, null);
        try {
            Class<?> cls = Class.forName(strO);
            Intrinsics.checkNotNullExpressionValue(cls, "forName(...)");
            return cls;
        } catch (ClassNotFoundException unused) {
            if (StringsKt.a0(strO, ".", false, 2, null)) {
                Class<?> cls2 = Class.forName(new Regex("(\\.+)(?!.*\\.)").replace(strO, "\\$"));
                Intrinsics.checkNotNullExpressionValue(cls2, "forName(...)");
                return cls2;
            }
            String str = "Cannot find class with name \"" + serialDescriptor.i() + "\". Ensure that the serialName for this argument is the default fully qualified name";
            if (serialDescriptor.d() instanceof SerialKind.ENUM) {
                str = str + ".\nIf the build is minified, try annotating the Enum class with \"androidx.annotation.Keep\" to ensure the Enum is not removed.";
            }
            throw new IllegalArgumentException(str);
        }
    }

    public static final NavType b(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        NavType navTypeD = NavType.f48956c.d(a(serialDescriptor), false);
        return navTypeD == null ? UNKNOWN.f49478t : navTypeD;
    }

    public static final NavType c(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Class clsA = a(serialDescriptor.h(0));
        Intrinsics.checkNotNull(clsA, "null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>>");
        return new InternalAndroidNavType.EnumListType(clsA);
    }

    public static final NavType d(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Class clsA = a(serialDescriptor);
        if (!Enum.class.isAssignableFrom(clsA)) {
            return UNKNOWN.f49478t;
        }
        Intrinsics.checkNotNull(clsA, "null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>?>");
        return new InternalAndroidNavType.EnumNullableType(clsA);
    }
}
