package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
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
@InternalSerializationApi
public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KClass f142695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f142696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f142697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f142698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f142699e;

    public SealedClassSerializer(final String serialName, KClass baseClass, KClass[] subclasses, KSerializer[] subclassSerializers) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        this.f142695a = baseClass;
        this.f142696b = CollectionsKt.emptyList();
        this.f142697c = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: kotlinx.serialization.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SealedClassSerializer.i(serialName, this);
            }
        });
        if (subclasses.length != subclassSerializers.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + e().m() + " should be marked @Serializable");
        }
        Map map = MapsKt.toMap(ArraysKt.zip(subclasses, subclassSerializers));
        this.f142698d = map;
        final Set setEntrySet = map.entrySet();
        Grouping<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>, String> grouping = new Grouping<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>, String>() { // from class: kotlinx.serialization.SealedClassSerializer$special$$inlined$groupingBy$1
            @Override // kotlin.collections.Grouping
            public String keyOf(Object obj) {
                return ((KSerializer) ((Map.Entry) obj).getValue()).getDescriptor().i();
            }

            @Override // kotlin.collections.Grouping
            public Iterator sourceIterator() {
                return setEntrySet.iterator();
            }
        };
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> next = itSourceIterator.next();
            String strKeyOf = grouping.keyOf(next);
            Object obj = linkedHashMap.get(strKeyOf);
            if (obj == null) {
                linkedHashMap.containsKey(strKeyOf);
            }
            Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> entry = next;
            Map.Entry entry2 = (Map.Entry) obj;
            String str = strKeyOf;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + e() + "' have the same serial name '" + str + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            linkedHashMap.put(strKeyOf, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.f142699e = linkedHashMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor i(String str, final SealedClassSerializer sealedClassSerializer) {
        return SerialDescriptorsKt.g(str, PolymorphicKind.SEALED.f142723a, new SerialDescriptor[0], new Function1() { // from class: kotlinx.serialization.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SealedClassSerializer.j(this.f142711a, (ClassSerialDescriptorBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(final SealedClassSerializer sealedClassSerializer, ClassSerialDescriptorBuilder buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "type", BuiltinSerializersKt.I(StringCompanionObject.f140150a).getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.b(buildSerialDescriptor, "value", SerialDescriptorsKt.g("kotlinx.serialization.Sealed<" + sealedClassSerializer.e().m() + '>', SerialKind.CONTEXTUAL.f142751a, new SerialDescriptor[0], new Function1() { // from class: kotlinx.serialization.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SealedClassSerializer.k(this.f142761a, (ClassSerialDescriptorBuilder) obj);
            }
        }), null, false, 12, null);
        buildSerialDescriptor.h(sealedClassSerializer.f142696b);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(SealedClassSerializer sealedClassSerializer, ClassSerialDescriptorBuilder buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        for (Map.Entry entry : sealedClassSerializer.f142699e.entrySet()) {
            ClassSerialDescriptorBuilder.b(buildSerialDescriptor, (String) entry.getKey(), ((KSerializer) entry.getValue()).getDescriptor(), null, false, 12, null);
        }
        return Unit.f139807a;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public DeserializationStrategy c(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        KSerializer kSerializer = (KSerializer) this.f142699e.get(str);
        return kSerializer != null ? kSerializer : super.c(decoder, str);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public SerializationStrategy d(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        KSerializer kSerializer = (KSerializer) this.f142698d.get(Reflection.b(value.getClass()));
        KSerializer kSerializerD = kSerializer != null ? kSerializer : super.d(encoder, value);
        if (kSerializerD != null) {
            return kSerializerD;
        }
        return null;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public KClass e() {
        return this.f142695a;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f142697c.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer(String serialName, KClass baseClass, KClass[] subclasses, KSerializer[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        this.f142696b = ArraysKt.asList(classAnnotations);
    }
}
