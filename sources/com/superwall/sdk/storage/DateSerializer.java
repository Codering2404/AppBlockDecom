package com.superwall.sdk.storage;

import com.superwall.sdk.utilities.DateUtils;
import com.superwall.sdk.utilities.DateUtilsKt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DateSerializer implements KSerializer<Date> {
    public static final DateSerializer INSTANCE = new DateSerializer();
    private static final SerialDescriptor descriptor;
    private static final SimpleDateFormat format;

    static {
        SimpleDateFormat simpleDateFormatDateFormat = DateUtilsKt.dateFormat(DateUtils.INSTANCE.getISO_SECONDS_TIMEZONE());
        simpleDateFormatDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        format = simpleDateFormatDateFormat;
        descriptor = SerialDescriptorsKt.c("Date", PrimitiveKind.STRING.f142732a);
    }

    private DateSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Date deserialize(Decoder decoder) throws ParseException {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String strZ = decoder.z();
        Date date = format.parse(strZ);
        if (date != null) {
            return date;
        }
        throw new SerializationException("Invalid date format: " + strZ);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Date value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        String str = format.format(value);
        Intrinsics.checkNotNull(str);
        encoder.G(str);
    }
}
