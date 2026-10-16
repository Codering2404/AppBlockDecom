package kotlin.reflect;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

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
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f140277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f140278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type[] f140279c;

    public ParameterizedTypeImpl(Class rawType, Type type, List typeArguments) {
        Intrinsics.checkNotNullParameter(rawType, "rawType");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        this.f140277a = rawType;
        this.f140278b = type;
        this.f140279c = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        return Intrinsics.areEqual(this.f140277a, parameterizedType.getRawType()) && Intrinsics.areEqual(this.f140278b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f140279c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f140278b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f140277a;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() throws IOException {
        StringBuilder sb = new StringBuilder();
        Type type = this.f140278b;
        if (type != null) {
            sb.append(TypesJVMKt.g(type));
            sb.append("$");
            sb.append(this.f140277a.getSimpleName());
        } else {
            sb.append(TypesJVMKt.g(this.f140277a));
        }
        Type[] typeArr = this.f140279c;
        if (!(typeArr.length == 0)) {
            ArraysKt___ArraysKt.joinTo(typeArr, sb, (50 & 2) != 0 ? ", " : null, (50 & 4) != 0 ? "" : "<", (50 & 8) == 0 ? ">" : "", (50 & 16) != 0 ? -1 : 0, (50 & 32) != 0 ? "..." : null, (50 & 64) != 0 ? null : ParameterizedTypeImpl$getTypeName$1$1.f140280a);
        }
        return sb.toString();
    }

    public int hashCode() {
        int iHashCode = this.f140277a.hashCode();
        Type type = this.f140278b;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
