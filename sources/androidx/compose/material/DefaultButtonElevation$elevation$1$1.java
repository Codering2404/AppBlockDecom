package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material.DefaultButtonElevation$elevation$1$1", f = "Button.kt", l = {510}, m = "invokeSuspend")
final class DefaultButtonElevation$elevation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f12543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InteractionSource f12544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SnapshotStateList f12545c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultButtonElevation$elevation$1$1(InteractionSource interactionSource, SnapshotStateList snapshotStateList, Continuation continuation) {
        super(2, continuation);
        this.f12544b = interactionSource;
        this.f12545c = snapshotStateList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultButtonElevation$elevation$1$1(this.f12544b, this.f12545c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DefaultButtonElevation$elevation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f12543a;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException(MHoiDDglUlPJC.pvuwxuxgUKKs);
            }
        } else {
            ResultKt.b(obj);
            Flow flowC = this.f12544b.c();
            final SnapshotStateList snapshotStateList = this.f12545c;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material.DefaultButtonElevation$elevation$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Interaction interaction, Continuation continuation) {
                    if (interaction instanceof HoverInteraction.Enter) {
                        snapshotStateList.add(interaction);
                    } else if (interaction instanceof HoverInteraction.Exit) {
                        snapshotStateList.remove(((HoverInteraction.Exit) interaction).a());
                    } else if (interaction instanceof FocusInteraction.Focus) {
                        snapshotStateList.add(interaction);
                    } else if (interaction instanceof FocusInteraction.Unfocus) {
                        snapshotStateList.remove(((FocusInteraction.Unfocus) interaction).a());
                    } else if (interaction instanceof PressInteraction.Press) {
                        snapshotStateList.add(interaction);
                    } else if (interaction instanceof PressInteraction.Release) {
                        snapshotStateList.remove(((PressInteraction.Release) interaction).a());
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        snapshotStateList.remove(((PressInteraction.Cancel) interaction).a());
                    }
                    return Unit.f139807a;
                }
            };
            this.f12543a = 1;
            if (flowC.collect(flowCollector, this) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }
}
