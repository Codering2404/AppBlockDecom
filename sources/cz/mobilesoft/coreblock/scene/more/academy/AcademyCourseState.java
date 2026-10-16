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
@JsonAdapter(AcademyCourseStateSerializer.class)
@Metadata
public final class AcademyCourseState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AcademyCourseState[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<Map<Integer, AcademyCourseState>> valuesById$delegate;
    private final int id;
    private final int order;
    public static final AcademyCourseState AVAILABLE = new AcademyCourseState("AVAILABLE", 0, 0, 2);
    public static final AcademyCourseState CURRENT = new AcademyCourseState("CURRENT", 1, 1, 0);
    public static final AcademyCourseState PAUSED = new AcademyCourseState("PAUSED", 2, 2, 1);
    public static final AcademyCourseState COMPLETE = new AcademyCourseState("COMPLETE", 3, 3, 3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AcademyCourseStateSerializer implements JsonDeserializer<AcademyCourseState>, JsonSerializer<AcademyCourseState> {
        @Override // com.google.gson.JsonDeserializer
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AcademyCourseState a(JsonElement json, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
            return AcademyCourseState.Companion.a(json.a());
        }

        @Override // com.google.gson.JsonSerializer
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public JsonElement b(AcademyCourseState academyCourseState, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(academyCourseState != null ? Integer.valueOf(academyCourseState.getId()) : null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map b() {
            return (Map) AcademyCourseState.valuesById$delegate.getValue();
        }

        public final AcademyCourseState a(int i3) {
            AcademyCourseState academyCourseState = (AcademyCourseState) AcademyCourseState.Companion.b().get(Integer.valueOf(i3));
            return academyCourseState == null ? AcademyCourseState.AVAILABLE : academyCourseState;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter {
        public final AcademyCourseState a(int i3) {
            return AcademyCourseState.Companion.a(i3);
        }

        public final int b(AcademyCourseState entityProperty) {
            Intrinsics.checkNotNullParameter(entityProperty, "entityProperty");
            return entityProperty.getId();
        }
    }

    private static final /* synthetic */ AcademyCourseState[] $values() {
        return new AcademyCourseState[]{AVAILABLE, CURRENT, PAUSED, COMPLETE};
    }

    static {
        AcademyCourseState[] academyCourseStateArr$values = $values();
        $VALUES = academyCourseStateArr$values;
        $ENTRIES = EnumEntriesKt.a(academyCourseStateArr$values);
        Companion = new Companion(null);
        valuesById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.academy.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AcademyCourseState.valuesById_delegate$lambda$0();
            }
        });
    }

    private AcademyCourseState(String str, int i3, int i4, int i5) {
        this.id = i4;
        this.order = i5;
    }

    public static EnumEntries<AcademyCourseState> getEntries() {
        return $ENTRIES;
    }

    public static AcademyCourseState valueOf(String str) {
        return (AcademyCourseState) Enum.valueOf(AcademyCourseState.class, str);
    }

    public static AcademyCourseState[] values() {
        return (AcademyCourseState[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map valuesById_delegate$lambda$0() {
        AcademyCourseState[] academyCourseStateArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(academyCourseStateArrValues.length), 16));
        for (AcademyCourseState academyCourseState : academyCourseStateArrValues) {
            linkedHashMap.put(Integer.valueOf(academyCourseState.id), academyCourseState);
        }
        return linkedHashMap;
    }

    public final int getId() {
        return this.id;
    }

    public final int getOrder() {
        return this.order;
    }
}
