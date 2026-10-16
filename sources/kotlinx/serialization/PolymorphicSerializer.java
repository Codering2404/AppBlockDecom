package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

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
public final class PolymorphicSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KClass f142692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f142693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f142694c;

    public PolymorphicSerializer(KClass baseClass) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        this.f142692a = baseClass;
        this.f142693b = CollectionsKt.emptyList();
        this.f142694c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: kotlinx.serialization.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PolymorphicSerializer.h(this.f142705a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor h(final PolymorphicSerializer polymorphicSerializer) {
        return ContextAwareKt.c(SerialDescriptorsKt.g("kotlinx.serialization.Polymorphic", PolymorphicKind.OPEN.f142722a, new SerialDescriptor[0], new Function1() { // from class: kotlinx.serialization.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PolymorphicSerializer.i(this.f142706a, (ClassSerialDescriptorBuilder) obj);
            }
        }), polymorphicSerializer.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(PolymorphicSerializer polymorphicSerializer, ClassSerialDescriptorBuilder buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "type", BuiltinSerializersKt.I(StringCompanionObject.f140150a).getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "value", SerialDescriptorsKt.h("kotlinx.serialization.Polymorphic<" + polymorphicSerializer.e().m() + '>', SerialKind.CONTEXTUAL.f142751a, new SerialDescriptor[0], null, 8, null), null, false, 12, null);
        buildSerialDescriptor.h(polymorphicSerializer.f142693b);
        return Unit.f139807a;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public KClass e() {
        return this.f142692a;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f142694c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + e() + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PolymorphicSerializer(KClass baseClass, Annotation[] classAnnotations) {
        this(baseClass);
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        this.f142693b = ArraysKt.asList(classAnnotations);
    }
}
