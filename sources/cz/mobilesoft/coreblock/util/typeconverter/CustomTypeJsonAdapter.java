package cz.mobilesoft.coreblock.util.typeconverter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class CustomTypeJsonAdapter<T> extends TypeAdapter<T> {
    @Override // com.google.gson.TypeAdapter
    public Object b(JsonReader jsonReader) throws IOException {
        Intrinsics.checkNotNullParameter(jsonReader, "jsonReader");
        if (jsonReader.j0() == JsonToken.NULL) {
            jsonReader.T();
            return null;
        }
        String strE0 = jsonReader.e0();
        Intrinsics.checkNotNull(strE0);
        return f(strE0);
    }

    @Override // com.google.gson.TypeAdapter
    public void d(JsonWriter jsonWriter, Object obj) throws IOException {
        Intrinsics.checkNotNullParameter(jsonWriter, "jsonWriter");
        if (obj == null) {
            jsonWriter.F();
        } else {
            jsonWriter.z0(e(obj));
        }
    }

    public abstract String e(Object obj);

    public abstract Object f(String str);
}
