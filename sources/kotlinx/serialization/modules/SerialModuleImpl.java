package kotlinx.serialization.modules;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.ContextualProvider;

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
public final class SerialModuleImpl extends SerializersModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f143193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f143194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f143195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f143196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f143197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f143198f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerialModuleImpl(Map class2ContextualFactory, Map polyBase2Serializers, Map polyBase2DefaultSerializerProvider, Map polyBase2NamedSerializers, Map polyBase2DefaultDeserializerProvider, boolean z2) {
        super(null);
        Intrinsics.checkNotNullParameter(class2ContextualFactory, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(polyBase2Serializers, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f143193a = class2ContextualFactory;
        this.f143194b = polyBase2Serializers;
        this.f143195c = polyBase2DefaultSerializerProvider;
        this.f143196d = polyBase2NamedSerializers;
        this.f143197e = polyBase2DefaultDeserializerProvider;
        this.f143198f = z2;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public void a(SerializersModuleCollector collector) {
        Intrinsics.checkNotNullParameter(collector, "collector");
        for (Map.Entry entry : this.f143193a.entrySet()) {
            KClass kClass = (KClass) entry.getKey();
            ContextualProvider contextualProvider = (ContextualProvider) entry.getValue();
            if (contextualProvider instanceof ContextualProvider.Argless) {
                Intrinsics.checkNotNull(kClass, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer kSerializerB = ((ContextualProvider.Argless) contextualProvider).b();
                Intrinsics.checkNotNull(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.c(kClass, kSerializerB);
            } else {
                if (!(contextualProvider instanceof ContextualProvider.WithTypeArguments)) {
                    throw new NoWhenBranchMatchedException();
                }
                collector.e(kClass, ((ContextualProvider.WithTypeArguments) contextualProvider).b());
            }
        }
        for (Map.Entry entry2 : this.f143194b.entrySet()) {
            KClass kClass2 = (KClass) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                KClass kClass3 = (KClass) entry3.getKey();
                KSerializer kSerializer = (KSerializer) entry3.getValue();
                Intrinsics.checkNotNull(kClass2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.checkNotNull(kClass3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.a(kClass2, kClass3, kSerializer);
            }
        }
        for (Map.Entry entry4 : this.f143195c.entrySet()) {
            KClass kClass4 = (KClass) entry4.getKey();
            Function1 function1 = (Function1) entry4.getValue();
            Intrinsics.checkNotNull(kClass4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            collector.d(kClass4, (Function1) TypeIntrinsics.f(function1, 1));
        }
        for (Map.Entry entry5 : this.f143197e.entrySet()) {
            KClass kClass5 = (KClass) entry5.getKey();
            Function1 function12 = (Function1) entry5.getValue();
            Intrinsics.checkNotNull(kClass5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.checkNotNull(function12, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            collector.b(kClass5, (Function1) TypeIntrinsics.f(function12, 1));
        }
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public KSerializer b(KClass kClass, List typeArgumentsSerializers) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = (ContextualProvider) this.f143193a.get(kClass);
        KSerializer kSerializerA = contextualProvider != null ? contextualProvider.a(typeArgumentsSerializers) : null;
        if (kSerializerA instanceof KSerializer) {
            return kSerializerA;
        }
        return null;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public boolean d() {
        return this.f143198f;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public DeserializationStrategy e(KClass baseClass, String str) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Map map = (Map) this.f143196d.get(baseClass);
        KSerializer kSerializer = map != null ? (KSerializer) map.get(str) : null;
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Object obj = this.f143197e.get(baseClass);
        Function1 function1 = TypeIntrinsics.m(obj, 1) ? (Function1) obj : null;
        if (function1 != null) {
            return (DeserializationStrategy) function1.invoke(str);
        }
        return null;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public SerializationStrategy f(KClass baseClass, Object value) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!baseClass.e(value)) {
            return null;
        }
        Map map = (Map) this.f143194b.get(baseClass);
        KSerializer kSerializer = map != null ? (KSerializer) map.get(Reflection.b(value.getClass())) : null;
        KSerializer kSerializer2 = kSerializer instanceof SerializationStrategy ? kSerializer : null;
        if (kSerializer2 != null) {
            return kSerializer2;
        }
        Object obj = this.f143195c.get(baseClass);
        Function1 function1 = TypeIntrinsics.m(obj, 1) ? (Function1) obj : null;
        if (function1 != null) {
            return (SerializationStrategy) function1.invoke(value);
        }
        return null;
    }
}
