package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.modules.SerializersModuleCollector;

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
public final class PolymorphismValidator implements SerializersModuleCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f143141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f143142b;

    public PolymorphismValidator(boolean z2, String discriminator) {
        Intrinsics.checkNotNullParameter(discriminator, "discriminator");
        this.f143141a = z2;
        this.f143142b = discriminator;
    }

    private final void f(SerialDescriptor serialDescriptor, KClass kClass) {
        int iE = serialDescriptor.e();
        for (int i3 = 0; i3 < iE; i3++) {
            String strF = serialDescriptor.f(i3);
            if (Intrinsics.areEqual(strF, this.f143142b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + kClass + " has property '" + strF + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    private final void g(SerialDescriptor serialDescriptor, KClass kClass) {
        SerialKind serialKindD = serialDescriptor.d();
        if ((serialKindD instanceof PolymorphicKind) || Intrinsics.areEqual(serialKindD, SerialKind.CONTEXTUAL.f142751a)) {
            throw new IllegalArgumentException("Serializer for " + kClass.m() + " can't be registered as a subclass for polymorphic serialization because its kind " + serialKindD + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.f143141a) {
            return;
        }
        if (Intrinsics.areEqual(serialKindD, StructureKind.LIST.f142754a) || Intrinsics.areEqual(serialKindD, StructureKind.MAP.f142755a) || (serialKindD instanceof PrimitiveKind) || (serialKindD instanceof SerialKind.ENUM)) {
            throw new IllegalArgumentException("Serializer for " + kClass.m() + " of kind " + serialKindD + " cannot be serialized polymorphically with class discriminator.");
        }
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void a(KClass baseClass, KClass actualClass, KSerializer actualSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(actualClass, "actualClass");
        Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
        SerialDescriptor descriptor = actualSerializer.getDescriptor();
        g(descriptor, actualClass);
        if (this.f143141a) {
            return;
        }
        f(descriptor, actualClass);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void b(KClass baseClass, Function1 defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void c(KClass kClass, KSerializer kSerializer) {
        SerializersModuleCollector.DefaultImpls.b(this, kClass, kSerializer);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void d(KClass baseClass, Function1 defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void e(KClass kClass, Function1 provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
    }
}
