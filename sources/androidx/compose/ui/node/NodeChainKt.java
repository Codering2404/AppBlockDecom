package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class NodeChainKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final NodeChainKt$SentinelHead$1 f27551a;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.Modifier$Node, androidx.compose.ui.node.NodeChainKt$SentinelHead$1] */
    static {
        ?? r02 = new Modifier.Node() { // from class: androidx.compose.ui.node.NodeChainKt$SentinelHead$1
            public String toString() {
                return "<Head>";
            }
        };
        r02.setAggregateChildKindSet$ui_release(-1);
        f27551a = r02;
    }

    public static final int d(Modifier.Element element, Modifier.Element element2) {
        if (Intrinsics.areEqual(element, element2)) {
            return 2;
        }
        return Actual_jvmKt.a(element, element2) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableVector e(Modifier modifier, final MutableVector mutableVector) {
        MutableVector mutableVector2 = new MutableVector(new Modifier[RangesKt.f(mutableVector.o(), 16)], 0);
        mutableVector2.b(modifier);
        Function1<Modifier.Element, Boolean> function1 = null;
        while (mutableVector2.o() != 0) {
            Modifier modifier2 = (Modifier) mutableVector2.u(mutableVector2.o() - 1);
            if (modifier2 instanceof CombinedModifier) {
                CombinedModifier combinedModifier = (CombinedModifier) modifier2;
                mutableVector2.b(combinedModifier.a());
                mutableVector2.b(combinedModifier.b());
            } else if (modifier2 instanceof Modifier.Element) {
                mutableVector.b(modifier2);
            } else {
                if (function1 == null) {
                    function1 = new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.node.NodeChainKt$fillVector$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public final Boolean invoke(Modifier.Element element) {
                            mutableVector.b(element);
                            return Boolean.TRUE;
                        }
                    };
                }
                modifier2.all(function1);
                function1 = function1;
            }
        }
        return mutableVector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ModifierNodeElement modifierNodeElement, Modifier.Node node) {
        Intrinsics.checkNotNull(node, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        modifierNodeElement.update(node);
    }
}
