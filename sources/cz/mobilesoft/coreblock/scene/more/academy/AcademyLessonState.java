package cz.mobilesoft.coreblock.scene.more.academy;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
/* JADX INFO: loaded from: classes8.dex */
@JsonAdapter(AcademyLessonStateSerializer.class)
@Metadata
public final class AcademyLessonState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AcademyLessonState[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<Map<Integer, AcademyLessonState>> valuesById$delegate;
    private final int id;
    public static final AcademyLessonState AVAILABLE = new AcademyLessonState("AVAILABLE", 0, 0);
    public static final AcademyLessonState CURRENT = new AcademyLessonState("CURRENT", 1, 1);

    @Deprecated
    public static final AcademyLessonState FUTURE = new AcademyLessonState("FUTURE", 2, 2);
    public static final AcademyLessonState COMPLETE = new AcademyLessonState("COMPLETE", 3, 3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AcademyLessonStateSerializer implements JsonDeserializer<AcademyLessonState>, JsonSerializer<AcademyLessonState> {
        @Override // com.google.gson.JsonDeserializer
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AcademyLessonState a(JsonElement json, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
            return AcademyLessonState.Companion.a(json.a());
        }

        @Override // com.google.gson.JsonSerializer
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public JsonElement b(AcademyLessonState academyLessonState, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(academyLessonState != null ? Integer.valueOf(academyLessonState.getId()) : null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map b() {
            return (Map) AcademyLessonState.valuesById$delegate.getValue();
        }

        public final AcademyLessonState a(int i3) {
            AcademyLessonState academyLessonState = (AcademyLessonState) b().get(Integer.valueOf(i3));
            return academyLessonState == null ? AcademyLessonState.AVAILABLE : academyLessonState;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter {
        public final AcademyLessonState a(int i3) {
            return AcademyLessonState.Companion.a(i3);
        }

        public final int b(AcademyLessonState entityProperty) {
            Intrinsics.checkNotNullParameter(entityProperty, "entityProperty");
            return entityProperty.getId();
        }
    }

    private static final /* synthetic */ AcademyLessonState[] $values() {
        return new AcademyLessonState[]{AVAILABLE, CURRENT, FUTURE, COMPLETE};
    }

    static {
        AcademyLessonState[] academyLessonStateArr$values = $values();
        $VALUES = academyLessonStateArr$values;
        $ENTRIES = EnumEntriesKt.a(academyLessonStateArr$values);
        Companion = new Companion(null);
        valuesById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcademyLessonState.valuesById_delegate$lambda$0();
            }
        });
    }

    private AcademyLessonState(String str, int i3, int i4) {
        this.id = i4;
    }

    public static EnumEntries<AcademyLessonState> getEntries() {
        return $ENTRIES;
    }

    public static AcademyLessonState valueOf(String str) {
        return (AcademyLessonState) Enum.valueOf(AcademyLessonState.class, str);
    }

    public static AcademyLessonState[] values() {
        return (AcademyLessonState[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map valuesById_delegate$lambda$0() {
        AcademyLessonState[] academyLessonStateArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(academyLessonStateArrValues.length), 16));
        for (AcademyLessonState academyLessonState : academyLessonStateArrValues) {
            linkedHashMap.put(Integer.valueOf(academyLessonState.id), academyLessonState);
        }
        return linkedHashMap;
    }

    public final int getId() {
        return this.id;
    }
}
