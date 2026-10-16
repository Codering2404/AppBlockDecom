package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

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
public abstract class AbstractPolymorphicSerializer<T> implements KSerializer<T> {
    /* JADX INFO: Access modifiers changed from: private */
    public final Object b(CompositeDecoder compositeDecoder) {
        return CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 1, PolymorphicSerializerKt.a(this, compositeDecoder, compositeDecoder.m(getDescriptor(), 0)), null, 8, null);
    }

    public DeserializationStrategy c(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder.a().e(e(), str);
    }

    public SerializationStrategy d(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return encoder.a().f(e(), value);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Object objB;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (compositeDecoderB.p()) {
            objB = b(compositeDecoderB);
        } else {
            Object objC = null;
            while (true) {
                int iO = compositeDecoderB.o(getDescriptor());
                if (iO != -1) {
                    if (iO == 0) {
                        objectRef.f140144a = compositeDecoderB.m(getDescriptor(), iO);
                    } else {
                        if (iO != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) objectRef.f140144a;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(iO);
                            throw new SerializationException(sb.toString());
                        }
                        Object obj = objectRef.f140144a;
                        if (obj == null) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                        objectRef.f140144a = obj;
                        objC = CompositeDecoder.DefaultImpls.c(compositeDecoderB, getDescriptor(), iO, PolymorphicSerializerKt.a(this, compositeDecoderB, (String) obj), null, 8, null);
                    }
                } else {
                    if (objC == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) objectRef.f140144a)).toString());
                    }
                    Intrinsics.checkNotNull(objC, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer");
                    objB = objC;
                }
            }
        }
        compositeDecoderB.c(descriptor);
        return objB;
    }

    public abstract KClass e();

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationStrategy serializationStrategyB = PolymorphicSerializerKt.b(this, encoder, value);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor);
        compositeEncoderB.y(getDescriptor(), 0, serializationStrategyB.getDescriptor().i());
        SerialDescriptor descriptor2 = getDescriptor();
        Intrinsics.checkNotNull(serializationStrategyB, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        compositeEncoderB.C(descriptor2, 1, serializationStrategyB, value);
        compositeEncoderB.c(descriptor);
    }
}
