package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EventShowAsType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventShowAsType[] $VALUES;
    public static final Companion Companion;
    public static final EventShowAsType NOTIFICATION = new EventShowAsType("NOTIFICATION", 0, 0, R.id.f95651p1);
    public static final EventShowAsType POP_UP = new EventShowAsType("POP_UP", 1, 1, R.id.C1);
    private final int buttonResId;
    private final int id;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventShowAsType a(int i3) {
            EventShowAsType eventShowAsType;
            EventShowAsType[] eventShowAsTypeArrValues = EventShowAsType.values();
            int length = eventShowAsTypeArrValues.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    eventShowAsType = null;
                    break;
                }
                eventShowAsType = eventShowAsTypeArrValues[i4];
                if (eventShowAsType.getButtonResId() == i3) {
                    break;
                }
                i4++;
            }
            return eventShowAsType == null ? EventShowAsType.NOTIFICATION : eventShowAsType;
        }

        public final EventShowAsType b(int i3) {
            EventShowAsType eventShowAsType;
            EventShowAsType[] eventShowAsTypeArrValues = EventShowAsType.values();
            int length = eventShowAsTypeArrValues.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    eventShowAsType = null;
                    break;
                }
                eventShowAsType = eventShowAsTypeArrValues[i4];
                if (eventShowAsType.getId() == i3) {
                    break;
                }
                i4++;
            }
            return eventShowAsType == null ? EventShowAsType.NOTIFICATION : eventShowAsType;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter implements PrefConverter<EventShowAsType, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Converter f96983a = new Converter();

        private Converter() {
        }

        public EventShowAsType a(int i3) {
            return EventShowAsType.Companion.b(i3);
        }

        @Override // cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer getId(EventShowAsType value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Integer.valueOf(value.getId());
        }
    }

    private static final /* synthetic */ EventShowAsType[] $values() {
        return new EventShowAsType[]{NOTIFICATION, POP_UP};
    }

    static {
        EventShowAsType[] eventShowAsTypeArr$values = $values();
        $VALUES = eventShowAsTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(eventShowAsTypeArr$values);
        Companion = new Companion(null);
    }

    private EventShowAsType(String str, int i3, int i4, int i5) {
        this.id = i4;
        this.buttonResId = i5;
    }

    @JvmStatic
    public static final EventShowAsType getByButtonResId(int i3) {
        return Companion.a(i3);
    }

    @JvmStatic
    public static final EventShowAsType getById(int i3) {
        return Companion.b(i3);
    }

    public static EnumEntries<EventShowAsType> getEntries() {
        return $ENTRIES;
    }

    public static EventShowAsType valueOf(String str) {
        return (EventShowAsType) Enum.valueOf(EventShowAsType.class, str);
    }

    public static EventShowAsType[] values() {
        return (EventShowAsType[]) $VALUES.clone();
    }

    public final int getButtonResId() {
        return this.buttonResId;
    }

    public final int getId() {
        return this.id;
    }
}
