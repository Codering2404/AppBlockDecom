package kotlinx.serialization.internal;

import java.lang.Enum;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
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
public final class EnumSerializer<T extends Enum<T>> implements KSerializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Enum[] f142808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SerialDescriptor f142809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f142810c;

    public EnumSerializer(final String serialName, Enum[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f142808a = values;
        this.f142810c = LazyKt.b(new Function0() { // from class: kotlinx.serialization.internal.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnumSerializer.c(this.f142928a, serialName);
            }
        });
    }

    private final SerialDescriptor b(String str) {
        EnumDescriptor enumDescriptor = new EnumDescriptor(str, this.f142808a.length);
        for (Enum r02 : this.f142808a) {
            PluginGeneratedSerialDescriptor.q(enumDescriptor, r02.name(), false, 2, null);
        }
        return enumDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor c(EnumSerializer enumSerializer, String str) {
        SerialDescriptor serialDescriptor = enumSerializer.f142809b;
        return serialDescriptor == null ? enumSerializer.b(str) : serialDescriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Enum deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int iE = decoder.e(getDescriptor());
        if (iE >= 0) {
            Enum[] enumArr = this.f142808a;
            if (iE < enumArr.length) {
                return enumArr[iE];
            }
        }
        throw new SerializationException(iE + " is not among valid " + getDescriptor().i() + " enum values, values size is " + this.f142808a.length);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, Enum value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        int iIndexOf = ArraysKt.indexOf(this.f142808a, value);
        if (iIndexOf != -1) {
            encoder.k(getDescriptor(), iIndexOf);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().i());
        sb.append(", must be one of ");
        String string = Arrays.toString(this.f142808a);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        throw new SerializationException(sb.toString());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.f142810c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().i() + '>';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EnumSerializer(String serialName, Enum[] values, SerialDescriptor descriptor) {
        this(serialName, values);
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.f142809b = descriptor;
    }
}
