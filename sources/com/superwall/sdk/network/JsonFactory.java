package com.superwall.sdk.network;

import com.superwall.sdk.models.serialization.DateSerializer;
import com.superwall.sdk.network.JsonFactory;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface JsonFactory {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Json JSON;
        private static final Json JSON_POLYMORPHIC;

        static {
            Json jsonB = JsonKt.b(null, new Function1() { // from class: com.superwall.sdk.network.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return JsonFactory.Companion.JSON$lambda$1((JsonBuilder) obj);
                }
            }, 1, null);
            JSON = jsonB;
            JSON_POLYMORPHIC = JsonKt.a(jsonB, new Function1() { // from class: com.superwall.sdk.network.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return JsonFactory.Companion.JSON_POLYMORPHIC$lambda$2((JsonBuilder) obj);
                }
            });
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit JSON$lambda$1(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.h(true);
            Json.f(true);
            Json.j(JsonNamingStrategy.f143018a.c());
            SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
            serializersModuleBuilder.c(Reflection.b(Date.class), DateSerializer.INSTANCE);
            Json.k(serializersModuleBuilder.f());
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit JSON_POLYMORPHIC$lambda$2(JsonBuilder Json) {
            Intrinsics.checkNotNullParameter(Json, "$this$Json");
            Json.d(ClassDiscriminatorMode.f142951c);
            Json.c("type");
            return Unit.f139807a;
        }

        public final Json getJSON() {
            return JSON;
        }

        public final Json getJSON_POLYMORPHIC() {
            return JSON_POLYMORPHIC;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static Json json(JsonFactory jsonFactory) {
            return JsonFactory.Companion.getJSON();
        }
    }

    Json json();
}
