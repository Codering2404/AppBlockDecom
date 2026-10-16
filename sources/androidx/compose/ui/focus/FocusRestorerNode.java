package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class FocusRestorerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FocusRequester f25531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PinnableContainer.PinnedHandle f25532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f25533c = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusRestorerNode$onExit$1
        {
            super(1);
        }

        public final void c(FocusEnterExitScope focusEnterExitScope) {
            FocusRequesterModifierNodeKt.d(this.f25536a);
            PinnableContainer.PinnedHandle pinnedHandle = this.f25536a.f25532b;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            FocusRestorerNode focusRestorerNode = this.f25536a;
            focusRestorerNode.f25532b = FocusRequesterModifierNodeKt.a(focusRestorerNode);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((FocusEnterExitScope) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f25534d = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusRestorerNode$onEnter$1
        {
            super(1);
        }

        public final void c(FocusEnterExitScope focusEnterExitScope) {
            PinnableContainer.PinnedHandle pinnedHandle = this.f25535a.f25532b;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            this.f25535a.f25532b = null;
            if (FocusRequesterModifierNodeKt.c(this.f25535a)) {
                return;
            }
            FocusRequester focusRequesterO2 = this.f25535a.o2();
            FocusRequester.Companion companion = FocusRequester.f25519b;
            if (Intrinsics.areEqual(focusRequesterO2, companion.b())) {
                return;
            }
            if (Intrinsics.areEqual(this.f25535a.o2(), companion.a())) {
                focusEnterExitScope.a();
            } else {
                FocusRequester.h(this.f25535a.o2(), 0, 1, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((FocusEnterExitScope) obj);
            return Unit.f139807a;
        }
    };

    public FocusRestorerNode(FocusRequester focusRequester) {
        this.f25531a = focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void i1(FocusProperties focusProperties) {
        focusProperties.u(this.f25534d);
        focusProperties.z(this.f25533c);
    }

    public final FocusRequester o2() {
        return this.f25531a;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PinnableContainer.PinnedHandle pinnedHandle = this.f25532b;
        if (pinnedHandle != null) {
            pinnedHandle.release();
        }
        this.f25532b = null;
        super.onDetach();
    }

    public final void p2(FocusRequester focusRequester) {
        this.f25531a = focusRequester;
    }
}
