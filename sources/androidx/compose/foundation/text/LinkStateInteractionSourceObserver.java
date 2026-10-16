package androidx.compose.foundation.text;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

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
public final class LinkStateInteractionSourceObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InteractionSource f9803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9804b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9805c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9806d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableIntState f9807e = SnapshotIntStateKt.a(0);

    public LinkStateInteractionSourceObserver(InteractionSource interactionSource) {
        this.f9803a = interactionSource;
    }

    public final Object e(Continuation continuation) {
        final MutableObjectList mutableObjectList = new MutableObjectList(0, 1, null);
        Object objCollect = this.f9803a.c().collect(new FlowCollector() { // from class: androidx.compose.foundation.text.LinkStateInteractionSourceObserver$collectInteractionsForLinks$2
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Interaction interaction, Continuation continuation2) {
                int i3;
                if (interaction instanceof HoverInteraction.Enter ? true : interaction instanceof FocusInteraction.Focus ? true : interaction instanceof PressInteraction.Press) {
                    mutableObjectList.n(interaction);
                } else if (interaction instanceof HoverInteraction.Exit) {
                    mutableObjectList.y(((HoverInteraction.Exit) interaction).a());
                } else if (interaction instanceof FocusInteraction.Unfocus) {
                    mutableObjectList.y(((FocusInteraction.Unfocus) interaction).a());
                } else if (interaction instanceof PressInteraction.Release) {
                    mutableObjectList.y(((PressInteraction.Release) interaction).a());
                } else if (interaction instanceof PressInteraction.Cancel) {
                    mutableObjectList.y(((PressInteraction.Cancel) interaction).a());
                }
                MutableObjectList mutableObjectList2 = mutableObjectList;
                LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = this;
                Object[] objArr = mutableObjectList2.f3081a;
                int i4 = mutableObjectList2.f3082b;
                int i5 = 0;
                for (int i6 = 0; i6 < i4; i6++) {
                    Interaction interaction2 = (Interaction) objArr[i6];
                    if (interaction2 instanceof HoverInteraction.Enter) {
                        i3 = linkStateInteractionSourceObserver.f9805c;
                    } else if (interaction2 instanceof FocusInteraction.Focus) {
                        i3 = linkStateInteractionSourceObserver.f9804b;
                    } else if (interaction2 instanceof PressInteraction.Press) {
                        i3 = linkStateInteractionSourceObserver.f9806d;
                    }
                    i5 |= i3;
                }
                this.f9807e.a(i5);
                return Unit.f139807a;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public final boolean f() {
        return (this.f9807e.g() & this.f9804b) != 0;
    }

    public final boolean g() {
        return (this.f9807e.g() & this.f9805c) != 0;
    }

    public final boolean h() {
        return (this.f9807e.g() & this.f9806d) != 0;
    }
}
