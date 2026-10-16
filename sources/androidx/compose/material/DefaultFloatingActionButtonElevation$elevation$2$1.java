package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1", f = "FloatingActionButton.kt", l = {293}, m = "invokeSuspend")
final class DefaultFloatingActionButtonElevation$elevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f12579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f12580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ InteractionSource f12581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FloatingActionButtonElevationAnimatable f12582d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultFloatingActionButtonElevation$elevation$2$1(InteractionSource interactionSource, FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, Continuation continuation) {
        super(2, continuation);
        this.f12581c = interactionSource;
        this.f12582d = floatingActionButtonElevationAnimatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DefaultFloatingActionButtonElevation$elevation$2$1 defaultFloatingActionButtonElevation$elevation$2$1 = new DefaultFloatingActionButtonElevation$elevation$2$1(this.f12581c, this.f12582d, continuation);
        defaultFloatingActionButtonElevation$elevation$2$1.f12580b = obj;
        return defaultFloatingActionButtonElevation$elevation$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f12579a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.f12580b;
            final ArrayList arrayList = new ArrayList();
            Flow flowC = this.f12581c.c();
            final FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = this.f12582d;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1.1

                /* JADX INFO: renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2$1$1$1", f = "FloatingActionButton.kt", l = {319}, m = "invokeSuspend")
                static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f12586a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ FloatingActionButtonElevationAnimatable f12587b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ Interaction f12588c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00371(FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, Interaction interaction, Continuation continuation) {
                        super(2, continuation);
                        this.f12587b = floatingActionButtonElevationAnimatable;
                        this.f12588c = interaction;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new C00371(this.f12587b, this.f12588c, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f12586a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = this.f12587b;
                            Interaction interaction = this.f12588c;
                            this.f12586a = 1;
                            if (floatingActionButtonElevationAnimatable.b(interaction, this) == objF) {
                                return objF;
                            }
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                        }
                        return Unit.f139807a;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((C00371) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Interaction interaction, Continuation continuation) {
                    if (interaction instanceof HoverInteraction.Enter) {
                        arrayList.add(interaction);
                    } else if (interaction instanceof HoverInteraction.Exit) {
                        arrayList.remove(((HoverInteraction.Exit) interaction).a());
                    } else if (interaction instanceof FocusInteraction.Focus) {
                        arrayList.add(interaction);
                    } else if (interaction instanceof FocusInteraction.Unfocus) {
                        arrayList.remove(((FocusInteraction.Unfocus) interaction).a());
                    } else if (interaction instanceof PressInteraction.Press) {
                        arrayList.add(interaction);
                    } else if (interaction instanceof PressInteraction.Release) {
                        arrayList.remove(((PressInteraction.Release) interaction).a());
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        arrayList.remove(((PressInteraction.Cancel) interaction).a());
                    }
                    BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new C00371(floatingActionButtonElevationAnimatable, (Interaction) CollectionsKt.lastOrNull(arrayList), null), 3, null);
                    return Unit.f139807a;
                }
            };
            this.f12579a = 1;
            if (flowC.collect(flowCollector, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DefaultFloatingActionButtonElevation$elevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
