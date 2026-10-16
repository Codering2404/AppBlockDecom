package androidx.compose.ui.node;

import kotlin.Metadata;
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
@Metadata
public interface TraversableNode extends DelegatableNode {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f27640a = new Companion();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class TraverseDescendantsAction {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final TraverseDescendantsAction f27641a = new TraverseDescendantsAction("ContinueTraversal", 0);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final TraverseDescendantsAction f27642b = new TraverseDescendantsAction("SkipSubtreeAndContinueTraversal", 1);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final TraverseDescendantsAction f27643c = new TraverseDescendantsAction("CancelTraversal", 2);

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ TraverseDescendantsAction[] f27644d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private static final /* synthetic */ EnumEntries f27645f;

            static {
                TraverseDescendantsAction[] traverseDescendantsActionArrA = a();
                f27644d = traverseDescendantsActionArrA;
                f27645f = EnumEntriesKt.a(traverseDescendantsActionArrA);
            }

            private TraverseDescendantsAction(String str, int i3) {
            }

            private static final /* synthetic */ TraverseDescendantsAction[] a() {
                return new TraverseDescendantsAction[]{f27641a, f27642b, f27643c};
            }

            public static TraverseDescendantsAction valueOf(String str) {
                return (TraverseDescendantsAction) Enum.valueOf(TraverseDescendantsAction.class, str);
            }

            public static TraverseDescendantsAction[] values() {
                return (TraverseDescendantsAction[]) f27644d.clone();
            }
        }

        private Companion() {
        }
    }

    Object U();
}
