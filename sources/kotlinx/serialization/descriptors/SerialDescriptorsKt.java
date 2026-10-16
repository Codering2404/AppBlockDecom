package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.ArrayListClassDesc;
import kotlinx.serialization.internal.HashMapClassDesc;
import kotlinx.serialization.internal.PrimitivesKt;

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
public final class SerialDescriptorsKt {
    public static final SerialDescriptor c(String serialName, PrimitiveKind kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (StringsKt.p0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        return PrimitivesKt.a(serialName, kind);
    }

    public static final SerialDescriptor d(String serialName, SerialDescriptor[] typeParameters, Function1 builderAction) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        if (StringsKt.p0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builderAction.invoke(classSerialDescriptorBuilder);
        return new SerialDescriptorImpl(serialName, StructureKind.CLASS.f142753a, classSerialDescriptorBuilder.f().size(), ArraysKt.toList(typeParameters), classSerialDescriptorBuilder);
    }

    public static /* synthetic */ SerialDescriptor e(String str, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = new Function1() { // from class: kotlinx.serialization.descriptors.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SerialDescriptorsKt.f((ClassSerialDescriptorBuilder) obj2);
                }
            };
        }
        return d(str, serialDescriptorArr, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "<this>");
        return Unit.f139807a;
    }

    public static final SerialDescriptor g(String serialName, SerialKind kind, SerialDescriptor[] typeParameters, Function1 builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (StringsKt.p0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (Intrinsics.areEqual(kind, StructureKind.CLASS.f142753a)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builder.invoke(classSerialDescriptorBuilder);
        return new SerialDescriptorImpl(serialName, kind, classSerialDescriptorBuilder.f().size(), ArraysKt.toList(typeParameters), classSerialDescriptorBuilder);
    }

    public static /* synthetic */ SerialDescriptor h(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            function1 = new Function1() { // from class: kotlinx.serialization.descriptors.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SerialDescriptorsKt.i((ClassSerialDescriptorBuilder) obj2);
                }
            };
        }
        return g(str, serialKind, serialDescriptorArr, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "<this>");
        return Unit.f139807a;
    }

    public static final SerialDescriptor j(SerialDescriptor elementDescriptor) {
        Intrinsics.checkNotNullParameter(elementDescriptor, "elementDescriptor");
        return new ArrayListClassDesc(elementDescriptor);
    }

    public static final SerialDescriptor k(SerialDescriptor keyDescriptor, SerialDescriptor valueDescriptor) {
        Intrinsics.checkNotNullParameter(keyDescriptor, "keyDescriptor");
        Intrinsics.checkNotNullParameter(valueDescriptor, "valueDescriptor");
        return new HashMapClassDesc(keyDescriptor, valueDescriptor);
    }
}
