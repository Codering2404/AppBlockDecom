package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonNamingStrategy;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@ExperimentalSerializationApi
public interface JsonNamingStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Builtins f143018a = Builtins.f143019a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @ExperimentalSerializationApi
    public static final class Builtins {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Builtins f143019a = new Builtins();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final JsonNamingStrategy f143020b = new JsonNamingStrategy() { // from class: kotlinx.serialization.json.JsonNamingStrategy$Builtins$SnakeCase$1
            @Override // kotlinx.serialization.json.JsonNamingStrategy
            public String a(SerialDescriptor descriptor, int i3, String serialName) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                return JsonNamingStrategy.Builtins.f143019a.b(serialName, '_');
            }

            public String toString() {
                return "kotlinx.serialization.json.JsonNamingStrategy.SnakeCase";
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final JsonNamingStrategy f143021c = new JsonNamingStrategy() { // from class: kotlinx.serialization.json.JsonNamingStrategy$Builtins$KebabCase$1
            @Override // kotlinx.serialization.json.JsonNamingStrategy
            public String a(SerialDescriptor descriptor, int i3, String serialName) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                return JsonNamingStrategy.Builtins.f143019a.b(serialName, '-');
            }

            public String toString() {
                return "kotlinx.serialization.json.JsonNamingStrategy.KebabCase";
            }
        };

        private Builtins() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(String str, char c3) {
            StringBuilder sb = new StringBuilder(str.length() * 2);
            Character chValueOf = null;
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char cCharAt = str.charAt(i4);
                if (Character.isUpperCase(cCharAt)) {
                    if (i3 == 0 && sb.length() > 0 && StringsKt.z1(sb) != c3) {
                        sb.append(c3);
                    }
                    if (chValueOf != null) {
                        sb.append(chValueOf.charValue());
                    }
                    i3++;
                    chValueOf = Character.valueOf(Character.toLowerCase(cCharAt));
                } else {
                    if (chValueOf != null) {
                        if (i3 > 1 && Character.isLetter(cCharAt)) {
                            sb.append(c3);
                        }
                        sb.append(chValueOf.charValue());
                        chValueOf = null;
                        i3 = 0;
                    }
                    sb.append(cCharAt);
                }
            }
            if (chValueOf != null) {
                sb.append(chValueOf.charValue());
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public final JsonNamingStrategy c() {
            return f143020b;
        }
    }

    String a(SerialDescriptor serialDescriptor, int i3, String str);
}
