package androidx.compose.material3.internal;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MappedInteractionSource implements InteractionSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f22084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f22085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Flow f22086c;

    public /* synthetic */ MappedInteractionSource(InteractionSource interactionSource, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PressInteraction.Press f(PressInteraction.Press press) {
        return new PressInteraction.Press(Offset.p(press.a(), this.f22084a), null);
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public Flow c() {
        return this.f22086c;
    }

    private MappedInteractionSource(InteractionSource interactionSource, long j3) {
        this.f22084a = j3;
        this.f22085b = new LinkedHashMap();
        final Flow flowC = interactionSource.c();
        this.f22086c = new Flow<Interaction>() { // from class: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1

            /* JADX INFO: renamed from: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f22089a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ MappedInteractionSource f22090b;

                /* JADX INFO: renamed from: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2", f = "MappedInteractionSource.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f22091a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f22092b;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f22091a = obj;
                        this.f22092b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, MappedInteractionSource mappedInteractionSource) {
                    this.f22089a = flowCollector;
                    this.f22090b = mappedInteractionSource;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = (androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f22092b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f22092b = r1
                        goto L18
                    L13:
                        androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = new androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f22091a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f22092b
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.b(r7)
                        goto L97
                    L2a:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L32:
                        kotlin.ResultKt.b(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.f22089a
                        androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
                        boolean r2 = r6 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
                        if (r2 == 0) goto L51
                        androidx.compose.material3.internal.MappedInteractionSource r2 = r5.f22090b
                        r4 = r6
                        androidx.compose.foundation.interaction.PressInteraction$Press r4 = (androidx.compose.foundation.interaction.PressInteraction.Press) r4
                        androidx.compose.foundation.interaction.PressInteraction$Press r2 = androidx.compose.material3.internal.MappedInteractionSource.e(r2, r4)
                        androidx.compose.material3.internal.MappedInteractionSource r4 = r5.f22090b
                        java.util.Map r4 = androidx.compose.material3.internal.MappedInteractionSource.d(r4)
                        r4.put(r6, r2)
                        r6 = r2
                        goto L8e
                    L51:
                        boolean r2 = r6 instanceof androidx.compose.foundation.interaction.PressInteraction.Cancel
                        if (r2 == 0) goto L70
                        androidx.compose.material3.internal.MappedInteractionSource r2 = r5.f22090b
                        java.util.Map r2 = androidx.compose.material3.internal.MappedInteractionSource.d(r2)
                        androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = (androidx.compose.foundation.interaction.PressInteraction.Cancel) r6
                        androidx.compose.foundation.interaction.PressInteraction$Press r4 = r6.a()
                        java.lang.Object r2 = r2.remove(r4)
                        androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                        if (r2 != 0) goto L6a
                        goto L8e
                    L6a:
                        androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                        r6.<init>(r2)
                        goto L8e
                    L70:
                        boolean r2 = r6 instanceof androidx.compose.foundation.interaction.PressInteraction.Release
                        if (r2 == 0) goto L8e
                        androidx.compose.material3.internal.MappedInteractionSource r2 = r5.f22090b
                        java.util.Map r2 = androidx.compose.material3.internal.MappedInteractionSource.d(r2)
                        androidx.compose.foundation.interaction.PressInteraction$Release r6 = (androidx.compose.foundation.interaction.PressInteraction.Release) r6
                        androidx.compose.foundation.interaction.PressInteraction$Press r4 = r6.a()
                        java.lang.Object r2 = r2.remove(r4)
                        androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                        if (r2 != 0) goto L89
                        goto L8e
                    L89:
                        androidx.compose.foundation.interaction.PressInteraction$Release r6 = new androidx.compose.foundation.interaction.PressInteraction$Release
                        r6.<init>(r2)
                    L8e:
                        r0.f22092b = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L97
                        return r1
                    L97:
                        kotlin.Unit r6 = kotlin.Unit.f139807a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowC.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }
}
