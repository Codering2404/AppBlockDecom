package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
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
@Metadata
public final class ObserverNodeOwnerScope implements OwnerScope {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f27602b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f27603c = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Function1 f27604d = new Function1<ObserverNodeOwnerScope, Unit>() { // from class: androidx.compose.ui.node.ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1
        public final void c(ObserverNodeOwnerScope observerNodeOwnerScope) {
            if (observerNodeOwnerScope.a1()) {
                observerNodeOwnerScope.b().w0();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((ObserverNodeOwnerScope) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ObserverModifierNode f27605a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function1 a() {
            return ObserverNodeOwnerScope.f27604d;
        }

        private Companion() {
        }
    }

    public ObserverNodeOwnerScope(ObserverModifierNode observerModifierNode) {
        this.f27605a = observerModifierNode;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean a1() {
        return this.f27605a.getNode().isAttached();
    }

    public final ObserverModifierNode b() {
        return this.f27605a;
    }
}
