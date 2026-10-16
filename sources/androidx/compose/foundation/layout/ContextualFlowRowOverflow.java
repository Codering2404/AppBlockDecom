package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FlowLayoutOverflow;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
@Deprecated
@Metadata
public final class ContextualFlowRowOverflow extends FlowLayoutOverflow {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f6717f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ContextualFlowRowOverflow f6718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ContextualFlowRowOverflow f6719h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ContextualFlowRowOverflow a() {
            return ContextualFlowRowOverflow.f6719h;
        }

        private Companion() {
        }
    }

    static {
        int i3 = 0;
        Function1 function1 = null;
        f6718g = new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.f6866a, 0, i3, null, function1, 30, null);
        f6719h = new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.f6867b, i3, 0, function1, null, 30, null);
    }

    /* synthetic */ ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i3, int i4, Function1 function1, Function1 function12, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, (i5 & 2) != 0 ? 0 : i3, (i5 & 4) != 0 ? 0 : i4, (i5 & 8) != 0 ? null : function1, (i5 & 16) != 0 ? null : function12);
    }

    private ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i3, int i4, Function1 function1, Function1 function12) {
        super(overflowType, i3, i4, function1, function12, null);
    }
}
