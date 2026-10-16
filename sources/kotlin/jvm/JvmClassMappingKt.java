package kotlin.jvm;

import com.facebook.LegacyTokenHelper;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class JvmClassMappingKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class b(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class clsF = ((ClassBasedDeclarationContainer) kClass).f();
        if (!clsF.isPrimitive()) {
            Intrinsics.checkNotNull(clsF, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return clsF;
        }
        String name = clsF.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals(LegacyTokenHelper.TYPE_DOUBLE)) {
                    clsF = Double.class;
                }
                break;
            case 104431:
                if (name.equals(LegacyTokenHelper.TYPE_INTEGER)) {
                    clsF = Integer.class;
                }
                break;
            case 3039496:
                if (name.equals(LegacyTokenHelper.TYPE_BYTE)) {
                    clsF = Byte.class;
                }
                break;
            case 3052374:
                if (name.equals(LegacyTokenHelper.TYPE_CHAR)) {
                    clsF = Character.class;
                }
                break;
            case 3327612:
                if (name.equals(LegacyTokenHelper.TYPE_LONG)) {
                    clsF = Long.class;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    clsF = Void.class;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    clsF = Boolean.class;
                }
                break;
            case 97526364:
                if (name.equals(LegacyTokenHelper.TYPE_FLOAT)) {
                    clsF = Float.class;
                }
                break;
            case 109413500:
                if (name.equals(LegacyTokenHelper.TYPE_SHORT)) {
                    clsF = Short.class;
                }
                break;
        }
        Intrinsics.checkNotNull(clsF, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return clsF;
    }

    public static final KClass c(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Reflection.b(cls);
    }

    public static final Class a(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class clsF = ((ClassBasedDeclarationContainer) kClass).f();
        Intrinsics.checkNotNull(clsF, pMpIcGE.ONWfoDa);
        return clsF;
    }
}
