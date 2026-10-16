package androidx.annotation;

import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Method from annotation default annotation not found: attributeId */
/* JADX WARN: Method from annotation default annotation not found: enumMapping */
/* JADX WARN: Method from annotation default annotation not found: flagMapping */
/* JADX WARN: Method from annotation default annotation not found: hasAttributeId */
/* JADX WARN: Method from annotation default annotation not found: name */
/* JADX WARN: Method from annotation default annotation not found: valueType */
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
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Metadata
@Deprecated
@kotlin.annotation.Target
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention
public @interface InspectableProperty {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface EnumEntry {
    }

    /* JADX WARN: Method from annotation default annotation not found: mask */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata
    @kotlin.annotation.Target
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface FlagEntry {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class ValueType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ValueType f605a = new ValueType("NONE", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ValueType f606b = new ValueType("INFERRED", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ValueType f607c = new ValueType("INT_ENUM", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ValueType f608d = new ValueType("INT_FLAG", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final ValueType f609f = new ValueType("COLOR", 4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final ValueType f610g = new ValueType(sKeKFMqmvNzY.sTmSHG, 5);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final ValueType f611h = new ValueType("RESOURCE_ID", 6);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ ValueType[] f612i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f613j;

        private ValueType(String str, int i3) {
        }

        private static final /* synthetic */ ValueType[] a() {
            return new ValueType[]{f605a, f606b, f607c, f608d, f609f, f610g, f611h};
        }

        public static ValueType valueOf(String str) {
            return (ValueType) Enum.valueOf(ValueType.class, str);
        }

        public static ValueType[] values() {
            return (ValueType[]) f612i.clone();
        }

        static {
            ValueType[] valueTypeArrA = a();
            f612i = valueTypeArrA;
            f613j = EnumEntriesKt.a(valueTypeArrA);
        }
    }
}
