package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.MustBeDocumented;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
@MustBeDocumented
@Metadata
@Documented
public @interface RestrictTo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Scope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Scope f618a = new Scope("LIBRARY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Scope f619b = new Scope("LIBRARY_GROUP", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Scope f620c = new Scope("LIBRARY_GROUP_PREFIX", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Scope f621d = new Scope("GROUP_ID", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Scope f622f = new Scope("TESTS", 4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Scope f623g = new Scope("SUBCLASSES", 5);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ Scope[] f624h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f625i;

        static {
            Scope[] scopeArrA = a();
            f624h = scopeArrA;
            f625i = EnumEntriesKt.a(scopeArrA);
        }

        private Scope(String str, int i3) {
        }

        private static final /* synthetic */ Scope[] a() {
            return new Scope[]{f618a, f619b, f620c, f621d, f622f, f623g};
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) f624h.clone();
        }
    }
}
