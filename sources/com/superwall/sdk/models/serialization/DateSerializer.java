package com.superwall.sdk.models.serialization;

import com.superwall.sdk.utilities.DateUtils;
import com.superwall.sdk.utilities.DateUtilsKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

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
@ExperimentalSerializationApi
public final class DateSerializer implements KSerializer<Date> {
    public static final DateSerializer INSTANCE = new DateSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.c("Date", PrimitiveKind.STRING.f142732a);
    private static final DateSerializer$dateFormat$1 dateFormat = new ThreadLocal<SimpleDateFormat>() { // from class: com.superwall.sdk.models.serialization.DateSerializer$dateFormat$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormatDateFormat = DateUtilsKt.dateFormat(DateUtils.INSTANCE.getISO_MILLIS());
            simpleDateFormatDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormatDateFormat;
        }
    };
    private static final DateSerializer$dateFormats$1 dateFormats = new ThreadLocal<List<? extends SimpleDateFormat>>() { // from class: com.superwall.sdk.models.serialization.DateSerializer$dateFormats$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public List<? extends SimpleDateFormat> initialValue() {
            DateUtils dateUtils = DateUtils.INSTANCE;
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{dateUtils.getISO_MILLIS(), dateUtils.getISO_MILLIS() + "'Z'", dateUtils.getISO_SECONDS(), dateUtils.getISO_SECONDS_TIMEZONE()});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                SimpleDateFormat simpleDateFormatDateFormat = DateUtilsKt.dateFormat((String) it.next());
                simpleDateFormatDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                arrayList.add(simpleDateFormatDateFormat);
            }
            return arrayList;
        }
    };

    private DateSerializer() {
    }

    private final Date parseStringDate(String str) {
        List<? extends SimpleDateFormat> list = dateFormats.get();
        Intrinsics.checkNotNull(list);
        Iterator<? extends SimpleDateFormat> it = list.iterator();
        while (it.hasNext()) {
            try {
                Date date = it.next().parse(str);
                Intrinsics.checkNotNull(date);
                return date;
            } catch (Throwable unused) {
            }
        }
        throw new IllegalArgumentException("Invalid date format: " + str);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Date deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder != null) {
            JsonElement jsonElementG = jsonDecoder.g();
            if (jsonElementG instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementG;
                Long lS = JsonElementKt.s(jsonPrimitive);
                return lS != null ? new Date(lS.longValue()) : parseStringDate(jsonPrimitive.a());
            }
        }
        return parseStringDate(decoder.z());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Date value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SimpleDateFormat simpleDateFormat = dateFormat.get();
        Intrinsics.checkNotNull(simpleDateFormat);
        String str = simpleDateFormat.format(value);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        encoder.G(str);
    }
}
