package androidx.glance;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface GlanceModifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f37605a = Companion.f37606b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Element extends GlanceModifier {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
        }

        @Override // androidx.glance.GlanceModifier
        default boolean all(Function1 function1) {
            return ((Boolean) function1.invoke(this)).booleanValue();
        }

        @Override // androidx.glance.GlanceModifier
        default boolean any(Function1 function1) {
            return ((Boolean) function1.invoke(this)).booleanValue();
        }

        @Override // androidx.glance.GlanceModifier
        default Object foldIn(Object obj, Function2 function2) {
            return function2.invoke(obj, this);
        }
    }

    default GlanceModifier a(GlanceModifier glanceModifier) {
        return glanceModifier == f37605a ? this : new CombinedGlanceModifier(this, glanceModifier);
    }

    boolean all(Function1 function1);

    boolean any(Function1 function1);

    Object foldIn(Object obj, Function2 function2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion implements GlanceModifier {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ Companion f37606b = new Companion();

        private Companion() {
        }

        @Override // androidx.glance.GlanceModifier
        public boolean all(Function1 function1) {
            return true;
        }

        @Override // androidx.glance.GlanceModifier
        public boolean any(Function1 function1) {
            return false;
        }

        public String toString() {
            return "Modifier";
        }

        @Override // androidx.glance.GlanceModifier
        public GlanceModifier a(GlanceModifier glanceModifier) {
            return glanceModifier;
        }

        @Override // androidx.glance.GlanceModifier
        public Object foldIn(Object obj, Function2 function2) {
            return obj;
        }
    }
}
